package com.panglin.service;

import com.panglin.mapper.TbUserMapper;
import com.panglin.pojo.TbUser;
import com.panglin.pojo.TbUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.stereotype.Service;

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
    TbUserMapper userMapper;

    public List<TbUser> selectUserByPhoneAndPassword(TbUser user){
        List<TbUser> tbUsers=null;
        TbUserExample example=new TbUserExample();
        example.createCriteria().andPhoneEqualTo(user.getPhone()).andPasswordEqualTo(user.getPassword());
        tbUsers = userMapper.selectByExample(example);
        return tbUsers;
    }
}
