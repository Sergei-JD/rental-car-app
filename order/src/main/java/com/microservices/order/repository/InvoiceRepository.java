package com.microservices.order.repository;

import com.microservices.order.entity.Invoice;
import com.microservices.order.entity.InvoiceStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Page<Invoice> findAllByInvoiceStatus(InvoiceStatus invoiceStatus, Pageable pageable);
}
