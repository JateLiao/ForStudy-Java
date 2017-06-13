/*
 * 文件名：Test4.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Test4.java
 * 修改人：tianzhong
 * 修改时间：2017年4月18日
 * 修改内容：新增
 */
package com.better517na.forStudy.quicktest;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

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
public class Test4 {

    @Test
    public void test1() {
        Gson gson = new GsonBuilder().registerTypeAdapter(Double.class, new JsonSerializer<Double>() {

            @Override
            public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                if (src == src.longValue())
                    return new JsonPrimitive(src.longValue());
                return new JsonPrimitive(src);
            }
        }).create();
        
        Map<String, Object> map = new HashMap<>();
        map.put("id", 20);
        map.put("name", "dasd");
        
        String json = gson.toJson(map);
        System.out.println(json);
        
        Map<String, Object> map2 = gson.fromJson(json, new TypeToken<Map<String, Object>>(){}.getType());
        json = gson.toJson(map2);
        System.out.println(json);
    }

    @Test
    public void test2() {
        String s = "成都成华区什么区";

        String info = s.substring(0, 2);
        System.out.println(info);
        System.out.println(info + "-" + s.substring(2, s.length()));
        
    } 
 
    @Test
    @SuppressWarnings("unused")
    public void test3() {
        String val = "太原市市万柏林区";
        Pattern p = Pattern.compile("市+?");
        
    }

    @Test
    public void test4() {
        String val = "1张1.5米大床（或1张1.8米大床）/1张1.5米的大床（或1张1.8米的大床）";
        Pattern p = Pattern.compile("[0-9]\\.?[0-9]{0,2}?米");
        Matcher m = p.matcher(val);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
    
    @Test
    public void matchesTest(){

        //JOptionPane.showMessageDialog(null, "您的中奖金额：0.50￥\n接收账户：374682617@qq.com", "来消息了!", JOptionPane.YES_OPTION);
        System.out.println("含2早有窗".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("含早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("有早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("无早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("不含早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("单早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("双早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("两早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("2早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("三早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("3早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("4早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("6早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("8早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("四早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("六早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("八早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("每人一份早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("2份中早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
    
    }
}
