package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.create.DriverLicenseCreateDTO;
import com.microservices.account.dto.update.DriverLicenseUpdateDTO;
import com.microservices.account.dto.view.DriverLicenseViewDTO;
import com.microservices.account.entity.DriverLicense;
import com.microservices.account.mapper.DriverLicenseMapper;
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

    @Override
    public Page<DriverLicenseViewDTO> getAllDriverLicenses(Pageable pageable) {
        Page<DriverLicense> pageDriverLicenses = driverLicenseRepository.findAll(pageable);

        List<DriverLicenseViewDTO> driverLicenses = pageDriverLicenses.stream()
                .map(DriverLicenseMapper::toDriverLicenseViewDTO)
                .toList();

        return new PageImpl<>(driverLicenses);
    }

    @Override
    public Page<DriverLicenseViewDTO> getAllDriverLicenseByAccountId(Long accountId, Pageable pageable) {
        Page<DriverLicense> pageDriverLicenses = driverLicenseRepository.findDriverLicenseByAccountId(accountId, pageable);

        List<DriverLicenseViewDTO> driverLicenses = pageDriverLicenses.stream()
                .map(DriverLicenseMapper::toDriverLicenseViewDTO)
                .toList();

        return new PageImpl<>(driverLicenses);
    }

    @Override
    public DriverLicenseViewDTO getDriverLicenseById(Long driverLicenseId) {
        DriverLicense driverLicense = driverLicenseRepository.findById(driverLicenseId)
                .orElseThrow(() -> new ServiceException(String.format(DRIVER_LICENSE_ID_EXCEPTION_MESSAGE, driverLicenseId)));

        return DriverLicenseMapper.toDriverLicenseViewDTO(driverLicense);
    }

    @Override
    @Transactional
    public DriverLicenseCreateDTO createDriverLicense(DriverLicenseCreateDTO driverLicenseCreateDTO) {
        DriverLicense newDriverLicense = DriverLicense.builder()
                .driverLicenseNumber(driverLicenseCreateDTO.getDriverLicenseNumber())
                .category(driverLicenseCreateDTO.getCategory())
                .dateOfIssue(driverLicenseCreateDTO.getDateOfIssue())
                .expirationDate(driverLicenseCreateDTO.getExpirationDate())
                .build();

        return DriverLicenseMapper.toDriverLicenseCreateDTO(driverLicenseRepository.save(newDriverLicense));
    }

    @Override
    @Transactional
    public DriverLicenseUpdateDTO updateDriverLicense(Long driverLicenseId, DriverLicenseUpdateDTO driverLicenseUpdateDTO) {
        DriverLicense driverLicense = driverLicenseRepository.findById(driverLicenseId)
                .orElseThrow(() -> new ServiceException(String.format(DRIVER_LICENSE_ID_EXCEPTION_MESSAGE, driverLicenseId)));
        driverLicense.setDriverLicenseNumber(driverLicenseUpdateDTO.getDriverLicenseNumber());
        driverLicense.setCategory(driverLicenseUpdateDTO.getCategory());
        driverLicense.setDateOfIssue(driverLicenseUpdateDTO.getDateOfIssue());
        driverLicense.setExpirationDate(driverLicenseUpdateDTO.getExpirationDate());

        driverLicenseRepository.save(driverLicense);

        return DriverLicenseMapper.toDriverLicenseUpdateDTO(driverLicense);
    }

    @Override
    @Transactional
    public boolean deleteDriverLicense(Long driverLicenseId) {
        driverLicenseRepository.deleteById(driverLicenseId);

        return driverLicenseRepository.findById(driverLicenseId).isEmpty();
    }
}
