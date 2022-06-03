package com.microservices.order.dto.request;

import com.microservices.order.entity.OrderStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {

    @NotEmpty(message = "'Account id' should not be empty")
    @Positive(message = "'Account id' should be positive number")
    private Long accountId;

    @NotEmpty(message = "'Order status' should not be empty")
    @Size(min = 2, max = 64, message = "'Order status' should be 'PENDING' or 'CONFIRMED' or 'CANCELLED'")
    private OrderStatus orderStatus;
}
