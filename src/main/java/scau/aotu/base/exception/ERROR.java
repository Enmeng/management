package scau.aotu.base.exception;

/**
 * Created by lishunpeng on 2015/10/22.
 */
public class ERROR {
    /* 空指针错误 */
    public static final int ERROR_NULLPOINTER = 1;
    /* 参数错误 */
    public static final int ERROR_PARAM_ERROR = 2;
    /* Cache错误 */
    public static final int ERROR_CACHE_STORE_ERROR = 3;
    /* 数据库存储错误 */
    public static final int ERROR_STORE_ERROR       = 4;
    /* SQL错误 */
    public static final int ERROR_STORE_SQL_ERROR   = 5;
    /* 未知系统异常 */
    public static final int ERROR_SYSTEM_ERROR      = 6;
    /* 服务不存在 */
    public static final int ERROR_SERVICE_NOT_EXIST = 7;
    /* service 方法名不支持 */
    public static final int ERROR_SERVICE_METHOD_NOT_VALIDATED = 8;
    /* 没有指定的字段 */
    public static final int ERROR_NO_SUCH_FIELD = 9;
    /* 文件传输错误 */
    public static final int ERROR_FILE_TRANSFER_FAIL = 10;
}
