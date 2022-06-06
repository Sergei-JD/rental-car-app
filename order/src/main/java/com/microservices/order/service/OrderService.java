package com.microservices.order.service;

import com.microservices.order.dto.request.OrderRequestDTO;
import com.microservices.order.dto.request.OrderUpdateRequestDTO;
import com.microservices.order.dto.response.OrderResponseDTO;
import com.microservices.order.entity.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrderService {

    Page<OrderResponseDTO> getAllOrders(Pageable pageable);

    Page<OrderResponseDTO> getAllOrdersByAccountId(Long accountId, Pageable pageable);

    Page<OrderResponseDTO> getAllOrdersByStatus(OrderStatus orderStatus, Pageable pageable);

    Optional<OrderResponseDTO> getOrderById(long orderId);

    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO updateOrder(OrderUpdateRequestDTO orderUpdateRequestDTO);

    boolean deleteOrder(long orderId);
}
