package com.cvent.capstone.services;

import com.cvent.capstone.entities.OrderItems;
import com.cvent.capstone.repositories.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderItemsService {
    @Autowired
    private OrderItemsRepository orderItemsRepository;

    public List<OrderItems> findAll() {
        return orderItemsRepository.findAll();
    }

    public OrderItems save(OrderItems orderItems, Long orderId) {
        if (orderItems.getOrderId() == null) {
            orderItems.setOrderId(orderId);
        }
        return orderItemsRepository.save(orderItems);
    }

    public OrderItems findById(Long id) {
        return orderItemsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "OrderItem not found"));
    }

    public OrderItems updateOrderItems(Long id, OrderItems updatedOrderItems) {
        OrderItems existingOrderItems = this.findById(id);

        existingOrderItems.setItemId(updatedOrderItems.getItemId());
        existingOrderItems.setOrderId(updatedOrderItems.getOrderId());
        existingOrderItems.setItemId(updatedOrderItems.getItemId());
        existingOrderItems.setPrice(updatedOrderItems.getPrice());
        existingOrderItems.setFirstName(updatedOrderItems.getFirstName());
        existingOrderItems.setNotes(updatedOrderItems.getNotes());

        return orderItemsRepository.save(existingOrderItems);
    }

    public void delete(OrderItems orderItems) {
        orderItemsRepository.delete(orderItems);
    }

    public List<OrderItems> findAllByOrderId(Long orderId) {
        List<OrderItems> result = orderItemsRepository.findAll().stream()
                .filter(orderItem -> orderItem.getOrderId().equals(orderId))
                .toList();

        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No OrderItems found for the given orderId");
        } else {
            return result;
        }
    }
}
