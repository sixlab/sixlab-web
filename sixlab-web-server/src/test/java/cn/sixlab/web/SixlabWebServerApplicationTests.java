package cn.sixlab.web;

import cn.sixlab.web.schedule.NotifySchedule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SixlabWebServerApplicationTests {

    @Autowired
    private NotifySchedule schedule;

    @Test
    public void contextLoads() {
        schedule.notifyUser();
    }

}
