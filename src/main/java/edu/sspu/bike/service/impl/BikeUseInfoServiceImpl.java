package edu.sspu.bike.service.impl;

import edu.sspu.bike.model.BikeUseInfo;
import edu.sspu.bike.model.EndTrip;
import edu.sspu.bike.model.Reservation;
import edu.sspu.bike.service.BikeUseInfoService;
import edu.sspu.bike.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther 杨亚龙
 * @date 2019/11/16 14:24
 */
@Service
@Transactional
public class BikeUseInfoServiceImpl extends BaseServiceImpl<BikeUseInfo> implements BikeUseInfoService {
    @Override
    public boolean insertBikeUseRecord(EndTrip endTrip) {
        //将经纬度字符串转为double类型
        double bikeLongitude=listStringToDouble(endTrip.getBikeLongtitude());
        double bikeLatitude=listStringToDouble(endTrip.getBikeLongtitude());
        //构造车辆使用信息
        BikeUseInfo bikeUseInfo = new BikeUseInfo(endTrip.getStuId(), endTrip.getName(), endTrip.getBikeId(),bikeLongitude,bikeLatitude);
        System.out.println("BikeUseInfoServiceImpl.insertBikeUseRecord"+bikeUseInfo.toString());
        //插入车辆使用记录
        if (bikeUseInfoMapper.insertBikeUseInfo(bikeUseInfo) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
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
    public List<BikeUseInfo> selcetBikeUseInfo() {
        List<BikeUseInfo> useInfoList = bikeUseInfoMapper.selectBikeUseInfo();
        return useInfoList;
    }

    @Override
    public Boolean reserveBike(Reservation reservation) {
        //向车辆预约表中插入信息
        System.out.println("BikeUseInfoServiceImpl.reserveBike"+reservation.getBikeId());
        return bikeUseInfoMapper.reserveBike(reservation)&& bikeInfoMapper.updateLockStatus(2, reservation.getBikeId());
    }

    @Override
    public BikeUseInfo findById(String id) {
       return null;
    }

    @Override
    public BikeUseInfo findById(int id) {
        return null;
    }
}
