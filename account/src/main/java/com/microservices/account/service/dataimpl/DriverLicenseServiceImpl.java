package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.create.CreateDriverLicenseDTO;
import com.microservices.account.dto.update.UpdateDriverLicenseDTO;
import com.microservices.account.dto.view.ViewDriverLicenseDTO;
import com.microservices.account.entity.Account;
import com.microservices.account.entity.DriverLicense;
import com.microservices.account.mapper.DriverLicenseMapper;
import com.microservices.account.repository.AccountRepository;
import com.microservices.account.repository.DriverLicenseRepository;
import com.microservices.account.service.DriverLicenseService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.microservices.account.util.ServiceData.DRIVER_LICENSE_ID_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class DriverLicenseServiceImpl implements DriverLicenseService {

    private final DriverLicenseRepository driverLicenseRepository;
    private final AccountRepository accountRepository;

    @Override
    public Page<ViewDriverLicenseDTO> getAllDriverLicenses(Pageable pageable) {
        Page<DriverLicense> pageDriverLicenses = driverLicenseRepository.findAll(pageable);

        List<ViewDriverLicenseDTO> driverLicenses = pageDriverLicenses.stream()
                .map(DriverLicenseMapper::toViewDriverLicenseDTO)
                .toList();

        return new PageImpl<>(driverLicenses);
    }

    @Override
    public Page<ViewDriverLicenseDTO> getAllDriverLicenseByAccountId(Long accountId, Pageable pageable) {
        Page<DriverLicense> pageDriverLicenses = driverLicenseRepository.findDriverLicenseByAccountId(accountId, pageable);

        List<ViewDriverLicenseDTO> driverLicenses = pageDriverLicenses.stream()
                .map(DriverLicenseMapper::toViewDriverLicenseDTO)
                .toList();

        return new PageImpl<>(driverLicenses);
    }

    @Override
    public DriverLicense getDriverLicenseById(Long driverLicenseId) {
        return driverLicenseRepository.findById(driverLicenseId)
                .orElseThrow(() -> new ServiceException(String.format(DRIVER_LICENSE_ID_EXCEPTION_MESSAGE, driverLicenseId)));
    }

    @Override
    @Transactional
    public Long createDriverLicense(CreateDriverLicenseDTO createDriverLicenseDTO) {
        Account account = accountRepository.findById(createDriverLicenseDTO.getAccountId())
                .orElseThrow(() -> new ServiceException("Failed to create 'driver license'. No such 'account'"));
        DriverLicense newDriverLicense = DriverLicense.builder()
                .driverLicenseNumber(createDriverLicenseDTO.getDriverLicenseNumber())
                .category(createDriverLicenseDTO.getCategory())
                .dateOfIssue(createDriverLicenseDTO.getDateOfIssue())
                .expirationDate(createDriverLicenseDTO.getExpirationDate())
                .account(account)
                .build();

        DriverLicense savedDriverLicense = driverLicenseRepository.save(newDriverLicense);

        return savedDriverLicense.getId();
    }

    @Override
    @Transactional
    public void updateDriverLicense(Long driverLicenseId, UpdateDriverLicenseDTO updateDriverLicenseDTO) {
        DriverLicense driverLicense = driverLicenseRepository.findById(driverLicenseId)
                .orElseThrow(() -> new ServiceException(String.format(DRIVER_LICENSE_ID_EXCEPTION_MESSAGE, driverLicenseId)));
        driverLicense.setDriverLicenseNumber(updateDriverLicenseDTO.getDriverLicenseNumber());
        driverLicense.setCategory(updateDriverLicenseDTO.getCategory());
        driverLicense.setDateOfIssue(updateDriverLicenseDTO.getDateOfIssue());
        driverLicense.setExpirationDate(updateDriverLicenseDTO.getExpirationDate());

        driverLicenseRepository.save(driverLicense);
    }

    @Override
    @Transactional
    public boolean deleteDriverLicense(Long driverLicenseId) {
        driverLicenseRepository.deleteById(driverLicenseId);

        return driverLicenseRepository.findById(driverLicenseId).isEmpty();
    }
}
