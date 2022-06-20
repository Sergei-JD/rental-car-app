package com.microservices.order.mapper;

import com.microservices.order.dto.create.CreateParkingSpaceDTO;
import com.microservices.order.dto.update.UpdateParkingSpaceDTO;
import com.microservices.order.dto.view.ViewParkingSpaceDTO;
import com.microservices.order.entity.ParkingSpace;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ParkingSpaceMapper {

    public static ViewParkingSpaceDTO toViewParkingSpaceDTO(ParkingSpace parkingSpace) {
        return Optional.ofNullable(parkingSpace)
                .map(existParkingSpace -> ViewParkingSpaceDTO.builder()
                        .id(parkingSpace.getId())
                        .address(parkingSpace.getAddress())
                        .level(parkingSpace.getLevel())
                        .numberSpace(parkingSpace.getNumberSpace())
                        .build())
                .orElse(null);
    }

    public static CreateParkingSpaceDTO toCreateParkingSpaceDTO(ParkingSpace parkingSpace) {
        return Optional.ofNullable(parkingSpace)
                .map(existParkingSpace -> CreateParkingSpaceDTO.builder()
                        .address(parkingSpace.getAddress())
                        .level(parkingSpace.getLevel())
                        .numberSpace(parkingSpace.getNumberSpace())
                        .build())
                .orElse(null);
    }

    public static UpdateParkingSpaceDTO toUpdateParkingSpaceDTO(ParkingSpace parkingSpace) {
        return Optional.ofNullable(parkingSpace)
                .map(existParkingSpace -> UpdateParkingSpaceDTO.builder()
                        .address(parkingSpace.getAddress())
                        .level(parkingSpace.getLevel())
                        .numberSpace(parkingSpace.getNumberSpace())
                        .build())
                .orElse(null);
    }
}
