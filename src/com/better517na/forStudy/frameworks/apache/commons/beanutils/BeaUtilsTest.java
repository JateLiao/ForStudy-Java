/*
 * 文件名：BeaUtilsTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： BeaUtilsTest.java
 * 修改人：tianzhong
 * 修改时间：2017年8月4日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.apache.commons.beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/**
 * TODO 添加类的一句话简单描述.
 * <p>
 * TODO 详细描述
 * <p>
 * TODO 示例代码
 * <pre>
 * </pre>
 * 
 * @author     tianzhong
 */
public class BeaUtilsTest {
    
    @Test
    public void cloneTest() throws Exception{
        TmpClass tmp = new  TmpClass();
        tmp.setTmpInfo("tmpInfo");
        BeanModel moden = new BeanModel("id", "name", 24, 183, "desc", tmp);
        System.out.println(moden.toString());
        
        // 被克隆的Bean必须具备一个无参构造方法（默认的构造方法也可以，但是在具备有参构造方法是必须同时具备无参构造方法）
        // 该方法是浅复制
        BeanModel newModel = (BeanModel) BeanUtils.cloneBean(moden);
        System.out.println(newModel.toString());
        
        moden.getTmp().setTmpInfo("new tmp info...");
        System.out.println(newModel.getTmp().getTmpInfo());
        
        System.out.println(moden.getTmp().getTmpInfo());
    }
}
