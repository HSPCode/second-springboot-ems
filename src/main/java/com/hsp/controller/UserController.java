package com.hsp.controller;

import com.hsp.entity.User;
import com.hsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/test")
    public void test() {
        System.out.println("hehe");
    }

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest req) {
        boolean b = service.login(user, req);
        if (b) return "emplist";
        return "login";
    }

    @RequestMapping("/remove")
    public String remove(Integer id, HttpServletRequest req) {
        service.removeUser(id);
        List<User> list = service.getAll();
        req.setAttribute("list", list);
        return "emplist";
    }

    @RequestMapping("/update")
    public String update(User user, HttpServletRequest req) {
        System.out.println(user);
        service.changeUser(user);
        List<User> list = service.getAll();
        req.setAttribute("list", list);
        return "emplist";
    }

    @RequestMapping("/add")
    public Object add(User user, Integer type, HttpServletRequest req) {

        //1--->添加管理员
        if (type == 1) {
            user.setRole(0);
            service.addUser(user);
            return "login";
        } else {
            user.setRole(1);
            service.addUser(user);
            List<User> list = service.getAll();
            req.setAttribute("list", list);
            return "emplist";
        }
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(Integer id, HttpServletRequest req) {
        User u = service.getUserById(id);
        req.setAttribute("user", u);
        return "updateEmp";
    }
}
