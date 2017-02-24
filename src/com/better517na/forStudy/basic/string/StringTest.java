/*
 * 文件名：StringTest.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： StringTest.java
 * 修改人：tianzhong
 * 修改时间：2016年12月8日
 * 修改内容：新增
 */
package com.better517na.forStudy.basic.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
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
public class StringTest {
    
    @Test
    public void regexTest() {
        String[] arr = {
//                "1张1.8米双人床+1张1.2米单人床","2张1.35米单人床", "1张2.4米*2.0米双人床/一客厅/两个卫生间", "1张1.8米*2.0米双人床", "2张1.2米*2.0米单人床", "有窗，1.35m*2m床2张", "1张1.2米*2.0米单人床/1张1.5米*2.0米双人床", "1张2米双人大床（带电脑）", "2张1.35米单人床（带电脑）",
//                "1房1厅1张2.4米双人大床", "有窗，有电脑，1.8m*2m床1张", "一张2X2.2M床带麻将桌", "一号楼，1张1.8米的床；二号楼1张1.5米的床", "1张2.0米双人床，有1个阳台、1个客厅和1个书房", "1张2.0米双人人床、1张1.2米单人床", "一张2.4米双人圆床", "商务大床1张1.8*2M，有电脑",
//                "豪华单人房1张1.8*2M",  "有窗，有电脑，有棋牌桌，有1张圆床单"
                
//                "1张1.2米*2.0米单人床/1张1.5米*2.0米双人床",
//                "有窗，1.35m*2m床2张",
//                "1房1厅1张2.4米双人大床",
//                "有窗，有电脑，1.8m*2m床1张",
//                "一张2X2.2M床带麻将桌",
//                "一号楼，1张1.8米的床；二号楼1张1.5米的床",
//                "1张2.0米双人人床、1张1.2米单人床",
//                "商务大床1张1.8*2M，有电脑",
//                "豪华单人房1张1.8*2M"
                
                "两张1.35单人床"
        };
    
        for (String bed : arr) {
            System.out.println(bed + ":  " + getBedTypeInfo(bed));
        }
    }
    @Test
    public void matchesTest(){
        String[] arr = {
                "1张1.8米双人床+1张1.2米单人床","2张1.35米单人床", "1张2.4米*2.0米双人床/一客厅/两个卫生间", "1张1.8米*2.0米双人床", "2张1.2米*2.0米单人床", "有窗，1.35m*2m床2张", "1张1.2米*2.0米单人床/1张1.5米*2.0米双人床", "1张2米双人大床（带电脑）", "2张1.35米单人床（带电脑）",
                "1房1厅1张2.4米双人大床", "有窗，有电脑，1.8m*2m床1张", "一张2X2.2M床带麻将桌", "一号楼，1张1.8米的床；二号楼1张1.5米的床", "1张2.0米双人床，有1个阳台、1个客厅和1个书房", "1张2.0米双人人床、1张1.2米单人床", "一张2.4米双人圆床", "商务大床1张1.8*2M，有电脑",
                "豪华单人房1张1.8*2M",  "有窗，有电脑，有棋牌桌，有1张圆床单","2张1.2*2.0单人床","2张1.2单人床","两张1.35单人床","2张1.2米X2M床"
        };
        for (String str : arr) {
//            if (!str.matches(".*\\d[m|M|米].*")) {
//                System.out.println(str);
//            }
            if (!str.matches(".*\\d[m|M|米].*") && !str.matches(".*张[\\d\\.\\*X]{1,9}.*")) {
                if (!str.matches(".*[\\d\\.]{1,4}[M|m|米]{0,1}[\\*Xx,]{1}[\\d\\.]{1,4}[M|m|米]{0,1}.*")) {
                    System.err.println(str);
                }
            }
        }
    }
    
    @Test
    public void matchesTest2() throws Exception {
        File file = new File("D://Test//BedSize.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//            if (!line.matches(".*[\\d\\.]{1,4}[M|m|米]{0,1}[\\*Xx,]{1}[\\d\\.]{1,4}[M|m|米]{0,1}.*") && !line.matches(".*张[\\d\\.]{1,4}[M|m|米]{0,1}.*")) {
//                System.err.println(line);
//            }
            

            System.out.println(line + ":  " + getBedTypeInfo(line));
        
        }
        
        reader.close();
    }

    
    /**
     * TODO 床型.
     * 
     * @param bedDesc .
     * @return .
     */
    private String getBedTypeInfo(String bedDesc) {
        // 先处理特殊房型
        if (bedDesc.contains("圆床")) {
            return "9"; // 9：圆床
        } else if (bedDesc.contains("水床")) {
            return "10"; // 10：水床
        } else if (bedDesc.contains("榻榻米")) {
            return "11"; // 11：榻榻米
        } else if (bedDesc.contains("沙发床")) {
            return "12"; // 12：沙发床
        } else if (bedDesc.contains("宿舍床") || bedDesc.contains("上下床") || bedDesc.contains("上下铺")) {
            return "13"; // 13：宿舍床
        } else if (bedDesc.contains("墨菲床")) {
            return "14"; // 14：墨菲床
        } else if (bedDesc.contains("日式床垫")) {
            return "15"; // 15：日式床垫
        }
        
        String bedCount = ""; // 数量

        // 先获取床的数量
        if (bedDesc.contains("+")) {
            Pattern p = Pattern.compile("\\d张");
            Matcher m = p.matcher(bedDesc);
            int n = 0;
            while (m.find()) {
                n += Integer.valueOf(m.group(0).substring(0, m.group(0).length() - 1));
            }
            bedCount = String.valueOf(n);
        } else if (bedDesc.matches(".*\\d张.*")) {
            Pattern p = Pattern.compile("\\d张");
            Matcher m = p.matcher(bedDesc);
            if (m.find()) {
                bedCount = m.group(0).substring(0, m.group(0).length() - 1);
            }
        } else if (bedDesc.matches(".*[一|两|三|四]张.*")) {
            Pattern p = Pattern.compile("[一|两|三|四]张");
            Matcher m = p.matcher(bedDesc);
            if (m.find()) {
                bedCount = m.group(0).substring(0, m.group(0).length() - 1);
                switch (bedCount) {
                    case "一":
                        bedCount = "1";
                        break;
                    case "两":
                        bedCount = "2";
                        break;
                    case "三":
                        bedCount = "3";
                        break;
                    case "四":
                        bedCount = "4";
                        break;

                    default:
                        break;
                }
            }
        }

        if (bedDesc.contains("大床") || bedDesc.contains("双人")) {
            if (null == bedCount || "".equals(bedCount)) {
                return "2"; // 2:大床
            } else {
                if ("1".equals(bedCount)) {
                    return "7"; // 7:大/单床
                } else if ("2".equals(bedCount)) {
                    return "6"; // 6:大/双床
                }
            }
        } else {
            switch (bedCount) {
                case "1":
                    return "3"; // 3:单床
                case "2":
                    return "1"; // 1:双床
                case "3":
                    return "4"; // 4:3床
                case "4":
                    return "5"; // 5:4床

                default:
                    break;
            }
        }

        // if (bedDesc.contains("圆床")) {
        // return "9"; // 9：圆床
        // } else if (bedDesc.contains("水床")) {
        // return "10"; // 10：水床
        // } else if (bedDesc.contains("榻榻米")) {
        // return "11"; // 11：榻榻米
        // } else if (bedDesc.contains("沙发床")) {
        // return "12"; // 12：沙发床
        // } else if (bedDesc.contains("宿舍床")) {
        // return "13"; // 13：宿舍床
        // } else if (bedDesc.contains("墨菲床")) {
        // return "14"; // 14：墨菲床
        // } else if (bedDesc.contains("日式床垫")) {
        // return "15"; // 15：日式床垫
        // } else {
        // return "100"; // 100：其他
        // }

        return "100"; // 100：其他
    }
}
