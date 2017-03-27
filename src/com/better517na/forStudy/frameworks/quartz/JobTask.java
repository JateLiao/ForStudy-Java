/*
 * 文件名：SimpleTriggerExample.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SimpleTriggerExample.java
 * 修改人：tianzhong
 * 修改时间：2016年3月25日
 * 修改内容：新增
 */
package com.better517na.forStudy.frameworks.quartz;

import org.springframework.stereotype.Component;

/**
 * @author tianzhong
 */
@Component
public class JobTask {
    public void doBiz() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("do job " + (i + 1));
            // Thread.sleep(1500);
        }
    }
}
