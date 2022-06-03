package com.microservices.account.mapper.request;

import com.microservices.account.entity.CreditCard;
import com.microservices.account.dto.request.CreditCardRequestDTO;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CreditCardRequestDTOToCreditCardMapper extends Converter<CreditCardRequestDTO, CreditCard> {

    @Override
    CreditCard convert(@NonNull CreditCardRequestDTO source);
}