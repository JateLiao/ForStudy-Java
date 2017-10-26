/*
 * 文件名：Test4.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test4.java
 * 修改人：tianzhong
 * 修改时间：2016年12月12日
 * 修改内容：新增
 */
package com.better517na.forstudy.basic.on2016_12_12_valuepass_preferencepass;

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
public class Test4 {

    class Park {
        String name;
        Boolean boolVal;
    }
    
    public void swap(Park p1, Park p2){
        Park p = p1;
        p1 = p2;
        p2 = p;
    }
    
    @Test
    public void test1(){
        Park p1 = new Park();
        Park p2 = new Park();
        
        System.out.println("p1:" + p1 + ", p2:" + p2);
        swap(p1, p2);
        System.out.println("p1:" + p1 + ", p2:" + p2);
    }

    
    public void changeVal(Park p){
        // p = new Park();
        p.name = "new park";
        p.boolVal = true;
    }
    @Test
    public void test2(){
        Park p = new Park();
        p.name = "ori park";
        p.boolVal = false;
        
        changeVal(p);
        
        System.out.println(p.name);
        System.out.println(p.boolVal);
    }
}
