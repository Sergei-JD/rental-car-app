package com.microservices.order.controller;

import com.microservices.order.dto.create.ReservationCreateDTO;
import com.microservices.order.dto.update.ReservationUpdateDTO;
import com.microservices.order.dto.view.ReservationViewDTO;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<Page<ReservationViewDTO>> getAllReservations(Pageable pageable) {
        Page<ReservationViewDTO> reservations = reservationService.getAllReservations(pageable);

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<ReservationViewDTO>> getAllReservationsStatus(
            @RequestParam(name = "status") ReservationStatus reservationStatus, Pageable pageable) {
        Page<ReservationViewDTO> reservations = reservationService.getAllReservationsStatus(reservationStatus, pageable);

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Page<ReservationViewDTO>> getAllReservationByOrderId(
            @PathVariable(name = "id") Long id, Pageable pageable) {
        Page<ReservationViewDTO> reservations = reservationService.getAllReservationByOrderId(id, pageable);

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationViewDTO> getReservationById(
            @PathVariable(name = "id") Long id) {
        ReservationViewDTO reservationViewDTO = reservationService.getReservationById(id);

        return new ResponseEntity<>(reservationViewDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReservationCreateDTO> createReservation(
            @RequestBody @Valid ReservationCreateDTO reservationCreateDTO) {
        ReservationCreateDTO addReservation = reservationService.createReservation(reservationCreateDTO);

        return new ResponseEntity<>(addReservation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationUpdateDTO> updateReservation(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid ReservationUpdateDTO reservationUpdateDTO) {
        ReservationUpdateDTO updateReservation = reservationService.updateReservation(id, reservationUpdateDTO);

        return new ResponseEntity<>(updateReservation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteReservation(
            @PathVariable(name = "id") Long id) {
        boolean deleteReservation = reservationService.deleteReservation(id);

        return new ResponseEntity<>(deleteReservation, HttpStatus.OK);
    }
}
