/*
 * 文件名：BufferedReaderTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： BufferedReaderTest.java
 * 修改人：tianzhong
 * 修改时间：2016年5月19日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.nio.buffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
public class BufferedReaderTest {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\Test\\sql.txt");
        // E:\\tianzhong(田仲)\\工作文档\\09.本地工作文档\\酒店\\2016-11-08-新渠道\\千淘\\RoomType_2016-11-14.room

        // BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        // int tmp = 0;
        // byte[] bytes = new byte[in.available() * 2];
        // while ((tmp = in.read(bytes)) != -1) {
        // System.out.println("每次读取字节数量:" + tmp);
        // System.out.println("本次读取内容:" + new String(bytes, 0, tmp, "UTF-8"));
        // }

        
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tmp = null;
        while ((tmp = reader.readLine()) != null) {
            System.out.println(new String(tmp.getBytes(System.getProperty("file.encoding")), "UTF-8"));
        }

        String str = new String("你好吗？");// 默认编码是unicode
        byte[] data = str.getBytes();// 平台默认编码 eclipse是gbk，windows下记事本也是gb2312(gbk的子集)
        String str2 = new String(data, "GBK");// str2的字符编码是unicode(java默认编码)
        // 貌似不好获取。java中所有的东西都是unicode存储的。 String可以看源码是 char[]数组存储的。
        System.out.println(str2);
        reader.close();
    }
}
