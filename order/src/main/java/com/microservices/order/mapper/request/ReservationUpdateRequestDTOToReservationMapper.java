package com.microservices.order.mapper.request;

import com.microservices.order.dto.request.ReservationUpdateRequestDTO;
import com.microservices.order.entity.Reservation;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ReservationUpdateRequestDTOToReservationMapper extends Converter<ReservationUpdateRequestDTO, Reservation> {

    @Override
    Reservation convert(@NonNull ReservationUpdateRequestDTO source);
}
