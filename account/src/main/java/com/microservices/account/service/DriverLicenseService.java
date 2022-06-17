package com.microservices.account.service;

import com.microservices.account.dto.create.DriverLicenseCreateDTO;
import com.microservices.account.dto.update.DriverLicenseUpdateDTO;
import com.microservices.account.dto.view.DriverLicenseViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DriverLicenseService {

    Page<DriverLicenseViewDTO> getAllDriverLicenses(Pageable pageable);

    Page<DriverLicenseViewDTO> getAllDriverLicenseByAccountId(Long accountId, Pageable pageable);

    DriverLicenseViewDTO getDriverLicenseById(Long driverLicenseId);

    DriverLicenseCreateDTO createDriverLicense(DriverLicenseCreateDTO driverLicenseCreateDTO);

    DriverLicenseUpdateDTO updateDriverLicense(Long driverLicenseId, DriverLicenseUpdateDTO driverLicenseUpdateDTO);

    boolean deleteDriverLicense(Long driverLicenseId);
}
