package com.microservices.order.mapper;

import com.microservices.order.dto.InvoiceResponseViewDTO;
import com.microservices.order.entity.Invoice;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface InvoiceToInvoiceResponseViewDTOMapper extends Converter<Invoice, InvoiceResponseViewDTO> {

    @Override
    InvoiceResponseViewDTO convert(@NonNull Invoice invoice);
}
