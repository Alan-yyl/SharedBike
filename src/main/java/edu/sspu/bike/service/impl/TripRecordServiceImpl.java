package edu.sspu.bike.service.impl;

import edu.sspu.bike.mapper.TripRecordMapper;
import edu.sspu.bike.model.BikeRecord;
import edu.sspu.bike.model.EndTrip;
import edu.sspu.bike.model.TripRecord;
import edu.sspu.bike.model.User;
import edu.sspu.bike.service.TripRecordService;
import edu.sspu.bike.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther 杨亚龙
 * @date 2019/11/15 23:49
 */
@Service
@Transactional
public class TripRecordServiceImpl extends BaseServiceImpl<BikeRecord> implements TripRecordService {
    @Override
    public Boolean insertTripRecord(EndTrip endTrip) {
        TripRecord tripRecord = new TripRecord(endTrip.getRideDate(), endTrip.getRideTime(), endTrip.getRideDistance(), endTrip.getBikeLongtitude(), endTrip.getBikeLatitude(), endTrip.getSpeed(), endTrip.getStuId(), endTrip.getName());
        if (tripRecordMapper.insertTripRecord(tripRecord) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<TripRecord> selectMyTrip(User user) {
        return tripRecordMapper.selectMyTrip(user);
    }

    @Override
    public BikeRecord findById(String id) {
        return null;
    }

    @Override
    public BikeRecord findById(int id) {
        return null;
    }
}
