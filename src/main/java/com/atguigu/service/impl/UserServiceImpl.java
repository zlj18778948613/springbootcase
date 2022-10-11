package com.atguigu.service.impl;

import com.atguigu.dao.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.utils.RedisTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @作者: zhulinjia
 * @时间: 2022/10/11
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplateConfig redisTemplateConfig;


    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<User> findAll() {
        RedisTemplate redisTemplateInit = redisTemplateConfig.redisTemplateInit();

        List<User> list = (List<User>) redisTemplateInit.boundValueOps("userList").get();

        if (list == null) {
            list = userMapper.selectAll();
            redisTemplateInit.boundValueOps("userList").set(list);
            System.out.println("从数据库里获取，并存放到缓存中list = " + list);

        } else {
            System.out.println("从缓存区获取list = " + list);

        }

        return list;


    }


}

