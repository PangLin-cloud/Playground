package com.panglin.controller;

import com.panglin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Pang-Lin
 * @version 1.0
 * @description: TODO
 * @date 2021/7/28 10:43
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
}
