/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 */
package cn.sixlab.web.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import java.util.Date;

/**
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
 */
@Entity
public class ToolsHisEvent {

    @Id
    @GeneratedValue
    private int id;
    private String event;
    private String eventType;
    private int keyId;
    private String eventRemark;
    private Date eventDate;

    public int getId () {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent () {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventType () {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getKeyId () {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    public String getEventRemark () {
        return eventRemark;
    }

    public void setEventRemark(String eventRemark) {
        this.eventRemark = eventRemark;
    }

    public Date getEventDate () {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

}