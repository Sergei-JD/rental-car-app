package com.microservices.order.controller;

import com.microservices.order.dto.create.CreateParkingSpaceDTO;
import com.microservices.order.dto.update.UpdateParkingSpaceDTO;
import com.microservices.order.dto.view.ViewParkingSpaceDTO;
import com.microservices.order.entity.ParkingSpace;
import com.microservices.order.mapper.ParkingSpaceMapper;
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
    public ResponseEntity<Page<ViewParkingSpaceDTO>> getAllParkingSpaces(Pageable pageable) {
        Page<ViewParkingSpaceDTO> creditParkingSpaces = parkingSpaceService.getAllParkingSpaces(pageable);

        return new ResponseEntity<>(creditParkingSpaces, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Page<ViewParkingSpaceDTO>> getAllParkingSpaceByOrderId(
            @PathVariable(name = "id") Long id, Pageable pageable) {
        Page<ViewParkingSpaceDTO> parkingSpaces = parkingSpaceService.getAllParkingSpaceByOrderId(id, pageable);

        return new ResponseEntity<>(parkingSpaces, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewParkingSpaceDTO> getParkingSpaceById(
            @PathVariable(name = "id") Long id) {
        ParkingSpace parkingSpace = parkingSpaceService.getParkingSpaceById(id);
        ViewParkingSpaceDTO viewParkingSpaceDTO = ParkingSpaceMapper.toViewParkingSpaceDTO(parkingSpace);

        return new ResponseEntity<>(viewParkingSpaceDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createParkingSpace(
            @RequestBody @Valid CreateParkingSpaceDTO createParkingSpaceDTO) {
        Long addParkingSpace = parkingSpaceService.createParkingSpace(createParkingSpaceDTO);

        return new ResponseEntity<>(addParkingSpace, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateParkingSpace(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid UpdateParkingSpaceDTO updateParkingSpaceDTO) {
        parkingSpaceService.updateParkingSpace(id, updateParkingSpaceDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteParkingSpace(
            @PathVariable(name = "id") Long id) {
        boolean deleteParkingSpace = parkingSpaceService.deleteParkingSpace(id);

        return new ResponseEntity<>(deleteParkingSpace, HttpStatus.OK);
    }
}
