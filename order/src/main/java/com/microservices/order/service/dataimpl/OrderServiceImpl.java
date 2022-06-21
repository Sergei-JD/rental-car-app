package com.microservices.order.service.dataimpl;

import com.microservices.order.dto.create.CreateOrderDTO;
import com.microservices.order.dto.update.UpdateOrderDTO;
import com.microservices.order.dto.view.ViewOrderDTO;
import com.microservices.order.entity.Invoice;
import com.microservices.order.entity.Order;
import com.microservices.order.entity.OrderStatus;
import com.microservices.order.mapper.OrderMapper;
import com.microservices.order.repository.OrderRepository;
import com.microservices.order.service.InvoiceService;
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
    private final InvoiceService invoiceService;

    @Override
    public Page<ViewOrderDTO> getAllOrders(Pageable pageable) {
        Page<Order> pageOrders = orderRepository.findAll(pageable);

        List<ViewOrderDTO> orders = pageOrders.stream()
                .map(OrderMapper::toViewOrderDTO)
                .toList();

        return new PageImpl<>(orders);
    }

    @Override
    public Page<ViewOrderDTO> getAllOrdersByAccountId(Long accountId, Pageable pageable) {
        Page<Order> pageOrders = orderRepository.findByAccountId(accountId, pageable);

        List<ViewOrderDTO> orders = pageOrders.stream()
                .map(OrderMapper::toViewOrderDTO)
                .toList();

        return new PageImpl<>(orders);
    }

    @Override
    public Page<ViewOrderDTO> getAllOrdersByStatus(OrderStatus orderStatus, Pageable pageable) {
        Page<Order> pageOrders = orderRepository.findAllByOrderStatus(orderStatus, pageable);

        List<ViewOrderDTO> orders = pageOrders.stream()
                .map(OrderMapper::toViewOrderDTO)
                .toList();

        return new PageImpl<>(orders);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ServiceException(String.format(ORDER_ID_EXCEPTION_MESSAGE, orderId)));
    }

    @Override
    @Transactional
    public Long createOrder(CreateOrderDTO createOrderDTO) {
        Invoice invoice = invoiceService.getInvoiceById(createOrderDTO.getInvoiceId());
        Order newOrder = Order.builder()
                .accountId(createOrderDTO.getAccountId())
                .orderStatus(createOrderDTO.getOrderStatus())
                .invoice(invoice)
                .build();

        Order savedOrder = orderRepository.save(newOrder);

        return savedOrder.getId();
    }

    @Override
    @Transactional
    public void updateOrder(Long orderId, UpdateOrderDTO updateOrderDTO) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ServiceException(String.format(ORDER_ID_EXCEPTION_MESSAGE, orderId)));
        order.setAccountId(updateOrderDTO.getAccountId());
        order.setOrderStatus(updateOrderDTO.getOrderStatus());

        orderRepository.save(order);
    }

    @Override
    @Transactional
    public boolean deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);

        return orderRepository.findById(orderId).isEmpty();
    }
}
