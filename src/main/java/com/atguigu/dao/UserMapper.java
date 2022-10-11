package com.atguigu.dao;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> { //继承通用Mapper框架父接口

}
