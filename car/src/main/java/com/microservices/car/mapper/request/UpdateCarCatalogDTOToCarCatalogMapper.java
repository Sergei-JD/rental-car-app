package com.microservices.car.mapper.request;

import com.microservices.car.dto.request.UpdateCarCatalogDTO;
import com.microservices.car.entity.CarCatalog;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface UpdateCarCatalogDTOToCarCatalogMapper extends Converter<UpdateCarCatalogDTO, CarCatalog> {

    @Override
    CarCatalog convert(@NonNull UpdateCarCatalogDTO source);
}
