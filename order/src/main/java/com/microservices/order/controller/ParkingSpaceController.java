package com.microservices.order.controller;

import com.microservices.order.dto.create.ParkingSpaceCreateDTO;
import com.microservices.order.dto.update.ParkingSpaceUpdateDTO;
import com.microservices.order.dto.view.ParkingSpaceViewDTO;
import com.microservices.order.service.ParkingSpaceService;
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
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/spaces")
public class ParkingSpaceController {

    private final ParkingSpaceService parkingSpaceService;

    @GetMapping
    public ResponseEntity<Page<ParkingSpaceViewDTO>> getAllParkingSpaces(Pageable pageable) {
        Page<ParkingSpaceViewDTO> creditParkingSpaces = parkingSpaceService.getAllParkingSpaces(pageable);

        return new ResponseEntity<>(creditParkingSpaces, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Page<ParkingSpaceViewDTO>> getAllParkingSpaceByOrderId(
            @PathVariable(name = "id") Long id, Pageable pageable) {
        Page<ParkingSpaceViewDTO> parkingSpaces = parkingSpaceService.getAllParkingSpaceByOrderId(id, pageable);

        return new ResponseEntity<>(parkingSpaces, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpaceViewDTO> getParkingSpaceById(
            @PathVariable(name = "id") Long id) {
        ParkingSpaceViewDTO parkingSpaceViewDTO = parkingSpaceService.getParkingSpaceById(id);

        return new ResponseEntity<>(parkingSpaceViewDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ParkingSpaceCreateDTO> createParkingSpace(
            @RequestBody @Valid ParkingSpaceCreateDTO parkingSpaceCreateDTO) {
        ParkingSpaceCreateDTO addParkingSpace = parkingSpaceService.createParkingSpace(parkingSpaceCreateDTO);

        return new ResponseEntity<>(addParkingSpace, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpaceUpdateDTO> updateParkingSpace(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid ParkingSpaceUpdateDTO parkingSpaceUpdateDTO) {
        ParkingSpaceUpdateDTO updateParkingSpace = parkingSpaceService.updateParkingSpace(id, parkingSpaceUpdateDTO);

        return new ResponseEntity<>(updateParkingSpace, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteParkingSpace(
            @PathVariable(name = "id") Long id) {
        boolean deleteParkingSpace = parkingSpaceService.deleteParkingSpace(id);

        return new ResponseEntity<>(deleteParkingSpace, HttpStatus.OK);
    }
}
