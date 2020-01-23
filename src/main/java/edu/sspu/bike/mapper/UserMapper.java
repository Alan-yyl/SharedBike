package edu.sspu.bike.mapper;

import edu.sspu.bike.mapper.base.BaseMapper;
import edu.sspu.bike.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @auther 杨亚龙
 * @date 2019/11/4 17:08
 */
public interface UserMapper extends BaseMapper<User> {
    Boolean register(@Param("Id") String stuId, @Param("name") String name, @Param("password") String password,@Param("role")int role);
}
