package com.panglin.service;

import com.panglin.mapper.PlayUserMapper;
import com.panglin.pojo.PlayUser;
import com.panglin.pojo.PlayUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Pang-Lin
 * @version 1.0
 * @description: TODO
 * @date 2021/7/28 10:45
 */
@Service
public class LoginService {
    @Autowired(required = false)
    PlayUserMapper userMapper;
    /** 登录，验证手机号和密码
     * @description: 登录，验证手机号和密码
     * @param: * @param user 
     * @return: java.util.List<com.panglin.pojo.PlayUser> 
     * @author Pang-Lin
     * @date: 2021/7/30 15:05
     */ 
    public List<PlayUser> selectUserByPhoneAndPassword(PlayUser user){
        PlayUserExample example=new PlayUserExample();
        example.createCriteria().andUserPhoneEqualTo(user.getUserPhone()).andUserPwdEqualTo(user.getUserPwd());
        return userMapper.selectByExample(example);
    }
    /** 验证身份证号修改密码
     * @description: 验证身份证号修改密码
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/30 15:01
     */
    public int changePwd(PlayUser user){
        PlayUserExample example=new PlayUserExample();
        example.createCriteria().andIdCardEqualTo(user.getIdCard()).andUserPhoneEqualTo(user.getUserPhone());
        List<PlayUser> playUsers = userMapper.selectByExample(example);
        if (playUsers.size()!=0){
            PlayUser user1=new PlayUser();
            user1.setId(playUsers.get(0).getId());
            user1.setUserPwd(user.getUserPwd());
            return userMapper.updateByPrimaryKeySelective(user1);
        }else {
            return -1;
        }
    }

    /** 注册账号
     * @description: 注册账号
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/7/30 15:24
     */
    public int register(PlayUser user){
        Date date=new Date();
        user.setCreateTime(date);
        user.setCreateTimestr(date.toLocaleString());
        return userMapper.insertSelective(user);
    }


}
