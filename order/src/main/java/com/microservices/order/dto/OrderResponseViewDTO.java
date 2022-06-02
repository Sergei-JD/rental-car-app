package com.microservices.order.dto;

import com.microservices.order.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseViewDTO {

    @Positive(message = "'Order id' should be positive number")
    private Long orderId;

    @NotEmpty(message = "'Order status' should not be empty")
    @Size(min = 2, max = 64, message = "'Order status' should be 'PENDING' or 'CONFIRMED' or 'CANCELLED'")
    private OrderStatus orderStatus;
}
