package com.constantine.daily.service.impl;

import com.constantine.daily.dao.UserDao;
import com.constantine.daily.domain.User;
import com.constantine.daily.service.UserService;
import com.sun.tools.javac.util.ServiceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@CacheConfig(cacheNames = {"userCache"})
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

//    public static void main(String[] args) {
//        ServiceLoader<UserService> loader = ServiceLoader.load(UserService.class);
//        Iterator iterator = loader.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//    }

    @Override
    @Cacheable("userList")
    public List<User> getALl() {
        System.out.println("缓存不存在，执行方法");
        return userDao.getAll();
    }

    @Override
    @Cacheable(value = "userCache",key="#id")
    public User getUser(Integer id){
        Map<String,Integer> paramMap = new HashMap<>();
        paramMap.put("id",id);
        System.out.println("如果没有缓存，就会调用下面方法，如果有缓存，则直接输出，不会输出此段话");
        return userDao.getUser(paramMap);
    }

    @Override
    @CachePut(value = "userCache")
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @CacheEvict(value = "userCache",key = "#id")
    public void deleteUser(Integer id) {
        Map<String,Integer> paramMap = new HashMap<>();
        paramMap.put("id",id);
        userDao.deleteUser(paramMap);
    }


}
