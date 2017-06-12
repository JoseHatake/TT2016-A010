<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">    
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script>          
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>   
        <link href="<%=request.getContextPath()%>/css/test.css" rel="stylesheet" type="text/css">

        <title><spring:message code="label.titulor" /></title>      


    </head>
    <body>

        <nav>
            <div class="amber accent-3">
                <img src="<%=request.getContextPath()%>/imgen/Captura.png" alt="" class=" responsive-img">
                <ul class="right hide-on-med-and-down">

                    </nav>

                    <form action="" method="POST" class="col s12"> 
                        <div style:="width:100%;">
                            <div style="float:left; width:50%;">
                                <spring:bind path="cu.Pseudonimo">

                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">perm_identity</i>
                                            <input id="Pseudonimo" type="text" name="Pseudonimo" class="validate" onblur="checaP()"/>
                                            <label for="perm_identity"><spring:message code="label.pseudo" /></label>
                                            <div id="ver" style="display: none; padding-left: 44px; color: green">${msj}</div>
                                        </div>
                                    </div>

                                </spring:bind>


                                <spring:bind path="cu.email">

                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">email</i>
                                            <input id="email" type="tel" name= "email" class="validate"/>
                                            <label for="icon_telephone"><spring:message code="label.correo" /></label>
                                        </div>
                                    </div>

                                </spring:bind>




                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">vpn_key</i>
                                        <input id="Pass" type="password" name = "Pass" class="validate" onblur="mhash()"/>
                                        <label for="icon_prefix"><spring:message code="label.contra" /></label>
                                    </div>
                                </div>
                                <spring:bind path="cu.Password">

                                    <input type="number" id="Password" name="Password"  hidden="true"/>

                                </spring:bind>




                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">vpn_key</i>
                                        <input id="Spass" type="password" class="validate"/>
                                        <label for="icon_prefix"><spring:message code="label.repcontra" /></label>

                                    </div>
                                </div>                         


                            </div>
                            <div style="float:right; width:50%;">

                                <spring:bind path="us.Nombre">

                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">perm_identity</i>
                                            <input id="Nombre" type="text" name="Nombre" class="validate"/>
                                            <label for="icon_telephone"><spring:message code="label.nombre" /></label>
                                        </div>
                                    </div>

                                </spring:bind>



                                <spring:bind path="us.aPaterno">

                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">supervisor_account</i>
                                            <input id="aPaterno" type="text" name="aPaterno" class="validate"/>
                                            <label for="icon_prefix"><spring:message code="label.apaterno" /></label>
                                        </div>
                                    </div>

                                </spring:bind>



                                <spring:bind path="us.aMaterno">

                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">supervisor_account</i>
                                            <input id="aMaterno" type="text" name="aMaterno" class="validate"/>
                                            <label for="icon_prefix"><spring:message code="label.amaterno" /></label>
                                        </div>
                                    </div>

                                </spring:bind>
                                </br>



                                </br>
                                </br>                               

                                <spring:bind path="us.Pais">
                                    <select name="Pais" id="Pais">
                                        <option value="" disabled selected> <spring:message code="label.pais" />

                                    </select>
                                </spring:bind>
                                </br>
                                </br>                                   
                                <spring:bind path="us.Fecha_Nacimiento">
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">picture_in_picture</i>
                                            <input id="Fecha_Nacimiento" type="text" name="Fecha_Nacimiento" class="validate"/>
                                            <label for="picture_in_picture"><spring:message code="label.nacimiento" /></label>
                                            <div id="ver" style="display: none; padding-left: 44px; color: green">${msj}</div>
                                        </div>
                                    </div>
                                </spring:bind>



                                </br>
                                <spring:bind path="us.Sexo">
                                    <select name="Sexo">
                                        <option value="" disabled selected> <spring:message code="label.sexo" />
                                        <option value="M"><spring:message code="label.masculino" />
                                        <option value="F"><spring:message code="label.femenino" />                      
                                    </select>                 
                                </spring:bind>                          


                            </div>
                            <div align="center">


                                <button class="btn waves-effect waves-light" type="submit" name="registrarse"><spring:message code="label.enviar"/>
                                    <i class="material-icons center">system_update_alt</i>
                                </button>
                                <button class="btn waves-effect waves-light" type="submit" name="cancelar" ><spring:message code="label.cancelar"/>
                                    <i class="material-icons center">send</i>
                                </button>
                                <div style="color: red">${param.error}</div>
                            </div>
                    </form>


                    <main>
                        <footer class="amber accent-3">
                            <div class="container">
                                <div class="row">
                                    <div class="col l2 s12">
                                        <h5 class="white-text">TT2016-A010</h5>
                                        <p class="grey-text text-lighten-4">SITIO WEB PARA LA VISUALIZACIÓN Y DIFUSIÓN DE CONTENIDO LITERARIO GENERADO POR LOS USUARIOS.</p>


                                    </div>
                                    <div class="col l2 s12">
                                        <h5 class="white-text">Comunidad</h5>
                                        <ul>
                                            <li><a class="white-text" href="#!">Facebook</a></li>
                                            <li><a class="white-text" href="#!">Twitter</a></li>
                                            <li><a class="white-text" href="#!">Google+</a></li>
                                            <li><a class="white-text" href="#!">--------</a></li>
                                        </ul>
                                    </div>
                                    <div class="col l2 s12">
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
                    </main>


                    <!--  Scripts-->
                    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
                    <script src="js/materialize.js"></script>
                    <script src="js/init.js"></script>


                    <script type="text/javascript">
                                            $(document).ready(function () {


                                                //Funcion para cargar dinamicamente lista de paises
                                                jQuery.ajax({
                                                    url: "<%=request.getContextPath()%>" + "/obtenPaises.htm",
                                                    type: "GET",
                                                    success: function (lista) {
                                                        var array = lista.split(',');
                                                        $.each(array, function (index, value) {
                                                            $('#Pais')
                                                                    .append($('<option>', {value: value})
                                                                            .text(value));
                                                            $('#Pais').material_select();
                                                        });


                                                    },
                                                    error: function () {
                                                        alert("woops, la peticion ajax falló");
                                                    }
                                                });

                                                $('select').material_select();
                                            });
                                            //funcion para verificar la disponibilidad de un usuario

                                            function checaP() {
                                                var nick = $("#Pseudonimo").val();
                                                jQuery.ajax({
                                                    url: "<%=request.getContextPath()%>" + "/validaP.htm",
                                                    data: 'name=' + nick,
                                                    type: "GET",
                                                    success: function (data) {
                                                        if (data == "Usuario no disponible" || data == "User already in use") {
                                                            $("#ver").text(data);
                                                            $("#ver").css("color", "red");
                                                            $("#ver").css("display", "block");
                                                        } else {
                                                            $("#ver").text(data);
                                                            $("#ver").css("color", "green");
                                                            $("#ver").css("display", "block");
                                                        }
                                                    },
                                                    error: function () {}
                                                });
                                            }

                                            //Función para calcular el hash de la contraseña

                                            String.prototype.hashCode = function () {

                                                var hash = 0;

                                                if (this.length == 0)
                                                    return hash;

                                                for (i = 0; i < this.length; i++) {

                                                    chr = this.charCodeAt(i);

                                                    hash = ((hash << 5) - hash) + chr;

                                                    hash = hash & hash; // Convierte a un entero de 32bit 

                                                }

                                                return hash;

                                            }

                                            function mhash() {
                                                var phash;
                                                phash = $("#Pass").val().hashCode();
                                                $("#Password").val(phash);

                                            }




                    </script>

                    </body>
                    </html>