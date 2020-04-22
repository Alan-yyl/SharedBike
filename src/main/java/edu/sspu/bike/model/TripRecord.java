package edu.sspu.bike.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Time;
import java.util.Arrays;
import java.util.Date;

/**
 * 行程记录表
 *
 * @auther 杨亚龙
 * @date 2019/11/8 23:07
 */
public class TripRecord {
    private int id;
    //转为Json能显示的格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date rideDate;  //骑行日期
    private String rideTime;  //骑行时长
    private double rideDistance;    //骑行距离
    private String bikeLongitude;   //车辆经度
    private String bikeLatitude;    //车辆纬度
    private String speed;   //车辆速度
    private String stuId;
    private String name;

    public TripRecord() {
    }


    public TripRecord(Date rideDate, String rideTime, double rideDistance, String bikeLongitude, String bikeLatitude, String speed, String stuId, String name) {
        this.rideDate = rideDate;
        this.rideTime = rideTime;
        this.rideDistance = rideDistance;
        this.bikeLongitude = bikeLongitude;
        this.bikeLatitude = bikeLatitude;
        this.speed = speed;
        this.stuId = stuId;
        this.name = name;
    }

    // public TripRecord(Date rideDate, double rideDistance) {
    //     this.rideDate = rideDate;
    //     this.rideDistance = rideDistance;
    // }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRideDate() {
        return rideDate;
    }

    public void setRideDate(Date rideDate) {
        this.rideDate = rideDate;
    }

    public String getRideTime() {
        return rideTime;
    }

    public void setRideTime(String rideTime) {
        this.rideTime = rideTime;
    }

    public double getRideDistance() {
        return rideDistance;
    }

    public void setRideDistance(double rideDistance) {
        this.rideDistance = rideDistance;
    }

    public String getBikeLongitude() {
        return bikeLongitude;
    }

    public void setBikeLongitude(String bikeLongitude) {
        this.bikeLongitude = bikeLongitude;
    }

    public String getBikeLatitude() {
        return bikeLatitude;
    }

    public void setBikeLatitude(String bikeLatitude) {
        this.bikeLatitude = bikeLatitude;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TripRecord{" +
                "id=" + id +
                ", rideDate=" + rideDate +
                ", rideTime=" + rideTime +
                ", rideDistance=" + rideDistance +
                ", bikeLongitude='" + bikeLongitude + '\'' +
                ", bikeLatitude='" + bikeLatitude + '\'' +
                ", speed='" + speed + '\'' +
                ", stuId='" + stuId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
