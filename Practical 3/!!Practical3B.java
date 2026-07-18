<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
version="3.1">
<servlet>
<servlet-name>QuizServlet</servlet-name>
<servlet-class>mypack.QuizServlet</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>QuizServlet</servlet-name>
<url-pattern>/QuizServlet</url-pattern>
</servlet-mapping>
<servlet>
<servlet-name>ShowResult</servlet-name>
<servlet-class>mypack.ShowResult</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>ShowResult</servlet-name>
<url-pattern>/ShowResult</url-pattern>
</servlet-mapping>
</web-app>
