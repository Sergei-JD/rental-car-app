package com.microservices.order.controller;

import com.microservices.order.dto.request.ReservationRequestDTO;
import com.microservices.order.dto.request.ReservationUpdateRequestDTO;
import com.microservices.order.dto.response.ReservationResponseDTO;
import com.microservices.order.entity.ReservationStatus;
import com.microservices.order.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<Page<ReservationResponseDTO>> getAllReservations(Pageable pageable) {
        Page<ReservationResponseDTO> reservations = reservationService.getAllReservations(pageable);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<ReservationResponseDTO>> getAllReservationsStatus(@RequestParam(name = "status") ReservationStatus reservationStatus, Pageable pageable) {
        Page<ReservationResponseDTO> reservations = reservationService.getAllReservationsStatus(reservationStatus, pageable);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Page<ReservationResponseDTO>> getAllReservationByOrderId(@PathVariable(name = "id") Long id, Pageable pageable) {
        Page<ReservationResponseDTO> reservations = reservationService.getAllReservationByOrderId(id, pageable);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> getReservationById(@PathVariable(name = "id") Long id) {
        Optional<ReservationResponseDTO> reservationResponseDTO = reservationService.getReservationById(id);
        return reservationResponseDTO.map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK))
                .orElseThrow(() -> new RuntimeException(
                        "Reservation with this id: " + id + " does not exist")
                );
    }

    @PostMapping
    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody @Valid ReservationRequestDTO reservationRequestDTO) {
        ReservationResponseDTO addReservation = reservationService.createReservation(reservationRequestDTO);
        return new ResponseEntity<>(addReservation, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ReservationResponseDTO> updateReservation(@RequestBody @Valid ReservationUpdateRequestDTO reservationUpdateRequestDTO) {
        ReservationResponseDTO updatedReservation = reservationService.updateReservation(reservationUpdateRequestDTO);
        return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteReservation(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(reservationService.deleteReservation(id), HttpStatus.OK);
    }
}
