package com.microservices.order.service.dataimpl;

import com.microservices.order.dto.create.OrderCreateDTO;
import com.microservices.order.dto.update.OrderUpdateDTO;
import com.microservices.order.dto.view.OrderViewDTO;
import com.microservices.order.entity.Order;
import com.microservices.order.entity.OrderStatus;
import com.microservices.order.mapper.OrderMapper;
import com.microservices.order.repository.OrderRepository;
import com.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.microservices.order.util.ServiceData.ORDER_ID_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Page<OrderViewDTO> getAllOrders(Pageable pageable) {
        Page<Order> pageOrders = orderRepository.findAll(pageable);

        List<OrderViewDTO> orders = pageOrders.stream()
                .map(OrderMapper::toOrderViewDTO)
                .toList();

        return new PageImpl<>(orders);
    }

    @Override
    public Page<OrderViewDTO> getAllOrdersByAccountId(Long accountId, Pageable pageable) {
        Page<Order> pageOrders = orderRepository.findByAccountId(accountId, pageable);

        List<OrderViewDTO> orders = pageOrders.stream()
                .map(OrderMapper::toOrderViewDTO)
                .toList();

        return new PageImpl<>(orders);
    }

    @Override
    public Page<OrderViewDTO> getAllOrdersByStatus(OrderStatus orderStatus, Pageable pageable) {
        Page<Order> pageOrders = orderRepository.findAllByOrderStatus(orderStatus, pageable);

        List<OrderViewDTO> orders = pageOrders.stream()
                .map(OrderMapper::toOrderViewDTO)
                .toList();

        return new PageImpl<>(orders);
    }

    @Override
    public OrderViewDTO getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ServiceException(String.format(ORDER_ID_EXCEPTION_MESSAGE, orderId)));

        return OrderMapper.toOrderViewDTO(order);
    }

    @Override
    @Transactional
    public OrderCreateDTO createOrder(OrderCreateDTO orderCreateDTO) {
        Order newOrder = Order.builder()
                .accountId(orderCreateDTO.getAccountId())
                .orderStatus(orderCreateDTO.getOrderStatus())
                .build();

        return OrderMapper.toOrderCreateDTO(orderRepository.save(newOrder));
    }

    @Override
    @Transactional
    public OrderUpdateDTO updateOrder(Long orderId, OrderUpdateDTO orderUpdateDTO) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ServiceException(String.format(ORDER_ID_EXCEPTION_MESSAGE, orderId)));
        order.setAccountId(orderUpdateDTO.getAccountId());
        order.setOrderStatus(orderUpdateDTO.getOrderStatus());

        orderRepository.save(order);

        return OrderMapper.toOrderUpdateDTO(order);
    }

    @Override
    @Transactional
    public boolean deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);

        return orderRepository.findById(orderId).isEmpty();
    }
}
