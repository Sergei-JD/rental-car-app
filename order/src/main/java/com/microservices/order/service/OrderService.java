package com.microservices.order.service;

import com.microservices.order.entity.Order;
import com.microservices.order.entity.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    Page<Order> getAllOrders(Pageable pageable);

    Page<Order> getAllOrdersByAccountId(Long accountId, Pageable pageable);

    Page<Order> getAllOrdersByStatus(OrderStatus orderStatus, Pageable pageable);

    Order getOrderById(long orderId);

    Order createOrder(Order order);

    Order updateOrder(Order order);

    boolean deleteOrder(long orderId);
}
