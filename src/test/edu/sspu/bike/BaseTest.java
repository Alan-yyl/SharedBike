package edu.sspu.bike;

import edu.sspu.bike.mapper.TripRecordMapper;
import edu.sspu.bike.mapper.UserMapper;
import edu.sspu.bike.model.Reservation;
import org.junit.Test;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

/**
 * @auther 杨亚龙
 * @date 2019/11/14 18:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class BaseTest {
    private static Logger logger = Logger.getLogger(BaseTest.class);
    @Resource
    private UserMapper userMapper;
    @Resource
    private TripRecordMapper tripRecordMapper;
    @Test
    public void find(){
       Boolean user=userMapper.register("20154", "亚龙", "1526",1);
       logger.info(user);
    }
    // @Test
    public void testModel(){

    }

}
