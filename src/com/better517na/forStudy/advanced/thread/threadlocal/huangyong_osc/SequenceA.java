/*
 * 文件名：SequenceA.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SequenceA.java
 * 修改人：tianzhong
 * 修改时间：2016年6月22日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.thread.threadlocal.huangyong_osc;

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
public class SequenceA implements Sequence {
    private static int number = 0;

    /**
     * {@inheritDoc}.
     */
    @Override
    public int getNumber() {
        number = number + 1;
        return number;
    }

    public static void main(String[] args) {
        Sequence sequence = new SequenceA();

        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
