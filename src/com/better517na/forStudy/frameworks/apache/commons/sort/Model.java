/*
 * 文件名：Model.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Model.java
 * 修改人：tianzhong
 * 修改时间：2017年8月3日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.apache.commons.sort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO 添加类的一句话简单描述.
 * <p>
 * TODO 详细描述
 * <p>
 * TODO 示例代码
 * 
 * <pre>
 * </pre>
 * 
 * @author tianzhong
 */
/**
 * @author tianzhong
 *
 */
public class Model {
    /**
     * 添加字段注释.
     */
    private SimpleDateFormat sdf = null;

    /**
     * 添加字段注释.
     */
    private Date date;

    /**
     * 添加字段注释.
     */
    private String dateStr;

    /**
     * 构造函数.
     * 
     */
    public Model() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 构造函数.
     * 
     */
    public Model(String dateStr) {
        this.dateStr = dateStr;
        if (null == sdf) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        try {
            this.date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String toString() {
        if (null == sdf) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.date);
    }

    /**
     * 设置dateStr.
     * 
     * @return 返回dateStr
     */
    public String getDateStr() {
        return dateStr;
    }

    /**
     * 获取dateStr.
     * 
     * @param dateStr
     *            要设置的dateStr
     */
    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    /**
     * 设置date.
     * 
     * @return 返回date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 获取date.
     * 
     * @param date
     *            要设置的date
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
