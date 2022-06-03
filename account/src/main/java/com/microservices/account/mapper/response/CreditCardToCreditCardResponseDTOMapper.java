package com.microservices.account.mapper.response;

import com.microservices.account.entity.CreditCard;
import com.microservices.account.dto.response.CreditCardResponseDTO;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CreditCardToCreditCardResponseDTOMapper extends Converter<CreditCard, CreditCardResponseDTO> {

    @Override
    CreditCardResponseDTO convert(@NonNull CreditCard creditCard);
}