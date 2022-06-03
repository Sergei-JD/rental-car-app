package com.microservices.order.service;

import com.microservices.order.dto.request.ParkingSpaceRequestDTO;
import com.microservices.order.dto.response.ParkingSpaceResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ParkingSpaceService {

    Page<ParkingSpaceResponseDTO> getAllParkingSpaces(Pageable pageable);

    List<ParkingSpaceResponseDTO> getAllParkingSpaceByOrderId(Long orderId);

    Optional<ParkingSpaceResponseDTO> getParkingSpaceById(long parkingSpaceId);

    ParkingSpaceRequestDTO createParkingSpace(ParkingSpaceRequestDTO parkingSpaceRequestDTO);

    ParkingSpaceResponseDTO updateParkingSpace(ParkingSpaceResponseDTO parkingSpaceResponseDTO);

    boolean deleteParkingSpace(long parkingSpaceId);
}
