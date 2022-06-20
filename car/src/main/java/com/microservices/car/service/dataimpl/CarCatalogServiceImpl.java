package com.microservices.car.service.dataimpl;

import com.microservices.car.dto.create.CreateCarCatalogDTO;
import com.microservices.car.dto.update.UpdateCarCatalogDTO;
import com.microservices.car.dto.view.ViewCarCatalogDTO;
import com.microservices.car.entity.CarCatalog;
import com.microservices.car.entity.CarStatus;
import com.microservices.car.entity.CarType;
import com.microservices.car.mapper.CarCatalogMapper;
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

import static com.microservices.car.util.ServiceData.CAR_CATALOG_ID_EXCEPTION_MESSAGE;
import static com.microservices.car.util.ServiceData.CAR_CATALOG_REGISTRATION_NUMBER_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class CarCatalogServiceImpl implements CarCatalogService {

    private final CarCatalogRepository carCatalogRepository;

    @Override
    public Page<ViewCarCatalogDTO> getAllCarCatalogs(Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAll(pageable);

        List<ViewCarCatalogDTO> cars = pageCarCatalogs.stream()
                .map(CarCatalogMapper::toViewCarCatalogDTO)
                .toList();

        return new PageImpl<>(cars);
    }

    @Override
    public Page<ViewCarCatalogDTO> getAllCarCatalogByCarType(CarType carType, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByCarType(carType, pageable);

        List<ViewCarCatalogDTO> cars = pageCarCatalogs.stream()
                .map(CarCatalogMapper::toViewCarCatalogDTO)
                .toList();

        return new PageImpl<>(cars);
    }

    @Override
    public Page<ViewCarCatalogDTO> getAllCarCatalogByMake(String make, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByMake(make, pageable);

        List<ViewCarCatalogDTO> cars = pageCarCatalogs.stream()
                .map(CarCatalogMapper::toViewCarCatalogDTO)
                .toList();

        return new PageImpl<>(cars);
    }

    @Override
    public Page<ViewCarCatalogDTO> getAllCarCatalogByModel(String model, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByModel(model, pageable);

        List<ViewCarCatalogDTO> cars = pageCarCatalogs.stream()
                .map(CarCatalogMapper::toViewCarCatalogDTO)
                .toList();

        return new PageImpl<>(cars);
    }

    @Override
    public Page<ViewCarCatalogDTO> getAllCarCatalogByPrice(BigDecimal price, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByPrice(price, pageable);

        List<ViewCarCatalogDTO> cars = pageCarCatalogs.stream()
                .map(CarCatalogMapper::toViewCarCatalogDTO)
                .toList();

        return new PageImpl<>(cars);
    }

    @Override
    public Page<ViewCarCatalogDTO> getAllCarCatalogCarStatus(CarStatus carStatus, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByCarStatus(carStatus, pageable);

        List<ViewCarCatalogDTO> cars = pageCarCatalogs.stream()
                .map(CarCatalogMapper::toViewCarCatalogDTO)
                .toList();

        return new PageImpl<>(cars);
    }

    @Override
    public CarCatalog getCarCatalogById(Long carCatalogId) {
        return carCatalogRepository.findById(carCatalogId)
                    .orElseThrow(() -> new ServiceException(
                            String.format(CAR_CATALOG_ID_EXCEPTION_MESSAGE, carCatalogId)));
        }

    @Override
    public CarCatalog getAllCarCatalogByRegistrationNumber(String registrationNumber) {
        return carCatalogRepository.findByRegistrationNumber(registrationNumber)
                .orElseThrow(() -> new ServiceException(
                        String.format(CAR_CATALOG_REGISTRATION_NUMBER_EXCEPTION_MESSAGE, registrationNumber)));
    }

    @Override
    @Transactional
    public Long createCarCatalog(CreateCarCatalogDTO createCarCatalogDTO) {
        CarCatalog newCarCatalog = CarCatalog.builder()
                .registrationNumber(createCarCatalogDTO.getRegistrationNumber())
                .carType(createCarCatalogDTO.getCarType())
                .yearOfManufacture(createCarCatalogDTO.getYearOfManufacture())
                .make(createCarCatalogDTO.getMake())
                .model(createCarCatalogDTO.getModel())
                .colour(createCarCatalogDTO.getColour())
                .price(createCarCatalogDTO.getPrice())
                .carStatus(createCarCatalogDTO.getCarStatus())
                .build();

        CarCatalog savedCarCatalog = carCatalogRepository.save(newCarCatalog);

        return savedCarCatalog.getId();
    }

    @Override
    @Transactional
    public void updateCarCatalog(Long carCatalogId, UpdateCarCatalogDTO updateCarCatalogDTO) {
        CarCatalog carCatalog = carCatalogRepository.findById(carCatalogId)
                .orElseThrow(() -> new ServiceException(String.format(CAR_CATALOG_ID_EXCEPTION_MESSAGE, carCatalogId)));
        carCatalog.setRegistrationNumber(updateCarCatalogDTO.getRegistrationNumber());
        carCatalog.setCarType(updateCarCatalogDTO.getCarType());
        carCatalog.setYearOfManufacture(updateCarCatalogDTO.getYearOfManufacture());
        carCatalog.setMake(updateCarCatalogDTO.getMake());
        carCatalog.setModel(updateCarCatalogDTO.getModel());
        carCatalog.setColour(updateCarCatalogDTO.getColour());
        carCatalog.setPrice(updateCarCatalogDTO.getPrice());
        carCatalog.setCarStatus(updateCarCatalogDTO.getCarStatus());

        carCatalogRepository.save(carCatalog);
    }

    @Override
    @Transactional
    public boolean deleteCarCatalog(long carCatalogId) {
        carCatalogRepository.deleteById(carCatalogId);

        return carCatalogRepository.findById(carCatalogId).isEmpty();
    }
}
