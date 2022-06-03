package com.microservices.car.mapper;

import com.microservices.car.dto.CarCatalogResponseFullDTO;
import com.microservices.car.entity.CarCatalog;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CarCatalogToCarCatalogResponseFullDTOMapper extends Converter<CarCatalog, CarCatalogResponseFullDTO> {

    @Override
    CarCatalogResponseFullDTO convert(@NonNull CarCatalog carCatalog);
}
