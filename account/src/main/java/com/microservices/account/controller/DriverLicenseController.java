package com.microservices.account.controller;

import com.microservices.account.dto.request.DriverLicenseRequestDTO;
import com.microservices.account.dto.request.DriverLicenseUpdateRequestDTO;
import com.microservices.account.dto.response.DriverLicenseResponseDTO;
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
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/licenses")
public class DriverLicenseController {

    private final DriverLicenseService driverLicenseService;

    @GetMapping
    public ResponseEntity<Page<DriverLicenseResponseDTO>> getAllDriverLicenses(Pageable pageable) {
        Page<DriverLicenseResponseDTO> driverLicenses = driverLicenseService.getAllDriverLicenses(pageable);
        return new ResponseEntity<>(driverLicenses, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Page<DriverLicenseResponseDTO>> getAllDriverLicensesByAccountId(@PathVariable(name = "id") Long id, Pageable pageable) {
        Page<DriverLicenseResponseDTO> licenses = driverLicenseService.getAllDriverLicenseByAccountId(id, pageable);
        return new ResponseEntity<>(licenses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverLicenseResponseDTO> getDriverLicenseById(@PathVariable(name = "id") Long id) {
        Optional<DriverLicenseResponseDTO> driverLicenseResponseDTO = driverLicenseService.getDriverLicenseById(id);
        return driverLicenseResponseDTO.map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK))
                .orElseThrow(() -> new RuntimeException(
                        "DriverLicense with this id: " + id + " does not exist")
                );
    }

    @PostMapping
    public ResponseEntity<DriverLicenseResponseDTO> createDriverLicense(@RequestBody @Valid DriverLicenseRequestDTO driverLicenseRequestDTO) {
        DriverLicenseResponseDTO addDriverLicense = driverLicenseService.createDriverLicense(driverLicenseRequestDTO);
        return new ResponseEntity<>(addDriverLicense, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DriverLicenseResponseDTO> updateDriverLicense(@RequestBody @Valid DriverLicenseUpdateRequestDTO driverLicenseUpdateRequestDTO) {
        DriverLicenseResponseDTO updatedDriverLicense = driverLicenseService.updateDriverLicense(driverLicenseUpdateRequestDTO);
        return new ResponseEntity<>(updatedDriverLicense, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDriverLicense(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(driverLicenseService.deleteDriverLicense(id), HttpStatus.OK);
    }
}
