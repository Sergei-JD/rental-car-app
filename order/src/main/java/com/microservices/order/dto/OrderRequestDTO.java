package com.microservices.order.dto;

import com.microservices.order.entity.Invoice;
import com.microservices.order.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
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
