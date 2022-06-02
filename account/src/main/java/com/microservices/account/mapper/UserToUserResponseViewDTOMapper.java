package com.microservices.account.mapper;

import com.microservices.account.dto.UserResponseViewDTO;
import com.microservices.account.entity.User;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface UserToUserResponseViewDTOMapper extends Converter<User, UserResponseViewDTO> {

    @Override
    UserResponseViewDTO convert(@NonNull User user);
}