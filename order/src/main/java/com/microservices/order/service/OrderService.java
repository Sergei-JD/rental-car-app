package com.microservices.order.service;

import com.microservices.order.dto.OrderRequestDTO;
import com.microservices.order.dto.OrderResponseFullDTO;
import com.microservices.order.dto.OrderResponseViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrderService {

    Page<OrderResponseViewDTO> getAllOrders(Pageable pageable);

    Page<OrderResponseViewDTO> getAllOrdersStatus(String orderStatus, Pageable pageable);

    Optional<OrderResponseViewDTO> getOrderById(long orderId);

    OrderRequestDTO createOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseFullDTO updateOrder(OrderResponseFullDTO orderResponseFullDTO);

    boolean deleteOrder(long orderId);
}
