package com.microservices.order.service;

import com.microservices.order.dto.ParkingSpaceRequestDTO;
import com.microservices.order.dto.ParkingSpaceResponseFullDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ParkingSpaceService {

    Page<ParkingSpaceResponseFullDTO> getAllParkingSpaces(Pageable pageable);

    List<ParkingSpaceResponseFullDTO> getAllParkingSpaceByOrderId(Long orderId);

    Optional<ParkingSpaceResponseFullDTO> getParkingSpaceById(long parkingSpaceId);

    ParkingSpaceRequestDTO createParkingSpace(ParkingSpaceRequestDTO parkingSpaceRequestDTO);

    ParkingSpaceResponseFullDTO updateParkingSpace(ParkingSpaceResponseFullDTO parkingSpaceResponseFullDTO);

    boolean deleteParkingSpace(long parkingSpaceId);
}
