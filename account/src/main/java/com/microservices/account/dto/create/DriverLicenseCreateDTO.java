package com.microservices.account.dto.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.Instant;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DriverLicenseCreateDTO {

    @NotEmpty(message = "'Driver license lumber' should not be empty")
    @Size(min = 8, max = 32, message = "'Driver license number' should be between 8 and 32 characters")
    private String driverLicenseNumber;

    @NotEmpty(message = "'Category' should not be empty")
    @Size(min = 1, max = 32, message = "'Category' should be between 1 and 32 characters")
    private String category;

    @NotEmpty(message = "'Date of issue' should not be empty")
    @Past(message = "'Date of issue' should be after current")
    private Instant dateOfIssue;

    @NotEmpty(message = "'Expiration date' should not be empty")
    @Future(message = "'Expiration date' should be after current")
    private Instant expirationDate;
}
