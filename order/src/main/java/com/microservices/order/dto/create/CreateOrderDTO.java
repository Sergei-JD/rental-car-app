package com.microservices.order.dto.create;

import com.microservices.order.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDTO {

    @NotEmpty(message = "'Account id' should not be empty")
    @Positive(message = "'Account id' should be positive number")
    private Long accountId;

    @NotEmpty(message = "'Order status' should not be empty")
    @Size(min = 2, max = 64, message = "'Order status' should be 'PENDING' or 'CONFIRMED' or 'CANCELLED'")
    private OrderStatus orderStatus;

    @NotEmpty(message = "'Invoice id' should not be empty")
    private Long invoiceId;
}
