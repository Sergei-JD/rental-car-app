package com.microservices.account.mapper.request;

import com.microservices.account.dto.request.DriverLicenseUpdateRequestDTO;
import com.microservices.account.entity.DriverLicense;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface DriverLicenseUpdateRequestDTOToDriverLicenseMapper extends Converter<DriverLicenseUpdateRequestDTO, DriverLicense> {

    @Override
    DriverLicense convert(@NonNull DriverLicenseUpdateRequestDTO source);
}
