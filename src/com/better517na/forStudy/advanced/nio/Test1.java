/*
 * 文件名：Test1.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test1.java
 * 修改人：tianzhong
 * 修改时间：2016年5月16日
 * 修改内容：新增
 */
package com.better517na.forStudy.advanced.nio;

import java.io.File;
import java.io.FileInputStream;

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
public class Test1 {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\Test\\sql.txt");
        FileInputStream in = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        in.read(bytes);

        in.close();
    }
}
