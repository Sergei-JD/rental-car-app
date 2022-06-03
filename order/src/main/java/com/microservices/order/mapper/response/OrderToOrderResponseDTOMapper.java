package com.microservices.order.mapper.response;

import com.microservices.order.entity.Order;
import com.microservices.order.dto.response.OrderResponseDTO;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface OrderToOrderResponseDTOMapper extends Converter<Order, OrderResponseDTO> {

    @Override
    OrderResponseDTO convert(@NonNull Order order);
}
