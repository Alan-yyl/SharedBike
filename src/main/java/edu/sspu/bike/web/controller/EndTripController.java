package edu.sspu.bike.web.controller;

import edu.sspu.bike.mapper.BikeInfoMapper;
import edu.sspu.bike.model.BikeRecord;
import edu.sspu.bike.model.EndTrip;
import edu.sspu.bike.model.TripRecord;
import edu.sspu.bike.service.BikeInfoService;
import edu.sspu.bike.service.BikeUseInfoService;
import edu.sspu.bike.service.TripRecordService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 行程控制器
 *
 * @auther 杨亚龙
 * @date 2019/11/15 16:29
 */
@Controller
@RequestMapping("/endtrip")
public class EndTripController {
    @Autowired
    private TripRecordService tripRecordService;
    @Autowired
    private BikeUseInfoService bikeUseInfoService;
    @Autowired
    private BikeInfoService bikeInfoService;

    @RequestMapping("/end")
    public @ResponseBody
    ModelAndView endTrip(@RequestBody EndTrip endTrip, HttpServletResponse response) throws IOException {
        System.out.println("TripRecordController.endTrip1" + endTrip);
        //向行程记录表triprecord中插入数据
        Boolean insertTripRecord = tripRecordService.insertTripRecord(endTrip);
        //向车辆使用情况表中插入数据
        Boolean insertBikeUseInfo = bikeUseInfoService.insertBikeUseRecord(endTrip);
        //修改车辆信息表中的数据
        Boolean insertOrUpdateBikeInfo=bikeInfoService.insertOrUpdateBikeInfo(endTrip);
        if (insertTripRecord && insertBikeUseInfo&&insertOrUpdateBikeInfo) {
            //数据正常提交，并且保存到数据库中
            //重定向到/bikeinfo/bikeposition.do获取车辆位置信息
            return new ModelAndView("redirect:/bikeinfo/bikeposition.do");
        } else {
            //数据提交异常
            return null;
        }

    }

}
