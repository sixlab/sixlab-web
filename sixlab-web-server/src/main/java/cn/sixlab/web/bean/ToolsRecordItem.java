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

import javax.persistence.Id;

import javax.persistence.GeneratedValue;


/**
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
 */
public class ToolsRecordItem {

    @Id
    @GeneratedValue
    private int id;
    private String itemName;
    private int itemOrder;
    private String isDel;
    private String remark;

    public int getId () {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName () {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemOrder () {
        return itemOrder;
    }

    public void setItemOrder(int itemOrder) {
        this.itemOrder = itemOrder;
    }

    public String getIsDel () {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}