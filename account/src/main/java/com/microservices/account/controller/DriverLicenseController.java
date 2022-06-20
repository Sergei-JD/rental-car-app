package com.microservices.account.controller;

import com.microservices.account.dto.create.CreateDriverLicenseDTO;
import com.microservices.account.dto.update.UpdateDriverLicenseDTO;
import com.microservices.account.dto.view.ViewDriverLicenseDTO;
import com.microservices.account.entity.DriverLicense;
import com.microservices.account.mapper.DriverLicenseMapper;
import com.microservices.account.service.DriverLicenseService;
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
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/licenses")
public class DriverLicenseController {

    private final DriverLicenseService driverLicenseService;

    @GetMapping
    public ResponseEntity<Page<ViewDriverLicenseDTO>> getAllDriverLicenses(Pageable pageable) {
        Page<ViewDriverLicenseDTO> driverLicenses = driverLicenseService.getAllDriverLicenses(pageable);

        return new ResponseEntity<>(driverLicenses, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Page<ViewDriverLicenseDTO>> getAllDriverLicensesByAccountId(
            @PathVariable(name = "id") Long id, Pageable pageable) {
        Page<ViewDriverLicenseDTO> driverLicenses = driverLicenseService.getAllDriverLicenseByAccountId(id, pageable);

        return new ResponseEntity<>(driverLicenses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewDriverLicenseDTO> getDriverLicenseById(
            @PathVariable(name = "id") Long id) {
        DriverLicense driverLicense = driverLicenseService.getDriverLicenseById(id);
        ViewDriverLicenseDTO viewDriverLicenseDTO = DriverLicenseMapper.toViewDriverLicenseDTO(driverLicense);

        return new ResponseEntity<>(viewDriverLicenseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createDriverLicense(
            @RequestBody @Valid CreateDriverLicenseDTO createDriverLicenseDTO) {
        Long addDriverLicense = driverLicenseService.createDriverLicense(createDriverLicenseDTO);

        return new ResponseEntity<>(addDriverLicense, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDriverLicense(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid UpdateDriverLicenseDTO updateDriverLicenseDTO) {
        driverLicenseService.updateDriverLicense(id, updateDriverLicenseDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDriverLicense(
            @PathVariable(name = "id") Long id) {
        boolean deleteDriverLicense = driverLicenseService.deleteDriverLicense(id);

        return new ResponseEntity<>(deleteDriverLicense, HttpStatus.OK);
    }
}
