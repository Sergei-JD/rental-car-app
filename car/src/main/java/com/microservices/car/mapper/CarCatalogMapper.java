package com.microservices.car.mapper;

import com.microservices.car.dto.create.CreateCarCatalogDTO;
import com.microservices.car.dto.update.UpdateCarCatalogDTO;
import com.microservices.car.dto.view.ViewCarCatalogDTO;
import com.microservices.car.entity.CarCatalog;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarCatalogMapper {

    public static ViewCarCatalogDTO toViewCarCatalogDTO(CarCatalog carCatalog) {
        return Optional.ofNullable(carCatalog)
                .map(existCarCatalog -> ViewCarCatalogDTO.builder()
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

    public static CreateCarCatalogDTO toCreateCarCatalogDTO(CarCatalog carCatalog) {
        return Optional.ofNullable(carCatalog)
                .map(existCarCatalog -> CreateCarCatalogDTO.builder()
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

    public static UpdateCarCatalogDTO toUpdateCarCatalogDTO(CarCatalog carCatalog) {
        return Optional.ofNullable(carCatalog)
                .map(existCarCatalog -> UpdateCarCatalogDTO.builder()
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
