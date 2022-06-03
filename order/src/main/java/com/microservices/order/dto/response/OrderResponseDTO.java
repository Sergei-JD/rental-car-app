package com.microservices.order.dto.response;

import com.microservices.order.entity.OrderStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {

    private Long orderId;

    private Long accountId;

    private OrderStatus orderStatus;
}
