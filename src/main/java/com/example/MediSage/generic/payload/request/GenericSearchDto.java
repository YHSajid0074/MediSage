package com.example.MediSage.generic.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GenericSearchDto extends SDto {
    private String query;
    private Boolean isActive = true;
}
