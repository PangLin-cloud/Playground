package com.panglin.pojo;

/**
 * @author Pang-Lin
 * @version 1.0
 * @description: TODO
 * @date 2021/8/3 17:19
 */
public class LineUp {
    /** 
     * @description: 排队人数 
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/8/3 17:20
     */ 
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    /**
     * @description: 预计等待时间
     * @param: * @param null 
     * @return:  
     * @author Pang-Lin
     * @date: 2021/8/3 17:20
     */ 
    private int time;
}
