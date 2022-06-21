package com.microservices.order.mapper;

import com.microservices.order.dto.view.ViewReservationDTO;
import com.microservices.order.entity.Reservation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReservationMapper {

    public static ViewReservationDTO toViewReservationDTO(Reservation reservation) {
        return Optional.ofNullable(reservation)
                .map(existReservation -> ViewReservationDTO.builder()
                        .id(reservation.getId())
                        .carCatalogId(reservation.getCarCatalogId())
                        .pickUpDateTime(reservation.getPickUpDateTime())
                        .dropOffDateTime(reservation.getDropOffDateTime())
                        .reservationStatus(reservation.getReservationStatus())
                        .build())
                .orElse(null);
    }
}
