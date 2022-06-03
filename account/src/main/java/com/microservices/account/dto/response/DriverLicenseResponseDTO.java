package com.microservices.account.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DriverLicenseResponseDTO {

    private Long driverLicenseId;

    private String driverLicenseNumber;

    private String category;

    private Instant dateOfIssue;

    private Instant expirationDate;

    private Long accountId;
}
