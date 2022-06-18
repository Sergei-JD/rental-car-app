package com.microservices.car.service.dataimpl;

import com.microservices.car.dto.create.CarCatalogCreateDTO;
import com.microservices.car.dto.update.CarCatalogUpdateDTO;
import com.microservices.car.dto.view.CarCatalogViewDTO;
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
    public Page<CarCatalogViewDTO> getAllCarCatalogs(Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAll(pageable);

        List<CarCatalogViewDTO> cars = pageCarCatalogs.stream()
                .map(CarCatalogMapper::toCarCatalogViewDTO)
                .toList();

        return new PageImpl<>(cars);
    }

    @Override
    public CarCatalogViewDTO getAllCarCatalogByRegistrationNumber(String registrationNumber) {
        CarCatalog carCatalog = carCatalogRepository.findByRegistrationNumber(registrationNumber)
                .orElseThrow(() -> new ServiceException(String.format(CAR_CATALOG_REGISTRATION_NUMBER_EXCEPTION_MESSAGE, registrationNumber)));

        return CarCatalogMapper.toCarCatalogViewDTO(carCatalog);
    }

    @Override
    public Page<CarCatalogViewDTO> getAllCarCatalogByCarType(CarType carType, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByCarType(carType, pageable);

        List<CarCatalogViewDTO> cars = pageCarCatalogs.stream()
                .map(CarCatalogMapper::toCarCatalogViewDTO)
                .toList();

        return new PageImpl<>(cars);
    }

    @Override
    public Page<CarCatalogViewDTO> getAllCarCatalogByMake(String make, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByMake(make, pageable);

        List<CarCatalogViewDTO> cars = pageCarCatalogs.stream()
                .map(CarCatalogMapper::toCarCatalogViewDTO)
                .toList();

        return new PageImpl<>(cars);
    }

    @Override
    public Page<CarCatalogViewDTO> getAllCarCatalogByModel(String model, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByModel(model, pageable);

        List<CarCatalogViewDTO> cars = pageCarCatalogs.stream()
                .map(CarCatalogMapper::toCarCatalogViewDTO)
                .toList();

        return new PageImpl<>(cars);
    }

    @Override
    public Page<CarCatalogViewDTO> getAllCarCatalogByPrice(BigDecimal price, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByPrice(price, pageable);

        List<CarCatalogViewDTO> cars = pageCarCatalogs.stream()
                .map(CarCatalogMapper::toCarCatalogViewDTO)
                .toList();

        return new PageImpl<>(cars);
    }

    @Override
    public Page<CarCatalogViewDTO> getAllCarCatalogCarStatus(CarStatus carStatus, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByCarStatus(carStatus, pageable);

        List<CarCatalogViewDTO> cars = pageCarCatalogs.stream()
                .map(CarCatalogMapper::toCarCatalogViewDTO)
                .toList();

        return new PageImpl<>(cars);
    }

    @Override
    public CarCatalogViewDTO getCarCatalogById(Long carCatalogId) {
            CarCatalog carCatalog = carCatalogRepository.findById(carCatalogId)
                    .orElseThrow(() -> new ServiceException(String.format(CAR_CATALOG_ID_EXCEPTION_MESSAGE, carCatalogId)));

            return CarCatalogMapper.toCarCatalogViewDTO(carCatalog);
        }

    @Override
    @Transactional
    public CarCatalogCreateDTO createCarCatalog(CarCatalogCreateDTO carCatalogCreateDTO) {
        CarCatalog newCarCatalog = CarCatalog.builder()
                .registrationNumber(carCatalogCreateDTO.getRegistrationNumber())
                .carType(carCatalogCreateDTO.getCarType())
                .yearOfManufacture(carCatalogCreateDTO.getYearOfManufacture())
                .make(carCatalogCreateDTO.getMake())
                .model(carCatalogCreateDTO.getModel())
                .colour(carCatalogCreateDTO.getColour())
                .price(carCatalogCreateDTO.getPrice())
                .carStatus(carCatalogCreateDTO.getCarStatus())
                .build();

        return CarCatalogMapper.toCarCatalogCreateDTO(carCatalogRepository.save(newCarCatalog));
    }

    @Override
    @Transactional
    public CarCatalogUpdateDTO updateCarCatalog(Long carCatalogId, CarCatalogUpdateDTO carCatalogUpdateDTO) {
        CarCatalog carCatalog = carCatalogRepository.findById(carCatalogId)
                .orElseThrow(() -> new ServiceException(String.format(CAR_CATALOG_ID_EXCEPTION_MESSAGE, carCatalogId)));
        carCatalog.setRegistrationNumber(carCatalogUpdateDTO.getRegistrationNumber());
        carCatalog.setCarType(carCatalogUpdateDTO.getCarType());
        carCatalog.setYearOfManufacture(carCatalogUpdateDTO.getYearOfManufacture());
        carCatalog.setMake(carCatalogUpdateDTO.getMake());
        carCatalog.setModel(carCatalogUpdateDTO.getModel());
        carCatalog.setColour(carCatalogUpdateDTO.getColour());
        carCatalog.setPrice(carCatalogUpdateDTO.getPrice());
        carCatalog.setCarStatus(carCatalogUpdateDTO.getCarStatus());

        carCatalogRepository.save(carCatalog);

        return CarCatalogMapper.toCarCatalogUpdateDTO(carCatalog);
    }

    @Override
    @Transactional
    public boolean deleteCarCatalog(long carCatalogId) {
        carCatalogRepository.deleteById(carCatalogId);

        return carCatalogRepository.findById(carCatalogId).isEmpty();
    }
}
