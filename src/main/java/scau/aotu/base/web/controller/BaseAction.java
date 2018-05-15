package scau.aotu.base.web.controller;

import scau.aotu.base.web.captcha.CaptchaGeneratorServlet;
import scau.aotu.base.web.constant.JsonResultCode;
import scau.aotu.base.web.entity.JsonResult;

import javax.servlet.http.HttpServletRequest;

public class BaseAction {

    public BaseAction() {
    }


    /**
     * 指定返回码和返回内容创建json
     *
     * @param recode
     * @param model
     * @return
     */
    protected JsonResult createJsonResult(int recode, Object model) {
        return new JsonResult(recode, model);
    }

    /**
     * 创建只返回成功状态码的json
     *
     * @return
     */
    protected JsonResult createSuccessJson() {
        return new JsonResult(JsonResultCode.SUCCESS, null);
    }

    /**
     * 指定内容创建成功状态的json
     *
     * @param model
     * @return
     */
    protected JsonResult createSuccessJson(Object model) {
        return this.createJsonResult(JsonResultCode.SUCCESS, model);
    }

    /**
     * 不指定内容创建成功状态的json
     *
     * @param retcode
     * @return
     */
    protected JsonResult createSuccessJson(int retcode) {
        return this.createJsonResult(retcode, null);
    }


    /**
     * 创建只返回未知错误状态码的json
     *
     * @return
     */
    protected JsonResult createErrorJson() {
        return new JsonResult(JsonResultCode.UNKNOW_ERROR, null);
    }

    /**
     * 指定内容生成未知错误的json
     *
     * @param model
     * @return
     */
    protected JsonResult createErrorJson(Object model) {
        return this.createJsonResult(JsonResultCode.UNKNOW_ERROR, model);
    }

    /**
     * @param retcode
     * @return
     */
    protected JsonResult createErrorJson(int retcode) {
        return this.createJsonResult(retcode, null);
    }

    /**
     * 判断验证码是否正确
     *
     * @param request
     * @param randCode
     * @return
     */
    protected boolean isRandCode(HttpServletRequest request, String randCode) {
        Object obj = request.getSession().getAttribute(
                CaptchaGeneratorServlet.VALIDATE_CODE);
        if (obj == null || randCode == null) {
            return false;
        }
        return obj.toString().toLowerCase().equals(randCode.toLowerCase());
    }

    protected String getRemortIP(HttpServletRequest request) {
        String realIP = request.getHeader("X-Real-IP");// 从反向代理获取ip
        if (realIP != null) {
            return realIP;
        } else {
            return request.getRemoteAddr();
        }
    }

}
