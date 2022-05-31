package com.microservices.order.repository;

import com.microservices.order.entity.Order;
import com.microservices.order.entity.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

//    Optional<Order> findByAccountId(Account accountId);

    Page<Order> findAllByOrderStatus(OrderStatus orderStatus, Pageable pageable);
}
