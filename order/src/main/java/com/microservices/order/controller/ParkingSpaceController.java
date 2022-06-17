package com.microservices.order.controller;

import com.microservices.order.dto.request.ParkingSpaceRequestDTO;
import com.microservices.order.dto.request.UpdateParkingSpaceDTO;
import com.microservices.order.dto.response.ParkingSpaceResponseDTO;
import com.microservices.order.entity.ParkingSpace;
import com.microservices.order.mapper.request.ParkingSpaceRequestDTOToParkingSpaceMapper;
import com.microservices.order.mapper.request.UpdateParkingSpaceDTOToParkingSpaceMapper;
import com.microservices.order.mapper.response.ParkingSpaceToParkingSpaceResponseDTOMapper;
import com.microservices.order.service.ParkingSpaceService;
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
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/spaces")
public class ParkingSpaceController {

    private final ParkingSpaceService parkingSpaceService;
    private final ParkingSpaceRequestDTOToParkingSpaceMapper parkingSpaceRequestDTOToParkingSpaceMapper;
    private final ParkingSpaceToParkingSpaceResponseDTOMapper parkingSpaceToParkingSpaceResponseDTOMapper;
    private final UpdateParkingSpaceDTOToParkingSpaceMapper updateParkingSpaceDTOToParkingSpaceMapper;

    @GetMapping
    public ResponseEntity<List<ParkingSpaceResponseDTO>> getAllParkingSpaces(Pageable pageable) {
        List<ParkingSpaceResponseDTO> spaces = parkingSpaceService.getAllParkingSpaces(pageable).stream()
                .map(parkingSpaceToParkingSpaceResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(spaces, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<List<ParkingSpaceResponseDTO>> getAllParkingSpaceByOrderId(@PathVariable(name = "id") Long id, Pageable pageable) {
        List<ParkingSpaceResponseDTO> spaces = parkingSpaceService.getAllParkingSpaceByOrderId(id, pageable).stream()
                .map(parkingSpaceToParkingSpaceResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(spaces, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpaceResponseDTO> getParkingSpaceById(@PathVariable(name = "id") Long id) {
        ParkingSpace parkingSpace = parkingSpaceService.getParkingSpaceById(id);
        ParkingSpaceResponseDTO parkingSpaceResponseDTO = parkingSpaceToParkingSpaceResponseDTOMapper.convert(parkingSpace);

        return new ResponseEntity<>(parkingSpaceResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ParkingSpaceResponseDTO> createParkingSpace(@RequestBody @Valid ParkingSpaceRequestDTO parkingSpaceRequestDTO) {
        ParkingSpace parkingSpace = parkingSpaceRequestDTOToParkingSpaceMapper.convert(parkingSpaceRequestDTO);
        ParkingSpace createdParkingSpace = parkingSpaceService.createParkingSpace(parkingSpace);
        ParkingSpaceResponseDTO addParkingSpace = parkingSpaceToParkingSpaceResponseDTOMapper.convert(createdParkingSpace);

        return new ResponseEntity<>(addParkingSpace, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ParkingSpaceResponseDTO> updateParkingSpace(@RequestBody @Valid UpdateParkingSpaceDTO updateParkingSpaceDTO) {
        ParkingSpace parkingSpace = updateParkingSpaceDTOToParkingSpaceMapper.convert(updateParkingSpaceDTO);
        ParkingSpace updateParkingSpace = parkingSpaceService.updateParkingSpace(parkingSpace);
        ParkingSpaceResponseDTO updatedParkingSpace = parkingSpaceToParkingSpaceResponseDTOMapper.convert(updateParkingSpace);

        return new ResponseEntity<>(updatedParkingSpace, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteParkingSpace(@PathVariable(name = "id") Long id) {
        boolean deleteParkingSpace = parkingSpaceService.deleteParkingSpace(id);

        return new ResponseEntity<>(deleteParkingSpace, HttpStatus.OK);
    }
}
