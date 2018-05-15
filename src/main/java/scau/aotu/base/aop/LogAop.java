package scau.aotu.base.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import scau.aotu.base.annotation.LogWriter;

import java.lang.reflect.Method;


/**
 * Created by leeshunpeng on 2015/6/18.
 */
@Component
@Aspect
public class LogAop {
    public LogAop(){
        System.out.println("=============================================================== LogAop start....");
    }
    private Logger logger = Logger.getLogger(LogAop.class);

    @Around("execution(* edu.scau.ssm.service..*.*(..))")
    public Object logHandler(ProceedingJoinPoint pjp) throws Throwable{
        logger.info("logHandler start....");
        Object retVal = null;

        //拦截的实体类
        Object target = pjp.getTarget();
        //拦截的方法
        String methodName = pjp.getSignature().getName();
        //拦截的方法参数
        Object[] methodArgs = pjp.getArgs();
        //获取方法参数类型
        Class[] parameterTypes = ((MethodSignature)pjp.getSignature()).getMethod().getParameterTypes();

        Method method = target.getClass().getMethod(methodName, parameterTypes);
        if(null != method){//方法不为空
            if(method.isAnnotationPresent(LogWriter.class)){//判断是否包含自定义的注解
                LogWriter logWriter = method.getAnnotation(LogWriter.class);//获取自定义注解实体
                String moduleName = logWriter.moduleName();//获取注解内容
                logger.info("moduleName:" + moduleName);
                retVal = pjp.proceed();
            }else{//没有包含自定义注解 跳过 不拦截
                retVal = pjp.proceed();
            }
        }else{//不拦截
            retVal = pjp.proceed();
        }

        return retVal;
    }


    @Around("@annotation(lw)")
    public Object beforeLog(ProceedingJoinPoint pjp, LogWriter lw) throws Throwable{
        logger.info("beforeLog start...");
        Object retVal = null;

        //拦截的实体类
        Object target = pjp.getTarget();
        //拦截的方法
        String methodName = pjp.getSignature().getName();
        //拦截的方法参数
        Object[] methodArgs = pjp.getArgs();
        //获取方法参数类型
        Class[] parameterTypes = ((MethodSignature)pjp.getSignature()).getMethod().getParameterTypes();


        retVal = pjp.proceed();
        return retVal;
    }
}
