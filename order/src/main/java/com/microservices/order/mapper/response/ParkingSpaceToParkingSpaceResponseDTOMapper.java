package com.microservices.order.mapper.response;

import com.microservices.order.entity.ParkingSpace;
import com.microservices.order.dto.response.ParkingSpaceResponseDTO;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ParkingSpaceToParkingSpaceResponseDTOMapper extends Converter<ParkingSpace, ParkingSpaceResponseDTO> {

    @Override
    ParkingSpaceResponseDTO convert(@NonNull ParkingSpace parkingSpace);
}
