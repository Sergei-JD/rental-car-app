package com.microservices.car.controller;

import com.microservices.car.dto.request.CarCatalogRequestDTO;
import com.microservices.car.dto.request.CarCatalogUpdateRequestDTO;
import com.microservices.car.dto.response.CarCatalogResponseDTO;
import com.microservices.car.entity.CarStatus;
import com.microservices.car.entity.CarType;
import com.microservices.car.service.CarCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cars")
public class CarCatalogController {

    private final CarCatalogService carCatalogService;

    @GetMapping
    public ResponseEntity<Page<CarCatalogResponseDTO>> getAllCarCatalogs(Pageable pageable) {
        Page<CarCatalogResponseDTO> carCatalogs = carCatalogService.getAllCarCatalogs(pageable);
        return new ResponseEntity<>(carCatalogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarCatalogResponseDTO> getCarCatalogById(@PathVariable(name = "id") Long id) {
        Optional<CarCatalogResponseDTO> carCatalogResponseDTO = carCatalogService.getCarCatalogById(id);
        return carCatalogResponseDTO.map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK))
                .orElseThrow(() -> new RuntimeException(
                        "CarCatalog with this id: " + id + " does not exist")
                );
    }

    @GetMapping("/reg-num")
    public ResponseEntity<CarCatalogResponseDTO> getAllCarCatalogByRegistrationNumber(@RequestParam(name = "reg-num") String registrationNumber) {
        Optional<CarCatalogResponseDTO> carCatalogResponseDTO = carCatalogService.getAllCarCatalogByRegistrationNumber(registrationNumber);
        return carCatalogResponseDTO.map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK))
                .orElseThrow(() -> new RuntimeException(
                        "Car with this registrationNumber: " + registrationNumber + " does not exist")
                );
    }

    @GetMapping("/type")
    public ResponseEntity<Page<CarCatalogResponseDTO>> getAllCarCatalogByCarType(@RequestParam(name = "type") CarType carType, Pageable pageable) {
        Page<CarCatalogResponseDTO> cars = carCatalogService.getAllCarCatalogByCarType(carType, pageable);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/make")
    public ResponseEntity<Page<CarCatalogResponseDTO>> getAllCarCatalogByMake(@RequestParam(name = "make") String make, Pageable pageable) {
        Page<CarCatalogResponseDTO> cars = carCatalogService.getAllCarCatalogByMake(make, pageable);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/model")
    public ResponseEntity<Page<CarCatalogResponseDTO>> getAllCarCatalogByModel(@RequestParam(name = "model") String model, Pageable pageable) {
        Page<CarCatalogResponseDTO> cars = carCatalogService.getAllCarCatalogByModel(model, pageable);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<Page<CarCatalogResponseDTO>> getAllCarCatalogByPrice(@RequestParam(name = "price") BigDecimal price, Pageable pageable) {
        Page<CarCatalogResponseDTO> cars = carCatalogService.getAllCarCatalogByPrice(price, pageable);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<CarCatalogResponseDTO>> getAllCarCatalogCarStatus(@RequestParam(name = "status") CarStatus carStatus, Pageable pageable) {
        Page<CarCatalogResponseDTO> cars = carCatalogService.getAllCarCatalogCarStatus(carStatus, pageable);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarCatalogResponseDTO> createCarCatalog(@RequestBody @Valid CarCatalogRequestDTO carCatalogRequestDTO) {
        CarCatalogResponseDTO addCarCatalog = carCatalogService.createCarCatalog(carCatalogRequestDTO);
        return new ResponseEntity<>(addCarCatalog, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CarCatalogResponseDTO> updateCarCatalog(@RequestBody CarCatalogUpdateRequestDTO carCatalogUpdateRequestDTO) {
        CarCatalogResponseDTO updatedCarCatalog = carCatalogService.updateCarCatalog(carCatalogUpdateRequestDTO);
        return new ResponseEntity<>(updatedCarCatalog, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCarCatalog(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(carCatalogService.deleteCarCatalog(id), HttpStatus.OK);
    }
}
