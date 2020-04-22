package edu.sspu.bike.service;

import edu.sspu.bike.model.User;
import edu.sspu.bike.service.base.BaseService;

/**
 * @auther 杨亚龙
 * @date 2019/11/4 16:46
 */
public interface UserService extends BaseService<User> {
    /**
     * 登录
     * @param uid 账号
     * @param password 密码
     * @return
     */
    Boolean login(String stuId, String password);

    /**
     * 注册
     * @param stuId 学号
     * @param name 姓名
     * @param password 密码
     * @return 注册成功返回true,失败返回false
     */
    Boolean register(String stuId, String name, String password,int role);
}
