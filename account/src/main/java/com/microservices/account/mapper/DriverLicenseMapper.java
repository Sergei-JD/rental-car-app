package com.microservices.account.mapper;

import com.microservices.account.dto.create.CreateDriverLicenseDTO;
import com.microservices.account.dto.update.UpdateDriverLicenseDTO;
import com.microservices.account.dto.view.ViewDriverLicenseDTO;
import com.microservices.account.entity.DriverLicense;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverLicenseMapper {

    public static ViewDriverLicenseDTO toViewDriverLicenseDTO(DriverLicense driverLicense) {
        return Optional.ofNullable(driverLicense)
                .map(existDriverLicense -> ViewDriverLicenseDTO.builder()
                        .id(driverLicense.getId())
                        .driverLicenseNumber(driverLicense.getDriverLicenseNumber())
                        .category(driverLicense.getCategory())
                        .dateOfIssue(driverLicense.getDateOfIssue())
                        .expirationDate(driverLicense.getExpirationDate())
                        .build())
                .orElse(null);
    }

    public static CreateDriverLicenseDTO toCreateDriverLicenseDTO(DriverLicense driverLicense) {
        return Optional.ofNullable(driverLicense)
                .map(existDriverLicense -> CreateDriverLicenseDTO.builder()
                        .driverLicenseNumber(driverLicense.getDriverLicenseNumber())
                        .category(driverLicense.getCategory())
                        .dateOfIssue(driverLicense.getDateOfIssue())
                        .expirationDate(driverLicense.getExpirationDate())
                        .build())
                .orElse(null);
    }

    public static UpdateDriverLicenseDTO toUpdateDriverLicenseDTO(DriverLicense driverLicense) {
        return Optional.ofNullable(driverLicense)
                .map(existDriverLicense -> UpdateDriverLicenseDTO.builder()
                        .driverLicenseNumber(driverLicense.getDriverLicenseNumber())
                        .category(driverLicense.getCategory())
                        .dateOfIssue(driverLicense.getDateOfIssue())
                        .expirationDate(driverLicense.getExpirationDate())
                        .build())
                .orElse(null);
    }
}
