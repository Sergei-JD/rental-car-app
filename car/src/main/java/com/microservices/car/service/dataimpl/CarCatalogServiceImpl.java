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
    private final CarCatalogRequestDTOToCarCatalogMapper carCatalogRequestDTOToCarCatalogMapper;
    private final CarCatalogToCarCatalogResponseDTOMapper carCatalogToCarCatalogResponseDTOMapper;
    private final CarCatalogUpdateRequestDTOToCarCatalogMapper carCatalogUpdateRequestDTOToCarCatalogMapper;

    @Override
    public Page<CarCatalogResponseDTO> getAllCarCatalogs(Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAll(pageable);

        List<CarCatalogResponseDTO> carCatalogs = pageCarCatalogs.stream()
                .map(carCatalogToCarCatalogResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(carCatalogs);
    }

    @Override
    public Optional<CarCatalogResponseDTO> getAllCarCatalogByRegistrationNumber(String registrationNumber) {
        CarCatalogResponseDTO carCatalogResponseDTO = null;

        Optional<CarCatalog> carCatalog = carCatalogRepository.findByRegistrationNumber(registrationNumber);
        if (carCatalog.isPresent()) {
            carCatalogResponseDTO = carCatalogToCarCatalogResponseDTOMapper.convert(carCatalog.get());
        }

        return Optional.ofNullable(carCatalogResponseDTO);
    }

    @Override
    public Page<CarCatalogResponseDTO> getAllCarCatalogByCarType(CarType carType, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByCarType(carType, pageable);

        List<CarCatalogResponseDTO> creditCarCatalogs = pageCarCatalogs.stream()
                .map(carCatalogToCarCatalogResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(creditCarCatalogs);
    }

    @Override
    public Page<CarCatalogResponseDTO> getAllCarCatalogByMake(String make, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByMake(make, pageable);

        List<CarCatalogResponseDTO> creditCarCatalogs = pageCarCatalogs.stream()
                .map(carCatalogToCarCatalogResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(creditCarCatalogs);
    }

    @Override
    public Page<CarCatalogResponseDTO> getAllCarCatalogByModel(String model, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByModel(model, pageable);

        List<CarCatalogResponseDTO> creditCarCatalogs = pageCarCatalogs.stream()
                .map(carCatalogToCarCatalogResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(creditCarCatalogs);
    }

    @Override
    public Page<CarCatalogResponseDTO> getAllCarCatalogByPrice(BigDecimal price, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByPrice(price, pageable);

        List<CarCatalogResponseDTO> creditCarCatalogs = pageCarCatalogs.stream()
                .map(carCatalogToCarCatalogResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(creditCarCatalogs);
    }

    @Override
    public Page<CarCatalogResponseDTO> getAllCarCatalogCarStatus(CarStatus carStatus, Pageable pageable) {
        Page<CarCatalog> pageCarCatalogs = carCatalogRepository.findAllByCarStatus(carStatus, pageable);

        List<CarCatalogResponseDTO> creditCarCatalogs = pageCarCatalogs.stream()
                .map(carCatalogToCarCatalogResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(creditCarCatalogs);
    }

    @Override
    public Optional<CarCatalogResponseDTO> getCarCatalogById(long carCatalogId) {
        CarCatalogResponseDTO carCatalogResponseDTO = null;

        Optional<CarCatalog> carCatalog = carCatalogRepository.findById(carCatalogId);
        if (carCatalog.isPresent()) {
            carCatalogResponseDTO = carCatalogToCarCatalogResponseDTOMapper.convert(carCatalog.get());
        }

        return Optional.ofNullable(carCatalogResponseDTO);
    }

    @Override
    @Transactional
    public CarCatalogResponseDTO createCarCatalog(CarCatalogRequestDTO carCatalogRequestDTO) {
        CarCatalog newCarCatalog = carCatalogRequestDTOToCarCatalogMapper.convert(carCatalogRequestDTO);
        CarCatalog saveCarCatalog = carCatalogRepository.save(Objects.requireNonNull(newCarCatalog));

        return carCatalogToCarCatalogResponseDTOMapper.convert(saveCarCatalog);
    }

    @Override
    @Transactional
    public CarCatalogResponseDTO updateCarCatalog(CarCatalogUpdateRequestDTO carCatalogUpdateRequestDTO) {
        carCatalogRepository.findById(carCatalogUpdateRequestDTO.getCarCatalogId())
                .orElseThrow(() -> new ServiceException("Failed to update carCatalog no such carCatalog"));

        CarCatalog сarCatalog = carCatalogUpdateRequestDTOToCarCatalogMapper.convert(carCatalogUpdateRequestDTO);
        CarCatalog updateCarCatalog = carCatalogRepository.save(Objects.requireNonNull(сarCatalog));

        return carCatalogToCarCatalogResponseDTOMapper.convert(updateCarCatalog);
    }

    @Override
    @Transactional
    public boolean deleteCarCatalog(long carCatalogId) {
        carCatalogRepository.deleteById(carCatalogId);

        return carCatalogRepository.findById(carCatalogId).isEmpty();
    }
}
