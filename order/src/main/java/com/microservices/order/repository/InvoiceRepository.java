package com.microservices.order.repository;

import com.microservices.order.entity.Invoice;
import com.microservices.order.entity.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findAllByInvoiceStatus(InvoiceStatus invoiceStatus);
}
