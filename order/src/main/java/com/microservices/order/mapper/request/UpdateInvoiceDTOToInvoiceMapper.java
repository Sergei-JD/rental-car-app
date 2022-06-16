package com.microservices.order.mapper.request;

import com.microservices.order.dto.request.UpdateInvoiceDTO;
import com.microservices.order.entity.Invoice;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface UpdateInvoiceDTOToInvoiceMapper extends Converter<UpdateInvoiceDTO, Invoice> {

    @Override
    Invoice convert(@NonNull UpdateInvoiceDTO source);
}
