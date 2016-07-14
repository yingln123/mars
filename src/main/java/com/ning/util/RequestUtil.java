package com.ning.util;

import javax.servlet.http.HttpServletRequest;

/**
 * web请求解析工具
 *
 */
public class RequestUtil {
	
	/**
	 * 获取用户请求的真实IP地址(有隐患)
	 * http://www.cnblogs.com/chengmo/archive/2013/05/29/php.html  网络资源
	 * http://www.cnblogs.com/chengmo/archive/2013/05/31/php-2.html 网络资源
	 * @param request
	 * @param keys
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
        String requestKey = "x-forwarded-for";	//
        if (request.getHeader(requestKey) == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader(requestKey);
    }
}
