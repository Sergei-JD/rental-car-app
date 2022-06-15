package com.microservices.account.service.dataimpl;

import com.microservices.account.entity.DriverLicense;
import com.microservices.account.repository.DriverLicenseRepository;
import com.microservices.account.service.DriverLicenseService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverLicenseServiceImpl implements DriverLicenseService {

    private final DriverLicenseRepository driverLicenseRepository;

    @Override
    public Page<DriverLicense> getAllDriverLicenses(Pageable pageable) {
        return driverLicenseRepository.findAll(pageable);
    }

    @Override
    public Page<DriverLicense> getAllDriverLicenseByAccountId(Long accountId, Pageable pageable) {
        return driverLicenseRepository.findDriverLicenseByAccountId(accountId, pageable);
    }

    @Override
    public Optional<DriverLicense> getDriverLicenseById(Long driverLicenseId) {
        return driverLicenseRepository.findById(driverLicenseId);
    }

    @Override
    @Transactional
    public DriverLicense createDriverLicense(DriverLicense driverLicense) {
        return driverLicenseRepository.save(driverLicense);
    }

    @Override
    @Transactional
    public DriverLicense updateDriverLicense(DriverLicense driverLicense) {
        DriverLicense maybeDriverLicense = driverLicenseRepository.findById(driverLicense.getId())
                .orElseThrow(() -> new ServiceException("Failed to update DriverLicense no such DriverLicense"));
        return driverLicenseRepository.save(maybeDriverLicense);
    }

    @Override
    @Transactional
    public boolean deleteDriverLicense(Long driverLicenseId) {
        Optional<DriverLicense> maybeDriverLicense = driverLicenseRepository.findById(driverLicenseId);
        maybeDriverLicense.ifPresent(driverLicense -> driverLicenseRepository.deleteById(driverLicense.getId()));

        return maybeDriverLicense.isPresent();
    }
}
