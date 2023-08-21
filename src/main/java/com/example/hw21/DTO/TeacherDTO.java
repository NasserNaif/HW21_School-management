package com.example.hw21.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherDTO {

    @NotEmpty(message = "name must not be empty")
    private String name;

    @NotNull(message = "age must not be null")
    @Positive(message = "age must be positive number")
    private Integer age;

    @NotEmpty(message = "email must not be empty")
    @Email(message = "please enter a valid email")
    private String email;

    @NotNull(message = "salary must not be null")
    @Positive(message = "salary must be positive number")
    private Integer salary;
}
