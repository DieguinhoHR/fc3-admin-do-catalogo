package com.fullcycle.admin.catalogo.infrastructure.utils;

import org.springframework.data.jpa.domain.Specification;

public final class SpecificationUtils {

    private SpecificationUtils() {}

    public static <T> Specification<T> like(final String prop, final String term) {
        // root pega a entidade e consulta o campo para uppercase
        return (root, query, cb) -> cb.like(cb.upper(root.get(prop)), like(term).toUpperCase());
    }

    private static String like(final String term) {
        return "%" + term + "%";
    }
}
