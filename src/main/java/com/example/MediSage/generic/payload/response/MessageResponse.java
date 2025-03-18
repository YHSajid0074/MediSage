package com.example.MediSage.generic.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class MessageResponse {

    private String domain;
    private String message;
    private Boolean isActiveUser;

    Long id;

    public MessageResponse(String message) {
        this.message = message;
    }

    public MessageResponse(String message, Long id) {
        this.message = message;
        this.id = id;
    }

    public MessageResponse(String domain, String message, Long id) {
        this.domain = domain;
        this.message = message;
        this.id = id;
    }

    public MessageResponse(String message, Boolean isActiveUser) {
        this.message = message;
        this.isActiveUser = isActiveUser;
    }
}
