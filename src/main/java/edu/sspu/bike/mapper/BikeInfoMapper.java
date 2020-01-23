package edu.sspu.bike.mapper;

import edu.sspu.bike.mapper.base.BaseMapper;
import edu.sspu.bike.model.BikeInfo;
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
    int updateBikeInfo(BikeInfo bikeInfo);

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
    Boolean updateLockStatus(@Param("status")int status, @Param("bikeId")String bikeId);

}
