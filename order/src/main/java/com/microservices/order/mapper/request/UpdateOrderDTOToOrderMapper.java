package com.microservices.order.mapper.request;

import com.microservices.order.dto.request.UpdateOrderDTO;
import com.microservices.order.entity.Order;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface UpdateOrderDTOToOrderMapper extends Converter<UpdateOrderDTO, Order> {

    @Override
    Order convert(@NonNull UpdateOrderDTO source);
}