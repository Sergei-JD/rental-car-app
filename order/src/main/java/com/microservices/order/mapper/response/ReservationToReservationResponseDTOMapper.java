package com.microservices.order.mapper.response;

import com.microservices.order.entity.Reservation;
import com.microservices.order.dto.response.ReservationResponseDTO;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ReservationToReservationResponseDTOMapper extends Converter<Reservation, ReservationResponseDTO> {

    @Override
    ReservationResponseDTO convert(@NonNull Reservation reservation);
}
