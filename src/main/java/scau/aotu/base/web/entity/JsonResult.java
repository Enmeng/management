package scau.aotu.base.web.entity;

import scau.aotu.base.web.constant.JsonResultCode;

import java.util.Date;


/**
 * 统一json 返回
 * 
 * {
 *   retcode : 0 // 错误返回码, 参考JsonResultCode
 *   ts : //服务器时间
 *   msg : // 信息
 * }
 * 
 */
public class JsonResult {


    private Object model;
    
    /**
     * 返回码
     */
    private int retcode;
    
    /**
     * 服务器时间
     */
    private long ts = new Date().getTime();
    
 
	public JsonResult() {
		 this.retcode = JsonResultCode.SUCCESS;
    }

    public JsonResult(int retcode, Object model) {
        this.retcode = retcode;
        this.model = model;
    }
    
    public JsonResult(Object model) {
        this.retcode = JsonResultCode.SUCCESS;
        this.model = model;
    }
    
    public int getRetcode() {
 		return retcode;
 	}

 	public void setRetcode(int retcode) {
 		this.retcode = retcode;
 	}

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}
    

}
