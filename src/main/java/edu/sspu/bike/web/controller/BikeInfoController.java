package edu.sspu.bike.web.controller;

import edu.sspu.bike.model.BikeInfo;
import edu.sspu.bike.model.ResultInfo;
import edu.sspu.bike.model.User;
import edu.sspu.bike.service.BikeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther 杨亚龙
 * @date 2019/11/9 23:20
 */
@RestController
@RequestMapping("/bikeinfo")
public class BikeInfoController {
    @Autowired
    private BikeInfoService bikeInfoService;

    /**
     * 获取车辆信息信息
     *
     * @return
     */
    @RequestMapping("/bikeposition")
    public @ResponseBody
    ResultInfo bikePosition() {
        ResultInfo info = new ResultInfo();
        info.setFlag(false);
        List<BikeInfo> infoList = bikeInfoService.selectAllBikeInfo();
        //存在车辆信息
        if (infoList.size() > 0) {
            info.setFlag(true);
            info.setData(infoList);
        }
        System.out.println("位置获取成功！！！");
        System.out.println(info);
        return info;
    }

    /**
     * 单车发起开锁请求
     * @param bikeInfo，包括开锁指令、车锁编号（即车辆的bikeID）
     * @return
     */
    @PostMapping("/openlock") @ResponseBody
    public ResultInfo openLock(@RequestParam String stuId, @RequestParam String bikeId) {
        BikeInfo bikeInfo=new BikeInfo();
        bikeInfo.setBikeId(bikeId);
        User user = new User();
        user.setStuId(stuId);
        ResultInfo resultInfo = new ResultInfo();
        //查询这辆车是否可以用（有没有被预约了）
        BikeInfo isUse = bikeInfoService.openLock(bikeInfo,user);
        System.out.println("BikeInfoController.openLock"+isUse.toString());
        if (isUse != null) {
            if (isUse.getLockStatus() == 2) {
                resultInfo.setFlag(true);
                resultInfo.setErrorMsg("车辆已经被预约，请找其他车辆进行开锁");
            }else if (isUse.getLockStatus() == 1) {
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("车辆已经被打开，如果骑行结束，请关闭车锁");
            }else{
                resultInfo.setFlag(true);
                resultInfo.setErrorMsg(null);
            }
        } else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("车辆不存在");
        }
        System.out.println("BikeInfoController.openLock"+resultInfo.toString());
        return resultInfo;
    }

    @PostMapping("/closeLock")
    public ResultInfo closeLock(@RequestParam String stuId, @RequestParam String bikeId){
        BikeInfo bikeInfo=new BikeInfo();
        bikeInfo.setBikeId(bikeId);
        User user = new User();
        user.setStuId(stuId);
        ResultInfo resultInfo = new ResultInfo();
        BikeInfo isClose=bikeInfoService.closeLock(bikeInfo,user);
        if (isClose != null) {
            resultInfo.setData(isClose);
            resultInfo.setFlag(true);
        }else{
            resultInfo.setData(null);
            resultInfo.setErrorMsg("关锁失败，请重新关锁");
            resultInfo.setFlag(false);
        }
        return resultInfo;
    }
}
