<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">    
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script> 
        <title></title>
    </head>

    <body>
        <form:form method="POST" modelAttribute="log">

        <nav>
            <div class="amber accent-3">
               <a href="<%=request.getContextPath()%>/listado.htm"><img src="<%=request.getContextPath()%>/imgen/Captura.png" alt="" class=" responsive-img"></a>
                <ul class="right hide-on-med-and-down">
                    <li> <input id="search" type="search"></li>
                    <li> <label for="search"><i class="material-icons">search</i></label></li>
                    <li><input  type="text" name="userName" length="5" value="<spring:message code="label.nombre" />"></li>                   
                    <li><input  type="password" name="password" length="5" value="<spring:message code="label.contra" />"></li>                   
                    <li><button class="black waves-light btn" type="submit" name="login" value="Logear"><spring:message code="label.insesion" /></button></li>
                    <li><button class="black waves-light btn" type="submit" name="registrarse" value="Register"><spring:message code="label.registrar" /></button></li>   
                    <div style=""><div style="color: red">${param.error}</div> <br><a href="<%=request.getContextPath()%>/RestaurarContra.htm" ><spring:message code="label.olcon" /></a></div>
                    
                </ul> 
                <img class="responsive-img" src="<%=request.getContextPath()%>/imgen/2.jpg">
            </div>

        </nav> 

    </form:form>

</body>

</html>
