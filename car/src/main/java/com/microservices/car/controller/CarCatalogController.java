package com.microservices.car.controller;

import com.microservices.car.dto.request.CarCatalogRequestDTO;
import com.microservices.car.dto.request.UpdateCarCatalogDTO;
import com.microservices.car.dto.response.CarCatalogResponseDTO;
import com.microservices.car.entity.CarCatalog;
import com.microservices.car.entity.CarStatus;
import com.microservices.car.entity.CarType;
import com.microservices.car.mapper.request.CarCatalogRequestDTOToCarCatalogMapper;
import com.microservices.car.mapper.request.UpdateCarCatalogDTOToCarCatalogMapper;
import com.microservices.car.mapper.response.CarCatalogToCarCatalogResponseDTOMapper;
import com.microservices.car.service.CarCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cars")
public class CarCatalogController {

    private final CarCatalogService carCatalogService;
    private final CarCatalogRequestDTOToCarCatalogMapper carCatalogRequestDTOToCarCatalogMapper;
    private final CarCatalogToCarCatalogResponseDTOMapper carCatalogToCarCatalogResponseDTOMapper;
    private final UpdateCarCatalogDTOToCarCatalogMapper updateCarCatalogDTOToCarCatalogMapper;

    @GetMapping
    public ResponseEntity<List<CarCatalogResponseDTO>> getAllCarCatalogs(Pageable pageable) {
        List<CarCatalogResponseDTO> cars = carCatalogService.getAllCarCatalogs(pageable).stream()
                .map(carCatalogToCarCatalogResponseDTOMapper::convert)
                .toList();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarCatalogResponseDTO> getCarCatalogById(@PathVariable(name = "id") Long id) {
        CarCatalog carCatalog = carCatalogService.getCarCatalogById(id);
        CarCatalogResponseDTO carCatalogResponseDTO = carCatalogToCarCatalogResponseDTOMapper.convert(carCatalog);

        return new ResponseEntity<>(carCatalogResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/reg-num")
    public ResponseEntity<CarCatalogResponseDTO> getAllCarCatalogByRegistrationNumber(@RequestParam(name = "reg-num") String registrationNumber) {
        CarCatalog carCatalog = carCatalogService.getAllCarCatalogByRegistrationNumber(registrationNumber);
        CarCatalogResponseDTO carCatalogResponseDTO = carCatalogToCarCatalogResponseDTOMapper.convert(carCatalog);

        return new ResponseEntity<>(carCatalogResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/type")
    public ResponseEntity<List<CarCatalogResponseDTO>> getAllCarCatalogByCarType(@RequestParam(name = "type") CarType carType, Pageable pageable) {
        List<CarCatalogResponseDTO> cars = carCatalogService.getAllCarCatalogByCarType(carType, pageable).stream()
                .map(carCatalogToCarCatalogResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/make")
    public ResponseEntity<List<CarCatalogResponseDTO>> getAllCarCatalogByMake(@RequestParam(name = "make") String make, Pageable pageable) {
        List<CarCatalogResponseDTO> cars = carCatalogService.getAllCarCatalogByMake(make, pageable).stream()
                .map(carCatalogToCarCatalogResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/model")
    public ResponseEntity<List<CarCatalogResponseDTO>> getAllCarCatalogByModel(@RequestParam(name = "model") String model, Pageable pageable) {
        List<CarCatalogResponseDTO> cars = carCatalogService.getAllCarCatalogByModel(model, pageable).stream()
                .map(carCatalogToCarCatalogResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<List<CarCatalogResponseDTO>> getAllCarCatalogByPrice(@RequestParam(name = "price") BigDecimal price, Pageable pageable) {
        List<CarCatalogResponseDTO> cars = carCatalogService.getAllCarCatalogByPrice(price, pageable).stream()
                .map(carCatalogToCarCatalogResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<CarCatalogResponseDTO>> getAllCarCatalogCarStatus(@RequestParam(name = "status") CarStatus carStatus, Pageable pageable) {
        List<CarCatalogResponseDTO> cars = carCatalogService.getAllCarCatalogCarStatus(carStatus, pageable).stream()
                .map(carCatalogToCarCatalogResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarCatalogResponseDTO> createCarCatalog(@RequestBody @Valid CarCatalogRequestDTO carCatalogRequestDTO) {
        CarCatalog carCatalog = carCatalogRequestDTOToCarCatalogMapper.convert(carCatalogRequestDTO);
        CarCatalog createdCarCatalog = carCatalogService.createCarCatalog(carCatalog);
        CarCatalogResponseDTO addCarCatalog = carCatalogToCarCatalogResponseDTOMapper.convert(createdCarCatalog);

        return new ResponseEntity<>(addCarCatalog, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CarCatalogResponseDTO> updateCarCatalog(@RequestBody UpdateCarCatalogDTO updateCarCatalogDTO) {
        CarCatalog carCatalog = updateCarCatalogDTOToCarCatalogMapper.convert(updateCarCatalogDTO);
        CarCatalog updateCarCatalog = carCatalogService.updateCarCatalog(carCatalog);
        CarCatalogResponseDTO updatedCarCatalog = carCatalogToCarCatalogResponseDTOMapper.convert(updateCarCatalog);

        return new ResponseEntity<>(updatedCarCatalog, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCarCatalog(@PathVariable(name = "id") Long id) {
        boolean deleteCarCatalog = carCatalogService.deleteCarCatalog(id);

        return new ResponseEntity<>(deleteCarCatalog, HttpStatus.OK);
    }
}
