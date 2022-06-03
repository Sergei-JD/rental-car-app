package com.microservices.order.mapper;

import com.microservices.order.dto.ReservationResponseFullDTO;
import com.microservices.order.entity.Reservation;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ReservationToReservationResponseFullDTOMapper extends Converter<Reservation, ReservationResponseFullDTO> {

    @Override
    ReservationResponseFullDTO convert(@NonNull Reservation reservation);
}
