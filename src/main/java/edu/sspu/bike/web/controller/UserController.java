package edu.sspu.bike.web.controller;

import edu.sspu.bike.model.BikeInfo;
import edu.sspu.bike.model.ResultInfo;
import edu.sspu.bike.model.User;
import edu.sspu.bike.service.BikeInfoService;
import edu.sspu.bike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther 杨亚龙
 * @date 2019/11/4 13:57
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BikeInfoService bikeInfoService;

    /**
     * 实现登录功能，并返回车辆位置信息
     *
     * @param id       用户学号
     * @param password 用户密码
     * @return 登录信息成功或者失败的信息和车辆位置信息（经纬度信息）
     */
    @RequestMapping("/login")
    public @ResponseBody
    ResultInfo login(String id, String password) {
        System.out.println("UserController.login" + "学号：" + id + "/t" + password);
        ResultInfo info = new ResultInfo();
        info.setFlag(false);
        Boolean login;
        //调用service方法，返回mapper层的查询结果
        login = userService.login(id, password);
        System.out.println("UserController.login" + login);
        if (login) {
            User user = userService.findById(id);
            //根据用户角色，返回不同的信息
            if (user.getRole() == 0) {
                //用户是普通人（来自安卓端），返回当前可以使用的所有车的位置信息
                Map<String,Object> infoMap=new HashMap<>();
                List<BikeInfo> infoList = bikeInfoService.selectAllBikeInfo();
                infoMap.put("bikeinfo", infoList);
                infoMap.put("user", user);
                info.setFlag(true);
                info.setData(infoMap);
            }else{
            //用户是管理员，需要返回共享单车被使用的总次数、当前正在骑行的用户数
            }
        }
        System.out.println("UserController.login"+info.toString());
        return info;
    }

    /**
     * 用户注册
     *
     * @param id       用户学号
     * @param name     用户姓名
     * @param password 用户密码
     * @return 注册成功或者失败的信息
     */
    @RequestMapping("/register")
    public @ResponseBody
    ResultInfo register(String id, String name, String password,Integer role) {
        System.out.println("UserController.register"+id+"   "+name+"    "+password+"   "+role);
        ResultInfo info = new ResultInfo();
        info.setFlag(false);
        //    查询用户是否已经注册过
        User u = userService.findById(id);
        if (u != null) {
            //用户已经注册过，此次注册失败
            info.setErrorMsg("failed");
        } else {
            //完成注册，将用户信息写入数据库，并能返回注册成功的信息
            Boolean registered = userService.register(id, name, password,role);
            if (registered) {
                //注册成功
                info.setFlag(true);
                info.setData("success");
            }
        }
        return info;
    }
}
