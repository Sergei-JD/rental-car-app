package com.microservices.account.mapper;

import com.microservices.account.dto.CreditCardRequestDTO;
import com.microservices.account.entity.CreditCard;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CreditCardRequestDTOToCreditCardMapper extends Converter<CreditCardRequestDTO, CreditCard> {

    @Override
    CreditCard convert(@NonNull CreditCardRequestDTO source);
}