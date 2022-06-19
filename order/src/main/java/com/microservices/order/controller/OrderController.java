package com.microservices.order.controller;

import com.microservices.order.dto.create.OrderCreateDTO;
import com.microservices.order.dto.update.OrderUpdateDTO;
import com.microservices.order.dto.view.OrderViewDTO;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<Page<OrderViewDTO>> getAllOrders(Pageable pageable) {
        Page<OrderViewDTO> creditOrders = orderService.getAllOrders(pageable);

        return new ResponseEntity<>(creditOrders, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Page<OrderViewDTO>> getAllOrdersByAccountId(
            @PathVariable(name = "id") Long id, Pageable pageable) {
        Page<OrderViewDTO> orders = orderService.getAllOrdersByAccountId(id, pageable);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<OrderViewDTO>> getAllOrdersByStatus(
            @RequestParam(name = "status") OrderStatus orderStatus, Pageable pageable) {
        Page<OrderViewDTO> orders = orderService.getAllOrdersByStatus(orderStatus, pageable);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderViewDTO> getOrderById(
            @PathVariable(name = "id") Long id) {
        OrderViewDTO orderViewDTO = orderService.getOrderById(id);

        return new ResponseEntity<>(orderViewDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderCreateDTO> createOrder(
            @RequestBody @Valid OrderCreateDTO orderCreateDTO) {
        OrderCreateDTO addOrder = orderService.createOrder(orderCreateDTO);

        return new ResponseEntity<>(addOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderUpdateDTO> updateOrder(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid OrderUpdateDTO orderUpdateDTO) {
        OrderUpdateDTO updateOrder = orderService.updateOrder(id, orderUpdateDTO);

        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOrder(
            @PathVariable(name = "id") Long id) {
        boolean deleteOrder = orderService.deleteOrder(id);

        return new ResponseEntity<>(deleteOrder, HttpStatus.OK);
    }
}
