package com.ztesoft.rail;

import com.ztesoft.rail.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication {

    @Autowired
    private HailwayLineService hailwayLineService;
    @Autowired
    private UserService userService;
    @Autowired
    private SceneMonitorService sceneMonitorService;
    @Autowired
    private IQuotaVoltePageService iq;

    @Test
    public void contextLoads() {
//        List<IndexEntity> list = new ArrayList<IndexEntity>();
//        list = hailwayLineService.getIndexByHailwayLine("df","af","af");
//        System.out.println(list);

//        ResultMsg resultMsg = new ResultMsg();
//        resultMsg = userService.getUserByUserName("admi1","Admin1");
//        System.out.println(resultMsg.getStatus()+""+resultMsg.getMsg());

//        ResultMsg resultMsg = new ResultMsg();
//        resultMsg = sceneMonitorService.getUserChange("2018-08-15 08");
        List<Map<Object,Object>> list = iq.getInfoByQuota("X2_IND1","2018-09-27 08","1");

    }
}
