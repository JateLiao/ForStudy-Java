/*
 * 文件名：SortTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SortTest.java
 * 修改人：tianzhong
 * 修改时间：2017年8月3日
 * 修改内容：新增
 */
package com.better517na.forstudy.frameworks.apache.commons.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

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
public class SortTest {

    /**
     * TODO 添加方法注释.
     * 
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Comparator<?> cmp = ComparableComparator.getInstance();
        // cmp = ComparatorUtils.reversedComparator(cmp);
        
        List<Model> list = new ArrayList<>();
        list.add(new Model("2017-08-03 16:55:51"));
        list.add(new Model("2017-08-03 16:55:21"));
        list.add(new Model("2017-08-03 16:55:41"));
        list.add(new Model("2017-08-03 16:55:11"));
        list.add(new Model("2017-08-03 16:55:01"));
        
        System.out.println("Before Sort: " + list);
        
        List<Object> sortFileds = new ArrayList<>();
        sortFileds.add(new BeanComparator("dateStr", cmp));
        
        // 创建一个排序链  
        ComparatorChain multiSort = new ComparatorChain(sortFileds);
        
        // 开始真正的排序，按照先主，后副的规则  
        Collections.sort(list, multiSort);
            
        System.out.println("After Sort: " + list);
    }

}
