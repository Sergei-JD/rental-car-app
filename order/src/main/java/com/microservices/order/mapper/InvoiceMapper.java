package com.microservices.order.mapper;

import com.microservices.order.dto.create.InvoiceCreateDTO;
import com.microservices.order.dto.update.InvoiceUpdateDTO;
import com.microservices.order.dto.view.InvoiceViewDTO;
import com.microservices.order.entity.Invoice;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvoiceMapper {

    public static InvoiceViewDTO toInvoiceViewDTO(Invoice invoice) {
        return Optional.ofNullable(invoice)
                .map(existInvoice -> InvoiceViewDTO.builder()
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

    public static InvoiceCreateDTO toInvoiceCreateDTO(Invoice invoice) {
        return Optional.ofNullable(invoice)
                .map(existInvoice -> InvoiceCreateDTO.builder()
                        .amount(invoice.getAmount())
                        .startDateRent(invoice.getStartDateRent())
                        .endDateRent(invoice.getEndDateRent())
                        .rentalPeriod(invoice.getRentalPeriod())
                        .paymentDate(invoice.getPaymentDate())
                        .invoiceStatus(invoice.getInvoiceStatus())
                        .build())
                .orElse(null);
    }

    public static InvoiceUpdateDTO toInvoiceUpdateDTO(Invoice invoice) {
        return Optional.ofNullable(invoice)
                .map(existInvoice -> InvoiceUpdateDTO.builder()
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
