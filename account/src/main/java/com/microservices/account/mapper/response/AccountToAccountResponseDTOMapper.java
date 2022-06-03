package com.microservices.account.mapper.response;

import com.microservices.account.entity.Account;
import com.microservices.account.dto.response.AccountResponseDTO;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface AccountToAccountResponseDTOMapper extends Converter<Account, AccountResponseDTO> {

    @Override
    AccountResponseDTO convert(@NonNull Account account);
}