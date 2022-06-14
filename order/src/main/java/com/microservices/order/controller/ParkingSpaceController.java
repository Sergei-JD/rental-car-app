package com.microservices.order.controller;

import com.microservices.order.dto.request.ParkingSpaceRequestDTO;
import com.microservices.order.dto.request.ParkingSpaceUpdateRequestDTO;
import com.microservices.order.dto.response.ParkingSpaceResponseDTO;
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
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/spaces")
public class ParkingSpaceController {

    private final ParkingSpaceService parkingSpaceService;

    @GetMapping
    public ResponseEntity<Page<ParkingSpaceResponseDTO>> getAllParkingSpaces(Pageable pageable) {
        Page<ParkingSpaceResponseDTO> parkingSpaces = parkingSpaceService.getAllParkingSpaces(pageable);
        return new ResponseEntity<>(parkingSpaces, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Page<ParkingSpaceResponseDTO>> getAllParkingSpaceByOrderId(@PathVariable(name = "id") Long id, Pageable pageable) {
        Page<ParkingSpaceResponseDTO> spaces = parkingSpaceService.getAllParkingSpaceByOrderId(id, pageable);
        return new ResponseEntity<>(spaces, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpaceResponseDTO> getParkingSpaceById(@PathVariable(name = "id") Long id) {
        Optional<ParkingSpaceResponseDTO> parkingSpaceResponseDTO = parkingSpaceService.getParkingSpaceById(id);
        return parkingSpaceResponseDTO.map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK))
                .orElseThrow(() -> new RuntimeException(
                        "ParkingSpace with this id: " + id + " does not exist")
                );
    }

    @PostMapping
    public ResponseEntity<ParkingSpaceResponseDTO> createParkingSpace(@RequestBody @Valid ParkingSpaceRequestDTO parkingSpaceRequestDTO) {
        ParkingSpaceResponseDTO addParkingSpace = parkingSpaceService.createParkingSpace(parkingSpaceRequestDTO);
        return new ResponseEntity<>(addParkingSpace, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ParkingSpaceResponseDTO> updateParkingSpace(@RequestBody @Valid ParkingSpaceUpdateRequestDTO parkingSpaceUpdateRequestDTO) {
        ParkingSpaceResponseDTO updatedParkingSpace = parkingSpaceService.updateParkingSpace(parkingSpaceUpdateRequestDTO);
        return new ResponseEntity<>(updatedParkingSpace, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteParkingSpace(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(parkingSpaceService.deleteParkingSpace(id), HttpStatus.OK);
    }
}
