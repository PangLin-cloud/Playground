package com.panglin.controller;

import com.panglin.pojo.LineUp;
import com.panglin.pojo.ParkTable;
import com.panglin.pojo.PlayUser;
import com.panglin.service.UserService;
import com.panglin.util.Msg;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.*;

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
    /** 
     * @description: 跳转推荐页面
     * @param: * @param model 
     * @return: java.lang.String 
     * @author Pang-Lin
     * @date: 2021/8/3 19:32
     */ 
    @RequestMapping("index.action")
    public String index(Model model){
        List<ParkTable> allPark = userService.findAllParkTop10();
        Map<Integer, Integer> allParkLine = userService.findAllParkLine();
        Map<Integer, Integer> lineUpTime = userService.lineUpTime();
        model.addAttribute("lineUpTime",lineUpTime);
        model.addAttribute("parkLineMap",allParkLine);
        model.addAttribute("parkList",allPark);
        return "index";
    }
    @RequestMapping("allindex.action")
    /** 
     * @description: 跳转所有景点页面
     * @param: * @param model 
     * @return: java.lang.String 
     * @author Pang-Lin
     * @date: 2021/8/3 19:37
     */ 
    public String allIndex(Model model){
        List<ParkTable> allPark = userService.findAllPark();
        Map<Integer, Integer> allParkLine = userService.findAllParkLine();
        Map<Integer, Integer> lineUpTime = userService.lineUpTime();
        model.addAttribute("lineUpTime",lineUpTime);
        model.addAttribute("parkLineMap",allParkLine);
        model.addAttribute("parkList",allPark);
        return "all_index";
    }
    /** 
     * @description: 跳转详情页面
     * @param: * @param uid
     * @return: java.lang.String 
     * @author Pang-Lin
     * @date: 2021/8/3 20:00
     */ 
    @RequestMapping("details")
    public String details(int uid,int pid,Model model){
        Map<Integer, Integer> collMap = userService.detailsCollMap(uid, pid);
        ParkTable details = userService.details(pid);
        Map<Integer, Integer> allParkLine = userService.findAllParkLine();
        Map<Integer, Integer> lineUpTime = userService.lineUpTime();
        boolean b = userService.selectCollectionByPidANDUid(uid, pid);
        model.addAttribute("collection",b);
        model.addAttribute("lineUpTime",lineUpTime);
        model.addAttribute("parkLineMap",allParkLine);
        model.addAttribute("collMap",collMap);
        model.addAttribute("parkTable",details);
        return "details";
    }
    @RequestMapping("tables")
    public String tables(){return "table";}
    
    /** 根据主用户id查询该用户下绑定的玩家
     * @description: 根据主用户id查询该用户下绑定的玩家
     * @param:  
     * @return: java.lang.String 
     * @author Pang-Lin
     * @date: 2021/8/4 17:51
     */ 
    @RequestMapping("selectUserByInId")
    public String selectUserByInId(int uid,int pid,Model model){
        List<PlayUser> playUsers = userService.selectUserByInId(uid);
        ParkTable details = userService.details(pid);
        model.addAttribute("playUsers",playUsers);
        model.addAttribute("parktable",details);
        return "table";
    }
    /** 根据页面传回的Id进行排队操作
     * @description: 根据页面传回的Id进行排队操作
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/8/4 19:04
     */
    @RequestMapping("lineUpInsert")
    @ResponseBody
    public Msg lineUpInsert(String ids, int pid){
        Map<String, String> stringStringMap =new HashMap<>();
        int result=-1;
        if (ids.contains("-")){
            List<Integer> insertIds=new ArrayList<>();
            String [] str_ids=ids.split("-");
            for (String s:str_ids) {
                insertIds.add(Integer.valueOf(s));
            }
            stringStringMap = userService.lineUpInserts(insertIds, pid);
            result=Integer.parseInt(stringStringMap.get("result"));
        }else {
            Integer id=Integer.parseInt(ids);
            result = userService.lineUpInsert(id,pid);
        }
        if (stringStringMap.get("stringUser").length()==0){
            if (result>0){
                return  Msg.success("排队成功！跳回首页！");
            }else {
                return Msg.fail("排队失败！");
            }
        }else {
            if (result>0){
                return  Msg.success("排队成功！"+stringStringMap.get("stringUser")+"已排队，请勿重复排队！");
            }else {
                return Msg.fail("排队失败！已经排队，请勿重复排队！");
            }
        }


    }
    
    /** 根据Id查询坐标
     * @description: 根据Id查询坐标
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/8/5 1:13
     */
    @RequestMapping("selectParkTableInXY")
    @ResponseBody
    public Msg selectParkTableInXY(int pid){
        Map<String, String> stringStringMap = userService.selectParkTableInXY(pid);
        return Msg.success().add("zuobiao",stringStringMap);
    }

    /** 点击收藏按钮收藏
     * @description:  点击收藏按钮收藏
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/8/5 15:24
     */
    @RequestMapping("insertCollectionByUidAndPid")
    @ResponseBody
    public Msg insertCollectionByUidAndPid(int uid,int pid){
        int i = userService.insertCollectionByUidAndPid(uid, pid);
        if (i>0){
            return  Msg.success("收藏成功！");
        }else {
            return Msg.success("收藏失败！");
        }
    }

    /** 点击按钮取消收藏
     * @description:  点击按钮取消收藏
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/8/5 15:24
     */
    @RequestMapping("deleteCollectionByUidAndPid")
    @ResponseBody
    public Msg deleteCollectionByUidAndPid(int uid,int pid){
        int i = userService.deleteCollectionByUidAndPid(uid, pid);
        if (i>0){
            return  Msg.success("取消收藏成功！");
        }else {
            return Msg.success("取消收藏失败！");
        }
    }
    @RequestMapping("collection")
    public String collection(int uid,Model model){
        List<ParkTable> parkTableList = userService.selectCollectionByUid(uid);
        model.addAttribute("parkList",parkTableList);
        Map<Integer, Integer> allParkLine = userService.findAllParkLine();
        Map<Integer, Integer> lineUpTime = userService.lineUpTime();
        model.addAttribute("lineUpTime",lineUpTime);
        model.addAttribute("parkLineMap",allParkLine);
        return "collection";
    }

    @RequestMapping("/logOut")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }
}
