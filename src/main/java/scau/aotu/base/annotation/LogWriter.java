package scau.aotu.base.annotation;

import java.lang.annotation.*;

/**
 * Created by leeshunpeng on 2015/6/18.
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LogWriter {
    /**
     * 模块名
     * @return
     */
    String moduleName() default "";

    /**
     * 操作类型 采用SQL方法
     * @return
     */
    String option() default "select";
}
