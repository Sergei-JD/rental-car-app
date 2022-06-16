package com.microservices.account.controller;

import com.microservices.account.dto.request.DriverLicenseRequestDTO;
import com.microservices.account.dto.request.UpdateDriverLicenseDTO;
import com.microservices.account.dto.response.DriverLicenseResponseDTO;
import com.microservices.account.entity.DriverLicense;
import com.microservices.account.mapper.request.DriverLicenseRequestDTOToDriverLicenseMapper;
import com.microservices.account.mapper.request.UpdateDriverLicenseDTOToDriverLicenseMapper;
import com.microservices.account.mapper.response.DriverLicenseToDriverLicenseResponseDTOMapper;
import com.microservices.account.service.DriverLicenseService;
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
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/licenses")
public class DriverLicenseController {

    private final DriverLicenseService driverLicenseService;
    private final DriverLicenseRequestDTOToDriverLicenseMapper driverLicenseRequestDTOToDriverLicenseMapper;
    private final DriverLicenseToDriverLicenseResponseDTOMapper driverLicenseToDriverLicenseResponseDTOMapper;
    private final UpdateDriverLicenseDTOToDriverLicenseMapper updateDriverLicenseDTOToDriverLicenseMapper;

    @GetMapping
    public ResponseEntity<List<DriverLicenseResponseDTO>> getAllDriverLicenses(Pageable pageable) {
        List<DriverLicenseResponseDTO> driverLicenses = driverLicenseService.getAllDriverLicenses(pageable).stream()
                .map(driverLicenseToDriverLicenseResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(driverLicenses, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<List<DriverLicenseResponseDTO>> getAllDriverLicensesByAccountId(@PathVariable(name = "id") Long id, Pageable pageable) {
        List<DriverLicenseResponseDTO> licences = driverLicenseService.getAllDriverLicenseByAccountId(id, pageable).stream()
                .map(driverLicenseToDriverLicenseResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(licences, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverLicenseResponseDTO> getDriverLicenseById(@PathVariable(name = "id") Long id) {
        DriverLicense driverLicense = driverLicenseService.getDriverLicenseById(id);
        DriverLicenseResponseDTO driverLicenseResponseDTO = driverLicenseToDriverLicenseResponseDTOMapper.convert(driverLicense);

        return new ResponseEntity<>(driverLicenseResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DriverLicenseResponseDTO> createDriverLicense(@RequestBody @Valid DriverLicenseRequestDTO driverLicenseRequestDTO) {
        DriverLicense driverLicense = driverLicenseRequestDTOToDriverLicenseMapper.convert(driverLicenseRequestDTO);
        DriverLicense createdDriverLicense = driverLicenseService.createDriverLicense(driverLicense);
        DriverLicenseResponseDTO addDriverLicense = driverLicenseToDriverLicenseResponseDTOMapper.convert(createdDriverLicense);

        return new ResponseEntity<>(addDriverLicense, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DriverLicenseResponseDTO> updateDriverLicense(@RequestBody @Valid UpdateDriverLicenseDTO updateDriverLicenseDTO) {
        DriverLicense driverLicense = updateDriverLicenseDTOToDriverLicenseMapper.convert(updateDriverLicenseDTO);
        DriverLicense updateDriverLicense = driverLicenseService.updateDriverLicense(driverLicense);
        DriverLicenseResponseDTO updatedDriverLicense = driverLicenseToDriverLicenseResponseDTOMapper.convert(updateDriverLicense);

        return new ResponseEntity<>(updatedDriverLicense, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDriverLicense(@PathVariable(name = "id") Long id) {
        boolean deleteDriverLicense = driverLicenseService.deleteDriverLicense(id);

        return new ResponseEntity<>(deleteDriverLicense, HttpStatus.OK);
    }
}
