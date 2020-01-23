package edu.sspu.bike.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


/**
 * @auther 杨亚龙
 * @date 2019/11/21 14:16
 */
@ToString
public class Reservation {
    //使用lombok生成get/set方法
    @Setter @Getter private String bikeId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")@Setter @Getter private Date appointment;
    @Setter @Getter private String stuId;
    @Setter @Getter private String name;

    public Reservation() {
    }

    public Reservation(String bikeId, Date appointment, String stuId, String name) {
        this.bikeId = bikeId;
        this.appointment = appointment;
        this.stuId = stuId;
        this.name = name;
    }
}
