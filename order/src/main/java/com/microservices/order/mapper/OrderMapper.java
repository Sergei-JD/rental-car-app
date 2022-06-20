package com.microservices.order.mapper;

import com.microservices.order.dto.create.CreateOrderDTO;
import com.microservices.order.dto.update.UpdateOrderDTO;
import com.microservices.order.dto.view.ViewOrderDTO;
import com.microservices.order.entity.Order;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderMapper {

    public static ViewOrderDTO toViewOrderDTO(Order order) {
        return Optional.ofNullable(order)
                .map(existOrder -> ViewOrderDTO.builder()
                        .id(order.getId())
                        .accountId(order.getAccountId())
                        .orderStatus(order.getOrderStatus())
                        .build())
                .orElse(null);
    }

    public static CreateOrderDTO toCreateOrderDTO(Order order) {
        return Optional.ofNullable(order)
                .map(existOrder -> CreateOrderDTO.builder()
                        .accountId(order.getAccountId())
                        .orderStatus(order.getOrderStatus())
                        .build())
                .orElse(null);
    }

    public static UpdateOrderDTO toUpdateOrderDTO(Order order) {
        return Optional.ofNullable(order)
                .map(existOrder -> UpdateOrderDTO.builder()
                        .accountId(order.getAccountId())
                        .orderStatus(order.getOrderStatus())
                        .build())
                .orElse(null);
    }
}
