package com.panglin.pojo;

public class ParkTable {
    private Integer id;

    private String parkName;

    private String parkFile;

    private Integer parkHot;

    private Double parkLongitude;

    private Double parkLatitude;

    private Integer parkMaxpeople;

    private String parkIntime;

    private String parkOuttime;

    private String title;

    private String titleDanger;

    private Double thrillDegree;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName == null ? null : parkName.trim();
    }

    public String getParkFile() {
        return parkFile;
    }

    public void setParkFile(String parkFile) {
        this.parkFile = parkFile == null ? null : parkFile.trim();
    }

    public Integer getParkHot() {
        return parkHot;
    }

    public void setParkHot(Integer parkHot) {
        this.parkHot = parkHot;
    }

    public Double getParkLongitude() {
        return parkLongitude;
    }

    public void setParkLongitude(Double parkLongitude) {
        this.parkLongitude = parkLongitude;
    }

    public Double getParkLatitude() {
        return parkLatitude;
    }

    public void setParkLatitude(Double parkLatitude) {
        this.parkLatitude = parkLatitude;
    }

    public Integer getParkMaxpeople() {
        return parkMaxpeople;
    }

    public void setParkMaxpeople(Integer parkMaxpeople) {
        this.parkMaxpeople = parkMaxpeople;
    }

    public String getParkIntime() {
        return parkIntime;
    }

    public void setParkIntime(String parkIntime) {
        this.parkIntime = parkIntime == null ? null : parkIntime.trim();
    }

    public String getParkOuttime() {
        return parkOuttime;
    }

    public void setParkOuttime(String parkOuttime) {
        this.parkOuttime = parkOuttime == null ? null : parkOuttime.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitleDanger() {
        return titleDanger;
    }

    public void setTitleDanger(String titleDanger) {
        this.titleDanger = titleDanger == null ? null : titleDanger.trim();
    }

    public Double getThrillDegree() {
        return thrillDegree;
    }

    public void setThrillDegree(Double thrillDegree) {
        this.thrillDegree = thrillDegree;
    }
}