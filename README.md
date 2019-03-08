# 模仿天猫官网（J2EE）

使用 Servlet + JSP + Tomcat 9.0 模仿实现的天猫官网效果。

![Tmall](http://github.com/Avicii4/tmall/raw/master/tmall/jpg)

### 介绍

* 项目分为前台（http://localhost:8080/tmall/）和后台（http://localhost:8080/tmall/admin）两个部分；
* 由于功能模块较多，使用 Filter 和 Java 反射，简化 XML 文件的配置；
* 后台使用同一个分页机制，减少了开发步骤。

### 运行

1. 下载图片资源：https://pan.baidu.com/s/1x1bLttN1TaI7Rveh-PZRcQ 提取码：s1fs 

2. 将 Database/tmall.sql 导入 MySQL 中；

3. 打开 tomcat/conf/server.xml，在 `<Host` 下加入以下配置：

   ```xml
   <Context path="/tmall" docBase="your-path-to-the-file\\tmall\\web" debug="0" reloadable="false" />
   ```

   如有任何疑问，欢迎交流！

