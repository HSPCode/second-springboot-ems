package com.hsp.dao;

import com.hsp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {
    User selectUserByName(@Param("username") String username);

    List<User> selectAllUser();

    void insertUser(@Param("user") User user);

    void deleteUserById(@Param("id") Integer id);

    void updateUser(@Param("user") User user);

    User selectUserById(@Param("id") Integer id);
}
