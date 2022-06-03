package com.microservices.order.mapper;

import com.microservices.order.dto.ReservationRequestDTO;
import com.microservices.order.entity.Reservation;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ReservationRequestDTOToReservationMapper extends Converter<ReservationRequestDTO, Reservation> {

    @Override
    Reservation convert(@NonNull ReservationRequestDTO source);
}
