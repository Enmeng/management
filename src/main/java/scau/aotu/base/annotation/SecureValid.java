package scau.aotu.base.annotation;

import java.lang.annotation.*;

/**
 * 安全验证
 * Created by leeshunpeng on 2015/6/18.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SecureValid {
    String desc() default "安全验证开始...";
}
