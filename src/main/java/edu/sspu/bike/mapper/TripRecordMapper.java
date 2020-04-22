package edu.sspu.bike.mapper;

import edu.sspu.bike.model.TripRecord;
import edu.sspu.bike.model.User;

import java.util.List;

/**
 * @auther 杨亚龙
 * @date 2019/11/15 23:26
 */
public interface TripRecordMapper {
    int insertTripRecord(TripRecord tripRecord);
    List<TripRecord> selectMyTrip(User user);
}
