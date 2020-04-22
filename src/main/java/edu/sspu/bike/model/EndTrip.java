package edu.sspu.bike.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 骑行结束后前端发回的数据包
 * @auther 杨亚龙
 * @date 2019/11/15 17:16
 */
public class EndTrip {
    // String bikeId, List<double> bikeLongtitude, List<double> bikeLatitude,List<double> spped,long rideDate,double rideTime,double rideDistance,
    private String name;    //姓名
    private String stuId;   //学号
    private String bikeId;  //车辆编号（或者车锁ip）
    private String bikeLongtitude;    //经度列表
    private String bikeLatitude;      //纬度列表
    private String speed;     //速度列表
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date rideDate;     //骑行日期
    private String rideTime;    //骑行时长
    private double rideDistance;    //骑行距离

    public EndTrip() {
    }


    public EndTrip(String name, String stuId, String bikeId, String bikeLongtitude, String bikeLatitude, String speed, Date rideDate, String
            rideTime, double rideDistance) {
        this.name = name;
        this.stuId = stuId;
        this.bikeId = bikeId;
        this.bikeLongtitude = bikeLongtitude;
        this.bikeLatitude = bikeLatitude;
        this.speed = speed;
        this.rideDate = rideDate;
        this.rideTime = rideTime;
        this.rideDistance = rideDistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }

    public String getBikeLongtitude() {
        return bikeLongtitude;
    }

    public void setBikeLongtitude(String bikeLongtitude) {
        this.bikeLongtitude = bikeLongtitude;
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

    public Double getRideDistance() {
        return rideDistance;
    }

    public void setRideDistance(double rideDistance) {
        this.rideDistance = rideDistance;
    }

    @Override
    public String toString() {
        return "EndTrip{" +
                "name='" + name + '\'' +
                ", stuId='" + stuId + '\'' +
                ", bikeId='" + bikeId + '\'' +
                ", bikeLongtitude='" + bikeLongtitude + '\'' +
                ", bikeLatitude='" + bikeLatitude + '\'' +
                ", speed='" + speed + '\'' +
                ", rideDate=" + rideDate +
                ", rideTime=" + rideTime +
                ", rideDistance=" + rideDistance +
                '}';
    }
}
