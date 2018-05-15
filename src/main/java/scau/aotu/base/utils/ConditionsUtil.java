package scau.aotu.base.utils;

import scau.aotu.base.dao.mybatis.Conditions;
import scau.aotu.base.dao.utils.NameUtil;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by cyl on 2017/4/9
 */
public class ConditionsUtil {

    /**
     * 根据某个类的属性，生成sql条件语句
     * @param clazz 某个类
     * @param isExact 是否为精确查询
     * @return
     */
    public static Conditions getConditionsByProperty(Class clazz, Object obj, boolean isExact) {
        Conditions conditions = new Conditions();
        for (Field f : clazz.getDeclaredFields()) {
            Object value = null;
            try {
                PropertyDescriptor pd = new PropertyDescriptor(f.getName(), clazz);
                Method getMethod = pd.getReadMethod();
                value = getMethod.invoke(obj);
            } catch (IllegalAccessException | InvocationTargetException | IntrospectionException e) {
                e.printStackTrace();
            }
            if (value == null)
                break;
            else {
                switch (f.getType().getName()) {
                    case "java.lang.String" :
                        if (isExact)
                            conditions.equal(NameUtil.camelToUnderline(f.getName()), value);
                        else
                            conditions.like(NameUtil.camelToUnderline(f.getName()), "%" + value + "%");
                        break;
                    default :
                        conditions.equal(NameUtil.camelToUnderline(f.getName()), value);
                }
            }
        }
        return conditions;
    }

}
