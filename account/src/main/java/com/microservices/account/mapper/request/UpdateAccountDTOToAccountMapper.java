package com.microservices.account.mapper.request;

import com.microservices.account.dto.request.UpdateAccountDTO;
import com.microservices.account.entity.Account;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface UpdateAccountDTOToAccountMapper extends Converter<UpdateAccountDTO, Account> {

    @Override
    Account convert(@NonNull UpdateAccountDTO source);
}
