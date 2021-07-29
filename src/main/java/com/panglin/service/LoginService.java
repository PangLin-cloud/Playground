package com.panglin.service;

import com.panglin.mapper.PlayUserMapper;
import com.panglin.pojo.PlayUser;
import com.panglin.pojo.PlayUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<PlayUser> selectUserByPhoneAndPassword(PlayUser user){
        List<PlayUser> tbUsers=new ArrayList<>();
        PlayUserExample example=new PlayUserExample();
        example.createCriteria().andUserPhoneEqualTo(user.getUserPhone()).andUserPwdEqualTo(user.getUserPwd());
        tbUsers = userMapper.selectByExample(example);
        return tbUsers;
    }
}
