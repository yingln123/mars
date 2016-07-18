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
	
	
## 另外简单介绍一下spring包的作用	
### spring-core###
	Spring 其它组件要都要使用到这个包里的类，是其它组件的基本核心，当然你也可以在自己的应用系统中使用这些工具类。外部依赖Commons Logging， (Log4J)。
	
### spring-aop
	这个jar 文件包含在应用中使用Spring 的AOP 特性时所需的类和源码级元数据支持。使用基于AOP 的Spring特性，如声明型事务管理（Declarative Transaction Management），也要在应用里包含这个jar包。
	外部依赖spring-core， (spring-beans，AOP Alliance， CGLIB，Commons Attributes)。
	
### spring-aspects
	spring提供对AspectJ的支持
	
### spring-beans
	springIoC（依赖注入）的基础实现，所有应用都要用到的，它包含访问配置文件、创建和管理bean以及进行Inversion of Control / Dependency Injection（IoC/DI）操作相关的所有类。
	如果应用只需基本的IoC/DI 支持，引入spring-core.jar 及spring-beans.jar 文件就可以了。
	
### spring-context
	这个jar 文件为Spring 核心提供了大量扩展。可以找到使用Spring ApplicationContext特性时所需的全部类，JDNI 所需的全部类，instrumentation组件以及校验Validation 方面的相关类。
	spring 提供在基础 IoC 功能上的扩展服务，此外还提供许多企业级服务的支持，如 邮件服务、任务调度、JNDI定位、EJB 集成、远程访问、 缓存以及各种视图层框架的封装等。
	外部依赖spring-beans, (spring-aop)。
	
### spring-context-support
	spring-context 的扩展支持，包含支持缓存Cache（ehcache）、JCA、JMX、邮件服务（Java Mail、COS Mail）、任务计划Scheduling（Timer、Quartz）方面类。
	
### spring-expression
	Spring表达式语言
	
### spring-jdbc
	包含对Spring对JDBC数据访问进行封装的所有类
	
### spring-jms
	提供了对JMS 1.0.2/1.1的支持类
	
### spring-orm
	spring提供orm框架的支持（hibernate3、hibernate4、jdo、jpa）

### spring-oxm
	spring 对Object/XMI 的映射的支持，可以让JAVA与XML之间来回切换。
	这是spring3.0添加的一个新特性 O/X Mapper，O/X 映射器这个概念并不新鲜，O 代表 Object，X 代表 XML。它的目的是在 Java 对象（几乎总是一个 plain old Java object，或简写为 POJO）和 XML 文档之间来回转换。

### spring-tx
	jar文件包含Spring DAO、Spring Transaction进行数据访问的所有类。为了使用声明型事务支持，还需在自己的应用里包含spring-aop.jar
	
### spring-web
	包含Web应用开发时，用到Spring框架时所需的核心类，包括自动载入WebApplicationContext 特性的类、Struts与JSF集成类、文件上传的支持类、Filter类和大量工具辅助类。

### spring-webmvc
	springmvc的核心开发包
	
### spring-test
	spring 对Junit 等测试框架的简单封装
	
	
说明一下：spring-asm.jar
Spring独立的asm程序,Spring2.5.6的时候需要asmJar 包3.0.6开始提供他自己独立的asmJar(后期会在)
在spring中主要是对aop提供支持
ASM是一个java字节码操纵框架，它能被用来动态生成类或者增强既有类的功能。ASM 可以直接产生二进制 class 文件，也可以在类被加载入 Java 虚拟机之前动态改变类行为。Java class 被存储在严格格式定义的 .class文件里，这些类文件拥有足够的元数据来解析类中的所有元素：类名称、方法、属性以及 Java 字节码（指令）。ASM从类文件中读入信息后，能够改变类行为，分析类信息，甚至能够根据用户要求生成新类。
ASM是小巧轻便的 Java 字节码操控框架 ，它能方便地生成和改造 Java 代码。
asm字节码增强技术主要是用来反射的时候提升性能的，如果单纯用jdk的反射调用，性能是非常低下的，而使用字节码增强技术后反射调用的时间已经基本可以与直接调用无差别
CGLIB是对ASM的封装，简化了ASM的操作，降低了ASM的使用门槛



## 下面是介绍各个分支的作用
### mybatis_demo1 
	集成mybatis框架并且添加log4j日志打印[主要是打印SQL语句]



	
