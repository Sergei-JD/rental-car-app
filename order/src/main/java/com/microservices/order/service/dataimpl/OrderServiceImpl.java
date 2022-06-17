package com.microservices.order.service.dataimpl;

import com.microservices.order.entity.Order;
import com.microservices.order.entity.OrderStatus;
import com.microservices.order.repository.OrderRepository;
import com.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.microservices.order.util.ServiceData.ORDER_DELETE_EXCEPTION_MESSAGE;
import static com.microservices.order.util.ServiceData.ORDER_ID_EXCEPTION_MESSAGE;
import static com.microservices.order.util.ServiceData.ORDER_UPDATE_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Page<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Page<Order> getAllOrdersByAccountId(Long accountId, Pageable pageable) {
        return orderRepository.findByAccountId(accountId, pageable);
    }

    @Override
    public Page<Order> getAllOrdersByStatus(OrderStatus orderStatus, Pageable pageable) {
        return orderRepository.findAllByOrderStatus(orderStatus, pageable);
    }

    @Override
    public Order getOrderById(long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ServiceException(String.format(ORDER_ID_EXCEPTION_MESSAGE, orderId)));
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order updateOrder(Order order) {
        Order maybeOrder = orderRepository.findById(order.getId())
                .orElseThrow(() -> new ServiceException(ORDER_UPDATE_EXCEPTION_MESSAGE));
        return orderRepository.save(maybeOrder);
    }

    @Override
    @Transactional
    public boolean deleteOrder(long orderId) {
        Order maybeOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new ServiceException(String.format(ORDER_DELETE_EXCEPTION_MESSAGE, orderId)));
        orderRepository.deleteById(maybeOrder.getId());
        return orderRepository.findById(orderId).isEmpty();
    }
}
