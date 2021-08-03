package com.panglin.service;

import com.panglin.mapper.ParkCollectionMapper;
import com.panglin.mapper.ParkLineUpMapper;
import com.panglin.mapper.ParkTableMapper;
import com.panglin.mapper.PlayUserMapper;
import com.panglin.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pang-Lin
 * @version 1.0
 * @description: TODO
 * @date 2021/7/28 10:43
 */
@Service
public class UserService {
    @Autowired(required = false)
    PlayUserMapper userMapper;
    @Autowired(required = false)
    ParkTableMapper parkTableMapper;
    @Autowired(required = false)
    ParkLineUpMapper parkLineUpMapper;
    @Autowired(required = false)
    ParkCollectionMapper collectionMapper;
    /** 
     * @description: 跳转index页面，查询所有的景点和排队人数，并计算热度
     * @param:  
     * @return: java.util.List<com.panglin.pojo.ParkTable> 
     * @author Pang-Lin
     * @date: 2021/7/30 16:26
     */ 
    public List<ParkTable> findAllPark(){
        return parkTableMapper.selectByExample(null);
    }
    public Map<Integer, Integer> findAllParkLine() {
        return parkLineUpMapper.selectLineUpCountGroupByParkId();
    }
    /** 查找本景点是否被收藏
     * @description: 查找本景点是否被收藏
     * @param: * @param uid 用户id pid 景点id
     * @return: java.util.Map<java.lang.Integer,java.lang.Integer> 
     * @author Pang-Lin
     * @date: 2021/8/3 16:50
     */ 
    public Map<Integer,Integer> detailsCollMap(int uid,int pid){
        ParkCollectionExample example=new ParkCollectionExample();
        example.createCriteria().andUidEqualTo(uid).andParkIdEqualTo(pid);
        List<ParkCollection> parkCollections = collectionMapper.selectByExample(example);
        if (parkCollections.size()==0){
            ParkCollection parkCollection=new ParkCollection();
            parkCollection.setUid(uid);
            parkCollection.setParkId(pid);
            parkCollection.setIsCollection(0);
        }
        List<ParkCollection> parkCollections1 = collectionMapper.selectByExample(null);
        Map<Integer,Integer> map=new HashMap<>();
        for (ParkCollection collection:parkCollections1) {
            map.put(collection.getParkId(),collection.getIsCollection());
        }
        return map;
    }
    /** 
     * @description: 查询项目详情
     * @param: * @param pid 
     * @return: com.panglin.pojo.ParkTable 
     * @author Pang-Lin
     * @date: 2021/8/3 16:58
     */ 
    public ParkTable details(int pid){
        return parkTableMapper.selectByPrimaryKey(pid);
    }
    /** 查询所有项目的排队人数,返回map集合，key为项目id，value为排队人数
     * @description: 查询所有项目的排队人数,返回map集合，key为项目id，value为排队人数
     * @param:  
     * @return: java.util.Map<java.lang.Integer,java.lang.Integer> 
     * @author Pang-Lin
     * @date: 2021/8/3 17:17
     */ 
    public Map<Integer, Integer> selectAll(){
        return parkLineUpMapper.selectLineUpCountGroupByParkId();
    }



}
