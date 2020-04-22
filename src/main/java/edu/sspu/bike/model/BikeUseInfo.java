package edu.sspu.bike.model;

/**
 * 车辆使用情况
 *
 * @auther 杨亚龙
 * @date 2019/11/8 22:52
 */
public class BikeUseInfo {
    private String stuId;   //用户学号
    private String name;    //用户姓名
    private String bikeId;  //车辆编号
    private double bikeLongitude;   //车辆的经度
    private double bikeLatitude;    //车辆的纬度

    public BikeUseInfo() {
    }

    public BikeUseInfo(String stuId, String name, String bikeId, double bikeLongitude, double bikeLatitude) {
        this.stuId = stuId;
        this.name = name;
        this.bikeId = bikeId;
        this.bikeLongitude = bikeLongitude;
        this.bikeLatitude = bikeLatitude;
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setBikeID(String bikeId) {
        this.bikeId = bikeId;
    }

    public double getBikeLongitude() {
        return bikeLongitude;
    }

    public void setBikeLongitude(double bikeLongitude) {
        this.bikeLongitude = bikeLongitude;
    }

    public double getBikeLatitude() {
        return bikeLatitude;
    }

    public void setBikeLatitude(double bikeLatitude) {
        this.bikeLatitude = bikeLatitude;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Override
    public String toString() {
        return "BikeUseInfo{" +
                "bikeId='" + bikeId + '\'' +
                ", name='" + name + '\'' +
                ", bikeId='" + bikeId + '\'' +
                ", bikeLongitude=" + bikeLongitude +
                ", bikeLatitude=" + bikeLatitude +
                '}';
    }
}
