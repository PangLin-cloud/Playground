package com.panglin.controller;

import com.panglin.pojo.LineUp;
import com.panglin.pojo.ParkTable;
import com.panglin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @RequestMapping("index.action")
    public String index(Model model){
        List<ParkTable> allPark = userService.findAllPark();
        Map<Integer, Integer> allParkLine = userService.findAllParkLine();
        model.addAttribute("parkLineMap",allParkLine);
        model.addAttribute("parkList",allPark);
        return "index";
    }

    @RequestMapping("details")
    public String details(int uid,int pid,Model model){
        Map<Integer, Integer> collMap = userService.detailsCollMap(uid, pid);
        ParkTable details = userService.details(pid);
        model.addAttribute("collMap",collMap);
        model.addAttribute("parkTable",details);
        return "details";
    }
}
