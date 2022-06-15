package com.microservices.account.service.dataimpl;

import com.microservices.account.entity.DriverLicense;
import com.microservices.account.entity.User;
import com.microservices.account.repository.DriverLicenseRepository;
import com.microservices.account.service.DriverLicenseService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.microservices.account.util.ServiceData.DRIVER_LICENSE_DELETE_EXCEPTION_MESSAGE;
import static com.microservices.account.util.ServiceData.DRIVER_LICENSE_ID_EXCEPTION_MESSAGE;
import static com.microservices.account.util.ServiceData.DRIVER_LICENSE_UPDATE_EXCEPTION_MESSAGE;
import static com.microservices.account.util.ServiceData.USER_DELETE_EXCEPTION_MESSAGE;
import static com.microservices.account.util.ServiceData.USER_ID_EXCEPTION_MESSAGE;

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
    public DriverLicense getDriverLicenseById(Long driverLicenseId) {
        return driverLicenseRepository.findById(driverLicenseId)
                .orElseThrow(() -> new ServiceException(String.format(DRIVER_LICENSE_ID_EXCEPTION_MESSAGE, driverLicenseId)));
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
                .orElseThrow(() -> new ServiceException(DRIVER_LICENSE_UPDATE_EXCEPTION_MESSAGE));
        return driverLicenseRepository.save(maybeDriverLicense);
    }

    @Override
    @Transactional
    public boolean deleteDriverLicense(Long driverLicenseId) {
        DriverLicense maybeDriverLicense = driverLicenseRepository.findById(driverLicenseId)
                .orElseThrow(() -> new ServiceException(String.format(DRIVER_LICENSE_DELETE_EXCEPTION_MESSAGE, driverLicenseId)));
        driverLicenseRepository.deleteById(maybeDriverLicense.getId());
        return driverLicenseRepository.findById(driverLicenseId).isEmpty();
    }
}
