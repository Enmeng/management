package scau.aotu.base.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import scau.aotu.base.exception.BaseException;
import scau.aotu.base.exception.ERROR;

/**
 * Created by lishunpeng on 2015/10/23.
 */
@Component
@Aspect
public class ServiceMethodCheckAop {
    private Logger logger = Logger.getLogger(ServiceMethodCheckAop.class);

    @Around("execution(* scau.aotu.business.service..*.*(..))")
    public Object methodCheck(ProceedingJoinPoint pjp) throws Throwable{
        String methodName = pjp.getSignature().getName();
        if(isValidServiceMethodForTx(methodName)){
            return pjp.proceed();
        }
        logger.error("=====================================================");
        logger.error("==出于事务管理原因，Service方法只能使用以下前缀命名的方法名==");
        logger.error("==新增方法：add*==");
        logger.error("==删除方法：delete*==");
        logger.error("==修改方法：update*==");
        logger.error("==查询单个值方法：get*==");
        logger.error("==查询多个值方法：list*==");
        logger.error("==查询分页方法：page*==");
        logger.error("==查询数量方法：count*==");
        logger.error("=====================================================");
        throw new BaseException(ERROR.ERROR_SERVICE_METHOD_NOT_VALIDATED);
    }

    private Boolean isValidServiceMethodForTx(String methodName){
        if(methodName.startsWith("add")
                || methodName.startsWith("update")
                || methodName.startsWith("delete")
                || methodName.startsWith("get")
                || methodName.startsWith("list")
                || methodName.startsWith("count")){
            return true;
        }
        return false;
    }
}
