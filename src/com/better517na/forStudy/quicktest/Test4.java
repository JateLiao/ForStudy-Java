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

}
