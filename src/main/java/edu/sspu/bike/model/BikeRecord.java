package edu.sspu.bike.model;

import java.util.List;

/**
 * 骑行记录表
 * @auther 杨亚龙
 * @date 2019/11/8 23:01
 */
public class BikeRecord {
    private int id;
    private String bikeLongitude;
    private String bikeLatitude;
    private String speed;
    private String stuId;
    private String name;

    public BikeRecord() {
    }

    public BikeRecord(String bikeLongitude, String bikeLatitude, String speed, String stuId, String name) {
        this.bikeLongitude = bikeLongitude;
        this.bikeLatitude = bikeLatitude;
        this.speed = speed;
        this.stuId = stuId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "BikeRecord{" +
                "id=" + id +
                ", bikeLongitude='" + bikeLongitude + '\'' +
                ", bikeLatitude='" + bikeLatitude + '\'' +
                ", speed=" + speed +
                ", stuId='" + stuId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
