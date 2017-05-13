/**
 * @Copyright © Sixlab 2015
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
 * @email <nianqinianyi@163.com>
 */
package cn.sixlab.web.server.util;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
 * @date 2015/6/28 13:38
 */
public class DUtil {
    
    private static String[] tableNames = new String[]{
            "learn_json",
            "sixlab_meta",
            "sixlab_user",
            "tools_code_line",
            "tools_his_event",
            "tools_movie",
            "tools_show",
            "tools_note",
            "tools_record_item",
            "tools_record_val",
            "tools_money_account",
            "tools_money_bill",
    };
    
    private String drive = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/sixlab?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8";
    private String username = "root";
    private String password = "root";
    private String schema = "sixlab";
    
    private String fileHeader = "Sixlab";
    private String classHeader = "Sixlab";
    
    public static void main(String[] args) throws Exception {
        for (String tableName : tableNames) {
            new Thread(() -> {
                try {
                    DUtil d = new DUtil();
                    List<TableColumn> columns = d.getColumnType(tableName);
                    System.out.println(Json.toJson(columns, JsonFormat.nice()));
                    d.genBeanFile(columns, tableName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("end");
    }
    
    public List<TableColumn> getColumnType(String tableName) throws Exception {
        
        Class.forName(drive);
        Connection con = DriverManager.getConnection(url, username, password);
        DatabaseMetaData metaData = con.getMetaData();
        ResultSet rs = metaData.getColumns(null, null, tableName, "%");
        
        List<TableColumn> columnList = new ArrayList<>();
        while (rs.next()) {
            TableColumn column = new TableColumn();
            column.setColumnName(rs.getString("COLUMN_NAME"));
            column.setColumnType(rs.getString("TYPE_NAME"));
            columnList.add(column);
        }
        return columnList;
    }
    
    private void genBeanFile(List<TableColumn> columnType, String tableName) throws IOException {
        StringBuffer javaFile = new StringBuffer();
        String fileName = getCamel(tableName, false);
        
        appendTitle(javaFile);
        
        //javaFile.append("//var " + fileName + " = require('./" + fileName + "');\n");
        //javaFile.append("//models." + fileName + " = " + fileName + "(db);\n");
        javaFile.append("var orm = require('orm');\n\n");
        javaFile.append("var tableName = '" + tableName + "';\n");
        javaFile.append("var obj = {\n");
        
        for (TableColumn tableColumn : columnType) {
            String name = tableColumn.getColumnName();
            String type = tableColumn.getColumnType();
            
            String key = "";
            if ("id".equals(name)) {
                javaFile.append("    id: {type: 'serial', key: true},\n");
                continue;
            }
    
    
            /**
             * text: A text string;
             number: A floating point number. You can specify size: 2|4|8.
             integer: An integer. You can specify size: 2|4|8.
             boolean: A true/false value;
             date: A date object. You can specify time: true
             enum: A value from a list of possible values;
             object: A JSON object;
             point: A N-dimensional point (not generally supported);
             binary: Binary data.
             serial: Auto-incrementing integer. Used for primary keys.
             */
            switch (type) {
                //point
                //enum
                case "INT":
                case "INTEGER":
                    javaFile.append("    " + getCamel(name) + ": {type: 'integer', mapsTo:'"+name+"'},\n");
                    break;
                case "DOUBLE":
                    javaFile.append("    " + getCamel(name) + ": {type: 'number', mapsTo:'" + name +"'},\n");
                    break;
                case "REAL":
                    javaFile.append("    " + getCamel(name) + ": {type: 'boolean', mapsTo:'" + name +"'},\n");
                    break;
                case "DATE":
                case "DATETIME":
                    javaFile.append("    " + getCamel(name) + ": {type: 'date', mapsTo:'" + name +"'},\n");
                    break;
                case "JSON":
                    javaFile.append("    " + getCamel(name) + ": {type: 'object', mapsTo:'" + name +"'},\n");
                    break;
                case "BLOB":
                    javaFile.append("    " + getCamel(name) + ": {type: 'binary', mapsTo:'" + name +"'},\n");
                    break;
                case "TEXT":
                case "CHAR":
                case "VARCHAR":
                    javaFile.append("    " + getCamel(name) + ": {type: 'text', mapsTo:'" + name +"'},\n");
                    break;
                default:
                    javaFile.append("    " + getCamel(name) + ":" + type + ": undefined>>>,\n");
            }
        }
        
        javaFile.append("};\n");
        javaFile.append("var method = {\n");
        javaFile.append("    \n");
        javaFile.append("};\n\n");
        javaFile.append("var Model = function (db) {\n" +
                "    var model = db.define(tableName, obj, method);\n" +
                "    \n" +
                "    return model;\n" +
                "};\n" +
                "\n" +
                "module.exports = Model;");
        String filePath = new File(getClass().getResource("/").getPath()).getParentFile().getParent() + File.separator + "temp" + File.separator + fileName + ".js";
        FileWriter writer = new FileWriter(filePath);
        writer.write(javaFile.toString());
        writer.flush();
        writer.close();
    }
    
    private void appendTitle(StringBuffer javaFile) {
        javaFile.append("/*\n" +
                " * Copyright (c) 2016 Sixlab. All rights reserved.\n" +
                " *\n" +
                " * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).\n" +
                " * see http://www.gnu.org/licenses/gpl-3.0-standalone.html\n" +
                " *\n" +
                " * For more information, please see\n" +
                " * http://sixlab.cn/\n" +
                " */\n");
    }
    
    /**
     * 判断字符串是null或者空字符串
     *
     * @param str 要传入的字符串
     * @return 返回true则{@code str}是null或者空字符串； 返回false则{@code str}既不是null也不是空字符串。
     */
    public static Boolean isEmpty(String str) {
        if (null == str || "".equals(str)) {
            return true;
        }
        return false;
    }
    
    /**
     * 判断字符串既不是null也不是空字符串
     *
     * @param str 要传入的字符串
     * @return 返回true则{@code str}既不是null也不是空字符串； 返回false则{@code str}是null或者空字符串。
     */
    public static Boolean isNotEmpty(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        return true;
    }
    
    /**
     * 把一个字符串中的大写转为小写，小写不变
     *
     * @param str 被转化的字符串
     * @return 结果
     */
    public static String lowerCase(String str) {
        if (isEmpty(str)) {
            return str;
        }
        
        char[] buffer = str.toCharArray();
        
        for (int i = 0; i < buffer.length; i++) {
            char ch = buffer[i];
            if (Character.isUpperCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);
            } else if (Character.isTitleCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);
            }
        }
        return new String(buffer);
    }
    
    /**
     * 把一个字符串中的大写转为小写，小写转换为大写
     *
     * @param str 被转化的字符串
     * @return 结果
     */
    public static String swapCase(String str) {
        if (isEmpty(str)) {
            return str;
        }
        
        char[] buffer = str.toCharArray();
        
        for (int i = 0; i < buffer.length; i++) {
            char ch = buffer[i];
            if (Character.isUpperCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);
            } else if (Character.isTitleCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                buffer[i] = Character.toUpperCase(ch);
            }
        }
        return new String(buffer);
    }
    
    /**
     * 判断字符串既不是null也不是空字符串
     *
     * @param ulStr 下划线分割的字符串
     * @return 返回驼峰命名法的字符串，首字母小写。
     */
    public static String getCamel(String ulStr) {
        return getCamel(ulStr, true);
    }
    
    /**
     * 判断字符串既不是null也不是空字符串
     *
     * @param ulStr        下划线分割的字符串
     * @param isFirstLower 首字母是否小写
     * @return 返回驼峰命名法的字符串，@{code isFirstCapital}为true，则首字母也是大写，否则首字母小写。
     */
    public static String getCamel(String ulStr, boolean isFirstLower) {
        StringBuffer result = new StringBuffer();
        
        String[] ulArray = ulStr.split("_");
        
        boolean isFirst = true;
        for (String s : ulArray) {
            if (isNotEmpty(s)) {
                s = lowerCase(s);
                if (isFirst && isFirstLower) {
                    result.append(s);
                    isFirst = false;
                } else {
                    result.append(swapCase(s.substring(0, 1))).append(s.substring(1, s.length()));
                }
            }
        }
        
        return result.toString();
    }
    
    private class TableColumn {
        private String columnName;
        private String columnType;
        
        public String getColumnName() {
            return columnName;
        }
        
        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }
        
        public String getColumnType() {
            return columnType;
        }
        
        public void setColumnType(String columnType) {
            this.columnType = columnType;
        }
    }
}
