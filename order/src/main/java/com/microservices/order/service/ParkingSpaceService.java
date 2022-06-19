package com.microservices.order.service;

import com.microservices.order.dto.create.ParkingSpaceCreateDTO;
import com.microservices.order.dto.update.ParkingSpaceUpdateDTO;
import com.microservices.order.dto.view.ParkingSpaceViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ParkingSpaceService {

    Page<ParkingSpaceViewDTO> getAllParkingSpaces(Pageable pageable);

    Page<ParkingSpaceViewDTO> getAllParkingSpaceByOrderId(Long orderId, Pageable pageable);

    ParkingSpaceViewDTO getParkingSpaceById(Long parkingSpaceId);

    ParkingSpaceCreateDTO createParkingSpace(ParkingSpaceCreateDTO parkingSpaceCreateDTO);

    ParkingSpaceUpdateDTO updateParkingSpace(Long parkingSpaceId, ParkingSpaceUpdateDTO parkingSpaceUpdateDTO);

    boolean deleteParkingSpace(Long parkingSpaceId);
}
