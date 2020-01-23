package edu.sspu.bike.service;

import edu.sspu.bike.mapper.BikeUseInfoMapper;
import edu.sspu.bike.model.BikeUseInfo;
import edu.sspu.bike.model.EndTrip;
import edu.sspu.bike.model.Reservation;
import edu.sspu.bike.service.base.BaseService;
import edu.sspu.bike.service.base.BaseServiceImpl;

import java.util.List;

/**
 * @auther 杨亚龙
 * @date 2019/11/16 14:23
 */
public interface BikeUseInfoService extends BaseService<BikeUseInfo> {
    boolean insertBikeUseRecord(EndTrip endTrip);
    List<BikeUseInfo> selcetBikeUseInfo();
    Boolean reserveBike(Reservation reservation);
}
