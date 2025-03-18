package com.example.MediSage.generic.specification;

import com.example.MediSage.generic.model.BaseEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;
import java.util.Set;

public class CustomSpecification<T extends BaseEntity> {

    /**
     * get specification
     *
     * @param value      {@link Object}
     * @param columnName {@link String}
     * @return {Specification<T>}
     */
    public <E> Specification<T> equalSpecificationAtRoot(E value, String columnName) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (Objects.nonNull(value)) {
                if (value instanceof String) {
                    if (StringUtils.isBlank((String) value)) {
                        return null;
                    }
                }
                return criteriaBuilder.equal(root.get(columnName), value);
            }
            return null;
        };
    }

    public <E> Specification<T> active(E value, String columnName) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) ->
                criteriaBuilder.equal(root.get(columnName), value);
    }

    /**
     * back and forth search specification
     * lowercase used for postgres SQL
     *
     * @param value      {@link String}
     * @param columnName {@link String}
     * @return {Specification<T>}
     */
    public Specification<T> likeSpecificationAtRoot(String value, String columnName) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (StringUtils.isNotBlank(value)) {
                return criteriaBuilder.like((
                                criteriaBuilder.lower(root.get(columnName))),
                        "%" + value.toLowerCase() + "%");
            }
            return null;
        };
    }

    /**
     * get specification
     * lowercase used for postgres SQL
     *
     * @param value      {@link String}
     * @param columnName {@link String}
     * @return {Specification<T>}
     */
    public Specification<T> wildCardSpecificationAtRoot(String value, String columnName) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (StringUtils.isNotBlank(value)) {
                return criteriaBuilder.like((
                                criteriaBuilder.lower(root.get(columnName))),
                        "%" + value.toLowerCase() + "%");
            }
            return null;
        };
    }

    public Specification<T> wildCardSpecificationAtChild(String value, String childEntityName, String columnName) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (StringUtils.isNotBlank(value)) {

                return criteriaBuilder.like((
                                criteriaBuilder.lower(root.join(childEntityName).get(columnName))),
                        "%" + value.toLowerCase() + "%");
            }
            return null;
        };
    }


    /**
     * get specification
     *
     * @param value             {@link String}
     * @param childEntityName   {@link String}
     * @param childEntityColumn {@link String}
     * @return {Specification<T>}
     */
    public Specification<T> likeSpecificationAtChild(String value,
                                                     String childEntityName, String childEntityColumn) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (Objects.nonNull(value)) {
                return criteriaBuilder.like((
                        criteriaBuilder.lower(root.join(childEntityName).get(childEntityColumn))), "%" + value.toLowerCase() + "%");
            }
            return null;
        };
    }

    /**
     * get specification
     *
     * @param values     {@link Set <E>}
     * @param columnName {@link String}
     * @return {Specification<T>}
     */
    public <E> Specification<T> inSpecificationAtRoot(Set<E> values, String columnName) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (CollectionUtils.isNotEmpty(values)) {
                query.distinct(true);
                return root.get(columnName).in(values);
            }
            return null;
        };
    }


    /**
     * get specification
     *
     * @param values            {@link Set <E>}
     * @param childEntityName   {@link String}
     * @param childEntityColumn {@link String}
     * @return {Specification<T>}
     */
    public <E> Specification<T> inSpecificationAtChild(Set<E> values,
                                                       String childEntityName, String childEntityColumn) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (CollectionUtils.isNotEmpty(values)) {
                query.distinct(true);
                return root.join(childEntityName).get(childEntityColumn).in(values);
            }
            return null;
        };
    }


    //  grandchild means join with parent of parent , example: mapping with employee ---> designation ---> department
    public <E> Specification<T> inSpecificationAtGrandChild(Set<E> values,
                                                            String childEntityName, String grandChildEntityName, String childEntityColumn) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (CollectionUtils.isNotEmpty(values)) {
                query.distinct(true);
                return root.join(childEntityName).join(grandChildEntityName).get(childEntityColumn).in(values);
            }
            return null;
        };
    }

    public <E> Specification<T> equalSpecificationAtGrandChild(E value,
                                                               String childEntityName, String grandChildEntityName,
                                                               String childEntityColumn) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (Objects.nonNull(value)) {
                query.distinct(true);
                return criteriaBuilder.equal(root.join(childEntityName).join(grandChildEntityName).get(childEntityColumn), value);
            }
            return null;
        };
    }

    public <E> Specification<T> equalSpecificationAtDecentChild(E value,
                                                                String childEntityName, String grandChildEntityName,
                                                                String decentChildEntityName,
                                                                String childEntityColumn) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (Objects.nonNull(value)) {
                query.distinct(true);
                return criteriaBuilder.equal(root.join(childEntityName).join(grandChildEntityName)
                        .join(decentChildEntityName).get(childEntityColumn), value);
            }
            return null;
        };
    }

    /**
     * get specification
     *
     * @param startValue {@link E}
     * @param endValue   {@link E}
     * @param columnName {@link String}
     * @return {Specification<T>}
     */
    public <E extends Comparable> Specification<T> inBetweenSpecification(
            E startValue, E endValue, String columnName) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(startValue) || Objects.isNull(endValue)) {
                return null;
            }
            return criteriaBuilder.between(root.get(columnName), startValue, endValue);
        };
    }

    public <E extends Comparable> Specification<T> inBetweenSpecificationAtChild(
            E startValue, E endValue, String childEntityName, String columnName) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(startValue) || Objects.isNull(endValue)) {
                return null;
            }
            ;
            return criteriaBuilder.between(root.join(childEntityName).get(columnName), startValue, endValue);
        };
    }

    /**
     * get specification
     *
     * @param maxValue   {@link E}
     * @param columnName {@link String}
     * @return {Specification<T>}
     */
    public <E extends Comparable> Specification<T> lessThanOrEqualToSpecification(E maxValue, String columnName) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(maxValue)) {
                return null;
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get(columnName), maxValue);
        };
    }

    public <E extends Comparable> Specification<T> lessThanSpecificationAtRoot(E maxValue, String columnName) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(maxValue)) {
                return null;
            }
            return criteriaBuilder.lessThan(root.get(columnName), maxValue);
        };
    }

    /**
     * get specification
     *
     * @param minValue   {@link E}
     * @param columnName {@link String}
     * @return {Specification<T>}
     */
    public <E extends Comparable> Specification<T> greaterThanOrEqualToSpecification(E minValue, String columnName) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(minValue)) {
                return null;
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get(columnName), minValue);
        };
    }

    public <E extends Comparable> Specification<T> greaterThanSpecificationAtRoot(E minValue, String columnName) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(minValue)) {
                return null;
            }
            return criteriaBuilder.greaterThan(root.get(columnName), minValue);
        };
    }

    /**
     * get equal match from join with child table
     *
     * @param value             {@link E}
     * @param childEntityName   {@link String}
     * @param childEntityColumn {@link String}
     * @return {Specification<T>}
     */
    public <E> Specification<T> equalSpecificationAtChild(E value,
                                                          String childEntityName, String childEntityColumn) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (Objects.nonNull(value)) {
                return criteriaBuilder.equal(root.join(childEntityName).get(childEntityColumn), value);
            }
            return null;
        };
    }


    public <E extends Comparable> Specification<T> greaterThanOrEqualToSpecificationAtChild(E maxValue,
                                                                                            String childEntityName,
                                                                                            String childEntityColumn) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(maxValue)) {
                return null;
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.join(childEntityName).get(childEntityColumn), maxValue);
        };
    }


    public <E extends Comparable> Specification<T> lessThanOrEqualToSpecificationAtChild(E maxValue,
                                                                                         String childEntityName,
                                                                                         String childEntityColumn) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(maxValue)) {
                return null;
            }
            return criteriaBuilder.lessThanOrEqualTo(root.join(childEntityName).get(childEntityColumn), maxValue);
        };
    }

    public <E extends Comparable> Specification<T> greaterThanSpecificationAtChild(E maxValue,
                                                                                   String childEntityName,
                                                                                   String childEntityColumn) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(maxValue)) {
                return null;
            }
            return criteriaBuilder.greaterThan(root.join(childEntityName).get(childEntityColumn), maxValue);
        };
    }


    public <E extends Comparable> Specification<T> lessThanSpecificationAtChild(E maxValue,
                                                                                String childEntityName,
                                                                                String childEntityColumn) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(maxValue)) {
                return null;
            }
            return criteriaBuilder.lessThan(root.join(childEntityName).get(childEntityColumn), maxValue);
        };
    }


}
