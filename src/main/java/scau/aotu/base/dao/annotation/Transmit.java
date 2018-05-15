package scau.aotu.base.dao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识注解，用于标识不需要持久化的字段
 * <p>
 * 或者不给属性设置getter和setter方法
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Transmit {
}