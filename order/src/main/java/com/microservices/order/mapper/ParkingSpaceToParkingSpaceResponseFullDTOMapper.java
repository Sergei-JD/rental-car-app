package com.microservices.order.mapper;

import com.microservices.order.dto.ParkingSpaceResponseFullDTO;
import com.microservices.order.entity.ParkingSpace;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ParkingSpaceToParkingSpaceResponseFullDTOMapper extends Converter<ParkingSpace, ParkingSpaceResponseFullDTO> {

    @Override
    ParkingSpaceResponseFullDTO convert(@NonNull ParkingSpace parkingSpace);
}
