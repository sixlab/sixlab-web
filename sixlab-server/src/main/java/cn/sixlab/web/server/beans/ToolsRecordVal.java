/*
 * Copyright (c) 1995 Sixlab. All rights reserved.
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

@Table("tools_record_val")

/**
 * @author 六楼的雨/Patrick Root
 * @since 2.0.0
 */
public class ToolsRecordVal {

    @Id
    private int id;
    @Column("item_id")
    private int itemId;
    @Column("record_date")
    private Date recordDate;
    @Column("record_val")
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