package com.microservices.order.repository;

import com.microservices.order.entity.Reservation;
import com.microservices.order.entity.ReservationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Page<Reservation> findReservationByOrderId(Long orderId, Pageable pageable);

    Page<Reservation> findAllByReservationStatus(ReservationStatus reservationStatus, Pageable pageable);
}
