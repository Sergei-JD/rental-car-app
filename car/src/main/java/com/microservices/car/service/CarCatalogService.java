package com.microservices.car.service;

import com.microservices.car.dto.request.CarCatalogRequestDTO;
import com.microservices.car.dto.request.CarCatalogUpdateRequestDTO;
import com.microservices.car.dto.response.CarCatalogResponseDTO;
import com.microservices.car.entity.CarStatus;
import com.microservices.car.entity.CarType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Optional;

public interface CarCatalogService {

    Page<CarCatalogResponseDTO> getAllCarCatalogs(Pageable pageable);

    Optional<CarCatalogResponseDTO> getAllCarCatalogByRegistrationNumber(String registrationNumber);

    Page<CarCatalogResponseDTO> getAllCarCatalogByCarType(CarType carType, Pageable pageable);

    Page<CarCatalogResponseDTO> getAllCarCatalogByMake(String make, Pageable pageable);

    Page<CarCatalogResponseDTO> getAllCarCatalogByModel(String model, Pageable pageable);

    Page<CarCatalogResponseDTO> getAllCarCatalogByPrice(BigDecimal price, Pageable pageable);

    Page<CarCatalogResponseDTO> getAllCarCatalogCarStatus(CarStatus carStatus, Pageable pageable);

    Optional<CarCatalogResponseDTO> getCarCatalogById(long carCatalogId);

    CarCatalogResponseDTO createCarCatalog(CarCatalogRequestDTO carCatalogRequestDTO);

    CarCatalogResponseDTO updateCarCatalog(CarCatalogUpdateRequestDTO carCatalogUpdateRequestDTO);

    boolean deleteCarCatalog(long carCatalogId);
}
