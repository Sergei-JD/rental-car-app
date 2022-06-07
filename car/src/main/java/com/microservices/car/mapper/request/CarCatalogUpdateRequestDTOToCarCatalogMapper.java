package com.microservices.car.mapper.request;

import com.microservices.car.dto.request.CarCatalogUpdateRequestDTO;
import com.microservices.car.entity.CarCatalog;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CarCatalogUpdateRequestDTOToCarCatalogMapper extends Converter<CarCatalogUpdateRequestDTO, CarCatalog> {

    @Override
    CarCatalog convert(@NonNull CarCatalogUpdateRequestDTO source);
}
