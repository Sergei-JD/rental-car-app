package com.microservices.order.service;

import com.microservices.order.dto.create.ReservationCreateDTO;
import com.microservices.order.dto.update.ReservationUpdateDTO;
import com.microservices.order.dto.view.ReservationViewDTO;
import com.microservices.order.entity.ReservationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReservationService {

    Page<ReservationViewDTO> getAllReservations(Pageable pageable);

    Page<ReservationViewDTO> getAllReservationsStatus(ReservationStatus reservationStatus, Pageable pageable);

    Page<ReservationViewDTO> getAllReservationByOrderId(Long orderId, Pageable pageable);

    ReservationViewDTO getReservationById(Long reservationId);

    ReservationCreateDTO createReservation(ReservationCreateDTO reservationCreateDTO);

    ReservationUpdateDTO updateReservation(Long reservationId, ReservationUpdateDTO reservationUpdateDTO);

    boolean deleteReservation(Long reservationId);
}
