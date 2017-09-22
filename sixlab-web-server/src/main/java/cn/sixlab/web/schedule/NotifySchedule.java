/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/9/21 22:11
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.schedule;

import cn.sixlab.web.bean.LabNotify;
import cn.sixlab.web.dao.LabNotifyDao;
import cn.sixlab.web.service.WxService;
import cn.sixlab.web.util.ConfigVal;
import cn.sixlab.web.util.JsonUtl;
import cn.sixlab.web.util.WxMpMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Component
public class NotifySchedule {

    @Autowired
    private LabNotifyDao labNotifyDao;
    @Autowired
    private WxService wxService;
    @Autowired
    private ConfigVal configVal;

    @Scheduled(cron = "0 0 6,18 * * ? ")
    public void notifyUser() {
        LabNotify example = new LabNotify();
        example.setActive(true);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("active", ExampleMatcher.GenericPropertyMatchers.exact());
        List<LabNotify> notifyList = labNotifyDao.findAll(Example.of(example, matcher));
        System.out.println(JsonUtl.toJSon(notifyList));

        LocalDate today = LocalDate.now();
        if (null!=notifyList && notifyList.size()>1) {
            for (LabNotify labNotify : notifyList) {
                if(today.isBefore(labNotify.getRepeatFinish())){

                    int day = 0;
                    switch (labNotify.getRepeatType()){
                        case Calendar.DAY_OF_MONTH:
                            day = today.getDayOfMonth();
                            break;
                        case Calendar.DAY_OF_WEEK:
                            day = today.getDayOfWeek().getValue();
                            break;
                    }

                    if(labNotify.getRepeatTime().contains(","+day+",")){
                        String wxAccessToken = wxService.getToken();
                        String myOpenId = configVal.getWxMyOpenId();

                        WxMpMessage.sendCustomTextMsg(wxAccessToken,myOpenId, labNotify.getNotifyName()+"\n"+labNotify.getNotifyDetail());
                    }
                }else{
                    labNotify.setActive(false);
                    labNotifyDao.save(labNotify);
                }
            }
        }
    }
}
