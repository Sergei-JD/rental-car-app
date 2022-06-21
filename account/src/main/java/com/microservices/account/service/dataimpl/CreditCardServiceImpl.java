package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.create.CreateCreditCardDTO;
import com.microservices.account.dto.update.UpdateCreditCardDTO;
import com.microservices.account.dto.view.ViewCreditCardDTO;
import com.microservices.account.entity.Account;
import com.microservices.account.entity.CreditCard;
import com.microservices.account.mapper.CreditCardMapper;
import com.microservices.account.repository.CreditCardRepository;
import com.microservices.account.service.AccountService;
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
    private final AccountService accountService;

    @Override
    public Page<ViewCreditCardDTO> getAllCreditCards(Pageable pageable) {
        Page<CreditCard> pageCreditCards = creditCardRepository.findAll(pageable);

        List<ViewCreditCardDTO> creditCards = pageCreditCards.stream()
                .map(CreditCardMapper::toViewCreditCardDTO)
                .toList();

        return new PageImpl<>(creditCards);
    }

    @Override
    public Page<ViewCreditCardDTO> getAllCreditCardsByAccountId(Long accountId, Pageable pageable) {
        Page<CreditCard> pageCreditCards = creditCardRepository.findCreditCardByAccountId(accountId, pageable);

        List<ViewCreditCardDTO> creditCards = pageCreditCards.stream()
                .map(CreditCardMapper::toViewCreditCardDTO)
                .toList();

        return new PageImpl<>(creditCards);
    }

    @Override
    public CreditCard getCreditCardById(Long creditCardId) {
        return creditCardRepository.findById(creditCardId)
                .orElseThrow(() -> new ServiceException(String.format(CREDIT_CARD_ID_EXCEPTION_MESSAGE, creditCardId)));
    }

    @Override
    @Transactional
    public Long createCreditCard(CreateCreditCardDTO createCreditCardDTO) {
        Account account = accountService.getAccountById(createCreditCardDTO.getAccountId());
        CreditCard newCreditCard = CreditCard.builder()
                .creditCardType(createCreditCardDTO.getCreditCardType())
                .cardNumber(createCreditCardDTO.getCardNumber())
                .dateOfIssue(createCreditCardDTO.getDateOfIssue())
                .expirationDate(createCreditCardDTO.getExpirationDate())
                .cvvCode(createCreditCardDTO.getCvvCode())
                .nameCardOwner(createCreditCardDTO.getNameCardOwner())
                .balance(createCreditCardDTO.getBalance())
                .account(account)
                .build();

        CreditCard savedCreditCard = creditCardRepository.save(newCreditCard);

        return savedCreditCard.getId();
    }

    @Override
    @Transactional
    public void updateCreditCard(Long creditCardId, UpdateCreditCardDTO updateCreditCardDTO) {
        CreditCard creditCard = creditCardRepository.findById(creditCardId)
                .orElseThrow(() -> new ServiceException(String.format(CREDIT_CARD_ID_EXCEPTION_MESSAGE, creditCardId)));
        creditCard.setCreditCardType(updateCreditCardDTO.getCreditCardType());
        creditCard.setCardNumber(updateCreditCardDTO.getCardNumber());
        creditCard.setDateOfIssue(updateCreditCardDTO.getDateOfIssue());
        creditCard.setExpirationDate(updateCreditCardDTO.getExpirationDate());
        creditCard.setCvvCode(updateCreditCardDTO.getCvvCode());
        creditCard.setNameCardOwner(updateCreditCardDTO.getNameCardOwner());
        creditCard.setBalance(updateCreditCardDTO.getBalance());

        creditCardRepository.save(creditCard);
    }

    @Override
    @Transactional
    public boolean deleteCreditCard(Long creditCardId) {
        creditCardRepository.deleteById(creditCardId);

        return creditCardRepository.findById(creditCardId).isEmpty();
    }
}
