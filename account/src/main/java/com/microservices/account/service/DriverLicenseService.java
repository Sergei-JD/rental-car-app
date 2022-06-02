package com.microservices.account.service;

import com.microservices.account.dto.DriverLicenseRequestDTO;
import com.microservices.account.dto.DriverLicenseResponseFullDTO;
import com.microservices.account.dto.DriverLicenseResponseViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DriverLicenseService {

    Page<DriverLicenseResponseViewDTO> getAllDriverLicenses(Pageable pageable);

    List<DriverLicenseResponseFullDTO> getAllDriverLicenseByAccountId(Long accountId);

    Optional<DriverLicenseResponseViewDTO> getDriverLicenseById(long driverLicenseId);

    DriverLicenseRequestDTO createDriverLicense(DriverLicenseRequestDTO driverLicenseRequestDTO);

    DriverLicenseResponseFullDTO updateDriverLicense(DriverLicenseResponseFullDTO driverLicenseResponseFullDTO);

    boolean deleteDriverLicense(long driverLicenseId);
}
