package com.example.possystem.controller;

import com.example.possystem.model.Order;
import com.example.possystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Creates a new order.
     *
     * @param order The order object to be created
     * @return ResponseEntity containing the created order and HttpStatus.OK if successful,
     *         or HttpStatus.INTERNAL_SERVER_ERROR if an error occurs
     */
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            Order createdOrder = orderService.createOrder(order);
            return ResponseEntity.ok(createdOrder);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retrieves all orders.
     *
     * @return ResponseEntity containing a list of all orders and HttpStatus.OK if successful,
     *         or HttpStatus.INTERNAL_SERVER_ERROR if an error occurs
     */
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            List<Order> orders = orderService.getAllOrders();
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retrieves an order by its ID.
     *
     * @param id The ID of the order to retrieve
     * @return ResponseEntity containing the order if found and HttpStatus.OK,
     *         or HttpStatus.NOT_FOUND if the order does not exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable("id") Integer id) {
        try {
            Optional<Order> order = orderService.getOrderById(id);
            if (order.isPresent()) {
                return new ResponseEntity<>(order, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
