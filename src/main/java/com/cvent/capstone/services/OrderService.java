package com.cvent.capstone.services;


import com.cvent.capstone.entities.Order;
import com.cvent.capstone.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }

    public Order updateOrder(Long id, Order updatedOrder){
        Order existingOrder = this.findById(id);

        existingOrder.setUserId(updatedOrder.getUserId());
        existingOrder.setOrderTime(updatedOrder.getOrderTime());
        existingOrder.setPickupTime(updatedOrder.getPickupTime());
        existingOrder.setArea(updatedOrder.getArea());
        existingOrder.setLocation(updatedOrder.getLocation());
        existingOrder.setTax(updatedOrder.getTax());
        existingOrder.setTip(updatedOrder.getTip());
        existingOrder.setPan(updatedOrder.getPan());
        existingOrder.setExpiryMonth(updatedOrder.getExpiryMonth());
        existingOrder.setExpiryYear(updatedOrder.getExpiryYear());
        existingOrder.setStatus(updatedOrder.getStatus());

        return orderRepository.save(existingOrder);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
