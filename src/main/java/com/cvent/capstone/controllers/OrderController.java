package com.cvent.capstone.controllers;

import com.cvent.capstone.entities.Order;
import com.cvent.capstone.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    @Operation(summary = "Get all orders")
    public List<Order> getOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an order by ID")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get all orders by user ID")
    public List<Order> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.findAll().stream()
                .filter(order -> order.getUserId().equals(userId))
                .toList();
    }

    @PostMapping
    @Operation(summary = "Create a new order")
    public Order createOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing order")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        Order result = orderService.updateOrder(id, updatedOrder);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an order by ID")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        Order existingOrder = orderService.findById(id);
        orderService.delete(existingOrder);
        return ResponseEntity.noContent().build();
    }
}
