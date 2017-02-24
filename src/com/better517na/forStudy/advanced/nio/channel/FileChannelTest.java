/*
 * 文件名：FileChannelTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： FileChannelTest.java
 * 修改人：tianzhong
 * 修改时间：2016年8月10日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.nio.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
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
public class FileChannelTest {
    public static void main(String[] args) throws Exception {
        // testfile测试wenjian文件
        RandomAccessFile file = new RandomAccessFile(FileChannelTest.class.getClassLoader().getResource("com/better517na/forStudy/nio/test.txt").getFile(), "rw");
        FileChannel inChannel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(10);

        List<Byte> bytes = new ArrayList<>();
        // int xxx = inChannel.write(buffer);
        while ((inChannel.read(buffer)) >= 0) {
            buffer.flip();

            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                bytes.add(b);
                // buffer.rewind();
                // System.out.println(new String(buffer.array()/* , "GBK" */));
                System.out.println((char) b);
            }

            buffer.clear();
            // buffer.compact();
            // buffer.mark();
            // buffer.reset();
        }

        byte[] res = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            res[i] = bytes.get(i);
        }
        System.out.println(new String(res, "GBK"));
        
        file.close();
        inChannel.close();
    }
}
