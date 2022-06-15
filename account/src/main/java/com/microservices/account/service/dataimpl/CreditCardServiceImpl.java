package com.microservices.account.service.dataimpl;

import com.microservices.account.entity.CreditCard;
import com.microservices.account.repository.CreditCardRepository;
import com.microservices.account.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;

    @Override
    public Page<CreditCard> getAllCreditCards(Pageable pageable) {
        return creditCardRepository.findAll(pageable);
    }

    @Override
    public Page<CreditCard> getAllCreditCardsByAccountId(Long accountId, Pageable pageable) {
        return creditCardRepository.findCreditCardByAccountId(accountId, pageable);
    }

    @Override
    public Optional<CreditCard> getCreditCardById(Long creditCardId) {
        return creditCardRepository.findById(creditCardId);
    }

    @Override
    @Transactional
    public CreditCard createCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    @Transactional
    public CreditCard updateCreditCard(CreditCard creditCard) {
        CreditCard maybeCreditCard = creditCardRepository.findById(creditCard.getId())
                .orElseThrow(() -> new ServiceException("Failed to update СreditCard no such CreditCard"));
        return creditCardRepository.save(maybeCreditCard);
    }

    @Override
    @Transactional
    public boolean deleteCreditCard(Long creditCardId) {
        Optional<CreditCard> maybeCreditCard = creditCardRepository.findById(creditCardId);
        maybeCreditCard.ifPresent(creditCard -> creditCardRepository.deleteById(creditCard.getId()));

        return maybeCreditCard.isPresent();
    }
}
