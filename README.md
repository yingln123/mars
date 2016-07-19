# Mars 是 一个负责开源框架集成的项目#

以springMVC为原型集成开发组件myBatis、Redis、MQ等等  之后会在添加的时候一一介绍
项目中以maven为构建工具，使用是本地需要安装maven并且配置好maven环境

## mybatis_demo1分支
	这个分支主要是讲spring整合mybatis
	添加日志打印(log4j)
	SQL我们会记录在sql目录下
	对mybatis修改配置，多数据源配置，读写分离
	
	
	注：properties文件中文显示问题
	   eclipse的.properties文件默认的编码方式是iso-8859-1，所以显示中文是有问题，我们修改开发环境的编码格式后需要对properties的显示格式也要做一下修改，Window --> preferences --> General -- Content Types 下面的  Text --> Java Properties File中的 .properties (locked)编码改为UTF-8 就阔以了
