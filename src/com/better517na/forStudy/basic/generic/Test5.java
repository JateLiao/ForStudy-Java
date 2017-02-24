/*
 * 文件名：Test5.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test5.java
 * 修改人：tianzhong
 * 修改时间：2016年6月2日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.generic;

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
public class Test5 {

    public static void main(String[] args) {
        /** 不指定泛型的时候 */
        int i = Test5.add(1, 2); // 这两个参数都是Integer，所以T为Integer类型
        System.out.println(i);
        Number f = Test5.add(1, 1.2);// 这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Number
        System.out.println(f);
        Object o = Test5.add(1, "asd");// 这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Object
        System.out.println(o);

        /** 指定泛型的时候 */
        int a = Test5.<Integer> add(1, 2);// 指定了Integer，所以只能为Integer类型或者其子类
        System.out.println(a);
        // int b = Test5.<Integer> add(1, 2.2);// 编译错误，指定了Integer，不能为Float
        Number c = Test5.<Number> add(1, 2.2); // 指定为Number，所以可以为Integer和Float
        System.out.println(c);
    }

    public static <T> T add(T x, T y) {
        return y;
    }

}
