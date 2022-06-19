package com.microservices.order.mapper;

import com.microservices.order.dto.create.ParkingSpaceCreateDTO;
import com.microservices.order.dto.update.ParkingSpaceUpdateDTO;
import com.microservices.order.dto.view.ParkingSpaceViewDTO;
import com.microservices.order.entity.ParkingSpace;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ParkingSpaceMapper {

    public static ParkingSpaceViewDTO toParkingSpaceViewDTO(ParkingSpace parkingSpace) {
        return Optional.ofNullable(parkingSpace)
                .map(existParkingSpace -> ParkingSpaceViewDTO.builder()
                        .id(parkingSpace.getId())
                        .address(parkingSpace.getAddress())
                        .level(parkingSpace.getLevel())
                        .numberSpace(parkingSpace.getNumberSpace())
                        .build())
                .orElse(null);
    }

    public static ParkingSpaceCreateDTO toParkingSpaceCreateDTO(ParkingSpace parkingSpace) {
        return Optional.ofNullable(parkingSpace)
                .map(existParkingSpace -> ParkingSpaceCreateDTO.builder()
                        .address(parkingSpace.getAddress())
                        .level(parkingSpace.getLevel())
                        .numberSpace(parkingSpace.getNumberSpace())
                        .build())
                .orElse(null);
    }

    public static ParkingSpaceUpdateDTO toParkingSpaceUpdateDTO(ParkingSpace parkingSpace) {
        return Optional.ofNullable(parkingSpace)
                .map(existParkingSpace -> ParkingSpaceUpdateDTO.builder()
                        .address(parkingSpace.getAddress())
                        .level(parkingSpace.getLevel())
                        .numberSpace(parkingSpace.getNumberSpace())
                        .build())
                .orElse(null);
    }
}
