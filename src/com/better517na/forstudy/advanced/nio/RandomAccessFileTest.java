/*
 * 文件名：RandomAccessFileTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： RandomAccessFileTest.java
 * 修改人：tianzhong
 * 修改时间：2016年12月21日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.nio;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

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
@SuppressWarnings("resource")
public class RandomAccessFileTest {

    @Test
    public void testssssssss1() {
        String path = "D:\\Test\\apache-maven-3.3.3.rar";
        File file = new File(path);

        System.out.println(file.getName());
        System.out.println(file.length());
    }

    @Test
    public void testssssssss2() throws Exception {
        String path = "D:\\Test\\apache-maven-3.3.3.rar";
        File file = new File(path);
        FileInputStream fi = new FileInputStream(file);

        System.out.println(file.getName());
        System.out.println(file.length());
        System.out.println(fi.getChannel().size()); 
    }
}
