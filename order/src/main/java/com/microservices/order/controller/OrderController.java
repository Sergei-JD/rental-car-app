package com.microservices.order.controller;

import com.microservices.order.dto.request.OrderRequestDTO;
import com.microservices.order.dto.request.UpdateOrderDTO;
import com.microservices.order.dto.response.OrderResponseDTO;
import com.microservices.order.entity.Order;
import com.microservices.order.entity.OrderStatus;
import com.microservices.order.mapper.request.OrderRequestDTOToOrderMapper;
import com.microservices.order.mapper.request.UpdateOrderDTOToOrderMapper;
import com.microservices.order.mapper.response.OrderToOrderResponseDTOMapper;
import com.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderRequestDTOToOrderMapper orderRequestDTOToOrderMapper;
    private final OrderToOrderResponseDTOMapper orderToOrderResponseDTOMapper;
    private final UpdateOrderDTOToOrderMapper updateOrderDTOToOrderMapper;

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders(Pageable pageable) {
        List<OrderResponseDTO> orders = orderService.getAllOrders(pageable).stream()
                .map(orderToOrderResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<List<OrderResponseDTO>> getAllOrdersByAccountId(@PathVariable(name = "id") Long id, Pageable pageable) {
        List<OrderResponseDTO> orders = orderService.getAllOrdersByAccountId(id, pageable).stream()
                .map(orderToOrderResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<OrderResponseDTO>> getAllOrdersByStatus(@RequestParam(name = "status") OrderStatus orderStatus, Pageable pageable) {
        List<OrderResponseDTO> orders = orderService.getAllOrdersByStatus(orderStatus, pageable).stream()
                .map(orderToOrderResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable(name = "id") Long id) {
        Order order = orderService.getOrderById(id);
        OrderResponseDTO orderResponseDTO = orderToOrderResponseDTOMapper.convert(order);

        return new ResponseEntity<>(orderResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody @Valid OrderRequestDTO orderRequestDTO) {
        Order order = orderRequestDTOToOrderMapper.convert(orderRequestDTO);
        Order createdOrder = orderService.createOrder(order);
        OrderResponseDTO addOrder = orderToOrderResponseDTOMapper.convert(createdOrder);

        return new ResponseEntity<>(addOrder, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<OrderResponseDTO> updateOrder(@RequestBody @Valid UpdateOrderDTO updateOrderDTO) {
        Order order = updateOrderDTOToOrderMapper.convert(updateOrderDTO);
        Order updateOrder = orderService.updateOrder(order);
        OrderResponseDTO updatedOrder = orderToOrderResponseDTOMapper.convert(updateOrder);

        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable(name = "id") Long id) {
        boolean deleteOrder = orderService.deleteOrder(id);

        return new ResponseEntity<>(deleteOrder, HttpStatus.OK);
    }
}
