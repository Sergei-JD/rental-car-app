package com.microservices.order.dto;

import com.microservices.order.entity.Order;
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
public class ParkingSpaceRequestDTO {

    @NotEmpty(message = "'Address' should not be empty")
    @Size(min = 2, max = 256, message = "'Address' should be between 2 and 256 characters")
    private String address;

    @NotEmpty(message = "'Level' should not be empty")
    @Size(min = 1, message = "'Level' should be at least one character")
    private String level;

    @NotEmpty(message = "'Number space' should not be empty")
    @Size(min = 1, message = "'Number space' should be at least one character")
    private String numberSpace;

    @NotEmpty(message = "'Order id' should not be empty")
    @Positive(message = "'Order id' should be positive number")
    private Order orderId;
}
