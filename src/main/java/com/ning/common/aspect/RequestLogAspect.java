package com.ning.common.aspect;

import java.lang.reflect.Method;




import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import com.ning.common.annotation.ActionControllerLog;
/**
 * spring Aspect 实现自定义注解的日志记录
 * 网络资源：http://www.oschina.net/code/snippet_1159320_49213
 */
@Aspect
@Component
public class RequestLogAspect {

	 //Controller层切点
    @Pointcut("@annotation(com.dlodlo.util.ActionControllerLog)")
    public void controllerAspect() { }  
    
    
    /**  
     * 前置通知 用于拦截Controller层记录用户的操作 
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut="controllerAspect()")
    public  void doBefore(JoinPoint joinPoint) {
        //handleLog(joinPoint,null);
    	
    }
    
    
    private void handleLog(JoinPoint joinPoint,Exception e) {
        try {
            //获得注解
            ActionControllerLog controllerLog = giveController(joinPoint);
            if(controllerLog == null)
            {
                return;
            }
            //获取当前的用户
         /*   ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();*/
           // HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
           // BusUserModel userModel = (BusUserModel) SessionUtil.getAttrAsObject(request, SessionUtil.SESSION_USER);
             
            //*========数据库日志=========*//    
          /*  BusUserlogModel userlogModel = new BusUserlogModel();
            //请求的IP
            String ip = MethodUtil.getIpAddr(request);
            userlogModel.setUserIp(ip); 
            userlogModel.setCreateTIme(new Date());
            userlogModel.setUrl(request.getRequestURI());
            if(userModel != null)
            {
                userlogModel.setUserId(userModel.getId().longValue());
                userlogModel.setUserName(userModel.getUserName());
            }
             
            if(e != null)
                userlogModel.setErrorMessage(e.getMessage());
             
            //处理设置注解上的参数
            getControllerMethodDescription(controllerLog,userlogModel,request);
            //保存数据库
            busUserlogService.insert(userlogModel);*/
          }  catch (Exception exp) {
           //记录本地异常日志
          /* logger.error("==前置通知异常==");
           logger.error("异常信息:{}", exp.getMessage());*/
           exp.printStackTrace();
          }
    }
    
    
   /**
    * 是否存在注解，如果存在就记录日志
    * @param joinPoint
    * @param controllerLog
    * @return
    * @throws Exception
    */
   private static ActionControllerLog giveController(JoinPoint joinPoint) throws Exception
   {
       Signature signature = joinPoint.getSignature();
       MethodSignature methodSignature = (MethodSignature) signature;  
       Method method = methodSignature.getMethod();  
        
       if(method != null)
       {
           return method.getAnnotation(ActionControllerLog.class);
       }
       return null;
   }
    
}
