<%-- 
    Document   : cambiaConstraseña
    Created on : 10-jun-2017, 13:35:59
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

        <title>Cambia Contraseña</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body>


        <nav>
            <div class="nav-wrapper amber accent-3">
                <a href="<%=request.getContextPath()%>/listado.htm"><img src="<%=request.getContextPath()%>/imgen/Captura.png" alt="" class=" responsive-img"></a>
                <ul class="right hide-on-med-and-down">
                    <li> <input id="search" type="search" ></li>
                    <li> <label for="search"><i class="material-icons">search</i></label></li>
                    <li><a href="<%=request.getContextPath()%>/pAutorL.htm" class="material-icons">perm_identity</a></li>
                    <li><a href="<%=request.getContextPath()%>/nuevoLibro.htm" class="material-icons">library_add</a></li>
                    <li><a href="<%=request.getContextPath()%>/CambiaPass.htm" class="material-icons">vpn_key</a></li>
                    <li><a href="<%=request.getContextPath()%>/main.htm" class="material-icons" onclick="logout()">input</a></li>     

                </ul>
            </div>
        </nav>



        <form:form class="col s4 center">

            <div class="row ">
                <label id="mensaje" style="padding-right: 70% ; font-size: 18px; color: ${color}">${mensaje}</label>
            </div>
            <div class="row ">
                <div class="input-field col s4">
                    <i class="material-icons prefix">vpn_key</i>
                    <input id="newpass" type="password" class="validate" name="newpass">
                    <label for="icon_telephone"><spring:message code="label.IntroducirContraseña" /></label>
                </div>

            </div>

            <div class="row center">
                <div class="input-field col s4">
                    <i class="material-icons prefix">vpn_key</i>
                    <input id="pass" type="password" class="validate" name="pass">
                    <label for="icon_telephone"><spring:message code="label.ContraseñaActual" /></label>
                </div>

            </div>


            <button class="btn waves-effect waves-light" type="submit" name="cc">
                <spring:message code="label.cambiarContraseña" />
                <i class="material-icons right">send</i>
            </button>

        </form:form>


        <footer class="amber accent-3">
        <div class="container">
            <div class="row">
                <div class="col l6 s12">
                    <h5 class="white-text">TT2016-A010</h5>
                    <p class="grey-text text-lighten-4">SITIO WEB PARA LA VISUALIZACIÓN Y DIFUSIÓN DE CONTENIDO LITERARIO GENERADO POR LOS USUARIOS.</p>


                </div>
                <div class="col l3 s12">
                    <h5 class="white-text">Comunidad</h5>
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
        <div class="footer-copyright">
            <div class="container">
                Made by <a class="orange-text text-lighten-3" href="http://materializecss.com">Materialize</a>
            </div>
        </div>
    </footer>


        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
        <script type="text/javascript">
                        function logout() {
                            jQuery.ajax({
                                url: "<%=request.getContextPath()%>" + "/logout.htm",
                                type: "POST",
                                success: function () {

                                },
                                error: function () {

                                }
                            });
                        }
        </script>

    </body>
</html>