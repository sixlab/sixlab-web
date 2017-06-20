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

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


/**
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
 */
public class ToolsNote {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String content;
    private Date time;
    private Date begin;
    private Date end;
    private String oneLevel;
    private String twoLevel;

    public int getId () {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent () {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime () {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getBegin () {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd () {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getOneLevel () {
        return oneLevel;
    }

    public void setOneLevel(String oneLevel) {
        this.oneLevel = oneLevel;
    }

    public String getTwoLevel () {
        return twoLevel;
    }

    public void setTwoLevel(String twoLevel) {
        this.twoLevel = twoLevel;
    }

}