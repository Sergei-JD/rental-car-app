package com.microservices.account.mapper;

import com.microservices.account.dto.UserRequestDTO;
import com.microservices.account.entity.User;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface UserRequestDTOToUserMapper extends Converter<UserRequestDTO, User> {

    @Override
    User convert(@NonNull UserRequestDTO source);
}