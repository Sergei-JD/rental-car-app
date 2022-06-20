package com.microservices.order.controller;

import com.microservices.order.dto.create.CreateOrderDTO;
import com.microservices.order.dto.update.UpdateOrderDTO;
import com.microservices.order.dto.view.ViewOrderDTO;
import com.microservices.order.entity.Order;
import com.microservices.order.entity.OrderStatus;
import com.microservices.order.mapper.OrderMapper;
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
    public ResponseEntity<Page<ViewOrderDTO>> getAllOrders(Pageable pageable) {
        Page<ViewOrderDTO> creditOrders = orderService.getAllOrders(pageable);

        return new ResponseEntity<>(creditOrders, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Page<ViewOrderDTO>> getAllOrdersByAccountId(
            @PathVariable(name = "id") Long id, Pageable pageable) {
        Page<ViewOrderDTO> orders = orderService.getAllOrdersByAccountId(id, pageable);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<ViewOrderDTO>> getAllOrdersByStatus(
            @RequestParam(name = "status") OrderStatus orderStatus, Pageable pageable) {
        Page<ViewOrderDTO> orders = orderService.getAllOrdersByStatus(orderStatus, pageable);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewOrderDTO> getOrderById(
            @PathVariable(name = "id") Long id) {
        Order order = orderService.getOrderById(id);
        ViewOrderDTO viewOrderDTO = OrderMapper.toViewOrderDTO(order);

        return new ResponseEntity<>(viewOrderDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createOrder(
            @RequestBody @Valid CreateOrderDTO createOrderDTO) {
        Long addOrder = orderService.createOrder(createOrderDTO);

        return new ResponseEntity<>(addOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrder(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid UpdateOrderDTO updateOrderDTO) {
        orderService.updateOrder(id, updateOrderDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOrder(
            @PathVariable(name = "id") Long id) {
        boolean deleteOrder = orderService.deleteOrder(id);

        return new ResponseEntity<>(deleteOrder, HttpStatus.OK);
    }
}
