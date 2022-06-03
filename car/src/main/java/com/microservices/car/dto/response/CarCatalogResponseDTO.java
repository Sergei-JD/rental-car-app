package com.microservices.car.dto.response;

import com.microservices.car.entity.CarType;
import com.microservices.car.entity.CarStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CarCatalogResponseDTO {

    private Long carCatalogId;

    private String registrationNumber;

    private CarType carType;

    private String yearOfManufacture;

    private String make;

    private String model;

    private String colour;

    private BigDecimal price;

    private CarStatus carStatus;
}
