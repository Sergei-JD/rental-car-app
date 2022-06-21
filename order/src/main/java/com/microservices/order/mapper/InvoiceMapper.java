package com.microservices.order.mapper;

import com.microservices.order.dto.view.ViewInvoiceDTO;
import com.microservices.order.entity.Invoice;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvoiceMapper {

    public static ViewInvoiceDTO toViewInvoiceDTO(Invoice invoice) {
        return Optional.ofNullable(invoice)
                .map(existInvoice -> ViewInvoiceDTO.builder()
                        .id(invoice.getId())
                        .amount(invoice.getAmount())
                        .startDateRent(invoice.getStartDateRent())
                        .endDateRent(invoice.getEndDateRent())
                        .rentalPeriod(invoice.getRentalPeriod())
                        .paymentDate(invoice.getPaymentDate())
                        .invoiceStatus(invoice.getInvoiceStatus())
                        .build())
                .orElse(null);
    }
}
