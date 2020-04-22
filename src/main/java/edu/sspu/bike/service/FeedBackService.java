package edu.sspu.bike.service;

import edu.sspu.bike.model.FeedBackInfo;
import edu.sspu.bike.service.base.BaseService;

/**
 * @auther 杨亚龙
 * @date 2019/11/20 14:31
 */
public interface FeedBackService extends BaseService<FeedBackInfo> {
    int submitPromble(FeedBackInfo feedBackInfo);
}
