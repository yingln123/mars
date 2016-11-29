# Mars 是 负责项目集成的一个项目#

以springMVC为原型集成开发组件myBatis、Redis、MQ等等  之后会在添加的时候一一介绍
项目中以maven为构建工具，使用是本地需要安装maven并且配置好maven环境

## 主分支项目包含内容：
	借助用户登录使用到以下技术点
	*   web原生过滤器：实现访问登录限制、对session的操作
	*   web原生监听器：实现对web 启动配置参数的读取
	*   springMVC的拦截器：基本配置和使用方式，实现访问登录限制和对session的操作
	*   原生annotation：基本定义和使用
	*   annotation配合springMVC实现记录系统访问日志功能配合（RequestLogAspect）：技术点annotation、springAOP（aspect）

## 下面是介绍各个分支的作用
### mybatis_demo1 
	集成mybatis框架并且添加log4j日志打印[主要是打印SQL语句]
### mybatis_demo2
	mybatis配置多数据源、读写分离


###
Logback 分为三个模块：logback-core，logback-classic，logback-access
logback-core 是核心；
logback-classic 改善了 log4j，且自身实现了 SLF4J API，所以即使用 Logback 你仍然可以使用其他的日志实现，如原始的 Log4J，java.util.logging 等；
logback-access 让你方便的访问日志信息，如通过 http 的方式

-----


	
