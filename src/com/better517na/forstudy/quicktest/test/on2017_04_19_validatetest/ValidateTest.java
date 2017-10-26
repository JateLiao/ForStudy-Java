/*
 * 文件名：ValidateTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ValidateTest.java
 * 修改人：tianzhong
 * 修改时间：2017年4月19日
 * 修改内容：新增
 */
package com.better517na.forstudy.quicktest.test.on2017_04_19_validatetest;

import org.junit.Test;

import util.CommonCheckUtils;

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
public class ValidateTest {

    @Test
    public void test1() {
        Integer ints  = 10;
        CommonCheckUtils.notNullValidateForName(ints);
        
        Model m = new Model();
        m.setDesc("desc描述");
        m.setId("id编码");

        System.out.println(CommonCheckUtils.notNullValidateForName(m));
    }

}
