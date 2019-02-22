package com.hsp.service.impl;

import com.hsp.dao.UserDAO;
import com.hsp.entity.User;
import com.hsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO dao;

    @Override
    public boolean login(User user, HttpServletRequest req) {
        User u = dao.selectUserByName(user.getUsername());
        if (u == null) return false;
        if (!u.getPassword().equals(user.getPassword())) return false;
        req.getSession().setAttribute("admin", u);
        List<User> list = dao.selectAllUser();
        req.setAttribute("list", list);
        return true;
    }

    @Override
    public User getUserById(Integer id) {
        return dao.selectUserById(id);
    }

    @Override
    public void addUser(User user) {
        dao.insertUser(user);
    }

    @Override
    public void changeUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void removeUser(Integer id) {
        dao.deleteUserById(id);
    }

    @Override
    public List<User> getAll() {
        return dao.selectAllUser();
    }
}
