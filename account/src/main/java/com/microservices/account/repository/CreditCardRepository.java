package com.microservices.account.repository;

import com.microservices.account.entity.CreditCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    Page<CreditCard> findCreditCardByAccountId(Long accountId, Pageable pageable);
}
