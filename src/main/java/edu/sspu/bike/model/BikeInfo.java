package edu.sspu.bike.model;

/**
 * 车辆骑行信息
 * @auther 杨亚龙
 * @date 2019/11/8 22:50
 */
public class BikeInfo {
    private String bikeId;  //车辆的编号（或者车锁的ip）
    private int lockStatus;
    private double bikeLongitude;
    private double bikeLatitude;
    private int useCount=0; //使用次数
    private String location;

    public BikeInfo() {
    }

    public BikeInfo(String bikeId,double bikeLongitude, double bikeLatitude,String location) {
        this.bikeId = bikeId;
        this.bikeLongitude = bikeLongitude;
        this.bikeLatitude = bikeLatitude;
        this.location=location;
    }

    public BikeInfo(String bikeId, int lockStatus, double bikeLongitude, double bikeLatitude, int useCount) {
        this.bikeId = bikeId;
        this.lockStatus = lockStatus;
        this.bikeLongitude = bikeLongitude;
        this.bikeLatitude = bikeLatitude;
        this.useCount = useCount;
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

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }

    public int getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(int lockStatus) {
        this.lockStatus = lockStatus;
    }

    public int getUseCount() {
        return useCount;
    }

    public void setUseCount(int useCount) {
        this.useCount = useCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "BikeInfo{" +
                "bikeId='" + bikeId + '\'' +
                ", lockStatus=" + lockStatus +
                ", bikeLongitude=" + bikeLongitude +
                ", bikeLatitude=" + bikeLatitude +
                ", useCount=" + useCount +
                '}';
    }
}
