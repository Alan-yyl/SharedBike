package edu.sspu.bike.mapper;

import edu.sspu.bike.model.BikeUseInfo;
import edu.sspu.bike.model.Reservation;

import java.util.List;

/**
 * @auther 杨亚龙
 * @date 2019/11/16 14:16
 */
public interface BikeUseInfoMapper{
    int insertBikeUseInfo(BikeUseInfo bikeUseInfo);
    List<BikeUseInfo> selectBikeUseInfo();
    Boolean reserveBike(Reservation reservation);
}
