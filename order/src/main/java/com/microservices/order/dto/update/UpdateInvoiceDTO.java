package com.microservices.order.dto.update;

import com.microservices.order.entity.InvoiceStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInvoiceDTO {

    @NotEmpty(message = "'Amount' should not be empty")
    @PositiveOrZero(message = "'Amount' should be positive number or 0")
    private BigDecimal amount;

    @NotEmpty(message = "'Start date rent' should not be empty")
    @Future(message = "'Start date rent' should be after current")
    private Instant startDateRent;

    @NotEmpty(message = "'End date rent' should not be empty")
    @Future(message = "'End date rent' should be after current")
    private Instant endDateRent;

    @NotEmpty(message = "'Rental period' should not be empty")
    @Positive(message = "'Rental period' should be positive number")
    private Integer rentalPeriod;

    @NotEmpty(message = "'Payment date' should not be empty")
    private Instant paymentDate;

    @NotEmpty(message = "'Invoice status' should not be empty")
    @Size(min = 2, max = 64, message = "'Invoice status' should be 'CREATED' or 'SENT' or 'PAID'")
    private InvoiceStatus invoiceStatus;
}
