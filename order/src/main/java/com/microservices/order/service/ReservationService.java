package com.microservices.order.service;

import com.microservices.order.dto.request.ReservationRequestDTO;
import com.microservices.order.dto.response.ReservationResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Page<ReservationResponseDTO> getAllReservations(Pageable pageable);

    Page<ReservationResponseDTO> getAllReservationsStatus(String reservationStatus, Pageable pageable);

    List<ReservationResponseDTO> getAllReservationByOrderId(Long orderId);

    Optional<ReservationResponseDTO> getReservationById(long reservationId);

    ReservationRequestDTO createReservation(ReservationRequestDTO reservationRequestDTO);

    ReservationResponseDTO updateReservation(ReservationResponseDTO reservationResponseDTO);

    boolean deleteReservation(long reservationId);
}
