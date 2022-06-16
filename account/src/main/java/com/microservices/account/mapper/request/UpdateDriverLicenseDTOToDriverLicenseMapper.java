package com.microservices.account.mapper.request;

import com.microservices.account.dto.request.UpdateDriverLicenseDTO;
import com.microservices.account.entity.DriverLicense;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface UpdateDriverLicenseDTOToDriverLicenseMapper extends Converter<UpdateDriverLicenseDTO, DriverLicense> {

    @Override
    DriverLicense convert(@NonNull UpdateDriverLicenseDTO source);
}
