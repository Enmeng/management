package scau.aotu.base.dao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标注类名和表名不一致的类名
 * <p>
 * 框架默认会把驼峰写法改写为以"_"分隔的单词串，有特殊需求的时候才需要标注
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {

    /**
     * 表名
     * 不能为空
     *
     * @return
     */
    String name() default "";
}