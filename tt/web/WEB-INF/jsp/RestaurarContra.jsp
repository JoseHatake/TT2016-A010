<%-- 
    Document   : recuperaContraseña
    Created on : 07-jun-2017, 19:41:10
    Author     : edgar
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>

        <title></title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body>


        <nav>
            <div class="amber accent-3">
                <img src="<%=request.getContextPath()%>/imgen/Captura.png" alt="" class=" responsive-img">
                <ul class="right hide-on-med-and-down"></ul>
            </div>
        </nav>



        <form:form method="POST" action="" class="col s4 center">



            <div class="row">
                <div class="input-field col s4">
                    <i class="material-icons prefix">email</i>
                    <input id="email" type="text" name= "mail" class="validate"/>
                    <label for="icon_telephone"><spring:message code="label.introducirCorreo" /></label>
                </div>  
                <br>
                <div style="color:red; font-size: 14px; padding-right: 1100px">
                    ${error}
                </div>
            </div>



            <button class="btn waves-effect waves-light" type="submit" name="rcon"><spring:message code="label.recuperaContraseña" />
                <i class="material-icons center">send</i>
            </button>

        </form:form>




        <footer class="amber accent-3">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">TT2016-A010</h5>
                        <p class="grey-text text-lighten-4"><spring:message code="label.sitioWeb" /></p>


                    </div>
                    <div class="col l3 s12">
                        <h5 class="white-text"><spring:message code="label.comunidad" /></h5>
                        <ul>
                            <li><a class="white-text" href="#!">Facebook</a></li>
                            <li><a class="white-text" href="#!">Twitter</a></li>
                            <li><a class="white-text" href="#!">Google+</a></li>
                            <li><a class="white-text" href="#!">--------</a></li>
                        </ul>
                    </div>
                    <div class="col l3 s12">
                        <h5 class="white-text">Connect</h5>
                        <ul>
                            <li><a class="white-text" href="#!">edgar061093@gmail.com</a></li>
                            <li><a class="white-text" href="#!">silvernoble@gmail.com</a></li>
                            <li><a class="white-text" href="#!">---------</a></li>
                            <li><a class="white-text" href="#!">---------</a></li>
                        </ul>
                    </div>
                </div>
            </div>

        </footer>


        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>

    </body>
</html>
