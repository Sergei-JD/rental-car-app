package com.microservices.account.mapper.request;

import com.microservices.account.dto.request.AccountUpdateRequestDTO;
import com.microservices.account.entity.Account;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface AccountUpdateRequestDTOToAccountMapper extends Converter<AccountUpdateRequestDTO, Account> {

    @Override
    Account convert(@NonNull AccountUpdateRequestDTO source);
}
