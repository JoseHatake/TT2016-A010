<%-- 
    Document   : logged
    Created on : 7/05/2017, 09:43:35 PM
    Author     : Lock
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br> <spring:message code="label.saludo" /> </br>
       <br> <spring:message code="label.usuario" />: ${pseudonimo}
       <br> <spring:message code="label.msg" />: ${mensaje}
    </body>
</html>
