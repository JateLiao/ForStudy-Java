/*
 * 文件名：StringTest2.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： StringTest2.java
 * 修改人：tianzhong
 * 修改时间：2016年12月8日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * TODO 添加类的一句话简单描述.
 * <p>
 * TODO 详细描述
 * <p>
 * TODO 示例代码
 * <pre>
 * </pre>
 * 
 * @author     tianzhong
 */
public class StringTest2 {
    
    
    @Test
    public void test1() throws Exception{
        File file = new File("D://Test//BedSize.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line + ":  " + handleBedSizeInfo(line));
        }
        
        reader.close();
    }
    
    
    @Test
    public void test2() throws Exception{
        String[] arr = {
                "1张1.8米双人床+1张1.2米单人床","2张1.35米单人床", "1张2.4米*2.0米双人床/一客厅/两个卫生间", "1张1.8米*2.0米双人床", "2张1.2米*2.0米单人床", "有窗，1.35m*2m床2张", "1张1.2米*2.0米单人床/1张1.5米*2.0米双人床", "1张2米双人大床（带电脑）", "2张1.35米单人床（带电脑）",
                "1房1厅1张2.4米双人大床", "有窗，有电脑，1.8m*2m床1张", "一张2X2.2M床带麻将桌", "一号楼，1张1.8米的床；二号楼1张1.5米的床", "1张2.0米双人床，有1个阳台、1个客厅和1个书房", "1张2.0米双人人床、1张1.2米单人床", "一张2.4米双人圆床", "商务大床1张1.8*2M，有电脑",
                "豪华单人房1张1.8*2M",  "有窗，有电脑，有棋牌桌，有1张圆床单","2张1.2*2.0单人床","2张1.2单人床","两张1.35单人床","2张1.2米X2M床","1张1.8米单人床(部分为1.5米)"
        };
        for (String str : arr) {
            System.out.println(handleBedSizeInfo(str));
        }
    }

    /**
     * TODO 床尺寸.
     * 
     * @param bedDesc .
     * @return .
     */
    private String handleBedSizeInfo(String bedDesc) {
        /**
         * 
        2张1.35米单人床
        1张2.4米*2.0米双人床/一客厅/两个卫生间
        1张1.8米*2.0米双人床
        2张1.2米*2.0米单人床
              有窗，1.35m*2m床2张
        1张1.2米*2.0米单人床/1张1.5米*2.0米双人床
        1张2米双人大床（带电脑）
        2张1.35米单人床（带电脑）
        1房1厅1张2.4米双人大床
              有窗，有电脑，1.8m*2m床1张
             一张2X2.2M床带麻将桌
             一号楼，1张1.8米的床；二号楼1张1.5米的床
        1张2.0米双人床，有1个阳台、1个客厅和1个书房
        1张2.0米双人人床、1张1.2米单人床
              一张2.4米双人圆床
            商务大床1张1.8*2M，有电脑
            豪华单人房1张1.8*2M
        1张1.8米双人床+1张1.2米单人床
            有窗，有电脑，有棋牌桌，有1张圆床单
        2张1.2*2.0单人床
        2张1.2单人床
            两张1.35单人床
        2张1.2米X2M床
         */
        String res = "";
        if (bedDesc.matches(".*[\\d\\.\\*Xx米]{1,11}.*") || bedDesc.matches(".*张[\\d\\.]{1,4}[M|m|米]{0,1}.*")) {
            if (bedDesc.contains("/") || bedDesc.contains("+")) {
                String[] arr = bedDesc.split(bedDesc.contains("/") ? "/" : "\\+");
                for (String desc : arr) {
                    if (bedDesc.matches(".*张[\\d\\.]{1,4}[M|m|米]{0,1}.*") || bedDesc.matches(".*[\\d\\.\\*Xx米]{1,11}.*")) {
                        res = res + getBedSize(desc);
                    }
                }
            } else {
                res = getBedSize(bedDesc);
            }
            
            if (null != res && res.endsWith("/")) {
                res = res.substring(0, res.length() - 1);
            }
        }
        
        return res;
    }

    /**
     * TODO 获取床尺寸.
     * 
     * @param desc .
     * @return .
     */
    private String getBedSize(String desc) {
        if (null == desc || "".equals(desc)) {
            return null;
        }
        
        String res = "";
        if (desc.matches(".*[\\d\\.]{1,4}[M|m|米]{0,1}[\\*Xx,]{1}[\\d\\.]{1,4}[M|m|米]{0,1}.*")) { // 1张2.4米*2.0米双人床
            Pattern p = Pattern.compile("[\\d\\.]{1,4}[M|m|米]{0,1}[\\*Xx,]{1}[\\d\\.]{1,4}[M|m|米]{0,1}");
            Matcher m = p.matcher(desc);
            while (m.find()) {
                String str = m.group(0);
                String splitChar = "";
                if (str.contains("*")) {
                    splitChar = "\\*";
                } else if (str.contains("X")) {
                    splitChar = "X";
                } else if (str.contains("x")) {
                    splitChar = "x";
                } else if (str.contains(",")) {
                    splitChar = ",";
                }
                
                if (null != splitChar && !"".equals(splitChar)) {
                    String[] arr = str.split(splitChar);
                    List<Double> valList = new ArrayList<>();
                    for (String val : arr) {
                        valList.addAll(getNumber(val));
                    }
                    double r = 100.0;
                    for (Double i : valList) {
                        r = (i <= r) ? i : r;
                    }
                    res = res + String.valueOf(r) + "m/";
                }
            }
        } else if (desc.matches(".*张[\\d\\.]{1,4}[M|m|米]{0,1}.*")) { // 2张1.35米单人床
            List<Double> valList = getNumber(desc);
            for (Double d : valList) {
                res = res + d + "m/";
            }
        }
        
        
        return res;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param val .
     * @return .
     */
    private List<Double> getNumber(String val) {
        List<Double> res = new ArrayList<>();
        
        if (val.contains("张")) {
            /**
             * 两张1.35单人床
             * 1张1.8米单人床(部分为1.5米)
             * 一号楼，1张1.8米的床；二号楼1张1.5米的床
             */
            if (val.contains("米")) {
                Pattern p = Pattern.compile("[\\d\\.]{1,4}[m|M|米]");
                Matcher m = p.matcher(val);
                while (m.find()) {
                    String s = m.group(0);
                    res.add(Double.valueOf(s.substring(0, s.length() - 1)));
                }
            } else {
                Pattern p = Pattern.compile("张[\\d\\.]{1,4}");
                Matcher m = p.matcher(val);
                while (m.find()) {
                    String s = m.group(0);
                    res.add(Double.valueOf(s.substring(1, s.length())));
                }
            }
        } else {
            Pattern p = Pattern.compile("[\\d\\.]{1,4}");
            Matcher m = p.matcher(val);
            while (m.find()) {
                res.add(Double.valueOf(m.group(0)));
            }
        }
        
        return res;
    }

}
