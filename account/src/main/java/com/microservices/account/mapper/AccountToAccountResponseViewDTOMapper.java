package com.microservices.account.mapper;

import com.microservices.account.dto.AccountResponseViewDTO;
import com.microservices.account.entity.Account;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface AccountToAccountResponseViewDTOMapper extends Converter<Account, AccountResponseViewDTO> {

    @Override
    AccountResponseViewDTO convert(@NonNull Account account);
}