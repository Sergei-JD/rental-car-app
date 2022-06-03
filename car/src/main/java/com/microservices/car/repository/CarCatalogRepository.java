package com.microservices.car.repository;

import com.microservices.car.entity.CarCatalog;
import com.microservices.car.entity.CarStatus;
import com.microservices.car.entity.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarCatalogRepository extends JpaRepository<CarCatalog, Long> {

    Optional<CarCatalog> findByRegistrationNumber(String registrationNumber);

    List<CarCatalog> findAllByCarType(CarType carType);

    List<CarCatalog> findAllByMake(String make);

    List<CarCatalog> findAllByModel(String model);

    List<CarCatalog> findAllByPrice(BigDecimal price);

    List<CarCatalog> findAllByCarStatus(CarStatus carStatus);
}
