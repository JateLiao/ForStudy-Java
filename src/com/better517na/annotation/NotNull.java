/*
 * 文件名：NotNull.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： NotNull.java
 * 修改人：tianzhong
 * 修改时间：2017年4月19日
 * 修改内容：新增
 */
package com.better517na.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {

}
