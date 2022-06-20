package com.microservices.car.controller;

import com.microservices.car.dto.create.CreateCarCatalogDTO;
import com.microservices.car.dto.update.UpdateCarCatalogDTO;
import com.microservices.car.dto.view.ViewCarCatalogDTO;
import com.microservices.car.entity.CarCatalog;
import com.microservices.car.entity.CarStatus;
import com.microservices.car.entity.CarType;
import com.microservices.car.mapper.CarCatalogMapper;
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
    public ResponseEntity<Page<ViewCarCatalogDTO>> getAllCarCatalogs(Pageable pageable) {
        Page<ViewCarCatalogDTO> carCatalogs = carCatalogService.getAllCarCatalogs(pageable);

        return new ResponseEntity<>(carCatalogs, HttpStatus.OK);
    }

    @GetMapping("/type")
    public ResponseEntity<Page<ViewCarCatalogDTO>> getAllCarCatalogByCarType(
            @RequestParam(name = "type") CarType carType, Pageable pageable) {
        Page<ViewCarCatalogDTO> carCatalogs = carCatalogService.getAllCarCatalogByCarType(carType, pageable);

        return new ResponseEntity<>(carCatalogs, HttpStatus.OK);
    }

    @GetMapping("/make")
    public ResponseEntity<Page<ViewCarCatalogDTO>> getAllCarCatalogByMake(
            @RequestParam(name = "make") String make, Pageable pageable) {
        Page<ViewCarCatalogDTO> carCatalogs = carCatalogService.getAllCarCatalogByMake(make, pageable);

        return new ResponseEntity<>(carCatalogs, HttpStatus.OK);
    }

    @GetMapping("/model")
    public ResponseEntity<Page<ViewCarCatalogDTO>> getAllCarCatalogByModel(
            @RequestParam(name = "model") String model, Pageable pageable) {
        Page<ViewCarCatalogDTO> carCatalogs = carCatalogService.getAllCarCatalogByModel(model, pageable);

        return new ResponseEntity<>(carCatalogs, HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<Page<ViewCarCatalogDTO>> getAllCarCatalogByPrice(
            @RequestParam(name = "price") BigDecimal price, Pageable pageable) {
        Page<ViewCarCatalogDTO> carCatalogs = carCatalogService.getAllCarCatalogByPrice(price, pageable);

        return new ResponseEntity<>(carCatalogs, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<ViewCarCatalogDTO>> getAllCarCatalogCarStatus(
            @RequestParam(name = "status") CarStatus carStatus, Pageable pageable) {
        Page<ViewCarCatalogDTO> carCatalogs = carCatalogService.getAllCarCatalogCarStatus(carStatus, pageable);

        return new ResponseEntity<>(carCatalogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewCarCatalogDTO> getCarCatalogById(
            @PathVariable(name = "id") Long id) {
        CarCatalog carCatalog = carCatalogService.getCarCatalogById(id);
        ViewCarCatalogDTO viewCarCatalogDTO = CarCatalogMapper.toViewCarCatalogDTO(carCatalog);

        return new ResponseEntity<>(viewCarCatalogDTO, HttpStatus.OK);
    }

    @GetMapping("/reg-num")
    public ResponseEntity<ViewCarCatalogDTO> getAllCarCatalogByRegistrationNumber(
            @RequestParam(name = "reg-num") String registrationNumber) {
        CarCatalog carCatalog = carCatalogService.getAllCarCatalogByRegistrationNumber(registrationNumber);
        ViewCarCatalogDTO viewCarCatalogDTO = CarCatalogMapper.toViewCarCatalogDTO(carCatalog);

        return new ResponseEntity<>(viewCarCatalogDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createCarCatalog(
            @RequestBody @Valid CreateCarCatalogDTO createCarCatalogDTO) {
        Long addCarCatalog = carCatalogService.createCarCatalog(createCarCatalogDTO);

        return new ResponseEntity<>(addCarCatalog, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCarCatalog(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateCarCatalogDTO updateCarCatalogDTO) {
        carCatalogService.updateCarCatalog(id, updateCarCatalogDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCarCatalog(@PathVariable(name = "id") Long id) {
        boolean deleteCarCatalog = carCatalogService.deleteCarCatalog(id);

        return new ResponseEntity<>(deleteCarCatalog, HttpStatus.OK);
    }
}
