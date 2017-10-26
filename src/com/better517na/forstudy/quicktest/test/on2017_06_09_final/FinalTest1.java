/*
 * 文件名：FinalTest1.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： FinalTest1.java
 * 修改人：tianzhong
 * 修改时间：2017年6月9日
 * 修改内容：新增
 */
package com.better517na.forstudy.quicktest.test.on2017_06_09_final;

import java.util.ArrayList;
import java.util.List;

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
public class FinalTest1 {
    
    public static final InnerTest INNER = new InnerTest();
    
    public void finalTest(){
        // inner = new InnerTest();
        
        INNER.cox = 5;
        INNER.sin = "sin";
        INNER.vals = new ArrayList<>();
    }
}

class InnerTest {
    Integer cox;
    
    String sin;
    
    List<String> vals;
}
