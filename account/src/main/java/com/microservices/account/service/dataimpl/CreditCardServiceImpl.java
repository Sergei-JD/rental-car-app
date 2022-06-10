package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.request.CreditCardRequestDTO;
import com.microservices.account.dto.request.CreditCardUpdateRequestDTO;
import com.microservices.account.dto.response.CreditCardResponseDTO;
import com.microservices.account.entity.CreditCard;
import com.microservices.account.entity.User;
import com.microservices.account.mapper.request.CreditCardRequestDTOToCreditCardMapper;
import com.microservices.account.mapper.request.CreditCardUpdateRequestDTOToCreditCardMapper;
import com.microservices.account.mapper.response.CreditCardToCreditCardResponseDTOMapper;
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
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final CreditCardRequestDTOToCreditCardMapper creditCardRequestDTOToCreditCardMapper;
    private final CreditCardToCreditCardResponseDTOMapper creditCardToCreditCardResponseDTOMapper;
    private final CreditCardUpdateRequestDTOToCreditCardMapper creditCardUpdateRequestDTOToCreditCardMapper;

    @Override
    public Page<CreditCardResponseDTO> getAllCreditCards(Pageable pageable) {
        Page<CreditCard> pageCreditCards = creditCardRepository.findAll(pageable);

        List<CreditCardResponseDTO> creditCards = pageCreditCards.stream()
                .map(creditCardToCreditCardResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(creditCards);
    }

    @Override
    public Page<CreditCardResponseDTO> getAllCreditCardsByAccountId(Long accountId, Pageable pageable) {
        Page<CreditCard> pageCreditCards = creditCardRepository.findCreditCardByAccountId(accountId, pageable);

        List<CreditCardResponseDTO> creditCards = pageCreditCards.stream()
                .map(creditCardToCreditCardResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(creditCards);
    }

    @Override
    public Optional<CreditCardResponseDTO> getCreditCardById(Long creditCardId) {
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
        CreditCard saveCreditCard = creditCardRepository.save(Objects.requireNonNull(newCreditCard));

        return creditCardToCreditCardResponseDTOMapper.convert(saveCreditCard);
    }

    @Override
    @Transactional
    public CreditCardResponseDTO updateCreditCard(CreditCardUpdateRequestDTO creditCardUpdateRequestDTO) {
        creditCardRepository.findById(creditCardUpdateRequestDTO.getId())
                .orElseThrow(() -> new ServiceException("Failed to update creditCard no such creditCard"));

        CreditCard creditCard = creditCardUpdateRequestDTOToCreditCardMapper.convert(creditCardUpdateRequestDTO);
        CreditCard updateCreditCard = creditCardRepository.save(Objects.requireNonNull(creditCard));

        return creditCardToCreditCardResponseDTOMapper.convert(updateCreditCard);
    }

    @Override
    @Transactional
    public boolean deleteCreditCard(Long creditCardId) {
        Optional<CreditCard> maybeCreditCard = creditCardRepository.findById(creditCardId);
        maybeCreditCard.ifPresent(creditCard -> creditCardRepository.deleteById(creditCard.getId()));

        return maybeCreditCard.isPresent();
    }
}
