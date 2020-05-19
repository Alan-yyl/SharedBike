package edu.sspu.bike.mapper;

import edu.sspu.bike.mapper.base.BaseMapper;
import edu.sspu.bike.model.BikeInfo;
import edu.sspu.bike.model.Reservation;
import edu.sspu.bike.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther 杨亚龙
 * @date 2019/11/9 22:28
 */
public interface BikeInfoMapper extends BaseMapper<BikeInfo> {
    /**
     * 查询车辆的所有信息
     *
     * @return
     */
    List<BikeInfo> selectAllBikeInfo();
    /**
     *插入一条车辆信息
     */
     int insertBikeInfo(BikeInfo bikeInfo);
    /**
     * 更新一条记录
     */
    int updateBikeInfo(@Param("bikeInfo") BikeInfo bikeInfo);

    /**
     * 查询共享单车的使用次数，计算usercount
     */
    int selectUsingTotal();

    /**
     * 查询正在使用共享单车的用户数
     */
    int selectUserOfBikingTotal();

    /**
     * 根据bikeId修改车辆状态
     */
    Boolean updateLockStatus(@Param("status")int status, @Param("bikeInfo")BikeInfo bikeInfo,@Param("user") User user);


    /**
     * 修改车锁状态，同时，让车辆使用次数+1
     */
    Boolean updateLockAndUseCount(@Param("status")int status,@Param("useCount") int useCount,@Param("bikeInfo")BikeInfo bikeInfo);

}
