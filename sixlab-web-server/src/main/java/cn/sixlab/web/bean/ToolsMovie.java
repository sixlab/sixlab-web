/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ToolsMovie {

    @Id
    @GeneratedValue
    private Integer id;
    private String movieName;
    private String produceYear;
    private String director;
    private String remark;
    private Date viewDate;
    private String doubanKey;
    private Double doubanScore;
    private String doubanInfo;
    private String infoStatus;

    public Integer getId () {
        return id;
    }

    public void setId(Integer id) {
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

    public Double getDoubanScore () {
        return doubanScore;
    }

    public void setDoubanScore(Double doubanScore) {
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