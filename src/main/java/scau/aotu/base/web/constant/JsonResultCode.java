package scau.aotu.base.web.constant;


public interface JsonResultCode {
	
	/**
	 * 成功
	 */
	public static final int SUCCESS  = 0;
	
	
	/**
	 * 未知错误
	 */
	public static final int UNKNOW_ERROR = 10000; 
	
	
	/**
	 * 未登录
	 */
	public static final int NOT_LOGIN = 10001; 
	
	/**
	 * 验证码错误
	 */
	public static final int RAND_CODE_ERR = 10002; 
	
	/**
	 * 手机格式错误
	 */
	public static final int MOBILE_ERROR = 10003; 
	
	/**
	 * 邮箱格式错误
	 */
	public static final int EMAIL_ERROR = 10004; 
	
	/**
	 * 验证码发送失败
	 */
	public static final int CODE_SEND_ERR = 10005; 
	
	/**
	 * 修改密码失败
	 */
	public static final int MODIFY_PASSWORD_ERROR = 10007; 
	
	/**
	 * 新旧密码不能一致
	 */
	public static final int PASSWORD_NOT_SAME = 10008; 
	
	/**
	 * 新旧电话不能一致
	 */
	public static final int TELEPHONE_NOT_SAME = 10009; 
	
	/**
	 * 身份证绑定失败
	 */
	public static final int IDCARD_NOT_ERROR = 10010; 
	
	/**
	 * 需要绑定身份证
	 */
	public static final int IDCARD_NOT_BIND = 10011; 
	
	/**
	 * not fount
	 */
	public static final int NOT_FOUNT = 10012; 
	
	/**
	 * 邮箱不存在
	 */
	public static final int EMAIL_NOT_IS_EXIST = 10013;
	
	/**
	 * 电话不存在
	 */
	public static final int MOBILE_NOT_IS_EXIST = 10014;
	
	/**
	 * csrf token error
	 */
	public static final int CSRF_TOKEN_ERROR = 10015;
	
	/**
	 * 邮箱重复
	 */
	public static final int EMAIL_DUPLICATED = 10016;
	
	/**
	 * 注册超时
	 */
	public static final int REGISTER_TIMEOUT = 10017;

	/**
	 * 文件格式不支持
	 */
	public static final int FILE_FORMAT_NOT_SUPPORT = 10018;

	/**
	 * 文件大小超过限制值
	 */
	public static final int FILE_SIZE_OVER = 10019;

	/**
	 * 文件数量超过限制值
	 */
	public static final int FILE_NUMBER_OVER = 10020;

	/**
	 * 非文件上传请求
	 */
	public static final int NOT_FILE_UPLOAD_REQUEST = 10021;
}
