package com.example.hw21.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    @NotNull(message = "teacher id must be valid")
    private Integer teacher_id;

    @NotEmpty(message = "area must not be empty")
    private String area;

    @NotEmpty(message = "street must not be empty")
    private String street;

    @NotNull(message = "building number must not be empty")
    private Integer buildingNumber;
}
