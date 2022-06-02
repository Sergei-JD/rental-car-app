package com.microservices.account.mapper;

import com.microservices.account.dto.AccountResponseFullDTO;
import com.microservices.account.entity.Account;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface AccountToAccountResponseFullDTOMapper extends Converter<Account, AccountResponseFullDTO> {

    @Override
    AccountResponseFullDTO convert(@NonNull Account account);
}