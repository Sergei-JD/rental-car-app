package com.microservices.account.service;

import com.microservices.account.dto.create.CreateDriverLicenseDTO;
import com.microservices.account.dto.update.UpdateDriverLicenseDTO;
import com.microservices.account.dto.view.ViewDriverLicenseDTO;
import com.microservices.account.entity.DriverLicense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DriverLicenseService {

    Page<ViewDriverLicenseDTO> getAllDriverLicenses(Pageable pageable);

    Page<ViewDriverLicenseDTO> getAllDriverLicenseByAccountId(Long accountId, Pageable pageable);

    DriverLicense getDriverLicenseById(Long driverLicenseId);

    Long createDriverLicense(CreateDriverLicenseDTO createDriverLicenseDTO);

    void updateDriverLicense(Long driverLicenseId, UpdateDriverLicenseDTO updateDriverLicenseDTO);

    boolean deleteDriverLicense(Long driverLicenseId);
}
