package com.microservices.order.controller;

import com.microservices.order.dto.request.ReservationRequestDTO;
import com.microservices.order.dto.request.UpdateReservationDTO;
import com.microservices.order.dto.response.ReservationResponseDTO;
import com.microservices.order.entity.Reservation;
import com.microservices.order.entity.ReservationStatus;
import com.microservices.order.mapper.request.ReservationRequestDTOToReservationMapper;
import com.microservices.order.mapper.request.UpdateReservationDTOToReservationMapper;
import com.microservices.order.mapper.response.ReservationToReservationResponseDTOMapper;
import com.microservices.order.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationRequestDTOToReservationMapper reservationRequestDTOToReservationMapper;
    private final ReservationToReservationResponseDTOMapper reservationToReservationResponseDTOMapper;
    private final UpdateReservationDTOToReservationMapper updateReservationDTOToReservationMapper;

    @GetMapping
    public ResponseEntity<List<ReservationResponseDTO>> getAllReservations(Pageable pageable) {
        List<ReservationResponseDTO> reservations = reservationService.getAllReservations(pageable).stream()
                .map(reservationToReservationResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<ReservationResponseDTO>> getAllReservationsStatus(@RequestParam(name = "status") ReservationStatus reservationStatus, Pageable pageable) {
        List<ReservationResponseDTO> reservations = reservationService.getAllReservationsStatus(reservationStatus, pageable).stream()
                .map(reservationToReservationResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<List<ReservationResponseDTO>> getAllReservationByOrderId(@PathVariable(name = "id") Long id, Pageable pageable) {
        List<ReservationResponseDTO> reservations = reservationService.getAllReservationByOrderId(id, pageable).stream()
                .map(reservationToReservationResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> getReservationById(@PathVariable(name = "id") Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        ReservationResponseDTO reservationResponseDTO = reservationToReservationResponseDTOMapper.convert(reservation);

        return new ResponseEntity<>(reservationResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody @Valid ReservationRequestDTO reservationRequestDTO) {
        Reservation reservation = reservationRequestDTOToReservationMapper.convert(reservationRequestDTO);
        Reservation createdReservation = reservationService.createReservation(reservation);
        ReservationResponseDTO addReservation = reservationToReservationResponseDTOMapper.convert(createdReservation);

        return new ResponseEntity<>(addReservation, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ReservationResponseDTO> updateReservation(@RequestBody @Valid UpdateReservationDTO updateReservationDTO) {
        Reservation reservation = updateReservationDTOToReservationMapper.convert(updateReservationDTO);
        Reservation updateReservation = reservationService.updateReservation(reservation);
        ReservationResponseDTO updatedReservation = reservationToReservationResponseDTOMapper.convert(updateReservation);

        return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteReservation(@PathVariable(name = "id") Long id) {
        boolean deleteReservation = reservationService.deleteReservation(id);

        return new ResponseEntity<>(deleteReservation, HttpStatus.OK);
    }
}
