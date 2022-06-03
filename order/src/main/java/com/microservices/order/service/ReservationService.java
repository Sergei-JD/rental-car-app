package com.microservices.order.service;

import com.microservices.order.dto.ReservationRequestDTO;
import com.microservices.order.dto.ReservationResponseFullDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Page<ReservationResponseFullDTO> getAllReservations(Pageable pageable);

    Page<ReservationResponseFullDTO> getAllReservationsStatus(String reservationStatus, Pageable pageable);

    List<ReservationResponseFullDTO> getAllReservationByOrderId(Long orderId);

    Optional<ReservationResponseFullDTO> getReservationById(long reservationId);

    ReservationRequestDTO createReservation(ReservationRequestDTO reservationRequestDTO);

    ReservationResponseFullDTO updateReservation(ReservationResponseFullDTO reservationResponseFullDTO);

    boolean deleteReservation(long reservationId);
}
