package com.microservices.order.controller;

import com.microservices.order.dto.create.CreateReservationDTO;
import com.microservices.order.dto.update.UpdateReservationDTO;
import com.microservices.order.dto.view.ViewReservationDTO;
import com.microservices.order.entity.Reservation;
import com.microservices.order.entity.ReservationStatus;
import com.microservices.order.mapper.ReservationMapper;
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
    public ResponseEntity<Page<ViewReservationDTO>> getAllReservations(Pageable pageable) {
        Page<ViewReservationDTO> reservations = reservationService.getAllReservations(pageable);

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<ViewReservationDTO>> getAllReservationsStatus(
            @RequestParam(name = "status") ReservationStatus reservationStatus, Pageable pageable) {
        Page<ViewReservationDTO> reservations = reservationService.getAllReservationsStatus(reservationStatus, pageable);

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Page<ViewReservationDTO>> getAllReservationByOrderId(
            @PathVariable(name = "id") Long id, Pageable pageable) {
        Page<ViewReservationDTO> reservations = reservationService.getAllReservationByOrderId(id, pageable);

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewReservationDTO> getReservationById(
            @PathVariable(name = "id") Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        ViewReservationDTO viewReservationDTO = ReservationMapper.toViewReservationDTO(reservation);

        return new ResponseEntity<>(viewReservationDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createReservation(
            @RequestBody @Valid CreateReservationDTO createReservationDTO) {
        Long addReservation = reservationService.createReservation(createReservationDTO);

        return new ResponseEntity<>(addReservation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateReservation(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid UpdateReservationDTO updateReservationDTO) {
        reservationService.updateReservation(id, updateReservationDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteReservation(
            @PathVariable(name = "id") Long id) {
        boolean deleteReservation = reservationService.deleteReservation(id);

        return new ResponseEntity<>(deleteReservation, HttpStatus.OK);
    }
}
