package edu.sspu.bike.web.controller;

import edu.sspu.bike.model.ResultInfo;
import edu.sspu.bike.service.BikeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 该类实现用户管理的功能
 * @auther 杨亚龙
 * @date 2019/11/17 0:02
 */
@Controller
@RequestMapping("/querynummer")
public class QueryUserNumberController {
    @Autowired
    BikeInfoService bikeInfoService;


    @RequestMapping("/userandbike")
    public @ResponseBody
    ResultInfo
    queryuserAndBike() {
        ResultInfo info=new ResultInfo();
        info.setFlag(false);
        //查询共享单车被使用的总次数
        info.setData(bikeInfoService.selectTotal());
        return info;
    }

}
