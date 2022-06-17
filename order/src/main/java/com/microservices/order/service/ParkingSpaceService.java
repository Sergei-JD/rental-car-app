package com.microservices.order.service;

import com.microservices.order.entity.ParkingSpace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ParkingSpaceService {

    Page<ParkingSpace> getAllParkingSpaces(Pageable pageable);

    Page<ParkingSpace> getAllParkingSpaceByOrderId(Long orderId, Pageable pageable);

    ParkingSpace getParkingSpaceById(long parkingSpaceId);

    ParkingSpace createParkingSpace(ParkingSpace parkingSpace);

    ParkingSpace updateParkingSpace(ParkingSpace parkingSpace);

    boolean deleteParkingSpace(long parkingSpaceId);
}
