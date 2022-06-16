package com.microservices.order.service;

import com.microservices.order.dto.request.ReservationRequestDTO;
import com.microservices.order.dto.request.UpdateReservationDTO;
import com.microservices.order.dto.response.ReservationResponseDTO;
import com.microservices.order.entity.Reservation;
import com.microservices.order.entity.ReservationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReservationService {

    Page<Reservation> getAllReservations(Pageable pageable);

    Page<Reservation> getAllReservationsStatus(ReservationStatus reservationStatus, Pageable pageable);

    Page<Reservation> getAllReservationByOrderId(Long orderId, Pageable pageable);

    Reservation getReservationById(long reservationId);

    Reservation createReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    boolean deleteReservation(long reservationId);
}
