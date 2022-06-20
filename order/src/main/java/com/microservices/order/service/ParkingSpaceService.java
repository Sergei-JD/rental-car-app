package com.microservices.order.service;

import com.microservices.order.dto.create.CreateParkingSpaceDTO;
import com.microservices.order.dto.update.UpdateParkingSpaceDTO;
import com.microservices.order.dto.view.ViewParkingSpaceDTO;
import com.microservices.order.entity.ParkingSpace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ParkingSpaceService {

    Page<ViewParkingSpaceDTO> getAllParkingSpaces(Pageable pageable);

    Page<ViewParkingSpaceDTO> getAllParkingSpaceByOrderId(Long orderId, Pageable pageable);

    ParkingSpace getParkingSpaceById(Long parkingSpaceId);

    Long createParkingSpace(CreateParkingSpaceDTO createParkingSpaceDTO);

    void updateParkingSpace(Long parkingSpaceId, UpdateParkingSpaceDTO updateParkingSpaceDTO);

    boolean deleteParkingSpace(Long parkingSpaceId);
}
