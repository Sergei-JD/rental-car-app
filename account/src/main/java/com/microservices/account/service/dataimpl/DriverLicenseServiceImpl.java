package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.request.DriverLicenseRequestDTO;
import com.microservices.account.dto.response.DriverLicenseResponseDTO;
import com.microservices.account.entity.DriverLicense;
import com.microservices.account.mapper.request.DriverLicenseRequestDTOToDriverLicenseMapper;
import com.microservices.account.mapper.response.DriverLicenseToDriverLicenseResponseDTOMapper;
import com.microservices.account.repository.DriverLicenseRepository;
import com.microservices.account.service.DriverLicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverLicenseServiceImpl implements DriverLicenseService {

    private final DriverLicenseRepository driverLicenseRepository;
    private final DriverLicenseRequestDTOToDriverLicenseMapper driverLicenseRequestDTOToDriverLicenseMapper;
    private final DriverLicenseToDriverLicenseResponseDTOMapper driverLicenseToDriverLicenseResponseDTOMapper;

    @Override
    public Page<DriverLicenseResponseDTO> getAllDriverLicenses(Pageable pageable) {
        Page<DriverLicense> pageDriverLicenses = driverLicenseRepository.findAll(pageable);

        List<DriverLicenseResponseDTO> driverLicenses = pageDriverLicenses.stream()
                .map(driverLicenseToDriverLicenseResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(driverLicenses);
    }

    @Override
    public Optional<DriverLicenseResponseDTO> getAllDriverLicenseByAccountId(Long accountId) {
        DriverLicenseResponseDTO driverLicenseResponseDTO = null;

        Optional<DriverLicense> driverLicense = driverLicenseRepository.findDriverLicenseByAccountId(accountId);
        if (driverLicense.isPresent()) {
            driverLicenseResponseDTO = driverLicenseToDriverLicenseResponseDTOMapper.convert(driverLicense.get());
        }

        return Optional.ofNullable(driverLicenseResponseDTO);
    }

    @Override
    public Optional<DriverLicenseResponseDTO> getDriverLicenseById(long driverLicenseId) {
        DriverLicenseResponseDTO driverLicenseResponseDTO = null;

        Optional<DriverLicense> driverLicense = driverLicenseRepository.findById(driverLicenseId);
        if (driverLicense.isPresent()) {
            driverLicenseResponseDTO = driverLicenseToDriverLicenseResponseDTOMapper.convert(driverLicense.get());
        }

        return Optional.ofNullable(driverLicenseResponseDTO);
    }

    @Override
    @Transactional
    public DriverLicenseResponseDTO createDriverLicense(DriverLicenseRequestDTO driverLicenseRequestDTO) {
        DriverLicense newDriverLicense = driverLicenseRequestDTOToDriverLicenseMapper.convert(driverLicenseRequestDTO);

        return driverLicenseToDriverLicenseResponseDTOMapper.convert(driverLicenseRepository.save(newDriverLicense));
    }

    @Override
    @Transactional
    public DriverLicenseResponseDTO updateDriverLicense(Long driverLicenseId, DriverLicenseRequestDTO driverLicenseRequestDTO) {
        DriverLicense driverLicense = driverLicenseRequestDTOToDriverLicenseMapper.convert(driverLicenseRequestDTO);
        driverLicense.setDriverLicenseId(driverLicenseId);

        return driverLicenseToDriverLicenseResponseDTOMapper.convert(driverLicenseRepository.save(driverLicense));
    }

    @Override
    @Transactional
    public boolean deleteDriverLicense(long driverLicenseId) {
        driverLicenseRepository.deleteById(driverLicenseId);

        return driverLicenseRepository.findById(driverLicenseId).isEmpty();
    }
}
