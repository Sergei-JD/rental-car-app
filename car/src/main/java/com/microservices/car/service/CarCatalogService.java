package com.microservices.car.service;

import com.microservices.car.dto.create.CarCatalogCreateDTO;
import com.microservices.car.dto.update.CarCatalogUpdateDTO;
import com.microservices.car.dto.view.CarCatalogViewDTO;
import com.microservices.car.entity.CarStatus;
import com.microservices.car.entity.CarType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface CarCatalogService {

    Page<CarCatalogViewDTO> getAllCarCatalogs(Pageable pageable);

    CarCatalogViewDTO getAllCarCatalogByRegistrationNumber(String registrationNumber);

    Page<CarCatalogViewDTO> getAllCarCatalogByCarType(CarType carType, Pageable pageable);

    Page<CarCatalogViewDTO> getAllCarCatalogByMake(String make, Pageable pageable);

    Page<CarCatalogViewDTO> getAllCarCatalogByModel(String model, Pageable pageable);

    Page<CarCatalogViewDTO> getAllCarCatalogByPrice(BigDecimal price, Pageable pageable);

    Page<CarCatalogViewDTO> getAllCarCatalogCarStatus(CarStatus carStatus, Pageable pageable);

    CarCatalogViewDTO getCarCatalogById(Long carCatalogId);

    CarCatalogCreateDTO createCarCatalog(CarCatalogCreateDTO carCatalogCreateDTO);

    CarCatalogUpdateDTO updateCarCatalog(Long carCatalogId, CarCatalogUpdateDTO carCatalogUpdateDTO);

    boolean deleteCarCatalog(long carCatalogId);
}
