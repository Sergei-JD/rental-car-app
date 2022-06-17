package com.microservices.order.controller;

import com.microservices.order.dto.request.InvoiceRequestDTO;
import com.microservices.order.dto.request.UpdateInvoiceDTO;
import com.microservices.order.dto.response.InvoiceResponseDTO;
import com.microservices.order.entity.Invoice;
import com.microservices.order.entity.InvoiceStatus;
import com.microservices.order.mapper.request.InvoiceRequestDTOToInvoiceMapper;
import com.microservices.order.mapper.request.UpdateInvoiceDTOToInvoiceMapper;
import com.microservices.order.mapper.response.InvoiceToInvoiceResponseDTOMapper;
import com.microservices.order.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceRequestDTOToInvoiceMapper invoiceRequestDTOToInvoiceMapper;
    private final InvoiceToInvoiceResponseDTOMapper invoiceToInvoiceResponseDTOMapper;
    private final UpdateInvoiceDTOToInvoiceMapper updateInvoiceDTOToInvoiceMapper;

    @GetMapping
    public ResponseEntity<List<InvoiceResponseDTO>> getAllInvoices(Pageable pageable) {
        List<InvoiceResponseDTO> invoices = invoiceService.getAllInvoices(pageable).stream()
                .map(invoiceToInvoiceResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<InvoiceResponseDTO>> getAllInvoicesByStatus(@RequestParam(name = "status") InvoiceStatus invoiceStatus, Pageable pageable) {
        List<InvoiceResponseDTO> invoices = invoiceService.getAllInvoicesByStatus(invoiceStatus, pageable).stream()
                .map(invoiceToInvoiceResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponseDTO> getInvoiceById(@PathVariable(name = "id") Long id) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        InvoiceResponseDTO invoiceResponseDTO = invoiceToInvoiceResponseDTOMapper.convert(invoice);

        return new ResponseEntity<>(invoiceResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InvoiceResponseDTO> createInvoice(@RequestBody @Valid InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = invoiceRequestDTOToInvoiceMapper.convert(invoiceRequestDTO);
        Invoice createdInvoice = invoiceService.createInvoice(invoice);
        InvoiceResponseDTO addInvoice = invoiceToInvoiceResponseDTOMapper.convert(createdInvoice);

        return new ResponseEntity<>(addInvoice, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<InvoiceResponseDTO> updateInvoice(@RequestBody @Valid UpdateInvoiceDTO updateInvoiceDTO) {
        Invoice invoice = updateInvoiceDTOToInvoiceMapper.convert(updateInvoiceDTO);
        Invoice updateInvoice = invoiceService.updateInvoice(invoice);
        InvoiceResponseDTO updatedInvoice = invoiceToInvoiceResponseDTOMapper.convert(updateInvoice);

        return new ResponseEntity<>(updatedInvoice, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteInvoice(@PathVariable(name = "id") Long id) {
        boolean deleteInvoice = invoiceService.deleteInvoice(id);

        return new ResponseEntity<>(deleteInvoice, HttpStatus.OK);
    }
}
