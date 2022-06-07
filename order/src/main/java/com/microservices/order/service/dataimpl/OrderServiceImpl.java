package com.microservices.order.service.dataimpl;

import com.microservices.order.dto.request.OrderRequestDTO;
import com.microservices.order.dto.request.OrderUpdateRequestDTO;
import com.microservices.order.dto.response.OrderResponseDTO;
import com.microservices.order.entity.Order;
import com.microservices.order.entity.OrderStatus;
import com.microservices.order.mapper.request.OrderRequestDTOToOrderMapper;
import com.microservices.order.mapper.request.OrderUpdateRequestDTOToOrderMapper;
import com.microservices.order.mapper.response.OrderToOrderResponseDTOMapper;
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
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderRequestDTOToOrderMapper orderRequestDTOToOrderMapper;
    private final OrderToOrderResponseDTOMapper orderToOrderResponseDTOMapper;
    private final OrderUpdateRequestDTOToOrderMapper orderUpdateRequestDTOToOrderMapper;

    @Override
    public Page<OrderResponseDTO> getAllOrders(Pageable pageable) {
        Page<Order> pageOrders = orderRepository.findAll(pageable);

        List<OrderResponseDTO> orders = pageOrders.stream()
                .map(orderToOrderResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(orders);
    }

    @Override
    public Page<OrderResponseDTO> getAllOrdersByAccountId(Long accountId, Pageable pageable) {
        Page<Order> pageOrders = orderRepository.findByAccountId(accountId, pageable);

        List<OrderResponseDTO> orders = pageOrders.stream()
                .map(orderToOrderResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(orders);
    }

    @Override
    public Page<OrderResponseDTO> getAllOrdersByStatus(OrderStatus orderStatus, Pageable pageable) {
        Page<Order> pageOrders = orderRepository.findAllByOrderStatus(orderStatus, pageable);

        List<OrderResponseDTO> orders = pageOrders.stream()
                .map(orderToOrderResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(orders);
    }

    @Override
    public Optional<OrderResponseDTO> getOrderById(long orderId) {
        OrderResponseDTO orderResponseDTO = null;

        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            orderResponseDTO = orderToOrderResponseDTOMapper.convert(order.get());
        }

        return Optional.ofNullable(orderResponseDTO);
    }

    @Override
    @Transactional
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Order newOrder = orderRequestDTOToOrderMapper.convert(orderRequestDTO);
        Order saveOrder = orderRepository.save(Objects.requireNonNull(newOrder));

        return orderToOrderResponseDTOMapper.convert(saveOrder);
    }

    @Override
    @Transactional
    public OrderResponseDTO updateOrder(OrderUpdateRequestDTO orderUpdateRequestDTO) {
        orderRepository.findById(orderUpdateRequestDTO.getOrderId())
                .orElseThrow(() -> new ServiceException("Failed to update order no such order"));

        Order order = orderUpdateRequestDTOToOrderMapper.convert(orderUpdateRequestDTO);
        Order updateOrder = orderRepository.save(Objects.requireNonNull(order));

        return orderToOrderResponseDTOMapper.convert(updateOrder);
    }

    @Override
    @Transactional
    public boolean deleteOrder(long orderId) {
        orderRepository.deleteById(orderId);

        return orderRepository.findById(orderId).isEmpty();
    }
}
