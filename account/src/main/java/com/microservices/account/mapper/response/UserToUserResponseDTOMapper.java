package com.microservices.account.mapper.response;

import com.microservices.account.dto.response.UserResponseDTO;
import com.microservices.account.entity.User;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface UserToUserResponseDTOMapper extends Converter<User, UserResponseDTO> {

    @Override
    UserResponseDTO convert(@NonNull User user);
}
