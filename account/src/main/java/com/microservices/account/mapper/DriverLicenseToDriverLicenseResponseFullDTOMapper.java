package com.microservices.account.mapper;

import com.microservices.account.dto.DriverLicenseResponseFullDTO;
import com.microservices.account.entity.DriverLicense;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface DriverLicenseToDriverLicenseResponseFullDTOMapper extends Converter<DriverLicense, DriverLicenseResponseFullDTO> {

    @Override
    DriverLicenseResponseFullDTO convert(@NonNull DriverLicense driverLicense);
}