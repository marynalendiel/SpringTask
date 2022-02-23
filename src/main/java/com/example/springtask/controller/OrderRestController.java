package com.example.springtask.controller;

import com.example.springtask.entity.Order;
import com.example.springtask.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @GetMapping(value = {"/orders"})
    public List<Order> getOrders() {

        return orderService.getOrders();
    }

    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable int orderId) {

        Order order = orderService.getOrder(orderId);

        if (order == null) {
            throw new EntityResultNotFoundException("order id not found - " + orderId);
        }

        return order;
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order) {

        order.setId(0);

        orderService.saveOrder(order);

        return order;
    }

    @PutMapping("/orders")
    public Order updateOrders(@RequestBody Order order) {

        orderService.saveOrder(order);

        return order;

    }

    @DeleteMapping("/orders/{orderId}")
    public String deleteOrder(@PathVariable int orderId) {

        Order order = orderService.getOrder(orderId);

        if (order == null) {
            throw new EntityResultNotFoundException("order id not found - " + orderId);
        }

        orderService.deleteOrder(orderId);

        return "Deleted order id - " + orderId;
    }
}
