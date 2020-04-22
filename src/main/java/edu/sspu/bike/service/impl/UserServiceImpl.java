package edu.sspu.bike.service.impl;

import edu.sspu.bike.model.User;
import edu.sspu.bike.service.UserService;
import edu.sspu.bike.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @auther 杨亚龙
 * @date 2019/11/4 16:48
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Override
    public User findById(String id) {
        User user = userMapper.findById(id);
        if (user == null) {
            return null;
        } else {
            user.setPassword("");
            return user;
        }
    }

    @Override
    public User findById(int id) {
        return null;
    }

    /**
     * @param uid      账号
     * @param password 密码
     * @return 是否登录成功
     */
    @Override
    public Boolean login(String stuId, String password) {
        User u = userMapper.findById(stuId);
        System.out.println("UserServiceImpl.login" + u);
        if (u == null) {
            //没有这个用户
            return false;
        } else {
            if (password.equals(u.getPassword())) {
                return true;
            } else {
                //找到用户，但是密码错误
                return false;
            }
        }
    }

    /**
     * 注册
     *
     * @param stuId    学号
     * @param name     姓名
     * @param password 密码
     * @return 注册成功返回true, 失败返回false
     */
    @Override
    public Boolean register(String stuId, String name, String password,int role) {
        System.out.println("UserServiceImpl.register"+stuId+"   "+name+ "   "+password+"    "+role);
        return userMapper.register(stuId, name, password,role);
    }
}
