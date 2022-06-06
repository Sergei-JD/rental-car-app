package com.microservices.order.repository;

import com.microservices.order.entity.ParkingSpace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {

    Page<ParkingSpace> findParkingSpaceByOrderId(Long orderId, Pageable pageable);
}
