package com.example.MediSage.generic.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageData {
    List<?> model = new ArrayList<>();
    int totalPages = 0;
    int currentPage = 0;
    long totalElements = 0;
    Integer totalNotification;

    public PageData(List<?> model, int totalPages, int currentPage, long totalElements) {
        this.model = model;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.totalElements = totalElements;
    }

    public static PageData empty() {
        Page<Object> pagedData = Page.empty();
        return PageData.builder()
                .model(pagedData.getContent())
                .totalPages(pagedData.getTotalPages())
                .totalElements(pagedData.getTotalElements())
                .currentPage(1)
                .build();
    }
}
