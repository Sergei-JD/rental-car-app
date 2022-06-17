package com.microservices.account.mapper;

import com.microservices.account.dto.create.DriverLicenseCreateDTO;
import com.microservices.account.dto.update.DriverLicenseUpdateDTO;
import com.microservices.account.dto.view.DriverLicenseViewDTO;
import com.microservices.account.entity.DriverLicense;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverLicenseMapper {

    public static DriverLicenseViewDTO toDriverLicenseViewDTO(DriverLicense driverLicense) {
        return Optional.ofNullable(driverLicense)
                .map(existDriverLicense -> DriverLicenseViewDTO.builder()
                        .id(driverLicense.getId())
                        .driverLicenseNumber(driverLicense.getDriverLicenseNumber())
                        .category(driverLicense.getCategory())
                        .dateOfIssue(driverLicense.getDateOfIssue())
                        .expirationDate(driverLicense.getExpirationDate())
                        .build())
                .orElse(null);
    }

    public static DriverLicenseCreateDTO toDriverLicenseCreateDTO(DriverLicense driverLicense) {
        return Optional.ofNullable(driverLicense)
                .map(existDriverLicense -> DriverLicenseCreateDTO.builder()
                        .driverLicenseNumber(driverLicense.getDriverLicenseNumber())
                        .category(driverLicense.getCategory())
                        .dateOfIssue(driverLicense.getDateOfIssue())
                        .expirationDate(driverLicense.getExpirationDate())
                        .build())
                .orElse(null);
    }

    public static DriverLicenseUpdateDTO toDriverLicenseUpdateDTO(DriverLicense driverLicense) {
        return Optional.ofNullable(driverLicense)
                .map(existDriverLicense -> DriverLicenseUpdateDTO.builder()
                        .driverLicenseNumber(driverLicense.getDriverLicenseNumber())
                        .category(driverLicense.getCategory())
                        .dateOfIssue(driverLicense.getDateOfIssue())
                        .expirationDate(driverLicense.getExpirationDate())
                        .build())
                .orElse(null);
    }
}
