package com.microservices.order.mapper;

import com.microservices.order.dto.InvoiceResponseFullDTO;
import com.microservices.order.entity.Invoice;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface InvoiceToInvoiceResponseFullDTOMapper extends Converter<Invoice, InvoiceResponseFullDTO> {

    @Override
    InvoiceResponseFullDTO convert(@NonNull Invoice invoice);
}
