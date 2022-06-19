package com.microservices.order.dto.view;

import com.microservices.order.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrderViewDTO {

    private Long id;

    private Long accountId;

    private OrderStatus orderStatus;
}
