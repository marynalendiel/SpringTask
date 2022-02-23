package com.example.springtask.dao;

import com.example.springtask.entity.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getOrders() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Order> orderQuery =
                currentSession.createQuery("from Order",
                        Order.class);

        List<Order> orders = orderQuery.getResultList();

        return orders;
    }

    @Override
    public List<Order> getUserOrders(int userId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Order> orderQuery =
                currentSession.createQuery("from Order where userId = userId",
                        Order.class);

        List<Order> orders = orderQuery.getResultList();

        return orders;
    }

    @Override
    public void saveOrder(Order order) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(order);
    }

    @Override
    public Order getOrder(int orderId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Order order = currentSession.get(Order.class, orderId);

        return order;
    }

    @Override
    public void deleteOrder(int orderId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query =
                currentSession.createQuery("delete from Order where id=:orderId");
        query.setParameter("orderId", orderId);

        query.executeUpdate();
    }
}
