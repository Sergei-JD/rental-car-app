package com.microservices.account.controller;

import com.microservices.account.dto.create.DriverLicenseCreateDTO;
import com.microservices.account.dto.update.DriverLicenseUpdateDTO;
import com.microservices.account.dto.view.DriverLicenseViewDTO;
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
    public ResponseEntity<Page<DriverLicenseViewDTO>> getAllDriverLicenses(Pageable pageable) {
        Page<DriverLicenseViewDTO> driverLicenses = driverLicenseService.getAllDriverLicenses(pageable);

        return new ResponseEntity<>(driverLicenses, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Page<DriverLicenseViewDTO>> getAllDriverLicensesByAccountId(@PathVariable(name = "id") Long id, Pageable pageable) {
        Page<DriverLicenseViewDTO> driverLicenses = driverLicenseService.getAllDriverLicenseByAccountId(id, pageable);

        return new ResponseEntity<>(driverLicenses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverLicenseViewDTO> getDriverLicenseById(@PathVariable(name = "id") Long id) {
        DriverLicenseViewDTO driverLicenseViewDTO = driverLicenseService.getDriverLicenseById(id);

        return new ResponseEntity<>(driverLicenseViewDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DriverLicenseCreateDTO> createDriverLicense(@RequestBody @Valid DriverLicenseCreateDTO driverLicenseCreateDTO) {
        DriverLicenseCreateDTO addDriverLicense = driverLicenseService.createDriverLicense(driverLicenseCreateDTO);

        return new ResponseEntity<>(addDriverLicense, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriverLicenseUpdateDTO> updateDriverLicense(@PathVariable(name = "id") Long id,
                                                                      @RequestBody @Valid DriverLicenseUpdateDTO driverLicenseUpdateDTO) {
        DriverLicenseUpdateDTO updateDriverLicense = driverLicenseService.updateDriverLicense(id, driverLicenseUpdateDTO);

        return new ResponseEntity<>(updateDriverLicense, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDriverLicense(@PathVariable(name = "id") Long id) {
        boolean deleteDriverLicense = driverLicenseService.deleteDriverLicense(id);

        return new ResponseEntity<>(deleteDriverLicense, HttpStatus.OK);
    }
}
