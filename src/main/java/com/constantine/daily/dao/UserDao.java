package com.constantine.daily.dao;

import com.constantine.daily.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {
    List<User> getAll();
    User getUser(Map map);
    void addUser(User user);
    void deleteUser(Map map);
}
