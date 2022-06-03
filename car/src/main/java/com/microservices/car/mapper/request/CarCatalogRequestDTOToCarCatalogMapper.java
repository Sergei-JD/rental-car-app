package com.microservices.car.mapper.request;

import com.microservices.car.entity.CarCatalog;
import com.microservices.car.dto.request.CarCatalogRequestDTO;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CarCatalogRequestDTOToCarCatalogMapper extends Converter<CarCatalogRequestDTO, CarCatalog> {

    @Override
    CarCatalog convert(@NonNull CarCatalogRequestDTO source);
}
