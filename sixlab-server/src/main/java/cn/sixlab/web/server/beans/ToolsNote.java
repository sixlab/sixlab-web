/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 */
package cn.sixlab.web.server.beans;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

@Table("tools_note")

/**
 * @author 六楼的雨/Patrick Root
 */
public class ToolsNote {

    @Id
    private int id;
    @Column("title")
    private String title;
    @Column("content")
    private String content;
    @Column("time")
    private Date time;
    @Column("begin")
    private Date begin;
    @Column("end")
    private Date end;
    @Column("one_level")
    private String oneLevel;
    @Column("two_level")
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