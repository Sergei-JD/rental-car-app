package com.microservices.order.mapper;

import com.microservices.order.dto.OrderResponseViewDTO;
import com.microservices.order.entity.Order;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface OrderToOrderResponseViewDTOMapper extends Converter<Order, OrderResponseViewDTO> {

    @Override
    OrderResponseViewDTO convert(@NonNull Order order);
}
