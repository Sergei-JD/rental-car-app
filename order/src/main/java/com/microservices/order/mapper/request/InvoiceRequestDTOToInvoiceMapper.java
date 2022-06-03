package com.microservices.order.mapper.request;

import com.microservices.order.entity.Invoice;
import com.microservices.order.dto.request.InvoiceRequestDTO;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface InvoiceRequestDTOToInvoiceMapper extends Converter<InvoiceRequestDTO, Invoice> {

    @Override
    Invoice convert(@NonNull InvoiceRequestDTO source);
}
