
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link href="https://fonts.googleapis.com/css?family=Barrio" rel="stylesheet">
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script> 
        <style type="text/css">.barrio{ font-family: 'Barrio', cursive;}</style>
        <title></title>
    </head>

    <body>
    <form:form method="GET" modelAttribute="log">
        <nav>
            <div class="nav-wrapper amber accent-3">
                <img src="Captura.png" alt="" class=" responsive-img">               
            </div>
        </nav>




        <div align="center" class="barrio" ><spring:message code="label.verifica"/></div> <br>

        <div align="center"> <span id="time">0:05</span></div> <br>

        <div align="center" class="barrio"><spring:message code="label.redirecciona"/></div><br>   




        <div align="center"><a href="<%=request.getContextPath()%>/main.htm"><spring:message code="label.click"/></a></div>      
        <input id="url" type="hidden" value="<%=request.getContextPath()%>/main.htm"/>
    </form:form>




    <footer class="amber accent-3 col s12 m4 l3">
        <div class="container col s12 m4 l3">




            <div class="row">
                <div class="col l6 s12">
                    <h5 class="white-text">TT2016-A010</h5>
                    <p class="grey-text text-lighten-4"><spring:message code="label.sitioWeb"/></p>
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

        </div>



    </footer>

    <script>
        function startTimer(duration, display) {
            var timer = duration, minutes, seconds;
            var end = setInterval(function () {
                minutes = parseInt(timer / 60, 10)
                seconds = parseInt(timer % 60, 10);

                minutes = minutes < 10 ? "0" + minutes : minutes;
                seconds = seconds < 10 ? "0" + seconds : seconds;

                display.textContent = minutes + ":" + seconds;

                if (--timer < 0) {
                    clearInterval(end);
                    var url = document.getElementById("url").getAttribute("value");
                    window.location.replace(url);
                }
            }, 1000);
        }

        window.onload = function () {
            var fiveMinutes = 5,
                    display = document.querySelector('#time');
            startTimer(fiveMinutes, display);
        };
    </script>


    <!--  Scripts-->
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="js/materialize.js"></script>
    <script src="js/init.js"></script>

</body>

</html>