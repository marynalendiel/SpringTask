package com.example.springtask.service;

import com.example.springtask.dao.OrderDAO;
import com.example.springtask.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public List<Order> getOrders() {
        return orderDAO.getOrders();
    }

    @Override
    public List<Order> getUserOrders(int userId) {
        return orderDAO.getUserOrders(userId);
    }

    @Override
    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    public Order getOrder(int orderId) {
        return orderDAO.getOrder(orderId);
    }

    @Override
    public void deleteOrder(int orderId) {
        orderDAO.deleteOrder(orderId);
    }
}
