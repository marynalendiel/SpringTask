package com.example.springtask.service;

import com.example.springtask.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();

    public void saveUser(User user);

    public User getUser(int userId);

    public void deleteUser(int userId);
}
