package com.microservices.account.mapper.request;

import com.microservices.account.dto.request.CreditCardUpdateRequestDTO;
import com.microservices.account.entity.CreditCard;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CreditCardUpdateRequestDTOToCreditCardMapper extends Converter<CreditCardUpdateRequestDTO, CreditCard> {

    @Override
    CreditCard convert(@NonNull CreditCardUpdateRequestDTO source);
}