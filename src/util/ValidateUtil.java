/*
 * 文件名：ValidateUtil.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ValidateUtil.java
 * 修改人：tianzhong
 * 修改时间：2017年4月19日
 * 修改内容：新增
 */
package util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.better517na.annotation.NotNull;

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
public class ValidateUtil {
    
    public static boolean notNullValidate(Object obj) {
        boolean result = true;
       
        // 获取所有字段，包括父类字段
        List<Field> res = new ArrayList<>();
        res.addAll(Arrays.asList(obj.getClass().getDeclaredFields()));
        Class superClazz = obj.getClass().getSuperclass();
        while(superClazz != Object.class){
            res.addAll(Arrays.asList(superClazz.getDeclaredFields()));
            superClazz = superClazz.getSuperclass();
        }
        
        // 验证
        try {
            for (Field fd : res) {
                if (fd.isAnnotationPresent(NotNull.class) && CommonCheckUtils.isEmpty(fd.get(obj))) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return result;
    }


    public static String notNullValidateForName(Object obj) {
        String result = null;
       
        // 获取所有字段，包括父类字段
        List<Field> res = new ArrayList<>();
        res.addAll(Arrays.asList(obj.getClass().getDeclaredFields()));
        Class superClazz = obj.getClass().getSuperclass();
        while(superClazz != Object.class){
            res.addAll(Arrays.asList(superClazz.getDeclaredFields()));
            superClazz = superClazz.getSuperclass();
        }
        
        // 验证
        try {
            for (Field fd : res) {
                if (fd.isAnnotationPresent(NotNull.class) && CommonCheckUtils.isEmpty(fd.get(obj))) {
                    Annotation[] ans = fd.getDeclaredAnnotations();
                    for (Annotation annotation : ans) {
                        if (annotation instanceof NotNull) {
                            return ((NotNull)annotation).name();
                        }
                    }
                    // return fd.getAnnotations();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return result;
    }

}
