package com.microservices.order.mapper.request;

import com.microservices.order.dto.request.ParkingSpaceUpdateRequestDTO;
import com.microservices.order.entity.ParkingSpace;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ParkingSpaceUpdateRequestDTOToParkingSpaceMapper extends Converter<ParkingSpaceUpdateRequestDTO, ParkingSpace> {

    @Override
    ParkingSpace convert(@NonNull ParkingSpaceUpdateRequestDTO source);
}
