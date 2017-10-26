/*
 * 文件名：Test3.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test3.java
 * 修改人：tianzhong
 * 修改时间：2016年2月1日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.reflect.on2016_2_1;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * TODO 获取一个类的方法详情：参数类型，异常.
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
public class Test3_获取一个类的方法详情 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.better517na.forStudy.advanced.reflect.on2016_2_1.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Method method[] = demo.getMethods();
        for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType(); // 返回值类型
            Class<?> para[] = method[i].getParameterTypes(); // 参数类型
            int temp = method[i].getModifiers(); // 访问权限
            System.out.print(Modifier.toString(temp) + "-->" + returnType.getName() + "-->" + method[i].getName() + " ");
            System.out.print("(");
            // 获取参数
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }

            // 获取异常
            Class<?> exce[] = method[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(")-->throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }

            System.out.println();
        }
    }
}
