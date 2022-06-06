package com.microservices.order.mapper.request;

import com.microservices.order.dto.request.OrderUpdateRequestDTO;
import com.microservices.order.entity.Order;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface OrderUpdateRequestDTOToOrderMapper extends Converter<OrderUpdateRequestDTO, Order> {

    @Override
    Order convert(@NonNull OrderUpdateRequestDTO source);
}
