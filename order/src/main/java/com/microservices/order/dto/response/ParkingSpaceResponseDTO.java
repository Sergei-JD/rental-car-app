package com.microservices.order.dto.response;

import com.microservices.order.entity.Order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpaceResponseDTO {

    private Long parkingSpaceId;

    private String address;

    private String level;

    private String numberSpace;

    private Order orderId;
}
