package com.microservices.order.service;

import com.microservices.order.dto.create.CreateOrderDTO;
import com.microservices.order.dto.update.UpdateOrderDTO;
import com.microservices.order.dto.view.ViewOrderDTO;
import com.microservices.order.entity.Order;
import com.microservices.order.entity.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    Page<ViewOrderDTO> getAllOrders(Pageable pageable);

    Page<ViewOrderDTO> getAllOrdersByAccountId(Long accountId, Pageable pageable);

    Page<ViewOrderDTO> getAllOrdersByStatus(OrderStatus orderStatus, Pageable pageable);

    Order getOrderById(Long orderId);

    Long createOrder(CreateOrderDTO createOrderDTO);

    void updateOrder(Long orderId, UpdateOrderDTO updateOrderDTO);

    boolean deleteOrder(Long orderId);
}
