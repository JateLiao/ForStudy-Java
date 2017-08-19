/*
 * 文件名：CountDownLatchTest.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CountDownLatchTest.java
 * 修改人：tianzhong
 * 修改时间：2017年8月18日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.concurrent.concurrenttest.on20170818;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
public class CountDownLatchTest {

    @Test
    public void countDownLatchTest() {
        // Executors.newScheduledThreadPool(5);
        ExecutorService pool = new ThreadPoolExecutor(4, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 10; i++) {
            pool.execute(new CntDwnLtchRunner("runner" + i));
        }
        
        pool.shutdown();
    }
}
