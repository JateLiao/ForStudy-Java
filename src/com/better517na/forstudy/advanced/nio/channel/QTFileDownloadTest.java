/*
 * 文件名：QTFileDownloadTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： QTFileDownloadTest.java
 * 修改人：tianzhong
 * 修改时间：2016年11月14日
 * 修改内容：新增
 */
package com.better517na.forstudy.advanced.nio.channel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 千淘文件下载测试.
 * 
 * @author tianzhong
 */
public class QTFileDownloadTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.qiantaohotel.com:7001/RoomType_2016-11-13.zip");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(10 * 1000);
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        InputStream in = conn.getInputStream();
        byte[] getData = readInputStream(in);

        // 文件保存位置
        File saveDir = new File("E:\\tianzhong(田仲)\\工作文档\\09.本地工作文档\\酒店\\2016-11-08-新渠道\\千淘\\RoomType");
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }
        File file = new File(saveDir + File.separator + "RoomType_2016-11-15.zip");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        
        if (fos != null) {
            fos.close();
        }
        if (in != null) {
            in.close();
        }

        System.out.println("info:" + url + " download success");
    }

    /**
     * 从输入流中获取字节数组
     * 
     * @param inputStream
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inputStream) throws Exception {
        byte[] buffer = new byte[102400];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
