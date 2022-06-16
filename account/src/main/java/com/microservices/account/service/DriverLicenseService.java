package com.microservices.account.service;

import com.microservices.account.entity.DriverLicense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DriverLicenseService {

    Page<DriverLicense> getAllDriverLicenses(Pageable pageable);

    Page<DriverLicense> getAllDriverLicenseByAccountId(Long accountId, Pageable pageable);

    DriverLicense getDriverLicenseById(Long driverLicenseId);

    DriverLicense createDriverLicense(DriverLicense driverLicense);

    DriverLicense updateDriverLicense(DriverLicense driverLicense);

    boolean deleteDriverLicense(Long driverLicenseId);
}
