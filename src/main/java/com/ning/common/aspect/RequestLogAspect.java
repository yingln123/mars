package com.ning.common.aspect;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.ning.common.annotation.ActionControllerLog;
import com.ning.entity.RequestLog;
import com.ning.service.RequestLogService;
import com.ning.util.RequestUtil;
/**
 * spring Aspect 实现自定义注解的日志记录
 * 网络资源：http://www.oschina.net/code/snippet_1159320_49213
 */
@Aspect
@Component
public class RequestLogAspect {
	
	@Autowired
	private RequestLogService requestLogService;

	public RequestLogAspect() {
		System.out.println("init RequestLogAspect");
	}
	
	 //Controller层切点
    @Pointcut("@annotation(com.ning.common.annotation.ActionControllerLog)")
    public void controllerAspect() { }  
    
    
    /**  
     * 前置通知 用于拦截Controller层记录用户的操作 
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut="controllerAspect()")
    //@AfterReturning("within(com.ning..*) && @annotation(com.ning.common.annotation.ActionControllerLog)")
    public  void doBefore(JoinPoint joinPoint) {
    	System.out.println("RequestLogAspect ==> doBefore");
        handleLog(joinPoint,null);
    }
    
    @AfterThrowing(value = "controllerAspect()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e) {
    	System.out.println("RequestLogAspect ==> doAfter");
        handleLog(joinPoint, e);
    }
    
    /**
     * 业务操作
     * @param joinPoint
     * @param e
     */
    private void handleLog(JoinPoint joinPoint,Exception e) {
        try {
            //获得注解
            ActionControllerLog controllerLog = giveController(joinPoint);
            if(controllerLog == null)
            {
                return;
            }
            
            /**
             * 在spring mvc中，为了随时都能取到当前请求的request对象，可以通过RequestContextHolder的静态方法getRequestAttributes()获取Request相关的变量，如request, response等。
             */
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
         
            //从session获取用户、访问IP、访问URL
            String userId = (String) request.getSession().getAttribute("USER_ID");
            String ip = RequestUtil.getIpAddress(request);
            String url = request.getRequestURI();
            
            //初始化请求log对象
            RequestLog requestLog = new RequestLog();
            requestLog.setIp(ip); 
            requestLog.setUserId(userId);
            requestLog.setCreateTime(new Date());
            requestLog.setUrl(url);
            
            //处理设置注解上的参数
            getControllerMethodDescription(controllerLog, requestLog, request);
            
            //保存数据库
            this.requestLogService.addRequestLog(requestLog);
          }  catch (Exception exp) {
          /** 
           * 	记录本地异常日志
           * 	logger.error("==前置通知异常==");
           *	logger.error("异常信息:{}", exp.getMessage());
           */
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
   
   /*
    * 获取注解中对方法的描述信息 用于Controller层注解
    *
    * @param joinPoint 切点
    *
    * @return 方法描述
    *
    * @throws Exception
    */
   public static void getControllerMethodDescription(ActionControllerLog controllerLog, RequestLog requestLog, HttpServletRequest request) throws Exception {

       // 设置标题
	   requestLog.setActionName(controllerLog.action());
	   
       // 是否需要保存request，参数和值
       if (controllerLog.isSaveRequestData()) {
           // 获取参数的信息，传入到数据库中。
           setRequestValue(requestLog, request);
       }
   }
   
   /**
    * 获取请求的参数，放到log中
    *
    * @param userlogModel
    * @param request
    */
   private static void setRequestValue(RequestLog requestLog, HttpServletRequest request) {
       if (requestLog == null)
    	   requestLog = new RequestLog();
       @SuppressWarnings("rawtypes")
       Map map = request.getParameterMap();
       String params = JSONObject.toJSONString(map);
       requestLog.setParameters(params);
   }
    
}
