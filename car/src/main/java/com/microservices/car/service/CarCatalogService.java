package com.microservices.car.service;

import com.microservices.car.dto.create.CreateCarCatalogDTO;
import com.microservices.car.dto.update.UpdateCarCatalogDTO;
import com.microservices.car.dto.view.ViewCarCatalogDTO;
import com.microservices.car.entity.CarCatalog;
import com.microservices.car.entity.CarStatus;
import com.microservices.car.entity.CarType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface CarCatalogService {

    Page<ViewCarCatalogDTO> getAllCarCatalogs(Pageable pageable);

    Page<ViewCarCatalogDTO> getAllCarCatalogByCarType(CarType carType, Pageable pageable);

    Page<ViewCarCatalogDTO> getAllCarCatalogByMake(String make, Pageable pageable);

    Page<ViewCarCatalogDTO> getAllCarCatalogByModel(String model, Pageable pageable);

    Page<ViewCarCatalogDTO> getAllCarCatalogByPrice(BigDecimal price, Pageable pageable);

    Page<ViewCarCatalogDTO> getAllCarCatalogCarStatus(CarStatus carStatus, Pageable pageable);

    CarCatalog getCarCatalogById(Long carCatalogId);

    CarCatalog getAllCarCatalogByRegistrationNumber(String registrationNumber);

    Long createCarCatalog(CreateCarCatalogDTO createCarCatalogDTO);

    void updateCarCatalog(Long carCatalogId, UpdateCarCatalogDTO updateCarCatalogDTO);

    boolean deleteCarCatalog(long carCatalogId);
}
