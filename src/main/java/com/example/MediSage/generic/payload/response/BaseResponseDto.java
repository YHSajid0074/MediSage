package com.example.MediSage.generic.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseDto {

    private Long sl;
//    private Long createdById;
//    private String createdByName;
//
//    private Long updatedById;
//    private String updatedByName;
//
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
//    private LocalDateTime createdTime;
//
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
//    private LocalDateTime updatedTime;


    public BaseResponseDto setSl(Long sl) {
        this.sl = sl;
        return this;
    }
}