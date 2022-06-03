package com.microservices.order.repository;

import com.microservices.order.entity.Order;
import com.microservices.order.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByAccountId(Long accountId);

    List<Order> findAllByOrderStatus(OrderStatus orderStatus);
}
