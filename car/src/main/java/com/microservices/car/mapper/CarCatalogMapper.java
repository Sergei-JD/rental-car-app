package com.microservices.car.mapper;

import com.microservices.car.dto.create.CarCatalogCreateDTO;
import com.microservices.car.dto.update.CarCatalogUpdateDTO;
import com.microservices.car.dto.view.CarCatalogViewDTO;
import com.microservices.car.entity.CarCatalog;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarCatalogMapper {

    public static CarCatalogViewDTO toCarCatalogViewDTO(CarCatalog carCatalog) {
        return Optional.ofNullable(carCatalog)
                .map(existCarCatalog -> CarCatalogViewDTO.builder()
                        .id(carCatalog.getId())
                        .registrationNumber(carCatalog.getRegistrationNumber())
                        .carType(carCatalog.getCarType())
                        .yearOfManufacture(carCatalog.getYearOfManufacture())
                        .make(carCatalog.getMake())
                        .model(carCatalog.getModel())
                        .colour(carCatalog.getColour())
                        .price(carCatalog.getPrice())
                        .carStatus(carCatalog.getCarStatus())
                        .build())
                .orElse(null);
    }

    public static CarCatalogCreateDTO toCarCatalogCreateDTO(CarCatalog carCatalog) {
        return Optional.ofNullable(carCatalog)
                .map(existCarCatalog -> CarCatalogCreateDTO.builder()
                        .registrationNumber(carCatalog.getRegistrationNumber())
                        .carType(carCatalog.getCarType())
                        .yearOfManufacture(carCatalog.getYearOfManufacture())
                        .make(carCatalog.getMake())
                        .model(carCatalog.getModel())
                        .colour(carCatalog.getColour())
                        .price(carCatalog.getPrice())
                        .carStatus(carCatalog.getCarStatus())
                        .build())
                .orElse(null);
    }

    public static CarCatalogUpdateDTO toCarCatalogUpdateDTO(CarCatalog carCatalog) {
        return Optional.ofNullable(carCatalog)
                .map(existCarCatalog -> CarCatalogUpdateDTO.builder()
                        .registrationNumber(carCatalog.getRegistrationNumber())
                        .carType(carCatalog.getCarType())
                        .yearOfManufacture(carCatalog.getYearOfManufacture())
                        .make(carCatalog.getMake())
                        .model(carCatalog.getModel())
                        .colour(carCatalog.getColour())
                        .price(carCatalog.getPrice())
                        .carStatus(carCatalog.getCarStatus())
                        .build())
                .orElse(null);
    }
}
