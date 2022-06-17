package com.microservices.order.service.dataimpl;

import com.microservices.order.entity.Invoice;
import com.microservices.order.entity.InvoiceStatus;
import com.microservices.order.repository.InvoiceRepository;
import com.microservices.order.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.microservices.order.util.ServiceData.INVOICE_DELETE_EXCEPTION_MESSAGE;
import static com.microservices.order.util.ServiceData.INVOICE_ID_EXCEPTION_MESSAGE;
import static com.microservices.order.util.ServiceData.INVOICE_UPDATE_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Override
    public Page<Invoice> getAllInvoices(Pageable pageable) {
        return invoiceRepository.findAll(pageable);
    }

    @Override
    public Page<Invoice> getAllInvoicesByStatus(InvoiceStatus invoiceStatus, Pageable pageable) {
        return invoiceRepository.findAllByInvoiceStatus(invoiceStatus, pageable);
    }

    @Override
    public Invoice getInvoiceById(long invoiceId) {
        return invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new ServiceException(String.format(INVOICE_ID_EXCEPTION_MESSAGE, invoiceId)));
    }

    @Override
    @Transactional
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    @Transactional
    public Invoice updateInvoice(Invoice invoice) {
        Invoice maybeInvoice = invoiceRepository.findById(invoice.getId())
                .orElseThrow(() -> new ServiceException(INVOICE_UPDATE_EXCEPTION_MESSAGE));
        return invoiceRepository.save(maybeInvoice);
    }

    @Override
    @Transactional
    public boolean deleteInvoice(long invoiceId) {
        Invoice maybeInvoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new ServiceException(String.format(INVOICE_DELETE_EXCEPTION_MESSAGE, invoiceId)));
        invoiceRepository.deleteById(maybeInvoice.getId());
        return invoiceRepository.findById(invoiceId).isEmpty();
    }
}
