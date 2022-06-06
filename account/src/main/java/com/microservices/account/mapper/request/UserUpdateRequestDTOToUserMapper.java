package com.microservices.account.mapper.request;

import com.microservices.account.dto.request.UserUpdateRequestDTO;
import com.microservices.account.entity.User;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface UserUpdateRequestDTOToUserMapper extends Converter<UserUpdateRequestDTO, User> {

    @Override
    User convert(@NonNull UserUpdateRequestDTO source);
}
