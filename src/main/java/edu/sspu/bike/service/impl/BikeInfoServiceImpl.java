package edu.sspu.bike.service.impl;

import edu.sspu.bike.mapper.BikeInfoMapper;
import edu.sspu.bike.model.BikeInfo;
import edu.sspu.bike.model.EndTrip;
import edu.sspu.bike.service.BikeInfoService;
import edu.sspu.bike.service.BikeUseInfoService;
import edu.sspu.bike.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service、Transactional两个注解每一个service类都应该有
 *
 * @auther 杨亚龙
 * @date 2019/11/9 22:37
 */
@Service
@Transactional
public class BikeInfoServiceImpl extends BaseServiceImpl<BikeInfo> implements BikeInfoService {
    @Autowired
    private BikeUseInfoService bikeUseInfoService;

    /**
     * 返回当前可以关锁状态下车辆的经纬度信息
     *
     * @return BikeInfo类型的列表
     */
    @Override
    public List<BikeInfo> selectAllBikeInfo() {
        List<BikeInfo> bikeList = bikeInfoMapper.selectAllBikeInfo();
        List<BikeInfo> reBikeList = new ArrayList<>();     //定义一个返回列表

        for (BikeInfo info : bikeList) {
            //将车锁为关闭的车辆加入返回列表
            if (info.getLockStatus() == 0) {
                BikeInfo bikeInfo = new BikeInfo(info.getBikeId(),info.getBikeLongitude(), info.getBikeLatitude(),info.getLocation());
                reBikeList.add(bikeInfo);
            }
        }
        return reBikeList;
    }

    @Override
    public Boolean insertOrUpdateBikeInfo(EndTrip endTrip) {
        //查看数据库中是否已经存在该车辆
        BikeInfo bikeInfo = new BikeInfo();
        BikeInfo isExist = bikeInfoMapper.findById(endTrip.getBikeId());
        if (isExist != null) {
            //该车存在，做更新操作.更新经纬度信息和使用次数
            Double bikeLongitude = listStringToDouble(endTrip.getBikeLongtitude());
            Double bikeLatitude = listStringToDouble(endTrip.getBikeLatitude());
            bikeInfo.setBikeLongitude(bikeLongitude);
            bikeInfo.setBikeLatitude(bikeLatitude);
            bikeInfo.setUseCount(isExist.getUseCount()+1);
            bikeInfo.setBikeId(isExist.getBikeId());
            //设置锁状态为关闭
            bikeInfo.setLockStatus(0);
            if (bikeInfoMapper.updateBikeInfo(bikeInfo) > 0) {
                return true;
            }
        } else {
            //该车不存在，做插入操作
            bikeInfo.setBikeId(endTrip.getBikeId());
            Double bikeLongitude = listStringToDouble(endTrip.getBikeLongtitude());
            Double bikeLatitude = listStringToDouble(endTrip.getBikeLatitude());
            bikeInfo.setBikeLongitude(bikeLongitude);
            bikeInfo.setBikeLatitude(bikeLatitude);
            System.out.println("BikeInfoServiceImpl.insertOrUpdateBikeInfo"+bikeInfo.getUseCount()+"次数");
            //设置锁状态为关闭
            bikeInfo.setLockStatus(0);
            if (bikeInfoMapper.insertBikeInfo(bikeInfo) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param listString String字符串，格式必须为：[小数,小数,小数]
     * @return Double类型对象数字
     */
    public Double listStringToDouble(String listString) {
        //"[10,20,30,50]"转为"10,20,30,50"
        String numStr = listString.subSequence(1, listString.length() - 1).toString();
        int endIndex = numStr.lastIndexOf(",");
        //获取最后一个“，”后面的字符串，并将其转为double数字
        Double endNum = Double.parseDouble(numStr.subSequence(endIndex + 1, numStr.length()).toString().trim());
        System.out.println(endNum);
        return endNum;
    }

    @Override
    public BikeInfo findById(String id) {
        return null;
    }

    @Override
    public BikeInfo findById(int id) {
        return null;
    }

    /**
     * 查询共享单车的使用总次数和正在骑行的用户数
     * @return 使用总次数
     */
    @Override
    public Map selectTotal() {
        Map total=new HashMap();
        int useTotal= bikeInfoMapper.selectUsingTotal();
        total.put("useTotal",useTotal);
        int userOfBikingTotal=bikeInfoMapper.selectUserOfBikingTotal();
        total.put("userOfBikingTotal",userOfBikingTotal);
        return total;
    }
}
