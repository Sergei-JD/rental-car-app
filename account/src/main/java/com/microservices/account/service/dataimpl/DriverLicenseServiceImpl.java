package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.request.DriverLicenseRequestDTO;
import com.microservices.account.dto.request.DriverLicenseUpdateRequestDTO;
import com.microservices.account.dto.response.DriverLicenseResponseDTO;
import com.microservices.account.entity.DriverLicense;
import com.microservices.account.mapper.request.DriverLicenseRequestDTOToDriverLicenseMapper;
import com.microservices.account.mapper.request.DriverLicenseUpdateRequestDTOToDriverLicenseMapper;
import com.microservices.account.mapper.response.DriverLicenseToDriverLicenseResponseDTOMapper;
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
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverLicenseServiceImpl implements DriverLicenseService {

    private final DriverLicenseRepository driverLicenseRepository;
    private final DriverLicenseRequestDTOToDriverLicenseMapper driverLicenseRequestDTOToDriverLicenseMapper;
    private final DriverLicenseToDriverLicenseResponseDTOMapper driverLicenseToDriverLicenseResponseDTOMapper;
    private final DriverLicenseUpdateRequestDTOToDriverLicenseMapper driverLicenseUpdateRequestDTOToDriverLicenseMapper;

    @Override
    public Page<DriverLicenseResponseDTO> getAllDriverLicenses(Pageable pageable) {
        Page<DriverLicense> pageDriverLicenses = driverLicenseRepository.findAll(pageable);

        List<DriverLicenseResponseDTO> driverLicenses = pageDriverLicenses.stream()
                .map(driverLicenseToDriverLicenseResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(driverLicenses);
    }

    @Override
    public Page<DriverLicenseResponseDTO> getAllDriverLicenseByAccountId(Long accountId, Pageable pageable) {
        Page<DriverLicense> pageDriverLicenses = driverLicenseRepository.findDriverLicenseByAccountId(accountId, pageable);

        List<DriverLicenseResponseDTO> driverLicenses = pageDriverLicenses.stream()
                .map(driverLicenseToDriverLicenseResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(driverLicenses);
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
        DriverLicense saveDriverLicense = driverLicenseRepository.save(Objects.requireNonNull(newDriverLicense));

        return driverLicenseToDriverLicenseResponseDTOMapper.convert(saveDriverLicense);
    }

    @Override
    @Transactional
    public DriverLicenseResponseDTO updateDriverLicense(DriverLicenseUpdateRequestDTO driverLicenseUpdateRequestDTO) {
        driverLicenseRepository.findById(driverLicenseUpdateRequestDTO.getDriverLicenseId())
                .orElseThrow(() -> new ServiceException("Failed to update driverLicense no such driverLicense"));

        DriverLicense driverLicense = driverLicenseUpdateRequestDTOToDriverLicenseMapper.convert(driverLicenseUpdateRequestDTO);
        DriverLicense updateDriverLicense = driverLicenseRepository.save(Objects.requireNonNull(driverLicense));

        return driverLicenseToDriverLicenseResponseDTOMapper.convert(updateDriverLicense);
    }

    @Override
    @Transactional
    public boolean deleteDriverLicense(long driverLicenseId) {
        driverLicenseRepository.deleteById(driverLicenseId);

        return driverLicenseRepository.findById(driverLicenseId).isEmpty();
    }
}
