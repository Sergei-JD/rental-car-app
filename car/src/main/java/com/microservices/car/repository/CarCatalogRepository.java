package com.microservices.car.repository;

import com.microservices.car.entity.CarCatalog;
import com.microservices.car.entity.CarStatus;
import com.microservices.car.entity.CarType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface CarCatalogRepository extends JpaRepository<CarCatalog, Long> {

    Optional<CarCatalog> findByRegistrationNumber(String registrationNumber);

    Page<CarCatalog> findAllByCarType(CarType carType, Pageable pageable);

    Page<CarCatalog> findAllByMake(String make, Pageable pageable);

    Page<CarCatalog> findAllByModel(String model, Pageable pageable);

    Page<CarCatalog> findAllByPrice(BigDecimal price, Pageable pageable);

    Page<CarCatalog> findAllByCarStatus(CarStatus carStatus, Pageable pageable);
}
