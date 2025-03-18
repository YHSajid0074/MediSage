package com.example.MediSage.generic.payload.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationResponse<T> {

    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private List<T> content;
    private String reportType;

}
