package cn.sixlab.web.bean;

import java.util.Date;

public class ToolsHisEvent {
    private Integer id;

    private String event;

    private String eventType;

    private Integer keyId;

    private String eventRamark;

    private Date eventDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getEventRamark() {
        return eventRamark;
    }

    public void setEventRamark(String eventRamark) {
        this.eventRamark = eventRamark;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}