package edu.sspu.bike.web.controller;

import edu.sspu.bike.model.Reservation;
import edu.sspu.bike.model.ResultInfo;
import edu.sspu.bike.service.BikeUseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 车辆管理类
 * @auther 杨亚龙
 * @date 2019/11/20 13:55
 */
@Controller
@RequestMapping("/bikemanage")
public class BikeUseInfoController {
    @Autowired
    private BikeUseInfoService bikeUseInfoService;

    /**
     * 实现网页端的车辆管理功能
     * @return  bikeuseinfo表中除编号以外的其他信息
     */
    @RequestMapping("/useinfo")
    public @ResponseBody
    ResultInfo bikeUseInfo() {
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        info.setData(bikeUseInfoService.selcetBikeUseInfo());
        return info;
    }

    /**
     * 实现车辆预约功能
     * @param reservation 预约车辆所需要的信息
     * @return 预约成功的信息和当前所有可以骑行的车辆
     */
   @RequestMapping("/reserve")
    public @ResponseBody
    ResultInfo Reserve(@RequestBody Reservation reservation){
       System.out.println("BikeUseInfoController.Reserve"+reservation.toString());
       System.out.println("BikeUseInfoController.Reserve"+reservation.toString());
       System.out.println("BikeUseInfoController.Reserve"+reservation.toString());
       System.out.println("BikeUseInfoController.Reserve"+reservation.toString());
        ResultInfo info = new ResultInfo();
        //向车辆预约表中的插入一条记录
       if (bikeUseInfoService.reserveBike(reservation)) {
        info.setFlag(true);
       }
       System.out.println("BikeUseInfoController.Reserve"+info.isFlag());
       return info;
   }

}
