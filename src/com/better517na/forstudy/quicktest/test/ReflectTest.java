/*
 * 文件名：ReflectTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ReflectTest.java
 * 修改人：tianzhong
 * 修改时间：2016年7月14日
 * 修改内容：新增
 */
package com.better517na.forstudy.quicktest.test;

import java.lang.reflect.Field;
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
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        // Normal normal = new Normal();
        // normal.setA(10);
        // normal.setStr("Normal...");
        //
        // Method method = normal.getClass().getMethod("setA", int.class);
        // method.invoke(normal, 100);
        // System.out.println(normal.getA());
        //
        // Field[] fields = normal.getClass().getDeclaredFields();
        // for (Field field : fields) {
        // field.setAccessible(true);
        // // System.out.println(field.get(normal));
        // System.out.println(field.getType() + " : " + field.getName());
        // }

        // Normal normal = new Normal();
        // for (int i = 0; i < normal.getClass().getDeclaredFields().length; i++) {
        // System.out.println(normal.getClass().getDeclaredFields()[i].getType().getName());
        // }

        List<String> list = new ArrayList<>();
        list.add("ssss");
        list.add("dddd");
        list.add("wwww");
        list.add("ffff");

        for (Field fd : list.getClass().getDeclaredFields()) {
            fd.setAccessible(true);
            System.out.println(fd.getName());
        }
        
        // System.out.println(JsonUtils.toJson(list));
        // Field[] fds = list.getClass().getDeclaredFields();
        // for (int i = 0; i < fds.length; i++) {
        // System.out.println(fds[i].getName());
        // }
    }
}

class Normal {
    private int a1;

    private Integer a2;

    private char a3;

    private Character a4;

    private byte a5;

    private Byte a6;

    private boolean a7;

    private Boolean a8;

    private String a9;

    public List<String> a10;

    public Unit a11;

    /**
     * 设置a10.
     * 
     * @return 返回a10
     */
    public List<String> getA10() {
        return a10;
    }

    /**
     * 获取a10.
     * 
     * @param a10
     *            要设置的a10
     */
    public void setA10(List<String> a10) {
        this.a10 = a10;
    }

    /**
     * 设置a1.
     * 
     * @return 返回a1
     */
    public int getA1() {
        return a1;
    }

    /**
     * 获取a1.
     * 
     * @param a1
     *            要设置的a1
     */
    public void setA1(int a1) {
        this.a1 = a1;
    }

    /**
     * 设置a2.
     * 
     * @return 返回a2
     */
    public Integer getA2() {
        return a2;
    }

    /**
     * 获取a2.
     * 
     * @param a2
     *            要设置的a2
     */
    public void setA2(Integer a2) {
        this.a2 = a2;
    }

    /**
     * 设置a3.
     * 
     * @return 返回a3
     */
    public char getA3() {
        return a3;
    }

    /**
     * 获取a3.
     * 
     * @param a3
     *            要设置的a3
     */
    public void setA3(char a3) {
        this.a3 = a3;
    }

    /**
     * 设置a4.
     * 
     * @return 返回a4
     */
    public Character getA4() {
        return a4;
    }

    /**
     * 获取a4.
     * 
     * @param a4
     *            要设置的a4
     */
    public void setA4(Character a4) {
        this.a4 = a4;
    }

    /**
     * 设置a5.
     * 
     * @return 返回a5
     */
    public byte getA5() {
        return a5;
    }

    /**
     * 获取a5.
     * 
     * @param a5
     *            要设置的a5
     */
    public void setA5(byte a5) {
        this.a5 = a5;
    }

    /**
     * 设置a6.
     * 
     * @return 返回a6
     */
    public Byte getA6() {
        return a6;
    }

    /**
     * 获取a6.
     * 
     * @param a6
     *            要设置的a6
     */
    public void setA6(Byte a6) {
        this.a6 = a6;
    }

    /**
     * 设置a7.
     * 
     * @return 返回a7
     */
    public boolean isA7() {
        return a7;
    }

    /**
     * 获取a7.
     * 
     * @param a7
     *            要设置的a7
     */
    public void setA7(boolean a7) {
        this.a7 = a7;
    }

    /**
     * 设置a8.
     * 
     * @return 返回a8
     */
    public Boolean getA8() {
        return a8;
    }

    /**
     * 获取a8.
     * 
     * @param a8
     *            要设置的a8
     */
    public void setA8(Boolean a8) {
        this.a8 = a8;
    }

    /**
     * 设置a9.
     * 
     * @return 返回a9
     */
    public String getA9() {
        return a9;
    }

    /**
     * 获取a9.
     * 
     * @param a9
     *            要设置的a9
     */
    public void setA9(String a9) {
        this.a9 = a9;
    }

}

class Unit {
    public String u1;
}