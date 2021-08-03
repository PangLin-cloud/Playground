package com.panglin.pojo;

import java.util.Date;

public class ParkLineUp {
    private Integer id;

    private Integer parkId;

    private Integer userId;

    private Integer isLineUp;

    private Date lineUpTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsLineUp() {
        return isLineUp;
    }

    public void setIsLineUp(Integer isLineUp) {
        this.isLineUp = isLineUp;
    }

    public Date getLineUpTime() {
        return lineUpTime;
    }

    public void setLineUpTime(Date lineUpTime) {
        this.lineUpTime = lineUpTime;
    }
}