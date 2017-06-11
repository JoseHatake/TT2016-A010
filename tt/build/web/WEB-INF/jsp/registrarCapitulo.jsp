<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <meta http-equiv="Expires" content="0" /> 
        <meta http-equiv="Pragma" content="no-cache" />

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <link href="css/nuevoLibroCapitulo.css" type="text/css" rel="stylesheet" media="screen,projection"/>

        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/validationEngine.jquery.css" type="text/css"/>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/template.css" type="text/css"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>   
        <script src="<%=request.getContextPath()%>/js/jquery.validationEngine-en.js" type="text/javascript" charset="utf-8">
        </script>
        <script src="<%=request.getContextPath()%>/js/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8">
        </script>
        <script src="<%=request.getContextPath()%>/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8">
        </script>


        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>


        <!--FUENTES -->
        <link href="https://fonts.googleapis.com/css?family=Barrio" rel="stylesheet">
        <title>Registrar Capitulo</title>

        <script>
            if (history.forward(1)) {
                location.replace(history.forward(1));
            }

            $(document).ready(function () {
                $('.modal').modal();
                $("#formID").validationEngine();
                $('#modal1').modal('open');

                // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered

            });

        </script>
    </head>

    <body onload="deshabilitaRetroceso()">
        <jsp:useBean id="libro" type="Modelos.Libro" scope="session"/>

        <div id="modal1" class="modal">
            <div class="modal-content">
                <div>
                    <img src="<%=request.getContextPath()%>/imgen/success.png" style="margin-left: 38%"/>
                    <h5 >El libro * <c:out value="${sessionScope.libro.nombre}"/> * se registró con éxito</h5>
                </div>

                <p>Por favor agrega uno o más capítulos</p>
            </div>
            <div class="modal-footer" style="margin-top: -10%;">
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Aceptar</a>
            </div>
        </div>


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
    <form action="controladorAgregarCapitulos.htm" method="POST" modelAttribute="log" enctype="multipart/form-data" id="formID" accept-charset="utf-8">
        <div>
            <p class="BarrioFont fontSize2"><spring:message code="label.nuevocap" /> * <c:out value="${sessionScope.libro.nombre}"/> * </p>   
        </div>

        USUARIO <c:out value="${sessionScope.miUseer}"/>

        <c:set var="user" value="${sessionScope.miUseer}" scope="session" />
        <c:set var="libro" value="${sessionScope.libro}" scope="session" />


        <div class="row" style="margin-left: 20%;">
            <button class="btn waves-effect waves-light" type="submit" name="action"><spring:message code="label.añadircap" />
                <i class="material-icons right">send</i>
            </button>
            <button class="btn waves-effect" type="button" id="mas" name="mas"><spring:message code="label.agregarOtroCapitulo" />
                <i class="material-icons right">library_add</i>
            </button>  
            <button class="btn waves-effect" type="button" id="menos" name="menos"><spring:message code="label.quitarCapitulo" />
                <i class="material-icons right">play_for_work</i>
            </button> 
        </div>

        <!-- VARIABLES!!!!!!!-->
        <c:set var="nuevoCapituloDetalles"><spring:message code="label.nuevoCapituloDetalles"/></c:set>

        <c:set var="numcap"><spring:message code="label.numcap" /></c:set>

        <c:set var="tituloCapitulo"><spring:message code="label.tituloCapitulo" /></c:set>

        <c:set var="cargapdf"><spring:message code="label.cargapdf" /></c:set>

        <c:set var="soloNum"><spring:message code="label.soloNumeros" /></c:set>

        <c:set var="noVacio"><spring:message code="label.campoObligatorio" /></c:set>

            <input type="hidden" id="soloNum" value="${label.soloNumeros}"/>
        <input type="hidden" id="noVacio" value="${label.campoObligatorio}"/>
        <!---->
        <div class="row" id="archivos">
            <div class="col s6 m4 cuadroCard" >               
                <div class="card-panel grey lighten-5" id="mensajes">
                    <i class="tiny material-icons prefix">library_books</i> 
                    <span class="black-text" style="font-size: 1em;" id="nuevoCapituloDetalles"><c:out value="${nuevoCapituloDetalles}"></c:out>
                        </span>
                        <div class="line-separator">
                        </div>
                        <div class="row">
                            <div class="input-field col s12 m12">
                                <i class="material-icons prefix">list</i>
                                <input id="icon_prefix" type="text" data-validation-engine="validate[required,custom[onlyNumberSp]]" data-errormessage-value-missing="${label.campoObligatorio}" data-errormessage="${label.soloNumeros}" name="numero[]">
                            <label for="icon_prefix" id="numcap"><c:out value="${numcap}"></c:out></label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12 m12">
                                <i class="material-icons prefix">mode_edit</i>
                                <input id="icon_prefix" type="text" data-validation-engine="validate[required]" data-errormessage-value-missing="${label.campoObligatorio}"  name="tituloCapitulo[]"/>
                            <label for="icon_prefix" id="tituloCapitulo"><c:out value="${tituloCapitulo}"></c:out></label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="file-field input-field">
                                <div class="btn amber">
                                    <i class="material-icons">description</i>
                                    <span id="cargapdf"><c:out value="${cargapdf}"></c:out></span>
                                    <input name="files[]" type="file" accept="application/pdf" required>
                                </div>
                                <div class="file-path-wrapper">
                                    <input class="file-path validate" type="text">
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="row" id="archivos2">

            </div>

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

                            </ul>
                        </div>
                    </div>
                </div>

            </footer>



        </form>

        <script>

            function deshabilitaRetroceso() {
                //alert("HOLA")
                window.location.hash = "no-back-button";
                window.location.hash = "Again-No-back-button" //chrome
                window.onhashchange = function () {
                    window.location.hash = "no-back-button";
                }
            }
            var n = 1;

            $(document).ready(function () {

                var nuevoCapituloDetalles = $('#mensajes #nuevoCapituloDetalles').text();
                var numcap = $('#numcap').text();
                var tituloCapitulo = $('#tituloCapitulo').text();
                var cargapdf = $('#cargapdf').text();
                var soloNum = $('#soloNum').text();
                var noVacio = $('#noVacio').text();

                document.getElementById("menos").disabled = true;
                $('#mas').click(function () {

                    //alert("ARCHIVO " + n);
                    document.getElementById("menos").disabled = false;
                    n++;
                    //var nuevoCapituloDetalles = document.getElementById("menos").disabled = false;
                    var cadena = "<div class=\"col s6 m4 cuadroCard\" id=\"boxNumber" + n + "\" >" +
                            "<div class=\"card-panel grey lighten-5\">" +
                            " <i class=\"tiny material-icons prefix\">library_books</i> " +
                            "<span class=\"black-text\" style=\"font-size: 1em;\">" + nuevoCapituloDetalles + " </span>" +
                            "<div class=\"line-separator\"></div>" +
                            "<div class=\"row\">" +
                            "<div class=\"input-field col s12 m12\">" +
                            "<i class=\"material-icons prefix\">list</i>" +
                            "<input id=\"icon_prefix\" type=\"text\" data-validation-engine=\"validate[required,custom[onlyNumberSp]]\" data-errormessage-value-missing=\"" + noVacio + "\" data-errormessage=\"" + soloNum + "\" name=\"numero[]\">" +
                            "<label for=\"icon_prefix\">" + numcap + "</label>" +
                            "</div>" +
                            "</div>" +
                            " <div class=\"row\">" +
                            "<div class=\"input-field col s12 m12\">" +
                            "<i class=\"material-icons prefix\">mode_edit</i>" +
                            "<input id=\"icon_prefix\" type=\"text\" data-validation-engine=\"validate[required]\" data-errormessage-value-missing=\"" + noVacio + "\" name=\"tituloCapitulo[]\"/>" +
                            "<label for=\"icon_prefix\">" + tituloCapitulo + "</label>" +
                            "</div>" +
                            "</div>" +
                            " <div class=\"row\">" +
                            "<div class=\"file-field input-field\">" +
                            "<div class=\"btn amber\">" +
                            "<i class=\"material-icons\">description</i>" +
                            "<span>" + cargapdf + "</span>" +
                            "<input name=\"files[]\" type=\"file\" accept=\"application/pdf\" required>" +
                            "</div>" +
                            "<div class=\"file-path-wrapper\">" +
                            "<input class=\"file-path validate\" type=\"text\">" +
                            "</div>" +
                            "</div>" +
                            "</div>" +
                            "</div>" +
                            "</div>";
                    if (n >= 4) {
                        $('#archivos2').append(cadena);
                        if (n == 6) {

                            document.getElementById("mas").disabled = true;
                        }
                    } else {
                        $('#archivos').append(cadena);
                    }

                });
                $('#menos').click(function () {
                    //alert("N " + n);
                    if (n === 6) {
                        document.getElementById("mas").disabled = false;
                    }

                    if (n > 1) {
                        var elem = document.getElementById('boxNumber' + n);
                        elem.parentNode.removeChild(elem);
                        n--;
                        if (n == 1) {
                            document.getElementById("menos").disabled = true;
                        }
                    }
                });
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
</body>
</html>