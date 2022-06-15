package com.microservices.car.service.dataimpl;

import com.microservices.car.dto.request.CarCatalogRequestDTO;
import com.microservices.car.dto.request.CarCatalogUpdateRequestDTO;
import com.microservices.car.dto.response.CarCatalogResponseDTO;
import com.microservices.car.entity.CarCatalog;
import com.microservices.car.entity.CarStatus;
import com.microservices.car.entity.CarType;
import com.microservices.car.mapper.request.CarCatalogRequestDTOToCarCatalogMapper;
import com.microservices.car.mapper.request.CarCatalogUpdateRequestDTOToCarCatalogMapper;
import com.microservices.car.mapper.response.CarCatalogToCarCatalogResponseDTOMapper;
import com.microservices.car.repository.CarCatalogRepository;
import com.microservices.car.service.CarCatalogService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarCatalogServiceImpl implements CarCatalogService {

    private final CarCatalogRepository carCatalogRepository;

    @Override
    public Page<CarCatalog> getAllCarCatalogs(Pageable pageable) {
        return carCatalogRepository.findAll(pageable);
    }

    @Override
    public Optional<CarCatalog> getAllCarCatalogByRegistrationNumber(String registrationNumber) {
        return carCatalogRepository.findByRegistrationNumber(registrationNumber);
    }

    @Override
    public Page<CarCatalog> getAllCarCatalogByCarType(CarType carType, Pageable pageable) {
        return carCatalogRepository.findAllByCarType(carType, pageable);
    }

    @Override
    public Page<CarCatalog> getAllCarCatalogByMake(String make, Pageable pageable) {
        return carCatalogRepository.findAllByMake(make, pageable);
    }

    @Override
    public Page<CarCatalog> getAllCarCatalogByModel(String model, Pageable pageable) {
        return carCatalogRepository.findAllByModel(model, pageable);
    }

    @Override
    public Page<CarCatalog> getAllCarCatalogByPrice(BigDecimal price, Pageable pageable) {
        return carCatalogRepository.findAllByPrice(price, pageable);
    }

    @Override
    public Page<CarCatalog> getAllCarCatalogCarStatus(CarStatus carStatus, Pageable pageable) {
        return carCatalogRepository.findAllByCarStatus(carStatus, pageable);
    }

    @Override
    public Optional<CarCatalog> getCarCatalogById(long carCatalogId) {
        return carCatalogRepository.findById(carCatalogId);
    }

    @Override
    @Transactional
    public CarCatalog createCarCatalog(CarCatalog carCatalog) {
        return carCatalogRepository.save(carCatalog);
    }

    @Override
    @Transactional
    public CarCatalog updateCarCatalog(CarCatalog carCatalog) {
        CarCatalog maybeCarCatalog = carCatalogRepository.findById(carCatalog.getId())
                .orElseThrow(() -> new ServiceException("Failed to update CarCatalog no such CarCatalog"));
        return carCatalogRepository.save(maybeCarCatalog);
    }

    @Override
    @Transactional
    public boolean deleteCarCatalog(long carCatalogId) {
        carCatalogRepository.deleteById(carCatalogId);

        return carCatalogRepository.findById(carCatalogId).isEmpty();
    }
}
