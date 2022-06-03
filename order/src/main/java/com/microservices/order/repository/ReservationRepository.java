package com.microservices.order.repository;

import com.microservices.order.entity.Reservation;
import com.microservices.order.entity.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findReservationByOrderId(Long orderId);

    List<Reservation> findAllByReservationStatus(ReservationStatus reservationStatus);
}
