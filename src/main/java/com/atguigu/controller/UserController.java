package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @作者: zhulinjia
 * @时间: 2022/10/11
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @RequestMapping(path = "/findAll")
    @ResponseBody
    public Result findAll() {
        List<User> users = userService.findAll();
        return Result.ok(users);
    }

}
