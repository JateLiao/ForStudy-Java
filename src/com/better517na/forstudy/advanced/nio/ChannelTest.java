/*
 * 文件名：ChannelTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ChannelTest.java
 * 修改人：tianzhong
 * 修改时间：2016年5月16日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

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
public class ChannelTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Test\\sql.txt");
        FileOutputStream out = new FileOutputStream(file);
        FileInputStream in = new FileInputStream(file);
        FileChannel channel = out.getChannel();
        FileChannel channel2 = in.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024); // write
        ByteBuffer buffer2 = ByteBuffer.allocate(1024); // read
        buffer.put("this is a channel test.1111".getBytes());
        buffer.flip();
        channel.write(buffer);
        channel2.read(buffer2);

        System.out.println(new String(buffer2.array()));

        channel.close();
        out.close();
        channel2.close();
        in.close();
    }

}
