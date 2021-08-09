package com.panglin.service;

import com.panglin.mapper.ParkCollectionMapper;
import com.panglin.mapper.ParkLineUpMapper;
import com.panglin.mapper.ParkTableMapper;
import com.panglin.mapper.PlayUserMapper;
import com.panglin.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
     * @description: 查询热度前10的景点
     * @param:  
     * @return: java.util.List<com.panglin.pojo.ParkTable> 
     * @author Pang-Lin
     * @date: 2021/7/30 16:26
     */ 
    public List<ParkTable> findAllParkTop10(){
        List<ParkTable> parkTables = findAllPark();
        List<ParkTable> parkTableList=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            parkTableList.add(parkTables.get(i));
        }
        return parkTableList;
    }
    /** 查询所有景点
     * @description: 查询所有景点
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/8/3 19:39
     */
    public List<ParkTable> findAllPark(){
        ParkTableExample example=new ParkTableExample();
        example.setOrderByClause("park_hot desc");
        return parkTableMapper.selectByExample(example);
    }
    /**
     * @description: 查询所有的景点的排队人数
     * @param:
     * @return: java.util.List<com.panglin.pojo.ParkTable>
     * @author Pang-Lin
     * @date: 2021/7/30 16:26
     */
    public Map<Integer, Integer> findAllParkLine() {
        List<LineUp> lineUps = parkLineUpMapper.selectLineUpCountGroupByParkId();
        Map<Integer,Integer> map=new HashMap<>();
        for (LineUp l:lineUps) {
            map.put(l.getPid(),l.getCount());
        }
        return map;

    }
    /** 
     * @description: 计算所有景点的等待时间
     * @param:  
     * @return: java.util.Map<java.lang.Integer,java.lang.Integer> 
     * @author Pang-Lin
     * @date: 2021/8/3 19:30
     */ 
    public Map<Integer, Integer> lineUpTime() {
        List<LineUp> lineUps = parkLineUpMapper.selectLineUpCountGroupByParkId();
        Map<Integer,Integer> map=new HashMap<>();
        for (LineUp l:lineUps) {
            int a=0;
            if (l.getCount()/20==0){
                a=1;
            }else {
                if (l.getCount()%20!=0){
                    a=l.getCount()/20+1;
                }else {
                    a=l.getCount()/20+1;
                }
            }
            map.put(l.getPid(),a*5);
        }
        return map;

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
    
    /** 
     * @description: 根据登录用户Id查询账号内所绑定的游客
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/8/4 18:03
     */

    public List<PlayUser> selectUserByInId(int id){
        PlayUserExample example=new PlayUserExample();
        example.createCriteria().andIsUserEqualTo(id);
        return userMapper.selectByExample(example);
    }
    
    /** 
     * @description: 根据集合Id进行循环插入
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/8/4 19:07
     */
    public Map<String,String> lineUpInserts(List<Integer> ids,int pid){
        StringBuilder stringBuilder=new StringBuilder();
        Map<String,String> map=new HashMap<>();
        int result=-1;
        for (int i = 0; i < ids.size(); i++) {
            Boolean aBoolean = selectLineUpByUserId(ids.get(i),pid);
            if (aBoolean){
                Date date=new Date();
                ParkLineUp parkLineUp=new ParkLineUp();
                parkLineUp.setUserId(ids.get(i));
                parkLineUp.setParkId(pid);
                parkLineUp.setIsLineUp(0);
                parkLineUp.setLineUpTime(date);
                updParkTableByHot(pid);
                result=parkLineUpMapper.insertSelective(parkLineUp);
            }else {
                String userName = userMapper.selectByPrimaryKey(ids.get(i)).getUserName();
                stringBuilder.append(userName+"-");
            }
            map.put("result",String.valueOf(result));
            map.put("stringUser",stringBuilder.toString());
        }
        return map;
    }
    /**
     * @description: 根据Id进行插入
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/8/4 19:07
     */
    public int lineUpInsert(Integer id,int pid){
            Date date=new Date();
            ParkLineUp parkLineUp=new ParkLineUp();
            parkLineUp.setUserId(id);
            parkLineUp.setParkId(pid);
            parkLineUp.setIsLineUp(0);
            parkLineUp.setLineUpTime(date);
            updParkTableByHot(pid);
            return parkLineUpMapper.insertSelective(parkLineUp);
    }

    /** 排队时每排一次队就给相应项目热度加一
     * @description: 排队时每排一次队就给相应项目热度加一
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/8/4 19:21
     */
    public void updParkTableByHot(int pid){
        ParkTable parkTable = parkTableMapper.selectByPrimaryKey(pid);
        ParkTable parkTable1=new ParkTable();
        parkTable1.setId(parkTable.getId());
        parkTable1.setParkHot(parkTable.getParkHot()+1);
        parkTableMapper.updateByPrimaryKeySelective(parkTable1);
    }

    /**
     * @description: 检查此人是否已经排队
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/8/4 20:30
     */
    public Boolean selectLineUpByUserId(int uid,int pid){
        ParkLineUpExample example=new ParkLineUpExample();
        example.createCriteria().andUserIdEqualTo(uid).andParkIdEqualTo(pid).andIsLineUpEqualTo(0);
        List<ParkLineUp> parkLineUps = parkLineUpMapper.selectByExample(example);
        return parkLineUps.size() == 0;
    }

    /** 根据id查询xy坐标
     * @description: 根据id查询xy坐标
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/8/5 1:15
     */
    public Map<String, String> selectParkTableInXY(int pid){
        ParkTable parkTable = parkTableMapper.selectByPrimaryKey(pid);
        Map<String,String> map=new HashMap<>();
        map.put("x",parkTable.getParkLongitude().toString());
        map.put("y",parkTable.getParkLatitude().toString());
        return map;
    }
    
    /** 根据用户id和景点id查询是否收藏
     * @description: 根据用户id和景点id查询是否收藏
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/8/5 15:12
     */
    public boolean selectCollectionByPidANDUid(int uid, int pid){
        ParkCollectionExample example=new ParkCollectionExample();
        example.createCriteria().andUidEqualTo(uid).andParkIdEqualTo(pid).andIsCollectionEqualTo(0);
        List<ParkCollection> parkCollections = collectionMapper.selectByExample(example);
        return parkCollections.size() != 0;
    }

    /** 收藏景点
     * @description: 收藏景点
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/8/5 15:25
     */
    public int insertCollectionByUidAndPid(int uid,int pid){
        ParkCollection collection=new ParkCollection();
        collection.setUid(uid);
        collection.setParkId(pid);
        collection.setIsCollection(0);
        return collectionMapper.insertSelective(collection);
    }

    /** 点击按钮取消收藏
     * @description: 点击按钮取消收藏
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/8/5 15:30
     */
    public int deleteCollectionByUidAndPid(int uid,int pid){
        ParkCollectionExample example=new ParkCollectionExample();
        example.createCriteria().andUidEqualTo(uid).andParkIdEqualTo(pid);
        return collectionMapper.deleteByExample(example);
    }

    /**
     * @description: 根据用户id取到收藏的项目
     * @param: * @param null
     * @return:
     * @author Pang-Lin
     * @date: 2021/8/5 15:40
     */

    public List<ParkTable> selectCollectionByUid(int uid){
        ParkCollectionExample example=new ParkCollectionExample();
        example.createCriteria().andUidEqualTo(uid);
        List<ParkCollection> parkCollections = collectionMapper.selectByExample(example);
        List<Integer> pids=new ArrayList<>();
        for (ParkCollection collextion: parkCollections) {
            int i=0;
            pids.add(collextion.getParkId());
        }
        List<ParkTable> parkTableList=new ArrayList<>();
        for (Integer pid:pids) {
            parkTableList.add(parkTableMapper.selectByPrimaryKey(pid));
        }
        return parkTableList;
    }


}
