package com.microservices.account.mapper.request;

import com.microservices.account.entity.DriverLicense;
import com.microservices.account.dto.request.DriverLicenseRequestDTO;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface DriverLicenseRequestDTOToDriverLicenseMapper extends Converter<DriverLicenseRequestDTO, DriverLicense> {

    @Override
    DriverLicense convert(@NonNull DriverLicenseRequestDTO source);
}