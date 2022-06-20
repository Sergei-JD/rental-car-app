package com.microservices.order.service;

import com.microservices.order.dto.create.CreateReservationDTO;
import com.microservices.order.dto.update.UpdateReservationDTO;
import com.microservices.order.dto.view.ViewReservationDTO;
import com.microservices.order.entity.Reservation;
import com.microservices.order.entity.ReservationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReservationService {

    Page<ViewReservationDTO> getAllReservations(Pageable pageable);

    Page<ViewReservationDTO> getAllReservationsStatus(ReservationStatus reservationStatus, Pageable pageable);

    Page<ViewReservationDTO> getAllReservationByOrderId(Long orderId, Pageable pageable);

    Reservation getReservationById(Long reservationId);

    Long createReservation(CreateReservationDTO createReservationDTO);

    void updateReservation(Long reservationId, UpdateReservationDTO updateReservationDTO);

    boolean deleteReservation(Long reservationId);
}
