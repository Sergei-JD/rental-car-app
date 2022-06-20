package com.microservices.order.mapper;

import com.microservices.order.dto.create.CreateInvoiceDTO;
import com.microservices.order.dto.update.UpdateInvoiceDTO;
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

    public static CreateInvoiceDTO toCreateInvoiceDTO(Invoice invoice) {
        return Optional.ofNullable(invoice)
                .map(existInvoice -> CreateInvoiceDTO.builder()
                        .amount(invoice.getAmount())
                        .startDateRent(invoice.getStartDateRent())
                        .endDateRent(invoice.getEndDateRent())
                        .rentalPeriod(invoice.getRentalPeriod())
                        .paymentDate(invoice.getPaymentDate())
                        .invoiceStatus(invoice.getInvoiceStatus())
                        .build())
                .orElse(null);
    }

    public static UpdateInvoiceDTO toUpdateInvoiceDTO(Invoice invoice) {
        return Optional.ofNullable(invoice)
                .map(existInvoice -> UpdateInvoiceDTO.builder()
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
