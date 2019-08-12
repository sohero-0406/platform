package com.jeesite.modules.common.aop;

import com.jeesite.modules.common.entity.CommonLog;
import com.jeesite.modules.common.entity.CommonUser;
import com.jeesite.modules.common.entity.PreEntity;
import com.jeesite.modules.common.service.CommonLogService;
import com.jeesite.modules.common.service.CommonUserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class WebLogAspect {

    @Autowired
    private CommonLogService commonLogService;
    @Autowired
    private CommonUserService commonUserService;

    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.jeesite.modules.common.web..*.*(..))")//切入点描述 这个是controller包的切入点
    public void controllerLog(){}//签名，可以理解成这个切入点的一个名称

    @Before("controllerLog()") //在切入点的方法run之前要干的
    public void logBeforeController(JoinPoint joinPoint) {


        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        // 记录下请求内容
        logger.info("################URL : " + request.getRequestURL().toString());
        logger.info("################HTTP_METHOD : " + request.getMethod());
        logger.info("################IP : " + request.getRemoteAddr());
        logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //logger.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
        //logger.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象

        String loginUserId = PreEntity.getUserIdByToken();


        String ip = request.getRemoteAddr();
        try {

            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
//			System.out.println(methodName+"....");
            Object[] arguments = joinPoint.getArgs();
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String operationType = "";
            String operationName = "";
            int flag = 0;
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    // //System.out.println("--------------------"+method.getName()+"--------------------");
                    if (clazzs.length == arguments.length) {
                        if (method.getAnnotation(Log.class) != null) {
                            operationType = method.getAnnotation(Log.class)
                                    .operationType();
                            operationName = method.getAnnotation(Log.class)
                                    .operationName();
                        }
                        flag++;
                        break;
                    }
                }
            }
            // *========控制台输出=========*//
            // //System.out.println("=====controller后置通知开始=====");
            // //System.out.println("请求方法:" +
            // (joinPoint.getTarget().getClass().getName() + "." +
            // joinPoint.getSignature().getName() + "()")+"."+operationType);
            // //System.out.println("方法描述:" + operationName);
            // //System.out.println("请求人:" + loginUser.getUserName());
            // //System.out.println("请求IP:" + ip);
            // *========数据库日志=========*//
            if(flag>0){
                CommonLog log = new CommonLog();
                //log.setId(UUID.randomUUID().toString());
                log.setDescription(operationName);
                log.setMethod((joinPoint.getTarget().getClass().getName() + "."
                        + joinPoint.getSignature().getName() + "()"));
                log.setOperationType(operationType);
                log.setRequestIp(ip);
                log.setExceptionCode(null);
                log.setExceptionDetail(null);
                log.setParams(null);
                if(loginUserId!=null){
                    CommonUser loginUser = commonUserService.get(loginUserId);
                    log.setCreateBy(loginUser.getUserName());
                }else{
                    log.setCreateBy("匿名");
                }

//            log.setCreateDate(new Date());
                // 保存数据库
                //commonLogService.save(log);
            }

            // //System.out.println("=====controller后置通知结束=====");
        } catch (Exception e) {
            // 记录本地异常日志
            logger.error("==后置通知异常==");
            logger.error("异常信息:{}", e);
        }
    }
}
