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
public class ToolsShow {

    @Id
    @GeneratedValue
    private int id;
    private String showName;
    private int showSeason;
    private int showEpisode;
    private String showStatus;
    private String viewStatus;
    private String tv;
    private String remark;
    private String doubanKey;
    private Date beginDate;
    private Date finishDate;
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