package com.microservices.order.controller;

import com.microservices.order.dto.create.CreateInvoiceDTO;
import com.microservices.order.dto.update.UpdateInvoiceDTO;
import com.microservices.order.dto.view.ViewInvoiceDTO;
import com.microservices.order.entity.Invoice;
import com.microservices.order.entity.InvoiceStatus;
import com.microservices.order.mapper.InvoiceMapper;
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
    public ResponseEntity<Page<ViewInvoiceDTO>> getAllInvoices(Pageable pageable) {
        Page<ViewInvoiceDTO> invoices = invoiceService.getAllInvoices(pageable);

        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<ViewInvoiceDTO>> getAllInvoicesByStatus(
            @RequestParam(name = "status") InvoiceStatus invoiceStatus, Pageable pageable) {
        Page<ViewInvoiceDTO> invoices = invoiceService.getAllInvoicesByStatus(invoiceStatus, pageable);

        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewInvoiceDTO> getInvoiceById(
            @PathVariable(name = "id") Long id) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        ViewInvoiceDTO viewInvoiceDTO = InvoiceMapper.toViewInvoiceDTO(invoice);

        return new ResponseEntity<>(viewInvoiceDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createInvoice(
            @RequestBody @Valid CreateInvoiceDTO createInvoiceDTO) {
        Long addInvoice = invoiceService.createInvoice(createInvoiceDTO);

        return new ResponseEntity<>(addInvoice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateInvoice(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid UpdateInvoiceDTO updateInvoiceDTO) {
        invoiceService.updateInvoice(id, updateInvoiceDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteInvoice(
            @PathVariable(name = "id") Long id) {
        boolean deleteInvoice = invoiceService.deleteInvoice(id);

        return new ResponseEntity<>(deleteInvoice, HttpStatus.OK);
    }
}
