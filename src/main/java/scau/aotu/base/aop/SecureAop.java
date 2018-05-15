package scau.aotu.base.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Created by leeshunpeng on 2015/6/18.
 */
@Component //依赖注入
@Aspect //标注为切面类
public class SecureAop {
    private static Logger logger = Logger.getLogger(SecureAop.class);

    public SecureAop(){
        System.out.println("=============================================================== SecureAop start....");
    }
    //通知类型
    //@Before 在连接点执行前执行
    //@After 在连接点执行后(不管是成功还是异常)
    //@AfterReturning 在连接点执行后(成功，不包括异常)
    //@AfterThrowing 抛出异常后通知
    //@Around 环绕通知 可在连接点前后执行

    @Around("@annotation(scau.aotu.base.annotation.SecureValid)")
    public Object secureHandler(ProceedingJoinPoint pjp) throws Throwable{
        logger.info("secureHandler start ...");

        //拦截的实体类
        Object target = pjp.getTarget();
        //拦截的方法
        String methodName = pjp.getSignature().getName();
        //拦截的方法参数
        Object[] methodArgs = pjp.getArgs();
        //获取方法参数类型
        Class[] parameterTypes = ((MethodSignature)pjp.getSignature()).getMethod().getParameterTypes();

        logger.info("methodName:"+methodName);

        //业务处理

        //继续执行代码
        Object retVal = null;

        retVal = pjp.proceed();

        logger.info("secureHandler end ...");
        return retVal;
    }
}
