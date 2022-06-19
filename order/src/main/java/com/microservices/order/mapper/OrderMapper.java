package com.microservices.order.mapper;

import com.microservices.order.dto.create.OrderCreateDTO;
import com.microservices.order.dto.update.OrderUpdateDTO;
import com.microservices.order.dto.view.OrderViewDTO;
import com.microservices.order.entity.Order;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderMapper {

    public static OrderViewDTO toOrderViewDTO(Order order) {
        return Optional.ofNullable(order)
                .map(existOrder -> OrderViewDTO.builder()
                        .id(order.getId())
                        .accountId(order.getAccountId())
                        .orderStatus(order.getOrderStatus())
                        .build())
                .orElse(null);
    }

    public static OrderCreateDTO toOrderCreateDTO(Order order) {
        return Optional.ofNullable(order)
                .map(existOrder -> OrderCreateDTO.builder()
                        .accountId(order.getAccountId())
                        .orderStatus(order.getOrderStatus())
                        .build())
                .orElse(null);
    }

    public static OrderUpdateDTO toOrderUpdateDTO(Order order) {
        return Optional.ofNullable(order)
                .map(existOrder -> OrderUpdateDTO.builder()
                        .accountId(order.getAccountId())
                        .orderStatus(order.getOrderStatus())
                        .build())
                .orElse(null);
    }
}
