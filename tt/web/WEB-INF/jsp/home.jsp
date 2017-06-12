
<%@page import="utilidades.Rutas"%>
<%@page import="DAO.LibroDAO"%>
<%@page import="Modelos.Libro"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Home</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>

        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script> 
        <script src="js/materialize.js"></script>

        <script>

            $(document).ready(function () {
                var angle = 90;
                $('#image').css('transform', 'rotate(' + angle + 'deg)');
                $('ul.tabs').tabs();
                $('ul.tabs').tabs({
                    onShow: function (tab) {
                        $('.carousel.carousel-slider').carousel();

                    }
                });
                $('.carousel').carousel({
                    padding: 100
                });

                $('#carousel2').carousel({
                    padding: 100
                });

                $("#test2Tab").click(function () {
                    setTimeout(autoplay, 3000);
                    $('#test2').carousel('next');
                    //  $('#test2').carousel('set', 4);
                });
                function autoplay() {
                    $('.carousel').carousel('next');
                    //  $('.carousel').carousel('set', 4);
                    $('.carousel-slider').slider({full_width: true});
                    setTimeout(autoplay, 4500);
                }

                autoplay()
                $('.icons2').css({
                    "-webkit-transform": "translate(100px,100px)",
                    "-ms-transform": "translate(100px,100px)",
                    "transform": "translate(100px,100px)"
                });
                //  $('.carousel.carousel-slider').carousel({full_width: true});
            });

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
        <style>
            .icons{
                display:inline-block;
                margin-top: 1%;
                padding-left: 1%;
                width: 200px; 
                height: 200px; 
            }
        </style>
    </head>
    <body>
        <c:set var = "idioma" scope = "session" value = "${pageContext.response.locale}"/>
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


        <div class="row">
            <div class="col s12">
                <ul class="tabs">
                    <li class="tab col s3"><a class="active" href="#test1">Random</a></li>
                    <li class="tab col s3"><a href="#test2" id="test2Tab">Recientes</a></li>
                    <li class="tab col s3"><a href="#test3">Los más Gustados</a></li>
                    <!--  <li class="tab col s3"><a href="#test4">Seguidos</a></li>-->
                </ul>
            </div>
            <div id="test1" class="carousel col s12 blue-grey lighten-5">
                <c:forEach items="${model.listaImagenesRandom}" var="imagen" varStatus="loop">
                    <a class="carousel-item" href="<%=request.getContextPath()%>/perfildelibro.htm?idLibro=${model.idLibros.get(loop.index)}" style="width: 35%; margin-top: -7%;"><c:out value="${model.listaTitulosRandom.get(loop.index)}"/> <img src="data:image/jpeg;base64,${imagen}" alt="" class=" responsive-img" ></a>                                      
                    </c:forEach>
                <br>
                <br>
            </div>

            <div id="test2" class="carousel col s12 blue-grey lighten-5">
                <c:forEach items="${model.listaImagenesRecientes}" var="imagen" varStatus="loop">
                    <a class="carousel-item carousel2" href="<%=request.getContextPath()%>/perfildelibro.htm?idLibro=${model.idLibros.get(loop.index)}" style="width: 35%; margin-top: -7%; margin-left: -10%;"><c:out value="${model.listaTitulosRecientes.get(loop.index)}"/> <img src="data:image/jpeg;base64,${imagen}" alt="" class=" responsive-img" ></a>                                      
                    </c:forEach>
                <br>
                <br>
            </div>

            <div id="test3" class="blue-grey lighten-5" >
                <c:forEach items="${model.listaImagenesMasGustados}" var="imagen" varStatus="loop">
                    <a class="" href="<%=request.getContextPath()%>/perfildelibro.htm?idLibro=${model.idLibros.get(loop.index)}"><img src="data:image/jpeg;base64,${imagen}" alt="" class="icons" ></a>                                      
                </c:forEach>
                <br><br>            
            </div>
            <footer class="page-footer orange">
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



    </body>
</html>