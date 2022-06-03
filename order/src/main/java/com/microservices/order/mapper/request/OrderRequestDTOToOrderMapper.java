package com.microservices.order.mapper.request;

import com.microservices.order.entity.Order;
import com.microservices.order.dto.request.OrderRequestDTO;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface OrderRequestDTOToOrderMapper extends Converter<OrderRequestDTO, Order> {

    @Override
    Order convert(@NonNull OrderRequestDTO source);
}
