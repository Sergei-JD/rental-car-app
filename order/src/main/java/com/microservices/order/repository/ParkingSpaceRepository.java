package com.microservices.order.repository;

import com.microservices.order.entity.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {

    Optional<ParkingSpace> findParkingSpaceByOrderId(Long orderId);
}
