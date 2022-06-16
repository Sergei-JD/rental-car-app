package com.microservices.account.mapper.request;

import com.microservices.account.dto.request.UpdateCreditCardDTO;
import com.microservices.account.entity.CreditCard;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface UpdateCreditCardDTOToCreditCardMapper extends Converter<UpdateCreditCardDTO, CreditCard> {

    @Override
    CreditCard convert(@NonNull UpdateCreditCardDTO source);
}