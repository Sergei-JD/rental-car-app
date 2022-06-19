package com.microservices.order.service.dataimpl;

import com.microservices.order.dto.create.InvoiceCreateDTO;
import com.microservices.order.dto.update.InvoiceUpdateDTO;
import com.microservices.order.dto.view.InvoiceViewDTO;
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
    public Page<InvoiceViewDTO> getAllInvoices(Pageable pageable) {
        Page<Invoice> pageInvoices = invoiceRepository.findAll(pageable);

        List<InvoiceViewDTO> invoices = pageInvoices.stream()
                .map(InvoiceMapper::toInvoiceViewDTO)
                .toList();

        return new PageImpl<>(invoices);
    }

    @Override
    public Page<InvoiceViewDTO> getAllInvoicesByStatus(InvoiceStatus invoiceStatus, Pageable pageable) {
        Page<Invoice> pageInvoices = invoiceRepository.findAllByInvoiceStatus(invoiceStatus, pageable);

        List<InvoiceViewDTO> invoices = pageInvoices.stream()
                .map(InvoiceMapper::toInvoiceViewDTO)
                .toList();

        return new PageImpl<>(invoices);
    }

    @Override
    public InvoiceViewDTO getInvoiceById(Long invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new ServiceException(String.format(INVOICE_ID_EXCEPTION_MESSAGE, invoiceId)));

        return InvoiceMapper.toInvoiceViewDTO(invoice);
    }

    @Override
    @Transactional
    public InvoiceCreateDTO createInvoice(InvoiceCreateDTO invoiceCreateDTO) {
        Invoice newInvoice = Invoice.builder()
                .amount(invoiceCreateDTO.getAmount())
                .startDateRent(invoiceCreateDTO.getStartDateRent())
                .endDateRent(invoiceCreateDTO.getEndDateRent())
                .rentalPeriod(invoiceCreateDTO.getRentalPeriod())
                .paymentDate(invoiceCreateDTO.getPaymentDate())
                .invoiceStatus(invoiceCreateDTO.getInvoiceStatus())
                .build();

        return InvoiceMapper.toInvoiceCreateDTO(invoiceRepository.save(newInvoice));
    }

    @Override
    @Transactional
    public InvoiceUpdateDTO updateInvoice(Long invoiceId, InvoiceUpdateDTO invoiceUpdateDTO) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new ServiceException(String.format(INVOICE_ID_EXCEPTION_MESSAGE, invoiceId)));
        invoice.setAmount(invoiceUpdateDTO.getAmount());
        invoice.setStartDateRent(invoiceUpdateDTO.getStartDateRent());
        invoice.setEndDateRent(invoiceUpdateDTO.getEndDateRent());
        invoice.setRentalPeriod(invoiceUpdateDTO.getRentalPeriod());
        invoice.setPaymentDate(invoiceUpdateDTO.getPaymentDate());
        invoice.setInvoiceStatus(invoiceUpdateDTO.getInvoiceStatus());

        invoiceRepository.save(invoice);

        return InvoiceMapper.toInvoiceUpdateDTO(invoice);
    }

    @Override
    @Transactional
    public boolean deleteInvoice(Long invoiceId) {
        invoiceRepository.deleteById(invoiceId);

        return invoiceRepository.findById(invoiceId).isEmpty();
    }
}
