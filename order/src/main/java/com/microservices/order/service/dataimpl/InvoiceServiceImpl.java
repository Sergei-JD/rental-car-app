package com.microservices.order.service.dataimpl;

import com.microservices.order.dto.create.CreateInvoiceDTO;
import com.microservices.order.dto.update.UpdateInvoiceDTO;
import com.microservices.order.dto.view.ViewInvoiceDTO;
import com.microservices.order.entity.Invoice;
import com.microservices.order.entity.InvoiceStatus;
import com.microservices.order.mapper.InvoiceMapper;
import com.microservices.order.repository.InvoiceRepository;
import com.microservices.order.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.microservices.order.util.ServiceData.INVOICE_ID_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Override
    public Page<ViewInvoiceDTO> getAllInvoices(Pageable pageable) {
        Page<Invoice> pageInvoices = invoiceRepository.findAll(pageable);

        List<ViewInvoiceDTO> invoices = pageInvoices.stream()
                .map(InvoiceMapper::toViewInvoiceDTO)
                .toList();

        return new PageImpl<>(invoices);
    }

    @Override
    public Page<ViewInvoiceDTO> getAllInvoicesByStatus(InvoiceStatus invoiceStatus, Pageable pageable) {
        Page<Invoice> pageInvoices = invoiceRepository.findAllByInvoiceStatus(invoiceStatus, pageable);

        List<ViewInvoiceDTO> invoices = pageInvoices.stream()
                .map(InvoiceMapper::toViewInvoiceDTO)
                .toList();

        return new PageImpl<>(invoices);
    }

    @Override
    public Invoice getInvoiceById(Long invoiceId) {
        return invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new ServiceException(String.format(INVOICE_ID_EXCEPTION_MESSAGE, invoiceId)));
    }

    @Override
    @Transactional
    public Long createInvoice(CreateInvoiceDTO createInvoiceDTO) {
        Invoice newInvoice = Invoice.builder()
                .amount(createInvoiceDTO.getAmount())
                .startDateRent(createInvoiceDTO.getStartDateRent())
                .endDateRent(createInvoiceDTO.getEndDateRent())
                .rentalPeriod(createInvoiceDTO.getRentalPeriod())
                .paymentDate(createInvoiceDTO.getPaymentDate())
                .invoiceStatus(createInvoiceDTO.getInvoiceStatus())
                .build();

        Invoice savedInvoice = invoiceRepository.save(newInvoice);

        return savedInvoice.getId();
    }

    @Override
    @Transactional
    public void updateInvoice(Long invoiceId, UpdateInvoiceDTO updateInvoiceDTO) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new ServiceException(String.format(INVOICE_ID_EXCEPTION_MESSAGE, invoiceId)));
        invoice.setAmount(updateInvoiceDTO.getAmount());
        invoice.setStartDateRent(updateInvoiceDTO.getStartDateRent());
        invoice.setEndDateRent(updateInvoiceDTO.getEndDateRent());
        invoice.setRentalPeriod(updateInvoiceDTO.getRentalPeriod());
        invoice.setPaymentDate(updateInvoiceDTO.getPaymentDate());
        invoice.setInvoiceStatus(updateInvoiceDTO.getInvoiceStatus());

        invoiceRepository.save(invoice);
    }

    @Override
    @Transactional
    public boolean deleteInvoice(Long invoiceId) {
        invoiceRepository.deleteById(invoiceId);

        return invoiceRepository.findById(invoiceId).isEmpty();
    }
}
