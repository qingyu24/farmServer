package com.fngame.farm.controller;

import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Tian
 * @Description：
 * @Date:Created in 16:45 2018/1/3
 * @Modified By:
 */
@RestController
@RequestMapping(value="/carinfo")
public class CarInfoController {

    @Autowired
    private ResultInfo resultInfo;

    /**
     *@Author:Tian
     *@Description:获取车库列表
     *@Date: 16:47 2018/1/3
     */
    @GetMapping(value="/getCarInfo")
    public ResultInfo getCarInfoByUserId(RequserOrder requsetOrder, @RequestParam("userid") Long userid){
        resultInfo.setOrder(requsetOrder);
        return resultInfo;
    }

    /**
     *@Author:Tian
     *@Description:获取一辆车的详细信息（包括车辆信息，点赞数，留言板）
     *@Date: 16:50 2018/1/3
     */
    @GetMapping(value="/getOneCarInfo")
    public ResultInfo getOneCarInfo(RequserOrder requsetOrder,
                                    @RequestParam("userid") Long userid,//请求的玩家id
                                    @RequestParam("carinfoid") Long carinfoid//请求的车辆信息id

    ){
        resultInfo.setOrder(requsetOrder);
        return resultInfo;
    }
    
    /**
     *@Author:Tian
     *@Description:添加车辆,需判断车辆最值
     *@Date: 17:01 2018/1/3
     */
    @GetMapping(value="/addCarInfo")
    public ResultInfo addNewCarInfo(RequserOrder requsetOrder,
                                    @RequestParam("userid") Long userid,//请求添加车辆的玩家id
                                    @RequestParam("carid") Integer carid//请求添加的车辆id

    ){
        resultInfo.setOrder(requsetOrder);
        return resultInfo;
    }

    /**
     *@Author:Tian
     *@Description:放出车辆，更改车辆状态：放出车辆需判断放出车辆总数
     *@Date: 17:06 2018/1/3
     */
    @GetMapping(value="/parkingCar")
    public ResultInfo parkingCar(RequserOrder requsetOrder,
                                 @RequestParam("userid") Long userid,//请求放出车辆的玩家id
                                 @RequestParam("carinfoid") Long carinfoid//请求放出的车辆信息id
    ){
        resultInfo.setOrder(requsetOrder);
        return resultInfo;
    }

    /**
     *@Author:Tian
     *@Description:给车辆点赞:每个玩家只能对另一个玩家的一辆车点赞一次，点赞不可取消
     *@Date: 17:12 2018/1/3
     */
    @GetMapping(value="/likeingCar")
    public ResultInfo likeingCar(RequserOrder requsetOrder,
                                 @RequestParam("userid") Long userid,//点赞的玩家
                                 @RequestParam("carinfoid") Long carinfoid//被点赞的车辆信息id
    ){
        resultInfo.setOrder(requsetOrder);
        return resultInfo;
    }

    /**
     *@Author:Tian
     *@Description:留言
     *@Date: 17:14 2018/1/3
     */
    @PutMapping(value="/leaveMessage")
    public ResultInfo leaveMessage(RequserOrder requsetOrder,
                                   @RequestParam("carinfoid") Long carinfoid,//被留言的车辆信息id
                                   @RequestParam("fromUserid") Long fromUserid,//留言的玩家
                                   @RequestParam("toUserid") Long toUserid,//被留言的玩家
                                   @RequestParam("content") String content//留言内容
    ){
        resultInfo.setOrder(requsetOrder);
        return resultInfo;
    }

    /**
     *@Author:Tian
     *@Description:删除单条留言，只能由主人删除评论
     *@Date: 17:32 2018/1/3
     */
    @GetMapping(value="/deleteMessage")
    public ResultInfo deleteMessage(RequserOrder requsetOrder,
                                    @RequestParam("userid") Long userid,//请求删除的玩家id
                                    @RequestParam("msgid") Long msgid//被删除的评论id
    ){
        resultInfo.setOrder(requsetOrder);
        return resultInfo;
    }

}
