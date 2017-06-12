<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <title>TT something</title>

        <meta charset="utf-8" />
        <meta name="description" content="A parallax scrolling experiment using jQuery" />

        <link rel="stylesheet" media="all" href="css/main.css" />
        <!-- Compiled and minified CSS -->
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

        <script src="js/modernizr.custom.37797.js"></script> 
        <!-- Grab Google CDN's jQuery. fall back to local if necessary --> 
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script> 
        <script>!window.jQuery && document.write('<script src="/js/jquery-1.6.1.min.js"><\/script>')</script>
        <script src="js/parallax.js"></script>
        <!-- Compiled and minified JavaScript -->

           <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">    
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
        
    </head>

    <body>

        <div id="wrapper">

            <header id="branding">
                
               <form:form method="POST" modelAttribute="log">

            <nav>
                <nav class="nav-wrapper white">
                    <img class="left responsive-img" src="<%=request.getContextPath()%>/imgen/Captura.png">
                  
                    <a class="right" style="color: black"><button class="black waves-light btn" type="submit" name="registrarse" value="Register"><spring:message code="label.registrar" /></button></a>
                    <a class="right"><button class=" black waves-light btn" type="submit" name="login" value="Logear"><spring:message code="label.insesion" /></button></a>
                    <a class="right" style="color: black " href="<%=request.getContextPath()%>/RestaurarContra.htm" ><spring:message code="label.olcon" /></a>
                    <a class="right" style="color:  #000"><input  type="password" name="password" length="5" value=""></a>
                    <a class="right" style=" color: black"><spring:message code="label.contraseña"  /></a>
                    <a class="right" style="color:  #000"><input  type="text" name="userName" length="5" value=""></a>  
                    <a class="right" style="color: black "><spring:message code="label.nombre"  /></a>
                    
                     
                </div>

            </nav> 

        </form:form>
                
            </header>

          

            <div id="content">
                <article id="manned-flight">
                    <header>
                        <h1>TRABAJO TERMINAL </h1>
                        <h1>2016-A010</h1>
                    </header>
                    <p align="justify">En el presente trabajo se describe el análisis, diseño, desarrollo e implementación de un sitio web para la visualización y difusión de contenido literario generado por los usuarios. Esto a través de un sitio web que permitirá a sus usuarios subir manuscritos de su autoría para que otros usuarios puedan leerlos, reseñarlos y compartirlos, incorporando para ello algunos elementos utilizados en las redes sociales.</p>
                   
                </article>

                <article id="frameless-parachute">
                    <header>
                        <h1>Problem&aacute;tica</h1>
                    </header>
                    <p align="justify">La dificultad que enfrenta un autor amateur para dar su obra a conocer, debido principalmente a la poca difusión que existe para este tipo de obras y que resulta limitada por el tamaño de las comunidades dedicadas a escritores amateur. La reducción de la comunidad lectora provocada por el idioma, tipo de lectura preferida o la extensión de las obras disponibles.</p>
              
                </article>

                <article id="english-channel">
                    <header>
                        <h1>Objetivo</h1>
                    </header>
                    <p align="justify">Brindar a los escritores amateur un medio que les permita llegar a una gran audiencia para lograr una gran difusión de sus obras, así como obtener una rápida retroalimentación de los lectores, aumentando con ello sus posibilidades de ser publicados. Esto mediante el análisis, diseño e implementación un sitio web que permita la visualización y publicación de contenido literario de diversos géneros y en diversos idiomas por parte de los usuarios, además de permitir añadir críticas, dar likes y compartir las obras del agrado del lector por medio de las redes sociales.</p>

                </article>

                <article id="about">
                    <header>
                        <h1>Elaborado por:</h1>
                    </header>
                    <p>Cruz Garfias Edgar</p>
                    <p>Sánchez Bello Ulises Amado</p>
          
                </article>
            </div>

            <!-- Parallax foreground -->
            <div id="parallax-bg3">
              
                <img id="bg3-4" src="img/ground.png" width="1104" height="684" alt="Landscape with trees and cows"/>
            </div>

            <!-- Parallax  midground clouds -->
            <div id="parallax-bg2">
                <img id="bg2-1" src="img/cloud-lg1.png" alt="cloud"/>
                <img id="bg2-2" src="img/cloud-lg1.png" alt="cloud"/>
                <img id="bg2-3" src="img/cloud-lg1.png" alt="cloud"/>
                <img id="bg2-4" src="img/cloud-lg1.png" alt="cloud"/>
                <img id="bg2-5" src="img/cloud-lg1.png" alt="cloud"/>
            </div>

            <!-- Parallax  background clouds -->
            <div id="parallax-bg1">
                <img id="bg1-1" src="img/cloud-lg2.png" alt="cloud"/>
                <img id="bg1-2" src="img/cloud-lg2.png" alt="cloud"/>
                <img id="bg1-3" src="img/cloud-lg2.png" alt="cloud"/>
                <img id="bg1-4" src="img/cloud-lg2.png" alt="cloud"/>
            </div>

        </div>

    </body>

</html>

