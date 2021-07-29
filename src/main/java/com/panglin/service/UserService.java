package com.panglin.service;

import com.panglin.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pang-Lin
 * @version 1.0
 * @description: TODO
 * @date 2021/7/28 10:43
 */
@Service
public class UserService {
    @Autowired(required = false)
    TbUserMapper userMapper;


}
