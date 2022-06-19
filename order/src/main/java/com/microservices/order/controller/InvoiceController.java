package com.microservices.order.controller;

import com.microservices.order.dto.create.InvoiceCreateDTO;
import com.microservices.order.dto.update.InvoiceUpdateDTO;
import com.microservices.order.dto.view.InvoiceViewDTO;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<Page<InvoiceViewDTO>> getAllInvoices(Pageable pageable) {
        Page<InvoiceViewDTO> invoices = invoiceService.getAllInvoices(pageable);

        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<InvoiceViewDTO>> getAllInvoicesByStatus(
            @RequestParam(name = "status") InvoiceStatus invoiceStatus, Pageable pageable) {
        Page<InvoiceViewDTO> invoices = invoiceService.getAllInvoicesByStatus(invoiceStatus, pageable);

        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceViewDTO> getInvoiceById(
            @PathVariable(name = "id") Long id) {
        InvoiceViewDTO invoiceViewDTO = invoiceService.getInvoiceById(id);

        return new ResponseEntity<>(invoiceViewDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InvoiceCreateDTO> createInvoice(
            @RequestBody @Valid InvoiceCreateDTO invoiceCreateDTO) {
        InvoiceCreateDTO addInvoice = invoiceService.createInvoice(invoiceCreateDTO);

        return new ResponseEntity<>(addInvoice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceUpdateDTO> updateInvoice(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid InvoiceUpdateDTO invoiceUpdateDTO) {
        InvoiceUpdateDTO updateInvoice = invoiceService.updateInvoice(id, invoiceUpdateDTO);

        return new ResponseEntity<>(updateInvoice, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteInvoice(
            @PathVariable(name = "id") Long id) {
        boolean deleteInvoice = invoiceService.deleteInvoice(id);

        return new ResponseEntity<>(deleteInvoice, HttpStatus.OK);
    }
}
