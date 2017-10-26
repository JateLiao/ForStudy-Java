/*
 * 文件名：Test2.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test2.java
 * 修改人：tianzhong
 * 修改时间：2016年12月22日
 * 修改内容：新增
 */
package com.better517na.forstudy.quicktest;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

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
public class Test2 {

    @Test
    public void test1(){
        int n = 11;
        int[][] a = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            a[i][0] = 0;
            if (i < 1) {
                continue;
            }
            for (int j = 0; j <= i; j++) {
                if (i > 0 && i == j) {
                    a[i][j] = 1;
                    break;
                }
                if (i > 1 && j > 0) {
                    a[i][j] = a[i-1][j-1] + a[i-1][j];
                    if (a[i-1][j-1] == 0) {
                        a[i][j] += 1;
                    }
                }
            } 
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(String.format("%-4d", a[i][j]));
            }
            System.out.println();
        }
    }
    
    
    @Test
    public void test2(){

        int n = 11;
        int[][] a = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            a[i][0] = 1;
            if (i < 1) {
                continue;
            }
            for (int j = 0; j <= i; j++) {
                if (i > 0 && i == j) {
                    a[i][j] = 1;
                    break;
                }
                if (i > 1 && j > 0) {
                    a[i][j] = a[i-1][j-1] + a[i-1][j];
                }
            } 
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(String.format("%-4d", a[i][j]));
            }
            System.out.println();
        }
    
    }
    
    @Test
    public void test3(){
        BeanUtils.copyProperties(null, null);
    }
}
