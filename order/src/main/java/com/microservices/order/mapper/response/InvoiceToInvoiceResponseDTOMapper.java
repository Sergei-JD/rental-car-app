package com.microservices.order.mapper.response;

import com.microservices.order.entity.Invoice;
import com.microservices.order.dto.response.InvoiceResponseDTO;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface InvoiceToInvoiceResponseDTOMapper extends Converter<Invoice, InvoiceResponseDTO> {

    @Override
    InvoiceResponseDTO convert(@NonNull Invoice invoice);
}
