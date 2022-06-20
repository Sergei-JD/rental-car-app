package com.microservices.order.service.dataimpl;

import com.microservices.order.dto.create.CreateReservationDTO;
import com.microservices.order.dto.update.UpdateReservationDTO;
import com.microservices.order.dto.view.ViewReservationDTO;
import com.microservices.order.entity.Reservation;
import com.microservices.order.entity.ReservationStatus;
import com.microservices.order.mapper.ReservationMapper;
import com.microservices.order.repository.ReservationRepository;
import com.microservices.order.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.microservices.order.util.ServiceData.RESERVATION_ID_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public Page<ViewReservationDTO> getAllReservations(Pageable pageable) {
        Page<Reservation> pageReservations = reservationRepository.findAll(pageable);

        List<ViewReservationDTO> reservations = pageReservations.stream()
                .map(ReservationMapper::toViewReservationDTO)
                .toList();

        return new PageImpl<>(reservations);
    }

    @Override
    public Page<ViewReservationDTO> getAllReservationsStatus(ReservationStatus reservationStatus, Pageable pageable) {
        Page<Reservation> pageReservations = reservationRepository.findAllByReservationStatus(reservationStatus, pageable);

        List<ViewReservationDTO> reservations = pageReservations.stream()
                .map(ReservationMapper::toViewReservationDTO)
                .toList();

        return new PageImpl<>(reservations);
    }

    @Override
    public Page<ViewReservationDTO> getAllReservationByOrderId(Long orderId, Pageable pageable) {
        Page<Reservation> pageReservations = reservationRepository.findReservationByOrderId(orderId, pageable);

        List<ViewReservationDTO> reservations = pageReservations.stream()
                .map(ReservationMapper::toViewReservationDTO)
                .toList();

        return new PageImpl<>(reservations);
    }

    @Override
    public Reservation getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ServiceException(String.format(RESERVATION_ID_EXCEPTION_MESSAGE, reservationId)));
    }

    @Override
    @Transactional
    public Long createReservation(CreateReservationDTO createReservationDTO) {
        Reservation newReservation = Reservation.builder()
                .carCatalogId(createReservationDTO.getCarCatalogId())
                .pickUpDateTime(createReservationDTO.getPickUpDateTime())
                .dropOffDateTime(createReservationDTO.getDropOffDateTime())
                .reservationStatus(createReservationDTO.getReservationStatus())
                .build();

        Reservation savedReservation = reservationRepository.save(newReservation);

        return savedReservation.getId();
    }

    @Override
    @Transactional
    public void updateReservation(Long reservationId, UpdateReservationDTO updateReservationDTO) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ServiceException(String.format(RESERVATION_ID_EXCEPTION_MESSAGE, reservationId)));
        reservation.setCarCatalogId(updateReservationDTO.getCarCatalogId());
        reservation.setPickUpDateTime(updateReservationDTO.getPickUpDateTime());
        reservation.setDropOffDateTime(updateReservationDTO.getDropOffDateTime());
        reservation.setReservationStatus(updateReservationDTO.getReservationStatus());

        reservationRepository.save(reservation);
    }

    @Override
    @Transactional
    public boolean deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);

        return reservationRepository.findById(reservationId).isEmpty();
    }
}
