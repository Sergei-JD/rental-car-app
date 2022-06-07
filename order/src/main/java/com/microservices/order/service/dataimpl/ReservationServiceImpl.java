package com.microservices.order.service.dataimpl;

import com.microservices.order.dto.request.ReservationRequestDTO;
import com.microservices.order.dto.request.ReservationUpdateRequestDTO;
import com.microservices.order.dto.response.ReservationResponseDTO;
import com.microservices.order.entity.Reservation;
import com.microservices.order.entity.ReservationStatus;
import com.microservices.order.mapper.request.ReservationRequestDTOToReservationMapper;
import com.microservices.order.mapper.request.ReservationUpdateRequestDTOToReservationMapper;
import com.microservices.order.mapper.response.ReservationToReservationResponseDTOMapper;
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
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationRequestDTOToReservationMapper reservationRequestDTOToReservationMapper;
    private final ReservationToReservationResponseDTOMapper reservationToReservationResponseDTOMapper;
    private final ReservationUpdateRequestDTOToReservationMapper reservationUpdateRequestDTOToReservationMapper;

    @Override
    public Page<ReservationResponseDTO> getAllReservations(Pageable pageable) {
        Page<Reservation> pageReservations = reservationRepository.findAll(pageable);

        List<ReservationResponseDTO> reservations = pageReservations.stream()
                .map(reservationToReservationResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(reservations);
    }

    @Override
    public Page<ReservationResponseDTO> getAllReservationsStatus(ReservationStatus reservationStatus, Pageable pageable) {
        Page<Reservation> pageReservations = reservationRepository.findAllByReservationStatus(reservationStatus, pageable);

        List<ReservationResponseDTO> reservations = pageReservations.stream()
                .map(reservationToReservationResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(reservations);
    }

    @Override
    public Page<ReservationResponseDTO> getAllReservationByOrderId(Long orderId, Pageable pageable) {
        Page<Reservation> pageParkingSpaces = reservationRepository.findReservationByOrderId(orderId, pageable);

        List<ReservationResponseDTO> reservations = pageParkingSpaces.stream()
                .map(reservationToReservationResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(reservations);
    }

    @Override
    public Optional<ReservationResponseDTO> getReservationById(long reservationId) {
        ReservationResponseDTO reservationResponseDTO = null;

        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            reservationResponseDTO = reservationToReservationResponseDTOMapper.convert(reservation.get());
        }

        return Optional.ofNullable(reservationResponseDTO);
    }

    @Override
    @Transactional
    public ReservationResponseDTO createReservation(ReservationRequestDTO reservationRequestDTO) {
        Reservation newReservation = reservationRequestDTOToReservationMapper.convert(reservationRequestDTO);
        Reservation saveReservation = reservationRepository.save(Objects.requireNonNull(newReservation));

        return reservationToReservationResponseDTOMapper.convert(saveReservation);
    }

    @Override
    @Transactional
    public ReservationResponseDTO updateReservation(ReservationUpdateRequestDTO reservationUpdateRequestDTO) {
        reservationRepository.findById(reservationUpdateRequestDTO.getReservationId())
                .orElseThrow(() -> new ServiceException("Failed to update reservation no such reservation"));

        Reservation reservation = reservationUpdateRequestDTOToReservationMapper.convert(reservationUpdateRequestDTO);
        Reservation updateReservation = reservationRepository.save(Objects.requireNonNull(reservation));

        return reservationToReservationResponseDTOMapper.convert(updateReservation);
    }

    @Override
    @Transactional
    public boolean deleteReservation(long reservationId) {
        reservationRepository.deleteById(reservationId);

        return reservationRepository.findById(reservationId).isEmpty();
    }
}
