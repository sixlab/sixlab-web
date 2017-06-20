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
public class ToolsRecordVal {

    @Id
    @GeneratedValue
    private int id;
    private int itemId;
    private Date recordDate;
    private String recordVal;

    public int getId () {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId () {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Date getRecordDate () {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordVal () {
        return recordVal;
    }

    public void setRecordVal(String recordVal) {
        this.recordVal = recordVal;
    }

}