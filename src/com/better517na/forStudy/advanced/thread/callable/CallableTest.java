/*
 * 文件名：CallableTest.java
 * 版权：Copyright 2007-2017 Liao Shijie Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CallableTest.java
 * 修改人：KOBE
 * 修改时间：2017年2月28日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

/**
 * TODO 添加类的一句话简单描述.
 * 
 * @author     KOBE
 */
public class CallableTest {
    
    @Test
    public void test1() throws InterruptedException, ExecutionException{
        ExecutorService es = Executors.newFixedThreadPool(10);
        List<Future<String>> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            res.add(es.submit(new CallableInstance("Thread" + (i + 1))));
        }
        
        es.shutdown();
        while(!es.isTerminated()){
            System.err.println("等待线程执行完毕...");
        }
        
        for (Future<String> future : res) {
            System.out.println(future.get());
        }
    }

}
