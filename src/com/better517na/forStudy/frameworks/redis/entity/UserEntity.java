/*
 * 文件名：UserEntity.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserEntity.java
 * 修改人：tianzhong
 * 修改时间：2017年8月15日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.redis.entity;

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
public class UserEntity {
    /**
     * 添加字段注释.
     */
    private String uaserName;

    /**
     * 添加字段注释.
     */
    private String userNo;

    /**
     * 设置uaserName.
     * 
     * @return 返回uaserName
     */
    public String getUaserName() {
        return uaserName;
    }

    /**
     * 获取uaserName.
     * 
     * @param uaserName
     *            要设置的uaserName
     */
    public void setUaserName(String uaserName) {
        this.uaserName = uaserName;
    }

    /**
     * 设置userNo.
     * 
     * @return 返回userNo
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 获取userNo.
     * 
     * @param userNo
     *            要设置的userNo
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
