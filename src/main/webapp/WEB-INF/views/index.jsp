<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();  //  +"/ticketRefactor"
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*,html{padding:0px;margin: 0px;font-family: '微软雅黑'}
	html,body{height: 100%;width: 100%;background-image: url('<%=path%>/css/purty_wood.png')}
	h1{width: 100%;text-align: center;padding-top: 200px;}
	h4{width: 100%;text-align: center;}
	div{width:100%}
	div ul{width:500px;margin: 10px auto;list-style: none;height: auto;}
	div ul li{line-height: 20px;height: 20px;}
</style>
</head>
<body>
<h1>Hello world</h1> 

<h4>this is a JSP page</h4>
<hr>
<div>
	<ul>
		<li>Session: demo ==> ${demo }</li>
		<li>Session: USER_TOKEN ==> ${USER_TOKEN }</li>
	</ul>
</div>
</body>
</html>