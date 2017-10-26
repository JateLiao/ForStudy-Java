/*
 * 文件名：Test6.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test6.java
 * 修改人：tianzhong
 * 修改时间：2016年6月3日
 * 修改内容：新增
 */
package com.better517na.forstudy.basic.generic;

import java.util.ArrayList;
import java.util.List;

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
public class Test6 {
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("123");
        // list1.add(123); // 此处报错

        List list2 = new ArrayList<String>();
        list2.add("123");
        list2.add(123);

        List list3 = new ArrayList();
        list3.add("123");
        list3.add(123);
    }
}
