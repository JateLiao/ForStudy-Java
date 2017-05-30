package util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.better517na.annotation.NotNull;
import com.better517na.forStudy.advanced.reflect.jsonutil.helper.CommonUtil;

/**
 * 常规检查辅助类.
 * 
 * @author xuanwei
 *
 */
@SuppressWarnings("rawtypes")
public final class CommonCheckUtils {
    /**
     * 构造函数.
     * 
     */
    private CommonCheckUtils() {
        throw new RuntimeException("this is a util class,can not instance");
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param value
     *            校验参数
     * @return true or false
     */
    public static boolean isNull(String value) {
        if (null == value || value.trim().isEmpty() || "null".equals(value.trim())) {
            return true;
        }
        return false;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param o
     *            校验参数
     * @return true or false
     */
    public static boolean isNotEmpty(Object... o) {
        if (null != o && o.length > 0) {
            for (Object obj : o) {
                if (null == obj) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param s
     *            校验参数
     * @return true or false
     */
    public static boolean isNotEmpty(String... s) {
        if (null != s && s.length > 0) {
            for (String str : s) {
                if (null == str || "".equals(str.trim())) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param o
     *            校验参数
     * @return true or false
     */
    public static boolean isEmpty(Object... o) {
        if (null == o || o.length == 0) {
            return true;
        }
        for (Object obj : o) {
            if (null != obj) {
                return false;
            }
        }
        return true;
    }
    

    /**
     * TODO 添加方法注释.
     * 
     * @param o
     *            校验参数
     * @return true or false
     */
    public static boolean isEmptyAll(Object... o) {
        if (null == o || o.length == 0) {
            return true;
        }
        for (Object obj : o) {
            if (null == obj) {
                return true;
            }
            
            if (obj instanceof String) {
                return isEmpty((String)obj);
            } else if (obj instanceof Map) {
                return isEmpty((Map<?, ?>)obj);
            } else if (obj instanceof Collection<?>) {
                return isEmpty((Collection<?>)obj);
            }
        }
        return false;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param c
     *            校验map
     * @return true or false
     */
    public static boolean isNotEmpty(Map<?, ?> c) {
        if (null != c && !c.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param c
     *            校验map
     * @return true or false.
     */
    public static boolean isEmpty(Map<?, ?> c) {
        if (null == c || c.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param c
     *            校验集合
     * @return true or false
     */
    public static boolean isNotEmpty(Collection<?> c) {
        if (null != c && !c.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param c
     *            校验集合
     * @return true or false
     */
    public static boolean isEmpty(Collection<?> c) {
        if (null == c || c.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param str
     *            字符串
     * @return true or false
     */
    public static boolean isEmpty(String str) {
        if (null == str || str.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param str
     *            校验集合
     * @return true or false
     */
    public static boolean isNotEmpty(String str) {
        if (null != str && !str.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * TODO 是否是11位手机号码.
     * 
     * @param phoneNo
     *            手机号码
     * @return true or false
     */
    public static boolean validPhoneNo(String phoneNo) {
        if (isNotEmpty(phoneNo)) {
            return phoneNo.matches("^1\\d{10}");
        }
        return false;
    }

    /**
     * TODO 是否是数字.
     * 
     * @param value
     *            手机号码
     * @return true or false
     */
    public static boolean isNumber(String value) {
        if (isNotEmpty(value)) {
            return value.matches("\\d+");
        }
        return false;
    }

    /**
     * TODO 校验邮箱.
     * 
     * @param email
     *            邮箱
     * @return true or false
     */
    public static boolean emailFormat(String email) {
        boolean tag = true;
        final String pattern1 = "^([a-z0-9A-Z]+[_|-|//.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }
    
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
                fd.setAccessible(true);
                if (!fd.isAnnotationPresent(NotNull.class)) {
                    continue;
                } 
                if (CommonUtil.isDefinedModel(fd.getType())) {
                    String name = notNullValidateForName(fd.get(obj));
                    if (isNotEmpty(name)) {
                        return name;
                    }
                } else if (CommonUtil.isListType(fd.getType())) {
                    List<?> list = (List<?>)fd.get(obj);
                    for (Object o : list) {
                        String name = notNullValidateForName(o);
                        if (isNotEmpty(name)) {
                            return name;
                        }
                    }
                } else if (CommonUtil.isMapType(fd.getType())) {
                    Map<?, ?> map = (Map<?, ?>) fd.get(obj);
                    for (Entry<?, ?> e : map.entrySet()) {
                        String name = notNullValidateForName(e.getValue());
                        if (isNotEmpty(name)) {
                            return name;
                        }
                    }
                }
                
                if (CommonCheckUtils.isEmpty(fd.get(obj))) {
                    // result = fd.getType().getAnnotation(NotNull.class).name();
                    Annotation[] ans = fd.getDeclaredAnnotations();
                    for (Annotation annotation : ans) {
                        if (annotation instanceof NotNull) {
                            result = ((NotNull) annotation).name();
                            break;
                        }
                    }
                }
                fd.setAccessible(false);
                if (CommonCheckUtils.isNotEmpty(result)) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return result;
    }


}
