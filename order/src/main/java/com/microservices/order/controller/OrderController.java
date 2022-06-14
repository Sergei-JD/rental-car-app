package com.microservices.order.controller;

import com.microservices.order.dto.request.OrderRequestDTO;
import com.microservices.order.dto.request.OrderUpdateRequestDTO;
import com.microservices.order.dto.response.OrderResponseDTO;
import com.microservices.order.entity.OrderStatus;
import com.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<Page<OrderResponseDTO>> getAllOrders(Pageable pageable) {
        Page<OrderResponseDTO> orders = orderService.getAllOrders(pageable);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Page<OrderResponseDTO>> getAllOrdersByAccountId(@PathVariable(name = "id") Long id, Pageable pageable) {
        Page<OrderResponseDTO> orders = orderService.getAllOrdersByAccountId(id, pageable);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<OrderResponseDTO>> getAllOrdersByStatus(@RequestParam(name = "status") OrderStatus orderStatus, Pageable pageable) {
        Page<OrderResponseDTO> orders = orderService.getAllOrdersByStatus(orderStatus, pageable);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable(name = "id") Long id) {
        Optional<OrderResponseDTO> orderResponseDTO = orderService.getOrderById(id);
        return orderResponseDTO.map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK))
                .orElseThrow(() -> new RuntimeException(
                        "Order with this id: " + id + " does not exist")
                );
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody @Valid OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO addOrder = orderService.createOrder(orderRequestDTO);
        return new ResponseEntity<>(addOrder, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<OrderResponseDTO> updateOrder(@RequestBody @Valid OrderUpdateRequestDTO orderUpdateRequestDTO) {
        OrderResponseDTO updatedOrder = orderService.updateOrder(orderUpdateRequestDTO);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(orderService.deleteOrder(id), HttpStatus.OK);
    }
}
