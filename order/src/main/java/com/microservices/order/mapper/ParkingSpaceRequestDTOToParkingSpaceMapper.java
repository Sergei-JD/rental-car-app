package com.microservices.order.mapper;

import com.microservices.order.dto.ParkingSpaceRequestDTO;
import com.microservices.order.entity.ParkingSpace;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ParkingSpaceRequestDTOToParkingSpaceMapper extends Converter<ParkingSpaceRequestDTO, ParkingSpace> {

    @Override
    ParkingSpace convert(@NonNull ParkingSpaceRequestDTO source);
}
