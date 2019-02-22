package com.hsp.service;

import com.hsp.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    boolean login(User user, HttpServletRequest req);

    User getUserById(Integer id);

    void addUser(User user);

    void changeUser(User user);

    void removeUser(Integer id);

    List<User> getAll();
}
