package edu.sspu.bike.service;

import edu.sspu.bike.model.BikeInfo;
import edu.sspu.bike.model.EndTrip;
import edu.sspu.bike.model.User;
import edu.sspu.bike.service.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * @auther 杨亚龙
 * @date 2019/11/9 22:36
 */
public interface BikeInfoService extends BaseService<BikeInfo> {
    List<BikeInfo> selectAllBikeInfo();
    Boolean insertOrUpdateBikeInfo(EndTrip endTrip);
    Map selectTotal();

    /**
     * 开锁
     * @param bikeInfo 车辆信息
     * @param user 用户信息
     * @return 开锁成功返回车辆信息，否则返回null
     */
    BikeInfo openLock(BikeInfo bikeInfo, User user);
    /**
     * 关锁
     * @param bikeInfo 车辆信息
     * @param user 用户信息
     * @return 关锁成功返回车辆信息，否则返回null
     */
    BikeInfo closeLock(BikeInfo bikeInfo, User user);
}
