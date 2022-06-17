package com.microservices.order.service;

import com.microservices.order.entity.Invoice;
import com.microservices.order.entity.InvoiceStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InvoiceService {

    Page<Invoice> getAllInvoices(Pageable pageable);

    Page<Invoice> getAllInvoicesByStatus(InvoiceStatus invoiceStatus, Pageable pageable);

    Invoice getInvoiceById(long invoiceId);

    Invoice createInvoice(Invoice invoice);

    Invoice updateInvoice(Invoice invoice);

    boolean deleteInvoice(long invoiceId);
}
