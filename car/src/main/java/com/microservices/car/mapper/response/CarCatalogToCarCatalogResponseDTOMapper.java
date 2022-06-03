package com.microservices.car.mapper.response;

import com.microservices.car.entity.CarCatalog;
import com.microservices.car.dto.response.CarCatalogResponseDTO;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CarCatalogToCarCatalogResponseDTOMapper extends Converter<CarCatalog, CarCatalogResponseDTO> {

    @Override
    CarCatalogResponseDTO convert(@NonNull CarCatalog carCatalog);
}
