package com.microservices.order.service.dataimpl;

import com.microservices.order.dto.create.ReservationCreateDTO;
import com.microservices.order.dto.update.ReservationUpdateDTO;
import com.microservices.order.dto.view.ReservationViewDTO;
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
    public Page<ReservationViewDTO> getAllReservations(Pageable pageable) {
        Page<Reservation> pageReservations = reservationRepository.findAll(pageable);

        List<ReservationViewDTO> reservations = pageReservations.stream()
                .map(ReservationMapper::toReservationViewDTO)
                .toList();

        return new PageImpl<>(reservations);
    }

    @Override
    public Page<ReservationViewDTO> getAllReservationsStatus(ReservationStatus reservationStatus, Pageable pageable) {
        Page<Reservation> pageReservations = reservationRepository.findAllByReservationStatus(reservationStatus, pageable);

        List<ReservationViewDTO> reservations = pageReservations.stream()
                .map(ReservationMapper::toReservationViewDTO)
                .toList();

        return new PageImpl<>(reservations);
    }

    @Override
    public Page<ReservationViewDTO> getAllReservationByOrderId(Long orderId, Pageable pageable) {
        Page<Reservation> pageReservations = reservationRepository.findReservationByOrderId(orderId, pageable);

        List<ReservationViewDTO> reservations = pageReservations.stream()
                .map(ReservationMapper::toReservationViewDTO)
                .toList();

        return new PageImpl<>(reservations);
    }

    @Override
    public ReservationViewDTO getReservationById(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ServiceException(String.format(RESERVATION_ID_EXCEPTION_MESSAGE, reservationId)));

        return ReservationMapper.toReservationViewDTO(reservation);
    }

    @Override
    @Transactional
    public ReservationCreateDTO createReservation(ReservationCreateDTO reservationCreateDTO) {
        Reservation newReservation = Reservation.builder()
                .carCatalogId(reservationCreateDTO.getCarCatalogId())
                .pickUpDateTime(reservationCreateDTO.getPickUpDateTime())
                .dropOffDateTime(reservationCreateDTO.getDropOffDateTime())
                .reservationStatus(reservationCreateDTO.getReservationStatus())
                .build();

        return ReservationMapper.toReservationCreateDTO(reservationRepository.save(newReservation));
    }

    @Override
    @Transactional
    public ReservationUpdateDTO updateReservation(Long reservationId, ReservationUpdateDTO reservationUpdateDTO) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ServiceException(String.format(RESERVATION_ID_EXCEPTION_MESSAGE, reservationId)));
        reservation.setCarCatalogId(reservationUpdateDTO.getCarCatalogId());
        reservation.setPickUpDateTime(reservationUpdateDTO.getPickUpDateTime());
        reservation.setDropOffDateTime(reservationUpdateDTO.getDropOffDateTime());
        reservation.setReservationStatus(reservationUpdateDTO.getReservationStatus());

        reservationRepository.save(reservation);

        return ReservationMapper.toReservationUpdateDTO(reservation);
    }

    @Override
    @Transactional
    public boolean deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);

        return reservationRepository.findById(reservationId).isEmpty();
    }
}
