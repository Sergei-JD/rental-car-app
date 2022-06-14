package com.microservices.order.controller;

import com.microservices.order.dto.request.InvoiceRequestDTO;
import com.microservices.order.dto.request.InvoiceUpdateRequestDTO;
import com.microservices.order.dto.response.InvoiceResponseDTO;
import com.microservices.order.entity.InvoiceStatus;
import com.microservices.order.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<Page<InvoiceResponseDTO>> getAllInvoices(Pageable pageable) {
        Page<InvoiceResponseDTO> invoices = invoiceService.getAllInvoices(pageable);
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<InvoiceResponseDTO>> getAllInvoicesByStatus(@RequestParam(name = "status") InvoiceStatus invoiceStatus, Pageable pageable) {
        Page<InvoiceResponseDTO> invoices = invoiceService.getAllInvoicesByStatus(invoiceStatus, pageable);
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponseDTO> getInvoiceById(@PathVariable(name = "id") Long id) {
        Optional<InvoiceResponseDTO> invoiceResponseDTO = invoiceService.getInvoiceById(id);
        return invoiceResponseDTO.map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK))
                .orElseThrow(() -> new RuntimeException(
                        "invoice with this id: " + id + " does not exist")
                );
    }

    @PostMapping
    public ResponseEntity<InvoiceResponseDTO> createInvoice(@RequestBody @Valid InvoiceRequestDTO invoiceRequestDTO) {
        InvoiceResponseDTO addInvoice = invoiceService.createInvoice(invoiceRequestDTO);
        return new ResponseEntity<>(addInvoice, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<InvoiceResponseDTO> updateInvoice(@RequestBody @Valid InvoiceUpdateRequestDTO invoiceUpdateRequestDTO) {
        InvoiceResponseDTO updatedInvoice = invoiceService.updateInvoice(invoiceUpdateRequestDTO);
        return new ResponseEntity<>(updatedInvoice, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteInvoice(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(invoiceService.deleteInvoice(id), HttpStatus.OK);
    }
}
