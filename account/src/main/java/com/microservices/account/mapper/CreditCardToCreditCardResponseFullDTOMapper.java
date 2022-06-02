package com.microservices.account.mapper;

import com.microservices.account.dto.CreditCardResponseFullDTO;
import com.microservices.account.entity.CreditCard;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CreditCardToCreditCardResponseFullDTOMapper extends Converter<CreditCard, CreditCardResponseFullDTO> {

    @Override
    CreditCardResponseFullDTO convert(@NonNull CreditCard creditCard);
}