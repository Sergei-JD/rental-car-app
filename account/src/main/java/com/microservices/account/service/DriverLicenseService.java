package com.microservices.account.service;

import com.microservices.account.dto.request.DriverLicenseRequestDTO;
import com.microservices.account.dto.response.DriverLicenseResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DriverLicenseService {

    Page<DriverLicenseResponseDTO> getAllDriverLicenses(Pageable pageable);

    Optional<DriverLicenseResponseDTO> getAllDriverLicenseByAccountId(Long accountId);

    Optional<DriverLicenseResponseDTO> getDriverLicenseById(long driverLicenseId);

    DriverLicenseResponseDTO createDriverLicense(DriverLicenseRequestDTO driverLicenseRequestDTO);

    DriverLicenseResponseDTO updateDriverLicense(Long driverLicenseId, DriverLicenseRequestDTO driverLicenseRequestDTO);

    boolean deleteDriverLicense(long driverLicenseId);
}
