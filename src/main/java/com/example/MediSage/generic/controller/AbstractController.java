package com.example.MediSage.generic.controller;

import com.example.MediSage.config.swagger.PageableQueryParameters;
import com.example.MediSage.generic.model.BaseEntity;
import com.example.MediSage.generic.payload.request.GenericIdsDto;
import com.example.MediSage.generic.payload.request.IDto;
import com.example.MediSage.generic.payload.request.SDto;
import com.example.MediSage.generic.payload.response.BaseResponseDto;
import com.example.MediSage.generic.payload.response.PageData;
import com.example.MediSage.generic.service.IService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@RequiredArgsConstructor
public abstract class AbstractController<E extends BaseEntity, D extends IDto, S extends SDto> implements IController<D> {

    protected final IService<E, D, S> service;

    private String getModelName(E entity) {
        return entity.getClass().getSimpleName();
    }

    @Override
    @GetMapping("{id}")
    public <T extends BaseResponseDto> T getSingle(@PathVariable Long id) {
        return service.getSingle(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        return service.getAll();
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody D dto) throws IOException {
        service.create(dto);
        return ResponseEntity.ok("Created Successfully");
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<String> update(@Valid @RequestBody D dto, @PathVariable Long id) throws IOException {
        service.update(dto, id);
        return ResponseEntity.ok("Updated Successfully");
    }

    @Override
    @PatchMapping("{id}")
    public ResponseEntity<String> updateActiveStatus(@PathVariable Long id, @RequestParam(name = "isActive") Boolean isActive) {
        service.updateActiveStatus(id, isActive);
        return ResponseEntity.ok(isActive ? "Active status changed to TRUE successfully" : "Active status changed successfully");
    }

    @PostMapping("search")
    @PageableQueryParameters
    public ResponseEntity<PageData> search(@RequestBody S searchDto) {
        return new ResponseEntity<>(service.search(searchDto, searchDto.getPageable()), HttpStatus.OK);
    }

    @Override
    @PostMapping("/batch-status")
    public ResponseEntity<String> batchActiveStatus(@RequestBody GenericIdsDto ids) {
        service.batchActiveStatus(ids);
        return ResponseEntity.ok("Active status changed successfully");
    }
}
