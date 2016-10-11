#MobileEasy 移动易 —— 手机APP后端 后台管理 综合一体化方案

## 7月份更新在devel分支，请自行切换。贡献请加入企鹅讨论群：103880410，请注明来自[赛克通博客](https://blog.sectong.com)或GitHub。复制代码，记得Fork并且Star。一旦有更新，会推送到你个人的GitHub账号中，切记切记。另：配套混合APP端在 [mobileeasyapp](https://github.com/sectong/mobileeasyapp)，与此后台框架无缝结合。

10月22日 线下见面会活动预告，欢迎报名。

<a style="background-color:#62b651;color:white;border-radius:2px;cursor:pointer;font-size:14px;padding:8px 10px;" href=
                            "http://www.huodongxing.com/event/8353869585000" target="_blank" title="立即报名">立即报名</a>

##架构设计
![Alt 架构设计](https://cloud.githubusercontent.com/assets/3350211/8512734/6e6de47a-2383-11e5-8f1f-f30632b556d1.png)
##业务逻辑层次划分
![业务逻辑层次划分](https://cloud.githubusercontent.com/assets/3350211/8520535/a580a94a-240d-11e5-8516-1d6f1b1ef317.jpg)
##在线API参考手册
![Alt 在线API参考手册](https://cloud.githubusercontent.com/assets/3350211/8520167/a0072938-240a-11e5-8f74-4496a72f0355.png)
##管理后台主页
![Alt 管理后台主页](https://cloud.githubusercontent.com/assets/3350211/8520168/a477b604-240a-11e5-84c1-8dc71d2f5496.png)
##管理后台-用户管理
![Alt 管理后台-用户管理](https://cloud.githubusercontent.com/assets/3350211/8520171/a6689f3c-240a-11e5-8f2c-889a77f871ff.png)
##数据库管理后台-基于lightadmin
![lightadmin-database](https://cloud.githubusercontent.com/assets/3350211/8520344/e0bfb958-240b-11e5-90b4-78625bd0e3de.png)

##启动应用步骤：
#####1、本地新建MySQL数据库demo，导入数据表（下面有create user table）;
#####2、本地启动redis服务器(默认redis存储token已关闭，可以在demo.session中去掉注释，来开启redis给功能)；
#####3、运行 
```
mvn spring-boot:run
log出现：Tomcat started on port(s): 8080 (http)，证明启动成功
```
##访问在线API文档:
http://localhost:8080/debug/index.html 即可在线查看API手册和调试API。

##具体测试操作步骤
#####1、使用在线API注册用户： /api/create 接口；
#####2、http://localhost:8080/ 测试“多重认证”（web form模拟web应用和httpBasic模拟客户端应用）；
#####3、http://localhost:8080/admin/ 登录访问图形管理界面（需要在authorities表中增加一条 第1步中创建的用户权限，比如：admin ROLE_ADMIN ）；
#####4、http://localhsot:8080/lightadmin/ 可GUI管理数据库；


##创建数据库
create user table:
```
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `image` varchar(200) DEFAULT '',
  `enabled` varchar(45) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;


CREATE TABLE `authorities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `authority` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`,`authority`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
```

##API保活访问采用cookie方式，APP客户端需要把cookie放在http  header中发送到服务端，测试如下，SESSION换成你得到的cookie即可
```
curl http://localhost:8080/api/i/user/9 -H "Cookie:SESSION=5b55e933-7c68-4333-82e4-656d777d72a4"
```

## 如果部署到Tomcat中，需要稍微修改一下

### 修改pom.xml文件

官方参考：
http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#build-tool-plugins-maven-packaging

```

	<?xml version="1.0" encoding="UTF-8"?>
	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	    <!-- ... -->
	    <packaging>war</packaging>
	    <!-- ... -->
	    <dependencies>
	        <dependency>
	            <groupId>org.springframework.boot</groupId>
	            <artifactId>spring-boot-starter-web</artifactId>
	        </dependency>
	        <dependency>
	            <groupId>org.springframework.boot</groupId>
	            <artifactId>spring-boot-starter-tomcat</artifactId>
	            <scope>provided</scope>
	        </dependency>
	        <!-- ... -->
	    </dependencies>
	</project>

```

将包改成 war，加入tomcat的scope为 provided，这样部署到TOMCAT就不会启动内置的tomcat了。

### 修改启动类

官方参考：
http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-create-a-deployable-war-file

```

	@SpringBootApplication
	public class Application extends SpringBootServletInitializer {
	
	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Application.class);
	    }
	
	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(Application.class, args);
	    }
	
	}

```

将你的启动类改成以上样式。 mvn package 打包，并把target下的war包部署到TOMCAT即可。



## 任何新的需求建议，bug提交，贡献请加入企鹅讨论群：103880410，请注明来自[赛克通博客](https://blog.sectong.com)或GitHub。