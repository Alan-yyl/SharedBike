package edu.sspu.bike.service.base;

import edu.sspu.bike.mapper.*;
import edu.sspu.bike.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 统一管理dao
 * @auther 杨亚龙
 * @date 2019/11/4 16:49
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    //统一管理dao
    @Autowired
    protected UserMapper userMapper;
    @Autowired
    protected BikeInfoMapper bikeInfoMapper;
    @Autowired
    protected TripRecordMapper tripRecordMapper;
    @Autowired
    protected BikeUseInfoMapper bikeUseInfoMapper;
    @Autowired
    protected FeedBackInfoMapper feedBackInfoMapper;
}
