package com.microservices.order.mapper;

import com.microservices.order.dto.create.ReservationCreateDTO;
import com.microservices.order.dto.update.ReservationUpdateDTO;
import com.microservices.order.dto.view.ReservationViewDTO;
import com.microservices.order.entity.Reservation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReservationMapper {

    public static ReservationViewDTO toReservationViewDTO(Reservation reservation) {
        return Optional.ofNullable(reservation)
                .map(existReservation -> ReservationViewDTO.builder()
                        .id(reservation.getId())
                        .carCatalogId(reservation.getCarCatalogId())
                        .pickUpDateTime(reservation.getPickUpDateTime())
                        .dropOffDateTime(reservation.getDropOffDateTime())
                        .reservationStatus(reservation.getReservationStatus())
                        .build())
                .orElse(null);
    }

    public static ReservationCreateDTO toReservationCreateDTO(Reservation reservation) {
        return Optional.ofNullable(reservation)
                .map(existReservation -> ReservationCreateDTO.builder()
                        .carCatalogId(reservation.getCarCatalogId())
                        .pickUpDateTime(reservation.getPickUpDateTime())
                        .dropOffDateTime(reservation.getDropOffDateTime())
                        .reservationStatus(reservation.getReservationStatus())
                        .build())
                .orElse(null);
    }

    public static ReservationUpdateDTO toReservationUpdateDTO(Reservation reservation) {
        return Optional.ofNullable(reservation)
                .map(existReservation -> ReservationUpdateDTO.builder()
                        .carCatalogId(reservation.getCarCatalogId())
                        .pickUpDateTime(reservation.getPickUpDateTime())
                        .dropOffDateTime(reservation.getDropOffDateTime())
                        .reservationStatus(reservation.getReservationStatus())
                        .build())
                .orElse(null);
    }
}
