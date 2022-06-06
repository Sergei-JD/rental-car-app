package com.microservices.order.mapper.request;

import com.microservices.order.dto.request.InvoiceUpdateRequestDTO;
import com.microservices.order.entity.Invoice;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface InvoiceUpdateRequestDTOToInvoiceMapper extends Converter<InvoiceUpdateRequestDTO, Invoice> {

    @Override
    Invoice convert(@NonNull InvoiceUpdateRequestDTO source);
}
