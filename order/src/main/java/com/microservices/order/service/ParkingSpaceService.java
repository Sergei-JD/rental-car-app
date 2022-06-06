package com.microservices.order.service;

import com.microservices.order.dto.request.ParkingSpaceRequestDTO;
import com.microservices.order.dto.request.ParkingSpaceUpdateRequestDTO;
import com.microservices.order.dto.response.ParkingSpaceResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ParkingSpaceService {

    Page<ParkingSpaceResponseDTO> getAllParkingSpaces(Pageable pageable);

    Page<ParkingSpaceResponseDTO> getAllParkingSpaceByOrderId(Long orderId, Pageable pageable);

    Optional<ParkingSpaceResponseDTO> getParkingSpaceById(long parkingSpaceId);

    ParkingSpaceResponseDTO createParkingSpace(ParkingSpaceRequestDTO parkingSpaceRequestDTO);

    ParkingSpaceResponseDTO updateParkingSpace(ParkingSpaceUpdateRequestDTO parkingSpaceUpdateRequestDTO);

    boolean deleteParkingSpace(long parkingSpaceId);
}
