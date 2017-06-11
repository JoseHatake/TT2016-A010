
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
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
      <!-- JavaScript -->
    </head>

    <body>
      <div id="fb-root"><!-- Carga contenidos de FaceBook --></div>
        <form:form method="POST" modelAttribute="log">
          <nav>
            <div class="amber accent-3">
            <img src="Captura.png" class=" responsive-img">
              <ul class="right hide-on-med-and-down">
                <li> <input id="search" type="search" required></li>
                <li> <label for="search"><i class="material-icons">search</i></label></li>
                <li><i class="material-icons">perm_identity</i></li>
                <li><i class="material-icons">chat_bubble_outline</i></li>
                <li><i class="material-icons">settings</i></li>
              </ul>
            </div>
          </nav>

          <div class="row col s6 m2 l2">
            <h5 class="left-align">Titulo de Obra</h5>
            <img class="responsive-img col s6 m2 l2" src="2016-11-01 21.08.29.jpg">
            <iframe src="https://www.facebook.com/plugins/like.php?href=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&width=143&layout=button&action=like&size=small&show_faces=false&share=true&height=65&appId=126104161298033" width="143" height="65" style="border:none;overflow:hidden" scrolling="no" frameborder="0" allowTransparency="true"></iframe>

            <!-- Inserta esta etiqueta donde quieras que aparezca Botón Compartir. -->
            <div class="g-plus" data-action="share" data-annotation="none" data-href="https://translate.google.com.mx"></div>
            <!-- Inserta esta etiqueta después de la última etiqueta de compartir. -->

            <a href="https://twitter.com/share" class="twitter-share-button">Tweet</a>
          </div>

          <div class="col s6 m4 l5"> 
            <ul class="collection">
              <li class="collection-item avatar">
                <img src="2016-11-01 21.08.29.jpg" alt="" class="circle responsive-img col s6 m2 l3">
                <span class="title"></span>
                <p>Autor:
                  <br>
                   Mensaje de Perfil:
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
    
    <h1><%=request.getParameter("idLibro")%></h1>

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