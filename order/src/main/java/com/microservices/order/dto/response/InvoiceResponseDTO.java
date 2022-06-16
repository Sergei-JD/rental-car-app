package com.microservices.order.dto.response;

import com.microservices.order.entity.InvoiceStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponseDTO {

    private Long id;

    private BigDecimal amount;

    private Instant startDateRent;

    private Instant endDateRent;

    private Integer rentalPeriod;

    private Instant paymentDate;

    private InvoiceStatus invoiceStatus;
}
