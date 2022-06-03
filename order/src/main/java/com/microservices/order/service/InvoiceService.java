package com.microservices.order.service;

import com.microservices.order.dto.InvoiceRequestDTO;
import com.microservices.order.dto.InvoiceResponseFullDTO;
import com.microservices.order.dto.InvoiceResponseViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface InvoiceService {

    Page<InvoiceResponseViewDTO> getAllInvoices(Pageable pageable);

    Page<InvoiceResponseViewDTO> getAllInvoicesStatus(String invoiceStatus, Pageable pageable);

    Optional<InvoiceResponseViewDTO> getInvoiceById(long invoiceId);

    InvoiceRequestDTO createInvoice(InvoiceRequestDTO accountRequestDTO);

    InvoiceResponseFullDTO updateInvoice(InvoiceResponseFullDTO invoiceResponseFullDTO);

    boolean deleteInvoice(long invoiceId);
}
