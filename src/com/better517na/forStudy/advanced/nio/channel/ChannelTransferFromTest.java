/*
 * 文件名：ChannelTransferFromTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ChannelTransferFromTest.java
 * 修改人：tianzhong
 * 修改时间：2016年8月19日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.nio.channel;

import java.io.RandomAccessFile;
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
public class ChannelTransferFromTest {

    /**
     * TODO 添加方法注释.
     * 
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        // testfile测试wenjian文件
        RandomAccessFile fromFile = new RandomAccessFile(ChannelTransferFromTest.class.getClassLoader().getResource("com/better517na/forStudy/nio/test.txt").getFile(), "rw");
        RandomAccessFile toFile = new RandomAccessFile(ChannelTransferFromTest.class.getClassLoader().getResource("com/better517na/forStudy/nio/ToFileTest.txt").getFile(), "rw");
        
        FileChannel fromChannel = fromFile.getChannel();
        FileChannel toChannel = toFile.getChannel();

        toChannel.transferFrom(fromChannel, fromChannel.size(), 0);
        fromChannel.transferTo(0, fromChannel.size(), toChannel);
        

        fromFile.close();
        fromChannel.close();
        toFile.close();
        toChannel.close();
    }

}
