package com.microservices.car.service;

import com.microservices.car.dto.request.CarCatalogRequestDTO;
import com.microservices.car.dto.response.CarCatalogResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CarCatalogService {

    Page<CarCatalogResponseDTO> getAllCarCatalogs(Pageable pageable);

    Page<CarCatalogResponseDTO> getAllCarCatalogCarType(String carType, Pageable pageable);

    Page<CarCatalogResponseDTO> getAllCarCatalogCarStatus(String carStatus, Pageable pageable);

    Optional<CarCatalogResponseDTO> getCarCatalogById(long carCatalogId);

    CarCatalogRequestDTO createCarCatalog(CarCatalogRequestDTO carCatalogRequestDTO);

    CarCatalogResponseDTO updateCarCatalog(CarCatalogResponseDTO carCatalogResponseDTO);

    boolean deleteCarCatalog(long carCatalogId);
}
