<%@page import="Modelos.Libro"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
      <!-- Metadatos -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">   
        <meta property="fb:admins" content="{126104161298033}"/>
        <title>LogIn de prueba capitulo</title> 
      <!-- Metadatos -->

      <!-- Estilos CSS -->
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
      <!-- Estilos CSS -->

      <!-- Funcionalidad de Redes Sociales -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="canonical" href="/web/tweet-button">
        <link rel="me" href="https://twitter.com/twitterdev">
      <!-- Funcionalidad de Redes Sociales -->

      <!-- JavaScript -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/deresSociales.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/peticionesAjax.js"></script>
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
      <!-- JavaScript -->
    </head>

    <body>
        <div id="fb-root"><!-- Carga contenidos de FaceBook --></div>
        <form:form method="POST" modelAttribute="log">
          <nav>
                <div class="nav-wrapper amber accent-3">
                    <a href="<%=request.getContextPath()%>/listado.htm"><img src="<%=request.getContextPath()%>/imgen/Captura.png" alt="" class=" responsive-img"></a>
                    <ul class="right hide-on-med-and-down" id="nl" style="display: ">
                        <li> <input id="search" type="search" ></li>
                        <li> <label for="search"><i class="material-icons">search</i></label></li>
                        <li><a href="<%=request.getContextPath()%>/pAutorL.htm" class="material-icons">perm_identity</a></li>
                        <li><a href="<%=request.getContextPath()%>/nuevoLibro.htm" class="material-icons">library_add</a></li>
                        <li><a href="<%=request.getContextPath()%>/CambiaPass.htm" class="material-icons">vpn_key</a></li>
                        <li><a href="<%=request.getContextPath()%>/main.htm" class="material-icons" onclick="logout()">input</a></li>     

                    </ul>

                    <ul class="right hide-on-med-and-down" id="sl" style="display: none;">
                        <li> <input id="search" type="search"></li>
                        <li> <label for="search"><i class="material-icons">search</i></label></li>
                        <li><input  type="text" name="userName" length="5" value="<spring:message code="label.nombre" />"></li>                   
                        <li><input  type="password" name="password" length="5" value="<spring:message code="label.contra" />"></li>                   
                        <li><button class="black waves-light btn" type="submit" name="login" value="Logear"><spring:message code="label.insesion" /></button></li>
                        <li><button class="black waves-light btn" type="submit" name="registrarse" value="Register"><spring:message code="label.registrar" /></button></li>   
                        <div style=""><div style="color: red">${param.error}</div> <br><a href="<%=request.getContextPath()%>/RestaurarContra.htm" ><spring:message code="label.olcon" /></a></div>

                    </ul> 
                </div>
            </nav>

          <div class="row col s6 m2 l2">
              <h5 class="left-align">${libro.nombre}</h5>
              <img class="responsive-img col s6 m2 l2" src="data:image/jpeg;base64,${portada}">
              <div class="row col s6 m2 l2">
                    <iframe src="https://www.facebook.com/plugins/like.php?href=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&width=143&layout=button&action=like&size=small&show_faces=false&share=true&height=65&appId=126104161298033" width="143" height="65" style="border:none;overflow:hidden" scrolling="no" frameborder="0" allowTransparency="true"></iframe>

                    <!-- Inserta esta etiqueta donde quieras que aparezca Botón Compartir.
                    <div class="g-plus col s6 m2 l2" data-action="share" data-annotation="none" data-href="https://translate.google.com.mx"></div>
                     Inserta esta etiqueta después de la última etiqueta de compartir. -->

                    <a href="https://twitter.com/share" class="twitter-share-button">Tweet</a>
              </div>
            
            <table class="highlight row col s6 m2 l2">
              <thead>
                  <tr>
                      <th colspan='2'>
                          <h2>Cap�tulos</h2>
                      </th>
                  </tr>
              </thead>
              <tbody>
                <c:forEach items="${capitulos}" var="capitulo" varStatus="loop">
                    <tr id="${capitulo.idCapitulo}">
                        <td>
                            <a class="carousel-item" href="<%=request.getContextPath()%>/${capitulo.capitulo}" style="width: 35%; margin-top: -7%;">${capitulo.nombre}</a>                                      
                        </td>
                        <c:if test="${perfil == 1 or perfil == 2}">
                        <td>
                            <i class="Small material-icons" style="cursor: pointer" onclick="eliminarCapitulo('<%=request.getContextPath()%>','${capitulo.idCapitulo}');">delete</i>
                        </td>
                        </c:if>
                    </tr>
                </c:forEach>
              </tbody>
            </table>

          </div>

          <div class="col s6 m4 l5"> 
            <ul class="collection">
              <li class="collection-item avatar">
                <img src="data:image/jpeg;base64,${foto}" alt="" class="circle responsive-img col s6 m2 l3">
                <span class="title"></span>
                <p>Autor: ${autor.pseudonimo}
                  <br>
                   Mensaje de Perfil: ${autor.mensaje}
                </p>
                <a href="#!" class="secondary-content"><i class="material-icons col s6 m2 l3">grade</i></a>
              </li>
            </ul>
          </div>
          <a href="#!" class="btn" onclick="Materialize.showStaggeredList('#staggered-test')">Click Me</a>
          <div class="fb-comments" data-href="https://developers.facebook.com/docs/plugins/comments#configurator" data-numposts="3">
            <!-- Comentarios de Facebook -->
          </div>
        </form:form>

        <footer class="amber accent-3 col s12 m4 l3">
          <div class="container col s12 m4 l3">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">TT2016-A010</h5>
                <p class="grey-text text-lighten-4">SITIO WEB PARA LA VISUALIZACIÓN Y DIFUSIÓN DE CONTENIDO LITERARIO GENERADO POR LOS USUARIOS.</p>
              </div>

              <div class="col s12 m4 l3">
                <h5 class="white-text">Settings</h5>
                <ul>
                  <li><a class="white-text" href="#!">Link 1</a></li>
                  <li><a class="white-text" href="#!">Link 2</a></li>
                  <li><a class="white-text" href="#!">Link 3</a></li>
                  <li><a class="white-text" href="#!">Link 4</a></li>
                </ul>
              </div>

              <div class="col s12 m4 l3">
                <h5 class="white-text">Connect</h5>
                <ul>
                  <li><a class="white-text" href="#!">edgar061093@gmail.com</a></li>
                  <li><a class="white-text" href="#!">silvernoble@gmail.com</a></li>
                </ul>
              </div>
            </div>
          </div>

          <div class="footer-copyright">
           <!-- Completar -->
          </div>
        </footer>
  </body>
</html>