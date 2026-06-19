package com.spring.weektwo.practice.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;
    @NotNull(message = "name should not be null")
    @Size(min=1,max = 20,message="name->(1,20)")
    private String name;
    @NotBlank(message = "email should not be blank")
    private String email;
    @Max(value = 100,message = "age should be less than 100")
    @Min(value=18,message = "age should be more than 18")
    private Integer age;
    private String role;
    @PastOrPresent(message = "incorrect format")
    private LocalDate doj;
    @Positive(message = "no should be positive")
    @Digits(integer = 6,fraction = 2)
    @DecimalMax(value = "900000.00")
    @DecimalMin(value = "100000.00")
    private BigDecimal salary;
    @AssertTrue
    private Boolean isActive;
}
