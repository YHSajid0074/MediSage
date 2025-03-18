package com.example.MediSage.generic.service;

import com.example.MediSage.generic.model.BaseEntity;
import com.example.MediSage.generic.payload.request.GenericIdsDto;
import com.example.MediSage.generic.payload.request.IDto;
import com.example.MediSage.generic.payload.request.SDto;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import com.example.MediSage.generic.payload.response.PageData;
import com.example.MediSage.generic.repository.AbstractRepository;
import com.example.MediSage.generic.specification.CustomSpecification;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public abstract class AbstractService<E extends BaseEntity, D extends IDto, S extends SDto> implements IService<E, D, S> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);
    static final Pattern CAPITAL_LETTER_PATTERN = Pattern.compile("([A-Z])");
    protected final AbstractRepository<E> repository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public E create(D d) throws IOException {
        checkStringSize(d);
        validateClientData(d, null);
        return saveItem(convertToEntity(d));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public E update(D d, Long id) throws IOException {
        E e = findById(id);
        checkStringSize(d);
        validateClientData(d, e);
        E e1 = updateEntity(d, e);
        if (Objects.equals(e.getUpdatedTime(), e1.getUpdatedTime())) {
            e1.setUpdatedTime(LocalDateTime.now());
        }
        return saveItem(e1);
    }

    @Override
    public <T extends BaseResponseDto> T getSingle(Long id) {
        E entity = findById(id);
        return convertToResponseDto(entity);
    }

    @Override
    public E findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public E updateActiveStatus(Long id, Boolean isActive) {
        E e = findById(id);
        if (e.getIsActive() == isActive) {
            throw new RuntimeException("Only toggle value accepted");
        }

        e.setIsActive(isActive);
        return saveItem(e);
    }

    @Override
    public E saveItem(E entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            LOGGER.error("Save failed for entity {}", entity.getClass().getSimpleName());
            LOGGER.error("Error message: {}", e.getMessage());
            throw new RuntimeException("Failed to save data: " + e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<E> saveItemList(List<E> entityList) {
        try {
            if (CollectionUtils.isEmpty(entityList)) {
                return entityList;
            }
            return repository.saveAll(entityList);
        } catch (Exception e) {
            String entityName = entityList.get(0).getClass().getSimpleName();
            LOGGER.error("Save failed for entity {}", entityName);
            LOGGER.error("Error message: {}", e.getMessage());
            throw new RuntimeException("Failed to save data: " + e.getMessage());
        }
    }

    @Override
    public List<E> findAllByIds(Collection<Long> ids) {
        return repository.findAllByIdIn(ids);
    }

    protected abstract <T extends BaseResponseDto> T convertToResponseDto(E e);

    protected abstract E convertToEntity(D d) throws IOException;

    protected abstract E updateEntity(D d, E entity) throws IOException;

    @Override
    public ResponseEntity<List<Object>> getAll() {
        return new ResponseEntity<>(repository.findAllByIsActiveTrue().stream().map(this::convertToResponseDto).toList(), HttpStatus.OK);
    }

    protected PageData convertToPageData(Page<E> pagedData, Pageable pageable) {
        AtomicReference<Long> sl = new AtomicReference<>(1L);
        List<Object> models = pagedData.getContent().stream().map(e -> {
                    BaseResponseDto baseResponseDto = convertToResponseDto(e);
                    return baseResponseDto.setSl(sl.getAndSet(sl.get() + 1));
                })
                .collect(Collectors.toList());

        return PageData.builder()
                .model(models)
                .totalPages(pagedData.getTotalPages())
                .totalElements(pagedData.getTotalElements())
                .currentPage(pageable.getPageNumber() + 1)
                .build();
    }

    @Override
    public PageData search(S searchDto, Pageable pageable) {
        Specification<E> amrSpecification = buildSpecification(searchDto);
        if (Objects.isNull(amrSpecification)) {
            amrSpecification = getNewSpecification(searchDto);
        }
        Page<E> pagedData = repository.findAll(amrSpecification, pageable);
        return convertToPageData(pagedData, pageable);
    }

    @Override
    @Transactional
    public List<E> batchActiveStatus(GenericIdsDto ids) {
        List<E> allByIdIn = repository.findAllByIdIn(ids.getIds());
        if (CollectionUtils.isEmpty(allByIdIn)) {
            throw new RuntimeException("Given Ids not found");
        }
        try {
            allByIdIn.forEach(e -> e.setIsActive(false));
            return repository.saveAll(allByIdIn);
        } catch (Exception e) {
            throw new RuntimeException("Failed to change batch active status");
        }
    }

    abstract protected Specification<E> buildSpecification(S searchDto);

    private Specification<E> getNewSpecification(S searchDto) {
        return new CustomSpecification<E>()
                .active(Objects.nonNull(searchDto.getIsActive()) ? searchDto.getIsActive() : true, "isActive");
    }



    protected void checkStringSize(D dto) {
        Field[] declaredFields = dto.getClass().getDeclaredFields();
        StringBuilder errorFieldNames = new StringBuilder();

        for (Field field : declaredFields) {
            if (field.getType().isAssignableFrom(String.class)) {
                field.setAccessible(true);
                try {
                    String s = (String) field.get(dto);
                    if (Objects.nonNull(s) && s.length() > 255) {
                        errorFieldNames.append(spaceAndCapitalizeFirstLetter(field.getName())).append(" ");
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Illegal access error: " + e.getMessage());
                }
            }
        }

        if (errorFieldNames.length() > 0) {
            throw new RuntimeException("Field exceeds size limit: " + errorFieldNames.toString());
        }
    }


    private String spaceAndCapitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder result = new StringBuilder();
        result.append(text.charAt(0));

        for (int i = 1; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                result.append(' ').append(currentChar);
            } else {
                result.append(currentChar);
            }
        }

        return result.toString();
    }

//    private ConcurrentMap<Long, User> getUserMap(Collection<Long> ids) {
//        return Helper.getAllUserByIds(ids)
//                .stream().collect(Collectors.toConcurrentMap(User::getId, Function.identity(), (a, b) -> a));
//    }
}
