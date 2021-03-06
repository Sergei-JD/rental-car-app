package com.microservices.account.dto.update;

import com.microservices.account.entity.CreditCardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCreditCardDTO {

    @NotEmpty(message = "'Credit card type' should not be empty")
    @Size(min = 2, max = 128, message = "'Credit card type' should be 'VISA' or 'MASTERCARD' or 'AMERICAN_EXPRESS'")
    private CreditCardType creditCardType;

    @NotEmpty(message = "'Card number' should not be empty")
    @Pattern(regexp = "\\d{16}", message = "'Card number' should be valid")
    private String cardNumber;

    @NotEmpty(message = "'Date of issue' should not be empty")
    @Past(message = "'Date of issue' should be before current")
    private Instant dateOfIssue;

    @NotEmpty(message = "'Expiration date' should not be empty")
    @Future(message = "'Expiration date' should be after current")
    private Instant expirationDate;

    @NotEmpty(message = "'CVV-code' should not be empty")
    @Pattern(regexp = "\\d{3}", message = "'CVV-code' should be valid")
    private String cvvCode;

    @NotEmpty(message = "'Name card owner' should not be empty")
    @Size(min = 8, max = 256, message = "'Name card owner' should be between 8 and 32 characters")
    private String nameCardOwner;

    @NotEmpty(message = "'Balance' should not be empty")
    @PositiveOrZero(message = "'Balance' should be positive number or 0")
    private BigDecimal balance;
}
