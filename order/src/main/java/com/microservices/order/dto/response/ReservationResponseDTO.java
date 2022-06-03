package com.microservices.order.dto.response;

import com.microservices.order.entity.Order;
import com.microservices.order.entity.ReservationStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDTO {

    private Long reservationId;

    private Order orderId;

    private Long carCatalogId;

    private Instant pickUpDateTime;

    private Instant dropOffDateTime;

    private ReservationStatus reservationStatus;
}
