package com.microservices.order.service;

import com.microservices.order.dto.create.CreateInvoiceDTO;
import com.microservices.order.dto.update.UpdateInvoiceDTO;
import com.microservices.order.dto.view.ViewInvoiceDTO;
import com.microservices.order.entity.Invoice;
import com.microservices.order.entity.InvoiceStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InvoiceService {

    Page<ViewInvoiceDTO> getAllInvoices(Pageable pageable);

    Page<ViewInvoiceDTO> getAllInvoicesByStatus(InvoiceStatus invoiceStatus, Pageable pageable);

    Invoice getInvoiceById(Long invoiceId);

    Long createInvoice(CreateInvoiceDTO createInvoiceDTO);

    void updateInvoice(Long invoiceId, UpdateInvoiceDTO updateInvoiceDTO);

    boolean deleteInvoice(Long invoiceId);
}
