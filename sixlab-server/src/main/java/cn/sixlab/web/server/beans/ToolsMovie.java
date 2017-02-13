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

@Table("tools_movie")

/**
 * @author 六楼的雨/Patrick Root
 */
public class ToolsMovie {

    @Id
    private int id;
    @Column("movie_name")
    private String movieName;
    @Column("produce_year")
    private String produceYear;
    @Column("director")
    private String director;
    @Column("remark")
    private String remark;
    @Column("view_date")
    private Date viewDate;
    @Column("douban_key")
    private String doubanKey;
    @Column("douban_score")
    private double doubanScore;
    @Column("douban_info")
    private String doubanInfo;
    @Column("info_status")
    private String infoStatus;

    public int getId () {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName () {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getProduceYear () {
        return produceYear;
    }

    public void setProduceYear(String produceYear) {
        this.produceYear = produceYear;
    }

    public String getDirector () {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getViewDate () {
        return viewDate;
    }

    public void setViewDate(Date viewDate) {
        this.viewDate = viewDate;
    }

    public String getDoubanKey () {
        return doubanKey;
    }

    public void setDoubanKey(String doubanKey) {
        this.doubanKey = doubanKey;
    }

    public double getDoubanScore () {
        return doubanScore;
    }

    public void setDoubanScore(double doubanScore) {
        this.doubanScore = doubanScore;
    }

    public String getDoubanInfo () {
        return doubanInfo;
    }

    public void setDoubanInfo(String doubanInfo) {
        this.doubanInfo = doubanInfo;
    }

    public String getInfoStatus () {
        return infoStatus;
    }

    public void setInfoStatus(String infoStatus) {
        this.infoStatus = infoStatus;
    }

}