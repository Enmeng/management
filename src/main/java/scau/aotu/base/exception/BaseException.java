package scau.aotu.base.exception;

/**
 * Created by lishunpeng on 2015/10/22.
 */
public class BaseException  extends Exception{
    private int errorCode;

    public BaseException(int errorCode){
        this.errorCode = errorCode;
    }

    public BaseException(String message, int errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public  BaseException(Throwable cause, int errorCode){
        super(cause);
        this.errorCode = errorCode;
    }

    public BaseException(String message, Throwable cause, int errorCode){
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
