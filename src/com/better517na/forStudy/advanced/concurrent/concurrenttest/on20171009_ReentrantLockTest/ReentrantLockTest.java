/*
 * 文件名：ReentrantLockTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ReentrantLockTest.java
 * 修改人：tianzhong
 * 修改时间：2017年10月9日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.concurrent.concurrenttest.on20171009_ReentrantLockTest;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

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
public class ReentrantLockTest {
    
    ReentrantLock lock = new ReentrantLock();

    public void lockTest() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    }

    public static void main(String[] args) {

    }
}
