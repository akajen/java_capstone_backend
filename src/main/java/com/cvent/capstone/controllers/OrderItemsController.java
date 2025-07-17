package com.cvent.capstone.controllers;

import com.cvent.capstone.entities.OrderItems;
import com.cvent.capstone.services.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class OrderItemsController {
    @Autowired
    private OrderItemsService orderItemsService;

    @GetMapping
    public List<OrderItems> getAllOrderItems() {
        return orderItemsService.findAll();
    }

//    Paths related to orderItems id
    @GetMapping("/{id}")
    public OrderItems getOrderItemById(@PathVariable Long id) {
        return orderItemsService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItems> updateOrderItem(@PathVariable Long id, @RequestBody OrderItems updatedOrderItems) {
        OrderItems result = orderItemsService.updateOrderItems(id, updatedOrderItems);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        OrderItems existingOrderItems = orderItemsService.findById(id);
        orderItemsService.delete(existingOrderItems);
        return ResponseEntity.noContent().build();
    }

//    Paths related to orderId
    @GetMapping("/order/{orderId}")
    public List<OrderItems> getOrderItemsByOrderId(@PathVariable Long orderId) {
        return orderItemsService.findAllByOrderId(orderId);
    }

    @PostMapping("/order/{orderId}")
    public List<OrderItems> createOrderItemsList(@PathVariable Long orderId, @RequestBody List<OrderItems> orderItemsList) {
        List<OrderItems> result = new ArrayList<>();

        if (orderItemsList == null || orderItemsList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order items list cannot be null or empty");
        } else {
            for (OrderItems orderItems : orderItemsList) {
                result.add(orderItemsService.save(orderItems, orderId));
            }
        }
        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No OrderItems created for the given orderId");
        }

        return result;
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<Void> deleteOrderItemsByOrderId(@PathVariable Long orderId) {
        List<OrderItems> orderItemsList = orderItemsService.findAllByOrderId(orderId);
        if (orderItemsList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No OrderItems found for the given orderId");
        }
        for (OrderItems orderItem : orderItemsList) {
            orderItemsService.delete(orderItem);
        }
        return ResponseEntity.noContent().build();
    }
}
