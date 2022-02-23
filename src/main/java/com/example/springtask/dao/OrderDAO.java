package com.example.springtask.dao;

import com.example.springtask.entity.Order;

import java.util.List;

public interface OrderDAO {
    public List<Order> getOrders();

    public List<Order> getUserOrders(int userId);

    public void saveOrder(Order order);

    public Order getOrder(int orderId);

    public void deleteOrder(int orderId);
}
