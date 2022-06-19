package com.microservices.order.service;

import com.microservices.order.dto.create.InvoiceCreateDTO;
import com.microservices.order.dto.update.InvoiceUpdateDTO;
import com.microservices.order.dto.view.InvoiceViewDTO;
import com.microservices.order.entity.InvoiceStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InvoiceService {

    Page<InvoiceViewDTO> getAllInvoices(Pageable pageable);

    Page<InvoiceViewDTO> getAllInvoicesByStatus(InvoiceStatus invoiceStatus, Pageable pageable);

    InvoiceViewDTO getInvoiceById(Long invoiceId);

    InvoiceCreateDTO createInvoice(InvoiceCreateDTO invoiceCreateDTO);

    InvoiceUpdateDTO updateInvoice(Long invoiceId, InvoiceUpdateDTO invoiceUpdateDTO);

    boolean deleteInvoice(Long invoiceId);
}
