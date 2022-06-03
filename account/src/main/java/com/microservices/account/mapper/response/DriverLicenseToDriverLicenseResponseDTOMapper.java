package com.microservices.account.mapper.response;

import com.microservices.account.entity.DriverLicense;
import com.microservices.account.dto.response.DriverLicenseResponseDTO;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface DriverLicenseToDriverLicenseResponseDTOMapper extends Converter<DriverLicense, DriverLicenseResponseDTO> {

    @Override
    DriverLicenseResponseDTO convert(@NonNull DriverLicense driverLicense);
}