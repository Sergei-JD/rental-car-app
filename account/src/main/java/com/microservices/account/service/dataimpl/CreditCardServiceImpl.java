package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.request.CreditCardRequestDTO;
import com.microservices.account.dto.response.CreditCardResponseDTO;
import com.microservices.account.entity.CreditCard;
import com.microservices.account.mapper.request.CreditCardRequestDTOToCreditCardMapper;
import com.microservices.account.mapper.response.CreditCardToCreditCardResponseDTOMapper;
import com.microservices.account.repository.CreditCardRepository;
import com.microservices.account.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final CreditCardRequestDTOToCreditCardMapper creditCardRequestDTOToCreditCardMapper;
    private final CreditCardToCreditCardResponseDTOMapper creditCardToCreditCardResponseDTOMapper;

    @Override
    public Page<CreditCardResponseDTO> getAllCreditCards(Pageable pageable) {
        Page<CreditCard> pageCreditCards = creditCardRepository.findAll(pageable);

        List<CreditCardResponseDTO> creditCards = pageCreditCards.stream()
                .map(creditCardToCreditCardResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(creditCards);
    }

    @Override
    public Optional<CreditCardResponseDTO> getAllCreditCardsByAccountId(Long accountId) {
        CreditCardResponseDTO creditCardResponseDTO = null;

        Optional<CreditCard> creditCard = creditCardRepository.findCreditCardByAccountId(accountId);
        if (creditCard.isPresent()) {
            creditCardResponseDTO = creditCardToCreditCardResponseDTOMapper.convert(creditCard.get());
        }

        return Optional.ofNullable(creditCardResponseDTO);
    }

    @Override
    public Optional<CreditCardResponseDTO> getCreditCardById(long creditCardId) {
        CreditCardResponseDTO creditCardResponseDTO = null;

        Optional<CreditCard> creditCard = creditCardRepository.findById(creditCardId);
        if (creditCard.isPresent()) {
            creditCardResponseDTO = creditCardToCreditCardResponseDTOMapper.convert(creditCard.get());
        }

        return Optional.ofNullable(creditCardResponseDTO);
    }

    @Override
    @Transactional
    public CreditCardResponseDTO createCreditCard(CreditCardRequestDTO creditCardRequestDTO) {
        CreditCard newCreditCard = creditCardRequestDTOToCreditCardMapper.convert(creditCardRequestDTO);

        return creditCardToCreditCardResponseDTOMapper.convert(creditCardRepository.save(newCreditCard));
    }

    @Override
    @Transactional
    public CreditCardResponseDTO updateCreditCard(Long creditCardId, CreditCardRequestDTO creditCardRequestDTO) {
        CreditCard creditCard = creditCardRequestDTOToCreditCardMapper.convert(creditCardRequestDTO);
        creditCard.setCreditCardId(creditCardId);

        return creditCardToCreditCardResponseDTOMapper.convert(creditCardRepository.save(creditCard));
    }

    @Override
    @Transactional
    public boolean deleteCreditCard(long creditCardId) {
        creditCardRepository.deleteById(creditCardId);

        return creditCardRepository.findById(creditCardId).isEmpty();
    }
}
