package com.microservices.order.service.dataimpl;

import com.microservices.order.dto.request.InvoiceRequestDTO;
import com.microservices.order.dto.request.InvoiceUpdateRequestDTO;
import com.microservices.order.dto.response.InvoiceResponseDTO;
import com.microservices.order.entity.Invoice;
import com.microservices.order.entity.InvoiceStatus;
import com.microservices.order.mapper.request.InvoiceRequestDTOToInvoiceMapper;
import com.microservices.order.mapper.request.InvoiceUpdateRequestDTOToInvoiceMapper;
import com.microservices.order.mapper.response.InvoiceToInvoiceResponseDTOMapper;
import com.microservices.order.repository.InvoiceRepository;
import com.microservices.order.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceRequestDTOToInvoiceMapper invoiceRequestDTOToInvoiceMapper;
    private final InvoiceToInvoiceResponseDTOMapper invoiceToInvoiceResponseDTOMapper;
    private final InvoiceUpdateRequestDTOToInvoiceMapper invoiceUpdateRequestDTOToInvoiceMapper;

    @Override
    public Page<InvoiceResponseDTO> getAllInvoices(Pageable pageable) {
        Page<Invoice> pageInvoices = invoiceRepository.findAll(pageable);

        List<InvoiceResponseDTO> invoices = pageInvoices.stream()
                .map(invoiceToInvoiceResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(invoices);
    }

    @Override
    public Page<InvoiceResponseDTO> getAllInvoicesByStatus(InvoiceStatus invoiceStatus, Pageable pageable) {
        Page<Invoice> pageInvoices = invoiceRepository.findAllByInvoiceStatus(invoiceStatus, pageable);

        List<InvoiceResponseDTO> invoices = pageInvoices.stream()
                .map(invoiceToInvoiceResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(invoices);
    }

    @Override
    public Optional<InvoiceResponseDTO> getInvoiceById(long invoiceId) {
        InvoiceResponseDTO invoiceResponseDTO = null;

        Optional<Invoice> invoice = invoiceRepository.findById(invoiceId);
        if (invoice.isPresent()) {
            invoiceResponseDTO = invoiceToInvoiceResponseDTOMapper.convert(invoice.get());
        }

        return Optional.ofNullable(invoiceResponseDTO);
    }

    @Override
    public InvoiceResponseDTO createInvoice(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice newInvoice = invoiceRequestDTOToInvoiceMapper.convert(invoiceRequestDTO);
        Invoice saveInvoice = invoiceRepository.save(Objects.requireNonNull(newInvoice));

        return invoiceToInvoiceResponseDTOMapper.convert(saveInvoice);
    }

    @Override
    public InvoiceResponseDTO updateInvoice(InvoiceUpdateRequestDTO invoiceUpdateRequestDTO) {
        invoiceRepository.findById(invoiceUpdateRequestDTO.getInvoiceId())
                .orElseThrow(() -> new ServiceException("Failed to update invoice no such invoice"));

        Invoice invoice = invoiceUpdateRequestDTOToInvoiceMapper.convert(invoiceUpdateRequestDTO);
        Invoice updateInvoice = invoiceRepository.save(Objects.requireNonNull(invoice));

        return invoiceToInvoiceResponseDTOMapper.convert(updateInvoice);
    }

    @Override
    public boolean deleteInvoice(long invoiceId) {
        invoiceRepository.deleteById(invoiceId);

        return invoiceRepository.findById(invoiceId).isEmpty();
    }
}
