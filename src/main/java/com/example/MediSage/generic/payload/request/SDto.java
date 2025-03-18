package com.example.MediSage.generic.payload.request;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SDto {
    private int pageNumber = 0;

    @Schema(defaultValue = "10")
    private int pageSize = 10;

    @Schema(defaultValue = "DESC")
    private Sort.Direction sort = Sort.Direction.DESC;

    @Schema(defaultValue = "id")
    private String sortProperty = "id";

    private boolean isActive = true;

    @JsonIgnore
    public PageRequest getPageable() {
        return PageRequest.of(pageNumber, pageSize, sort, sortProperty);
    }

    public Boolean getIsActive() {
        return isActive;
    }
}
