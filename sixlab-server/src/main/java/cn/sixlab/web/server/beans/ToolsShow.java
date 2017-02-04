/*
<<<<<<< HEAD
 * Copyright (c) 2016 Sixlab. All rights reserved.
=======
 * Copyright (c) 1995 Sixlab. All rights reserved.
>>>>>>> 初始化网站后台项目 sixlab-server
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
<<<<<<< HEAD
 * https://sixlab.cn/
=======
 * http://sixlab.cn/
>>>>>>> 初始化网站后台项目 sixlab-server
 */
package cn.sixlab.web.server.beans;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

@Table("tools_show")

/**
<<<<<<< HEAD
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
=======
 * @author 六楼的雨/Patrick Root
 * @since 2.0.0
>>>>>>> 初始化网站后台项目 sixlab-server
 */
public class ToolsShow {

    @Id
    private int id;
    @Column("show_name")
    private String showName;
    @Column("show_season")
    private int showSeason;
    @Column("show_episode")
    private int showEpisode;
    @Column("show_status")
    private String showStatus;
    @Column("view_status")
    private String viewStatus;
    @Column("tv")
    private String tv;
    @Column("remark")
    private String remark;
    @Column("douban_key")
    private String doubanKey;
    @Column("begin_date")
    private Date beginDate;
    @Column("finish_date")
    private Date finishDate;
    @Column("update_date")
    private Date updateDate;

    public int getId () {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShowName () {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public int getShowSeason () {
        return showSeason;
    }

    public void setShowSeason(int showSeason) {
        this.showSeason = showSeason;
    }

    public int getShowEpisode () {
        return showEpisode;
    }

    public void setShowEpisode(int showEpisode) {
        this.showEpisode = showEpisode;
    }

    public String getShowStatus () {
        return showStatus;
    }

    public void setShowStatus(String showStatus) {
        this.showStatus = showStatus;
    }

    public String getViewStatus () {
        return viewStatus;
    }

    public void setViewStatus(String viewStatus) {
        this.viewStatus = viewStatus;
    }

    public String getTv () {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDoubanKey () {
        return doubanKey;
    }

    public void setDoubanKey(String doubanKey) {
        this.doubanKey = doubanKey;
    }

    public Date getBeginDate () {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getFinishDate () {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Date getUpdateDate () {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}