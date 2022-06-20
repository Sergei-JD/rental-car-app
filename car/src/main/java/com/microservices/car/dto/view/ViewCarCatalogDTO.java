package com.microservices.car.dto.view;

import com.microservices.car.entity.CarStatus;
import com.microservices.car.entity.CarType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ViewCarCatalogDTO {

    private Long id;

    private String registrationNumber;

    private CarType carType;

    private String yearOfManufacture;

    private String make;

    private String model;

    private String colour;

    private BigDecimal price;

    private CarStatus carStatus;
}
