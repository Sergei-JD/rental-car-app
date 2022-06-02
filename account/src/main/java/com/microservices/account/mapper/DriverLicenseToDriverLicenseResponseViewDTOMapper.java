package com.microservices.account.mapper;

import com.microservices.account.dto.DriverLicenseResponseViewDTO;
import com.microservices.account.entity.DriverLicense;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface DriverLicenseToDriverLicenseResponseViewDTOMapper extends Converter<DriverLicense, DriverLicenseResponseViewDTO> {

    @Override
    DriverLicenseResponseViewDTO convert(@NonNull DriverLicense driverLicense);
}
