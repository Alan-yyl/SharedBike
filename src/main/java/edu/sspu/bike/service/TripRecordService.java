package edu.sspu.bike.service;

import edu.sspu.bike.model.BikeRecord;
import edu.sspu.bike.model.EndTrip;
import edu.sspu.bike.model.TripRecord;
import edu.sspu.bike.model.User;
import edu.sspu.bike.service.base.BaseService;

import java.util.List;

/**
 * @auther 杨亚龙
 * @date 2019/11/15 23:47
 */
public interface TripRecordService extends BaseService<BikeRecord> {
    Boolean insertTripRecord(EndTrip endTrip);
    List<TripRecord> selectMyTrip(User user);
}
