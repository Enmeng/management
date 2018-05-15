package scau.aotu.base.dao.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lsp on 24/11/2016.
 * <p>
 * 命名转换工具类
 * 驼峰命名法 -> 下划线风格字符串
 * 下划线风格字符串 -> 驼峰命名法
 */
public class NameUtil {
    /**
     * 转换正则表达式
     */
    private static Pattern camelToUnderlinePattern = Pattern.compile("[A-Z]");
    private static Pattern underlineToCamelPattern = Pattern.compile("_(\\w)");


    /**
     * 首字母小写驼峰命名法转为下划线风格字符串
     * <p>
     * 首字母小写驼峰命名法规则：首单词首字母小写，后面拼接的单词的首字母大写
     * <p>
     * 适用于将类中的属性名转换为对应数据表中的字段名
     *
     * @param str
     * @return
     */
    public static String camelToUnderline(String str) {
        Matcher matcher = camelToUnderlinePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 首字母大写驼峰命名法转为下划线风格字符串
     * <p>
     * 首字母大写驼峰命名法规则：首单词首字母大写，后面拼接的单词的首字母大写
     * <p>
     * 适用于将类名转换为表名
     *
     * @param str
     * @return
     */
    public static String capitalizeCamelToUnderline(String str) {
        str = str.substring(0, 1).toLowerCase() + str.substring(1, str.length());
        return camelToUnderline(str);
    }

    /**
     * 下划线风格字符串转为首字母小写驼峰命名法
     * <p>
     * 下划线风格字符串规则：不同单词间用"_"连接
     * <p>
     * 适用于将表中字段转换为类中属性名
     *
     * @param str
     * @return
     */
    public static String underlineToCamel(String str) {
        str = str.toLowerCase();
        Matcher matcher = underlineToCamelPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 下划线风格字符串转为首字母大写驼峰命名法
     * <p>
     * 下划线风格字符串规则：不同单词间用"_"连接
     * <p>
     * 适用于将表名转换为类名
     *
     * @param str
     * @return
     */
    public static String underlineToCapitalizeCamel(String str) {
        str = underlineToCamel(str);
        return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
    }
}
