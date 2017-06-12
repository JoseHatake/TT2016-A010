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
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">  
        <meta http-equiv="Expires" content="0" /> 
        <meta http-equiv="Pragma" content="no-cache" />


        <link href="css/nuevoLibroCapitulo.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <title>LogIn de prueba capitulo</title>

        <link href="<%=request.getContextPath()%>/css/validationEngine.jquery.css" type="text/css" rel="stylesheet" />
        <link href="<%=request.getContextPath()%>/css/template.css" type="text/css" rel="stylesheet" />
        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validationEngine-en.js"></script>  
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validationEngine-en.js"></script>  
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validationEngine.js"></script>  
        <!--FUENTES -->
        <link href="https://fonts.googleapis.com/css?family=Barrio" rel="stylesheet">

        <!--MATERIALIZE-->

        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>

    </head>
    <body>
        <c:set var="campoObligatorio"><spring:message code="label.campoObligatorio"/></c:set>
        <c:set var="selectObligatorio"><spring:message code="label.selectObligatorio"/></c:set>
        <c:set var="idiomaObligatorio"><spring:message code="label.idiomaObligatorio"/></c:set>
        <c:set var="portadaObligatoria"><spring:message code="label.portadaObligatoria"/></c:set>
        <c:set var="archivoObligatorio"><spring:message code="label.archivoObligatorio"/></c:set>

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


    <div>
        <div><p class="BarrioFont fontSize3"><spring:message code="label.nuevaobra" /></p></div>
    </div>

    <form action="controladorNuevoLibro.htm" method="post" enctype="multipart/form-data" accept="image/jpg,image/png" id="formID" accept-charset="utf-8">
        <div class="row">
            <label>
                <span class="checkbox">I accept terms of use : </span>
                <input class="validate[required] checkbox" type="checkbox" id="agree" name="agree" style="margin-left: 40"/>
            </label>
        </div>

        <div class="row">
            <div class="col s5 m3 z-depth-1" style="margin-left: 1.5%; background: #eceff1;" >
                <div class="card">
                    <div class="card-image">
                        <img src="<%=request.getContextPath()%>/imgen/cover.png" style="width: 100%; height: 130%;"  id="imagenUno"> 
                        <output id="list"></output>
                    </div>
                    <div class="backgroundAmber card-action">
                        <!--<input class="inputfile " type="file" name="files[]" id="files"/>-->
                        <input class="inputfile" type="file" id="files" name="files[]" accept="image/jpeg" required/>
                        <label for="files"> <spring:message code="label.cargaportada"/><i class="material-icons right">present_to_all</i></label>
                    </div>
                </div>
            </div>

            <div class="col s1-offset">

            </div>        
            <div class="col s6 m7" style="margin-left: 1.5%; background: #eceff1;" >
                <div class="card-panel grey lighten-5">
                    <span class="black-text"><spring:message code="label.nuevoLibroDetalles"/>
                    </span>
                    <div class="line-separator">

                    </div>

                    <div class="row">
                        <div class="input-field col s12 m6">
                            <i class="material-icons prefix">spellcheck</i>
                            <input id="icon_prefix" type="text" data-validation-engine="validate[required]"
                                   data-errormessage-value-missing="${campoObligatorio}" name="tituloLibro"/>
                            <label for="icon_prefix"><spring:message code="label.titulo"/></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">mode_edit</i>
                            <textarea id="sinopsis" class="materialize-textarea" name="sinopsis" data-validation-engine="validate[required]"
                                      data-errormessage-value-missing="${campoObligatorio}"></textarea>
                            <label for="sinopsis"><spring:message code="label.sinopsis"/></label>
                        </div>
                    </div>


                    <div class="row">
                        <div class="input-field col s12 m6">
                            <i class="material-icons prefix">language</i>
                            <select name="idioma" <data-validation-engine="validate[required]"
                                    data-errormessage-value-missing="${idiomaObligatorio}">
                                    <option value="" disabled ><spring:message code="label.seleccionarIdioma"/></option>
                                    <option value="es"><spring:message code="label.seleccionarEspaniol"/></option>
                                    <option value="en"><spring:message code="label.seleccionarIngles"/></option>
                            </select>
                            <label><spring:message code="label.seleccionarIdioma"/></label>   


                        </div>
                    </div>


                    <div class="row">
                        <div class="col s6 m5">
                            <p style="font-size:1.5em;"><i class="material-icons prefix" style="margin-right: .8em;">list</i><spring:message code="label.generolibro"/></p> 
                        </div>
                        <div class="col s6 m6">
                            <p style="font-size:.8em; margin-top: 10%;"><spring:message code="label.seleccionarGenero"/></p> 
                        </div>
                    </div>


                    <table class="responsive-table" id="tabla">
                        <tr>
                            <td><input type="checkbox"  class="filled-in" id="filled-in-box1" name="genero[]" value="Terror"/>
                                <label for="filled-in-box1"><spring:message code="label.terror"/></label></td>

                            <td><input type="checkbox" class="filled-in" id="filled-in-box2" name="genero[]" value="Fantasia" />
                                <label for="filled-in-box2"><spring:message code="label.fantasia"/></label></td>

                            <td><input type="checkbox"  class="filled-in" id="filled-in-box3" name="genero[]" value="Suspenso"/>
                                <label for="filled-in-box3"><spring:message code="label.suspenso"/></label></td>

                            <td><input type="checkbox"  class="filled-in" id="filled-in-box4" name="genero[]" value="Romance"/>
                                <label for="filled-in-box4"><spring:message code="label.romance"/></label></td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" class="filled-in" id="filled-in-box5" name="genero[]" value="Misterio"/>
                                <label for="filled-in-box5"><spring:message code="label.misterio"/></label></td>

                            <td><input type="checkbox" class="filled-in" id="filled-in-box6" name="genero[]" value="Historico"/>
                                <label for="filled-in-box6"><spring:message code="label.historico"/></label></td>

                            <td><input type="checkbox" class="filled-in" id="filled-in-box7" name="genero[]" value="Cuento"/>
                                <label for="filled-in-box7"><spring:message code="label.cuento"/></label></td>

                            <td><input type="checkbox" class="filled-in" id="filled-in-box8"  name="genero[]" value="Poesia"/>
                                <label for="filled-in-box8"><spring:message code="label.poesia"/></label></td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" class="filled-in" id="filled-in-box9" name="genero[]" value="Ficcion" />
                                <label for="filled-in-box9"><spring:message code="label.ficcion"/></label></td>

                            <td> <input type="checkbox" class="filled-in" id="filled-in-box10"  name="genero[]" value="Tragedia"/>
                                <label for="filled-in-box10"><spring:message code="label.tragedia"/></label></td>

                            <td><input type="checkbox" class="filled-in" id="filled-in-box11"  name="genero[]" value="Comedia"/>
                                <label for="filled-in-box11"><spring:message code="label.comedia"/></label></td>

                            <td><input type="checkbox" class="filled-in" id="filled-in-box12"  name="genero[]" value="Drama"/>
                                <label for="filled-in-box12"><spring:message code="label.drama"/></label></td>
                        </tr>
                    </table>


                    <div class="row">
                        <button class="btn waves-effect waves-light" type="submit" name="action" id="submit">Crear Libro
                            <i class="material-icons right">send</i>
                        </button>
                    </div>


                </div>
            </div>

        </div>
    </form>


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
                 <a class="orange-text text-lighten-3" href="http://materializecss.com">Materialize</a>
            </div>
        </div>
    </footer>
    <script>
        var cant = 0;
        $(document).ready(function () {
            $("#formID").validationEngine();
            $('select').material_select();


            $("input[type=checkbox]").change(function () {
                // Tomamos el elemento actual
                var elemento = this;
                var contador = 0;

                // Recorremos todos los checkbox para contar los que estan seleccionados
                $("input[type=checkbox]").each(function () {
                    if ($(this).is(":checked"))
                        contador++;
                });
                // Comprobamos si supera la cantidad máxima indicada
                if (contador > 3)
                {
                    alert("Has seleccionado mas checkbox que los indicados");

                    // Desmarcamos el ultimo elemento
                    $(elemento).prop('checked', false);
                    contador--;
                }

            });

            $("#submit").on("click", function () {
                var cajas = 0;

                $("input[type=checkbox]").each(function () {
                    if ($(this).is(":checked"))
                        cajas++;
                });

                if (cajas == 0) {
                    alert("Debe seleccionar almenos un género");
                    event.preventDefault();
                }

            });

            // total = $(“input[@name=’benTitu[]’]:checked”).length;
        });


        function archivo(evt) {
            var files = evt.target.files; // FileList object

            // Obtenemos la imagen del campo "file".
            for (var i = 0, f; f = files[i]; i++) {
                //Solo admitimos imágenes.
                if (!f.type.match('image.*')) {
                    continue;
                }

                var reader = new FileReader();

                reader.onload = (function (theFile) {
                    return function (e) {
                        // Insertamos la imagen
                        document.getElementById("list").innerHTML = ['<img class="thumb" src="', e.target.result, '" title="', escape(theFile.name), '"/>'].join('');
                        document.getElementById("imagenUno").remove();
                    };
                })(f);

                reader.readAsDataURL(f);
            }
        }

        document.getElementById('files').addEventListener('change', archivo, false);


        function deshabilitaRetroceso() {
            //alert("HOLA")
            window.location.hash = "no-back-button";
            window.location.hash = "Again-No-back-button" //chrome
            window.onhashchange = function () {
                window.location.hash = "no-back-button";
            }
        }
        
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