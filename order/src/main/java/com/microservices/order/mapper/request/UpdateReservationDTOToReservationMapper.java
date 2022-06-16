package com.microservices.order.mapper.request;

import com.microservices.order.dto.request.UpdateReservationDTO;
import com.microservices.order.entity.Reservation;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface UpdateReservationDTOToReservationMapper extends Converter<UpdateReservationDTO, Reservation> {

    @Override
    Reservation convert(@NonNull UpdateReservationDTO source);
}
