package com.panglin.controller;

import com.panglin.pojo.PlayUser;
import com.panglin.service.LoginService;
import javafx.print.PageLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
    @RequestMapping("changePwd")
    public String changePwdH(){return "change_pwd";}
    @RequestMapping("register")
    public String registerH(){return "register";}
    /** 登录
     * @description: 登录
     * @param: * @param user
     * @return: java.lang.String
     * @author Pang-Lin
     * @date: 2021/7/30 15:22
     */
    @RequestMapping("login.action")
    public String loginAction(PlayUser user, HttpSession session){
        List<PlayUser> tbUsers = loginService.selectUserByPhoneAndPassword(user);
        if (tbUsers.size()!=0){
            session.setAttribute("user",tbUsers.get(0));
            return "redirect:/index.action";
        }else {
            session.setAttribute("message","用户名或密码错误");
            return "login";
        }
    }
    /** 找回密码
     * @description: 找回密码
     * @param: * @param user
     * @return: java.lang.String
     * @author Pang-Lin
     * @date: 2021/7/30 15:22
     */
    @RequestMapping("changePwd.form")
    public String changePwd(PlayUser user,Model model){
        int i = loginService.changePwd(user);
        if (i>0){
            return "login";
        }
        return "change_pwd";
    }
    @RequestMapping("/register.form")
    public  String register(PlayUser user){
        int register = loginService.register(user);
        if (register>0){
            return "login";
        }else {
            return "register";
        }
    }

}
