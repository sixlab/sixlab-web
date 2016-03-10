package cn.sixlab.web.bean;

import java.util.Date;

public class ToolsRecordVal {
    private Integer id;

    private Integer itemId;

    private Date recordDate;

    private String recordVal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordVal() {
        return recordVal;
    }

    public void setRecordVal(String recordVal) {
        this.recordVal = recordVal;
    }
}