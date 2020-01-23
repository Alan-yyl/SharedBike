package edu.sspu.bike.web.controller;

import edu.sspu.bike.model.BikeInfo;
import edu.sspu.bike.model.ResultInfo;
import edu.sspu.bike.service.BikeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther 杨亚龙
 * @date 2019/11/9 23:20
 */
@Controller
@RequestMapping("/bikeinfo")
public class BikeInfoController {
    @Autowired
    private BikeInfoService bikeInfoService;

    /**
     * 获取车辆信息信息
     * @return
     */
    @RequestMapping("/bikeposition")
    public @ResponseBody ResultInfo bikePosition(){
        ResultInfo info=new ResultInfo();
        info.setFlag(false);
        List<BikeInfo> infoList=bikeInfoService.selectAllBikeInfo();
        //存在车辆信息
        if (infoList.size()>0){
            info.setFlag(true);
            info.setData(infoList);
        }
        System.out.println("位置获取成功！！！");
        System.out.println(info);
        return info;
    }
}
