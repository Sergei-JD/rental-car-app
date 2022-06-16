package com.microservices.car.service;

import com.microservices.car.entity.CarCatalog;
import com.microservices.car.entity.CarStatus;
import com.microservices.car.entity.CarType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface CarCatalogService {

    Page<CarCatalog> getAllCarCatalogs(Pageable pageable);

    CarCatalog getAllCarCatalogByRegistrationNumber(String registrationNumber);

    Page<CarCatalog> getAllCarCatalogByCarType(CarType carType, Pageable pageable);

    Page<CarCatalog> getAllCarCatalogByMake(String make, Pageable pageable);

    Page<CarCatalog> getAllCarCatalogByModel(String model, Pageable pageable);

    Page<CarCatalog> getAllCarCatalogByPrice(BigDecimal price, Pageable pageable);

    Page<CarCatalog> getAllCarCatalogCarStatus(CarStatus carStatus, Pageable pageable);

    CarCatalog getCarCatalogById(long carCatalogId);

    CarCatalog createCarCatalog(CarCatalog carCatalog);

    CarCatalog updateCarCatalog(CarCatalog carCatalog);

    boolean deleteCarCatalog(long carCatalogId);
}
