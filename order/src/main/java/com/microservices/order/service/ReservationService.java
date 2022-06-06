package com.microservices.order.service;

import com.microservices.order.dto.request.ReservationRequestDTO;
import com.microservices.order.dto.request.ReservationUpdateRequestDTO;
import com.microservices.order.dto.response.ReservationResponseDTO;
import com.microservices.order.entity.ReservationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReservationService {

    Page<ReservationResponseDTO> getAllReservations(Pageable pageable);

    Page<ReservationResponseDTO> getAllReservationsStatus(ReservationStatus reservationStatus, Pageable pageable);

    public Page<ReservationResponseDTO> getAllReservationByOrderId(Long orderId, Pageable pageable);

    Optional<ReservationResponseDTO> getReservationById(long reservationId);

    ReservationResponseDTO createReservation(ReservationRequestDTO reservationRequestDTO);

    ReservationResponseDTO updateReservation(ReservationUpdateRequestDTO reservationUpdateRequestDTO);

    boolean deleteReservation(long reservationId);
}
