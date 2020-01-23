package edu.sspu.bike.web.controller;

import edu.sspu.bike.model.FeedBackInfo;
import edu.sspu.bike.model.ResultInfo;
import edu.sspu.bike.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.transform.Result;

/**
 * @auther 杨亚龙
 * @date 2019/11/20 14:23
 */
@Controller
@RequestMapping("/feedback")
public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;

    @RequestMapping("/question")
    public @ResponseBody
    ResultInfo feedBack(@RequestBody FeedBackInfo feedBackInfo){
        System.out.println("FeedBackController.feedBack"+feedBackInfo);
        ResultInfo info=new ResultInfo();
        info.setFlag(false);
        if (feedBackService.submitPromble(feedBackInfo)==1){
            info.setFlag(true);
        }
        return info;
    }
}
