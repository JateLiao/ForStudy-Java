/*
 * 文件名：ClientThread.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ClientThread.java
 * 修改人：tianzhong
 * 修改时间：2016年6月22日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.concurrent.threadlocal.huangyong_osc;

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
public class ClientThread extends Thread {

    private Sequence sequence;

    public ClientThread(Sequence s) {
        this.sequence = s;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " => " + sequence.getNumber());
        }
    }
}
