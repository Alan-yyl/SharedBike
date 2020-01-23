package edu.sspu.bike.service;

import edu.sspu.bike.model.BikeInfo;
import edu.sspu.bike.model.EndTrip;
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
}
