package com.microservices.account.mapper;

import com.microservices.account.dto.CreditCardResponseViewDTO;
import com.microservices.account.entity.CreditCard;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CreditCardToCreditCardResponseViewDTOMapper extends Converter<CreditCard, CreditCardResponseViewDTO> {

    @Override
    CreditCardResponseViewDTO convert(@NonNull CreditCard creditCard);
}