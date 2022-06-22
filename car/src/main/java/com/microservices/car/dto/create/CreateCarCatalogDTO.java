package com.microservices.car.dto.create;

import com.microservices.car.entity.CarStatus;
import com.microservices.car.entity.CarType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarCatalogDTO {

    @UniqueElements
    @NotEmpty(message = "'Registration number' name should not be empty")
    @Pattern(regexp = "\\d{8}", message = "'Registration number' should be valid")
    private String registrationNumber;

    @NotEmpty(message = "'Car type' should not be empty")
    @Size(min = 2, max = 32, message = "'Car type' should be 'UNIVERSAL' or 'MINIVAN' or 'SEDAN' or 'COUPE' or 'SUV'")
    private CarType carType;

    @NotEmpty(message = "'Year of manufacture' name should not be empty")
    @Size(min = 4, max = 4, message = "'Year of manufacture' should have 4 characters")
    @Pattern(regexp = "\\d{4}", message = "'Year of manufacture' should be valid")
    private String yearOfManufacture;

    @NotEmpty(message = "'Make' name should not be empty")
    @Size(min = 2, max = 128, message = "'Make' should be between 2 and 128 characters")
    private String make;

    @NotEmpty(message = "'Model' name should not be empty")
    @Size(min = 2, max = 128, message = "'Model' should be between 2 and 128 characters")
    private String model;

    @NotEmpty(message = "'Colour' name should not be empty")
    @Size(min = 2, max = 32, message = "'Colour' should be between 2 and 32 characters")
    private String colour;

    @NotEmpty(message = "'Price' should not be empty")
    @PositiveOrZero(message = "'Price' should be positive number or 0")
    private BigDecimal price;

    @NotEmpty(message = "'Car status' should not be empty")
    @Size(min = 2, max = 64, message = "'Car status' should be 'READY' or 'REPAIR' or 'SERVICE' or 'WASH' or 'RENT'")
    private CarStatus carStatus;
}
