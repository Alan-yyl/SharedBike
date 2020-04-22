package edu.sspu.bike.service.impl;

import edu.sspu.bike.model.FeedBackInfo;
import edu.sspu.bike.service.FeedBackService;
import edu.sspu.bike.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther 杨亚龙
 * @date 2019/11/20 14:33
 */
@Service
@Transactional
public class FeedBackServiceImpl extends BaseServiceImpl<FeedBackInfo> implements FeedBackService{
    @Override
    public int submitPromble(FeedBackInfo feedBackInfo) {
        System.out.println("FeedBackServiceImpl.submitPromble"+feedBackInfo.toString());
        return feedBackInfoMapper.insertFeedBack(feedBackInfo);
    }

    @Override
    public FeedBackInfo findById(String id) {
        return null;
    }

    @Override
    public FeedBackInfo findById(int id) {
        return null;
    }
}
