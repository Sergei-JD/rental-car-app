package com.microservices.order.service;

import com.microservices.order.dto.request.OrderRequestDTO;
import com.microservices.order.dto.response.OrderResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrderService {

    Page<OrderResponseDTO> getAllOrders(Pageable pageable);

    Page<OrderResponseDTO> getAllOrdersStatus(String orderStatus, Pageable pageable);

    Optional<OrderResponseDTO> getOrderById(long orderId);

    OrderRequestDTO createOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO updateOrder(OrderResponseDTO orderResponseFullDTO);

    boolean deleteOrder(long orderId);
}
