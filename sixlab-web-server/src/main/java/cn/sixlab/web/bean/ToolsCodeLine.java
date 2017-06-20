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
public class ToolsCodeLine {

    @Id
    @GeneratedValue
    private int id;
    private Date checkDate;
    private int allNum;
    private int codeNum;
    private String codeType;

    public int getId () {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckDate () {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public int getAllNum () {
        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    public int getCodeNum () {
        return codeNum;
    }

    public void setCodeNum(int codeNum) {
        this.codeNum = codeNum;
    }

    public String getCodeType () {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

}