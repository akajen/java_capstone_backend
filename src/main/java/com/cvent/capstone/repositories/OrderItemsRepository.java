package com.cvent.capstone.repositories;

import com.cvent.capstone.entities.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
    List<OrderItems> findAll();

    Optional<OrderItems> findById(Long id);

    OrderItems save(OrderItems orderItems);

    void delete(OrderItems orderItems);
}
