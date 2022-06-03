package com.microservices.order.service;

import com.microservices.order.dto.request.InvoiceRequestDTO;
import com.microservices.order.dto.response.InvoiceResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface InvoiceService {

    Page<InvoiceResponseDTO> getAllInvoices(Pageable pageable);

    Page<InvoiceResponseDTO> getAllInvoicesStatus(String invoiceStatus, Pageable pageable);

    Optional<InvoiceResponseDTO> getInvoiceById(long invoiceId);

    InvoiceRequestDTO createInvoice(InvoiceRequestDTO accountRequestDTO);

    InvoiceResponseDTO updateInvoice(InvoiceResponseDTO invoiceResponseDTO);

    boolean deleteInvoice(long invoiceId);
}
