package com.cvent.capstone.repositories;

import com.cvent.capstone.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();

    Order save(Order order);

    Optional<Order> findById(Long id);

    void delete(Order order);
}
