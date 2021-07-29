package com.panglin.controller;

import com.panglin.pojo.TbUser;
import com.panglin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Pang-Lin
 * @version 1.0
 * @description: TODO
 * @date 2021/7/28 10:45
 */
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("login")
    public String login(){return "login";}

    @RequestMapping("login.action")
    public String loginAction(TbUser user, Model model){
        List<TbUser> tbUsers = loginService.selectUserByPhoneAndPassword(user);
        if (tbUsers.size()!=0){
            model.addAttribute("user",tbUsers.get(0));
            return "index";
        }else {
            model.addAttribute("message","用户名或密码错误");
            return "login";
        }
    }
}
