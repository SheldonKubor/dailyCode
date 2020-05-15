package com.constantine.daily.service;

import com.constantine.daily.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getALl();
    User getUser(Integer id);
    void addUser(User user);
    void deleteUser(Integer id);
    //String getUser();
}
