package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.create.CreditCardCreateDTO;
import com.microservices.account.dto.update.CreditCardUpdateDTO;
import com.microservices.account.dto.view.CreditCardViewDTO;
import com.microservices.account.entity.CreditCard;
import com.microservices.account.mapper.CreditCardMapper;
import com.microservices.account.repository.CreditCardRepository;
import com.microservices.account.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.microservices.account.util.ServiceData.CREDIT_CARD_ID_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;

    @Override
    public Page<CreditCardViewDTO> getAllCreditCards(Pageable pageable) {
        Page<CreditCard> pageCreditCards = creditCardRepository.findAll(pageable);

        List<CreditCardViewDTO> creditCards = pageCreditCards.stream()
                .map(CreditCardMapper::toCreditCardViewDTO)
                .toList();

        return new PageImpl<>(creditCards);
    }

    @Override
    public Page<CreditCardViewDTO> getAllCreditCardsByAccountId(Long accountId, Pageable pageable) {
        Page<CreditCard> pageCreditCards = creditCardRepository.findCreditCardByAccountId(accountId, pageable);

        List<CreditCardViewDTO> creditCards = pageCreditCards.stream()
                .map(CreditCardMapper::toCreditCardViewDTO)
                .toList();

        return new PageImpl<>(creditCards);
    }

    @Override
    public CreditCardViewDTO getCreditCardById(Long creditCardId) {
        CreditCard creditCard = creditCardRepository.findById(creditCardId)
                .orElseThrow(() -> new ServiceException(String.format(CREDIT_CARD_ID_EXCEPTION_MESSAGE, creditCardId)));

        return CreditCardMapper.toCreditCardViewDTO(creditCard);
    }

    @Override
    @Transactional
    public CreditCardCreateDTO createCreditCard(CreditCardCreateDTO creditCardCreateDTO) {
        CreditCard newCreditCard = CreditCard.builder()
                .creditCardType(creditCardCreateDTO.getCreditCardType())
                .cardNumber(creditCardCreateDTO.getCardNumber())
                .dateOfIssue(creditCardCreateDTO.getDateOfIssue())
                .expirationDate(creditCardCreateDTO.getExpirationDate())
                .cvvCode(creditCardCreateDTO.getCvvCode())
                .nameCardOwner(creditCardCreateDTO.getNameCardOwner())
                .balance(creditCardCreateDTO.getBalance())
                .build();

        return CreditCardMapper.toCreditCardCreateDTO(creditCardRepository.save(newCreditCard));
    }

    @Override
    @Transactional
    public CreditCardUpdateDTO updateCreditCard(Long creditCardId, CreditCardUpdateDTO creditCardUpdateDTO) {
        CreditCard creditCard = creditCardRepository.findById(creditCardId)
                .orElseThrow(() -> new ServiceException(String.format(CREDIT_CARD_ID_EXCEPTION_MESSAGE, creditCardId)));
        creditCard.setCreditCardType(creditCardUpdateDTO.getCreditCardType());
        creditCard.setCardNumber(creditCardUpdateDTO.getCardNumber());
        creditCard.setDateOfIssue(creditCardUpdateDTO.getDateOfIssue());
        creditCard.setExpirationDate(creditCardUpdateDTO.getExpirationDate());
        creditCard.setCvvCode(creditCardUpdateDTO.getCvvCode());
        creditCard.setNameCardOwner(creditCardUpdateDTO.getNameCardOwner());
        creditCard.setBalance(creditCardUpdateDTO.getBalance());

        creditCardRepository.save(creditCard);

        return CreditCardMapper.toCreditCardUpdateDTO(creditCard);
    }

    @Override
    @Transactional
    public boolean deleteCreditCard(Long creditCardId) {
        creditCardRepository.deleteById(creditCardId);

        return creditCardRepository.findById(creditCardId).isEmpty();
    }
}
