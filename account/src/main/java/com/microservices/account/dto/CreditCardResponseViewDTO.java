package com.microservices.account.dto;

import com.microservices.account.entity.CreditCardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardResponseViewDTO {

    @Positive(message = "'Credit card id' should be positive number")
    private Long creditCardId;

    @NotEmpty(message = "'Credit card type' should not be empty")
    @Size(min = 2, max = 128, message = "'Credit card type' should be 'VISA' or 'MASTERCARD' or 'AMERICAN_EXPRESS'")
    private CreditCardType creditCardType;

    @NotEmpty(message = "'Date of issue' should not be empty")
    @Past(message = "'Date of issue' should be before current")
    private Instant dateOfIssue;

    @NotEmpty(message = "'Expiration date' of birth should not be empty")
    @Future(message = "Expiration date' should be after current")
    private Instant expirationDate;

    @NotEmpty(message = "'Name card owner' should not be empty")
    @Size(min = 8, max = 256, message = "'Name card owner' should be between 8 and 32 characters")
    private String nameCardOwner;
}
