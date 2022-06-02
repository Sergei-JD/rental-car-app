package com.microservices.account.mapper;

import com.microservices.account.dto.AccountRequestDTO;
import com.microservices.account.entity.Account;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface AccountRequestDTOToAccountMapper extends Converter<AccountRequestDTO, Account> {

    @Override
    Account convert(@NonNull AccountRequestDTO source);
}
