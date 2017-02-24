/*
 * 文件名：QTBufferedReadTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： QTBufferedReadTest.java
 * 修改人：tianzhong
 * 修改时间：2016年11月14日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.nio.channel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 千淘文件读取测试
 * 
 * @author     tianzhong
 */
public class QTBufferedReadTest {
    public static void main(String[] args) throws Exception {
        File file = new File("E:\\tianzhong(田仲)\\工作文档\\09.本地工作文档\\酒店\\2016-11-08-新渠道\\千淘\\房型-价格计划-下载\\PricePlan_2016-11-18.plan");

        // BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        // int tmp = 0;
        // byte[] bytes = new byte[in.available() * 2];
        // while ((tmp = in.read(bytes)) != -1) {
        // System.out.println("每次读取字节数量:" + tmp);
        // System.out.println("本次读取内容:" + new String(bytes, 0, tmp, "UTF-8"));
        // }

        
        long s = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tmp = null;
        int count = 0;
        String code = "xxxxx";
        while ((tmp = reader.readLine()) != null) {
            count++;
            if (!new String(tmp.getBytes(System.getProperty("file.encoding")), "UTF-8").startsWith(code)) {
                code = new String(tmp.getBytes(System.getProperty("file.encoding")), "UTF-8").substring(0, 22);
                System.out.println(code);
            }
        }

        reader.close();
        long e = System.currentTimeMillis();
        System.out.println(count);
        System.out.println("总耗时：" + (e -s));
    }

}
