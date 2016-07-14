package com.ning.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统请求日志
 * @author Mf-CX05
 *
 */
public class RequestLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** 访问IP */
	private String Ip;

	/** 请求地址 */
	private String url;
	
	/** 调用者Id */
	private String userId;
	
	/** 操作动作名称 */
	private String actionName;
	
	/** 请求参数 */
	private String parameters;
	
	/** 创建时间  */
	private Date createTime;

	public String getIp() {
		return Ip;
	}

	public void setIp(String ip) {
		Ip = ip;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

}
