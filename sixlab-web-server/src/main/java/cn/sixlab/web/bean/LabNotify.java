/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/9/21 22:06
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class LabNotify {
    @Id
    @GeneratedValue
    private Integer id;
    private String notifyName;
    private String notifyDetail;
    private Integer repeatType;
    private String repeatTime;
    private Boolean active;
    private LocalDate repeatFinish;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotifyName() {
        return notifyName;
    }

    public void setNotifyName(String notifyName) {
        this.notifyName = notifyName;
    }

    public String getNotifyDetail() {
        return notifyDetail;
    }

    public void setNotifyDetail(String notifyDetail) {
        this.notifyDetail = notifyDetail;
    }

    public Integer getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(Integer repeatType) {
        this.repeatType = repeatType;
    }

    public String getRepeatTime() {
        return repeatTime;
    }

    public void setRepeatTime(String repeatTime) {
        this.repeatTime = repeatTime;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getRepeatFinish() {
        return repeatFinish;
    }

    public void setRepeatFinish(LocalDate repeatFinish) {
        this.repeatFinish = repeatFinish;
    }
}
