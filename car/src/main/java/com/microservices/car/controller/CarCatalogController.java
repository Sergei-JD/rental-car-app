package com.microservices.car.controller;

import com.microservices.car.dto.create.CarCatalogCreateDTO;
import com.microservices.car.dto.update.CarCatalogUpdateDTO;
import com.microservices.car.dto.view.CarCatalogViewDTO;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cars")
public class CarCatalogController {

    private final CarCatalogService carCatalogService;

    @GetMapping
    public ResponseEntity<Page<CarCatalogViewDTO>> getAllCarCatalogs(Pageable pageable) {
        Page<CarCatalogViewDTO> carCatalogs = carCatalogService.getAllCarCatalogs(pageable);

        return new ResponseEntity<>(carCatalogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarCatalogViewDTO> getCarCatalogById(
            @PathVariable(name = "id") Long id) {
        CarCatalogViewDTO carCatalogViewDTO = carCatalogService.getCarCatalogById(id);

        return new ResponseEntity<>(carCatalogViewDTO, HttpStatus.OK);
    }

    @GetMapping("/reg-num")
    public ResponseEntity<CarCatalogViewDTO> getAllCarCatalogByRegistrationNumber(
            @RequestParam(name = "reg-num") String registrationNumber) {
        CarCatalogViewDTO carCatalogViewDTO = carCatalogService.getAllCarCatalogByRegistrationNumber(registrationNumber);

        return new ResponseEntity<>(carCatalogViewDTO, HttpStatus.OK);
    }

    @GetMapping("/type")
    public ResponseEntity<Page<CarCatalogViewDTO>> getAllCarCatalogByCarType(
            @RequestParam(name = "type") CarType carType, Pageable pageable) {
        Page<CarCatalogViewDTO> carCatalogs = carCatalogService.getAllCarCatalogByCarType(carType, pageable);

        return new ResponseEntity<>(carCatalogs, HttpStatus.OK);
    }

    @GetMapping("/make")
    public ResponseEntity<Page<CarCatalogViewDTO>> getAllCarCatalogByMake(
            @RequestParam(name = "make") String make, Pageable pageable) {
        Page<CarCatalogViewDTO> carCatalogs = carCatalogService.getAllCarCatalogByMake(make, pageable);

        return new ResponseEntity<>(carCatalogs, HttpStatus.OK);
    }

    @GetMapping("/model")
    public ResponseEntity<Page<CarCatalogViewDTO>> getAllCarCatalogByModel(
            @RequestParam(name = "model") String model, Pageable pageable) {
        Page<CarCatalogViewDTO> carCatalogs = carCatalogService.getAllCarCatalogByModel(model, pageable);

        return new ResponseEntity<>(carCatalogs, HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<Page<CarCatalogViewDTO>> getAllCarCatalogByPrice(
            @RequestParam(name = "price") BigDecimal price, Pageable pageable) {
        Page<CarCatalogViewDTO> carCatalogs = carCatalogService.getAllCarCatalogByPrice(price, pageable);

        return new ResponseEntity<>(carCatalogs, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<CarCatalogViewDTO>> getAllCarCatalogCarStatus(
            @RequestParam(name = "status") CarStatus carStatus, Pageable pageable) {
        Page<CarCatalogViewDTO> carCatalogs = carCatalogService.getAllCarCatalogCarStatus(carStatus, pageable);

        return new ResponseEntity<>(carCatalogs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarCatalogCreateDTO> createCarCatalog(
            @RequestBody @Valid CarCatalogCreateDTO carCatalogCreateDTO) {
        CarCatalogCreateDTO addCarCatalog = carCatalogService.createCarCatalog(carCatalogCreateDTO);

        return new ResponseEntity<>(addCarCatalog, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarCatalogUpdateDTO> updateCarCatalog(
            @PathVariable(name = "id") Long id,
            @RequestBody CarCatalogUpdateDTO carCatalogUpdateDTO) {
        CarCatalogUpdateDTO updateCarCatalog = carCatalogService.updateCarCatalog(id, carCatalogUpdateDTO);

        return new ResponseEntity<>(updateCarCatalog, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCarCatalog(@PathVariable(name = "id") Long id) {
        boolean deleteCarCatalog = carCatalogService.deleteCarCatalog(id);

        return new ResponseEntity<>(deleteCarCatalog, HttpStatus.OK);
    }
}
