package com.microservices.car.service;

import com.microservices.car.dto.CarCatalogRequestDTO;
import com.microservices.car.dto.CarCatalogResponseFullDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CarCatalogService {

    Page<CarCatalogResponseFullDTO> getAllCarCatalogs(Pageable pageable);

    Page<CarCatalogResponseFullDTO> getAllCarCatalogCarType(String carType, Pageable pageable);

    Page<CarCatalogResponseFullDTO> getAllCarCatalogCarStatus(String carStatus, Pageable pageable);

    Optional<CarCatalogResponseFullDTO> getCarCatalogById(long carCatalogId);

    CarCatalogRequestDTO createCarCatalog(CarCatalogRequestDTO carCatalogRequestDTO);

    CarCatalogResponseFullDTO updateCarCatalog(CarCatalogResponseFullDTO carCatalogResponseFullDTO);

    boolean deleteCarCatalog(long carCatalogId);
}
