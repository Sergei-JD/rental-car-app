package com.microservices.account.dto.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DriverLicenseViewDTO {

    private Long id;

    private String driverLicenseNumber;

    private String category;

    private Instant dateOfIssue;

    private Instant expirationDate;
}
