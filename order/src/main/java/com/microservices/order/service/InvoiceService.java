package com.microservices.order.service;

import com.microservices.order.dto.request.InvoiceRequestDTO;
import com.microservices.order.dto.request.InvoiceUpdateRequestDTO;
import com.microservices.order.dto.response.InvoiceResponseDTO;
import com.microservices.order.entity.InvoiceStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface InvoiceService {

    Page<InvoiceResponseDTO> getAllInvoices(Pageable pageable);

    Page<InvoiceResponseDTO> getAllInvoicesByStatus(InvoiceStatus invoiceStatus, Pageable pageable);

    Optional<InvoiceResponseDTO> getInvoiceById(long invoiceId);

    InvoiceResponseDTO createInvoice(InvoiceRequestDTO invoiceRequestDTO);

    InvoiceResponseDTO updateInvoice(InvoiceUpdateRequestDTO invoiceUpdateRequestDTO);

    boolean deleteInvoice(long invoiceId);
}
