package com.microservices.order.mapper.request;

import com.microservices.order.dto.request.UpdateParkingSpaceDTO;
import com.microservices.order.entity.ParkingSpace;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface UpdateParkingSpaceDTOToParkingSpaceMapper extends Converter<UpdateParkingSpaceDTO, ParkingSpace> {

    @Override
    ParkingSpace convert(@NonNull UpdateParkingSpaceDTO source);
}
