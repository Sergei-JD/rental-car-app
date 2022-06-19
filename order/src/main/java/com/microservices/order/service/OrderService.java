package com.microservices.order.service;

import com.microservices.order.dto.create.OrderCreateDTO;
import com.microservices.order.dto.update.OrderUpdateDTO;
import com.microservices.order.dto.view.OrderViewDTO;
import com.microservices.order.entity.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    Page<OrderViewDTO> getAllOrders(Pageable pageable);

    Page<OrderViewDTO> getAllOrdersByAccountId(Long accountId, Pageable pageable);

    Page<OrderViewDTO> getAllOrdersByStatus(OrderStatus orderStatus, Pageable pageable);

    OrderViewDTO getOrderById(Long orderId);

    OrderCreateDTO createOrder(OrderCreateDTO orderCreateDTO);

    OrderUpdateDTO updateOrder(Long orderId, OrderUpdateDTO orderUpdateDTO);

    boolean deleteOrder(Long orderId);
}
