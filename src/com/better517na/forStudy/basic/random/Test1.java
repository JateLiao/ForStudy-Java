/*
 * 文件名：Test1.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test1.java
 * 修改人：tianzhong
 * 修改时间：2016年12月28日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.random;

import java.util.Random;
import java.util.UUID;

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
public class Test1 {


    /**
     * -15~15之间的随机数
     */
    @Test
    public void randomTest1() {
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            //System.out.println(15 - (r.nextInt(30) + 1));
            System.out.println((r.nextInt(15) + 1) * (1 - r.nextInt(3)));
            // System.out.println((r.nextInt(15) + 1) - r.nextInt(30) + 1);
        }
    }
    
    @Test
    public void randomTest2() {
        for (int i = 0; i < 100; i++) {
            System.out.println(UUID.randomUUID());
        }
    }
}
