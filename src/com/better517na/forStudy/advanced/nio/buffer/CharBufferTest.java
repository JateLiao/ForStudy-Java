/*
 * 文件名：CharBufferTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CharBufferTest.java
 * 修改人：tianzhong
 * 修改时间：2016年8月17日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.nio.buffer;

import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

import com.better517na.forStudy.advanced.nio.channel.FileChannelTest;

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
@SuppressWarnings({"unused", "resource"})
public class CharBufferTest {
    
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile(FileChannelTest.class.getClassLoader().getResource("com/better517na/forStudy/nio/test.txt").getFile(), "rw");
        FileChannel inChannel = file.getChannel();
        CharBuffer buffer = CharBuffer.allocate(10);
        
        char c = '否';
        System.err.println(Integer.valueOf(c));

        // while (true) {
        //
        // }
        
        // file.close();
        // inChannel.close();
    }

}
