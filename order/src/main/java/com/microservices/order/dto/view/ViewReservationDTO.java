package com.microservices.order.dto.view;

import com.microservices.order.entity.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ViewReservationDTO {

    private Long id;

    private Long carCatalogId;

    private Instant pickUpDateTime;

    private Instant dropOffDateTime;

    private ReservationStatus reservationStatus;
}
