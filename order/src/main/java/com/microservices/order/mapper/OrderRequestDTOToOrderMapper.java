package com.microservices.order.mapper;

import com.microservices.order.dto.OrderRequestDTO;
import com.microservices.order.entity.Order;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface OrderRequestDTOToOrderMapper extends Converter<OrderRequestDTO, Order> {

    @Override
    Order convert(@NonNull OrderRequestDTO source);
}
