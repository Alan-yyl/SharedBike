package edu.sspu.bike.model;

import lombok.*;

/**
 * 车辆骑行信息
 * @auther 杨亚龙
 * @date 2019/11/8 22:50
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BikeInfo {
    /**
     *  车辆的编号（或者车锁的ip）
     */
    private String bikeId;
    private int lockStatus;
    private double bikeLongitude;
    private double bikeLatitude;
    //使用次数
    private int useCount=0;
    private String location;
    private String stuId;


    public BikeInfo(String bikeId, double bikeLongitude, double bikeLatitude, String location) {
    }
}
