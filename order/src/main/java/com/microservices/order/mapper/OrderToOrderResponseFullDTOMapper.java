package com.microservices.order.mapper;

import com.microservices.order.dto.OrderResponseFullDTO;
import com.microservices.order.entity.Order;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface OrderToOrderResponseFullDTOMapper extends Converter<Order, OrderResponseFullDTO> {

    @Override
    OrderResponseFullDTO convert(@NonNull Order order);
}
