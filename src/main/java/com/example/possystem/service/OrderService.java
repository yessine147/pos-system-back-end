package com.example.possystem.service;

import com.example.possystem.model.Order;
import com.example.possystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Retrieves all orders from the database.
     *
     * @return List of all orders
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Creates a new order in the database.
     *
     * @param order The order object to be created
     * @return The created order object with orderDateTime set to the current time
     */
    public Order createOrder(Order order) {
        // Set the orderDateTime to the current date and time
        order.setOrderDateTime(LocalDateTime.now());
        return orderRepository.save(order);
    }

    /**
     * Retrieves an order by its ID.
     *
     * @param id The ID of the order to retrieve
     * @return Optional containing the order if found, empty otherwise
     */
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

}
