package edu.sspu.bike.web.controller;

import edu.sspu.bike.model.ResultInfo;
import edu.sspu.bike.model.TripRecord;
import edu.sspu.bike.model.User;
import edu.sspu.bike.service.TripRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther 杨亚龙
 * @date 2019/11/20 15:59
 */
@Controller
@RequestMapping("/tripmanage")
public class TripManageController {
    @Autowired
    private TripRecordService tripRecordService;

    @RequestMapping("/mytrip")
    public @ResponseBody
    ResultInfo tripRecord(@RequestBody User user){
        ResultInfo info =new ResultInfo();
        info.setFlag(false);
        //查询用户的所有行程记录
        List<TripRecord> myTrips=tripRecordService.selectMyTrip(user);
        if (myTrips.size()>0){
            //查询成功
            info.setFlag(true);
            info.setData(myTrips);
        }else{
            //查询失败
            info.setErrorMsg("failed");
        }
        return info;
    }
}
