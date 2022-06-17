package com.microservices.order.service.dataimpl;

import com.microservices.order.entity.Reservation;
import com.microservices.order.entity.ReservationStatus;
import com.microservices.order.repository.ReservationRepository;
import com.microservices.order.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.microservices.order.util.ServiceData.RESERVATION_DELETE_EXCEPTION_MESSAGE;
import static com.microservices.order.util.ServiceData.RESERVATION_ID_EXCEPTION_MESSAGE;
import static com.microservices.order.util.ServiceData.RESERVATION_UPDATE_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public Page<Reservation> getAllReservations(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }

    @Override
    public Page<Reservation> getAllReservationsStatus(ReservationStatus reservationStatus, Pageable pageable) {
        return reservationRepository.findAllByReservationStatus(reservationStatus, pageable);
    }

    @Override
    public Page<Reservation> getAllReservationByOrderId(Long orderId, Pageable pageable) {
        return reservationRepository.findReservationByOrderId(orderId, pageable);
    }

    @Override
    public Reservation getReservationById(long reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ServiceException(String.format(RESERVATION_ID_EXCEPTION_MESSAGE, reservationId)));
    }

    @Override
    @Transactional
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    @Transactional
    public Reservation updateReservation(Reservation reservation) {
        Reservation maybeReservation = reservationRepository.findById(reservation.getId())
                .orElseThrow(() -> new ServiceException(RESERVATION_UPDATE_EXCEPTION_MESSAGE));
        return reservationRepository.save(maybeReservation);
    }

    @Override
    @Transactional
    public boolean deleteReservation(long reservationId) {
        Reservation maybeReservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ServiceException(String.format(RESERVATION_DELETE_EXCEPTION_MESSAGE, reservationId)));
        reservationRepository.deleteById(maybeReservation.getId());
        return reservationRepository.findById(reservationId).isEmpty();
    }
}
