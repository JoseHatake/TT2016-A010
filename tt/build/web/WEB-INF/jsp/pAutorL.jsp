<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>  

        <!--FUENTES-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!--SCRIPTS-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script> 
        <script src="http://malsup.github.com/jquery.form.js"></script>
        <!--ESTILOS-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/nuevoLibroCapitulo.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">  
        <link href="<%=request.getContextPath()%>/css/test.css" rel="stylesheet" type="text/css">
        <title>Perfil Autor Con Login</title>

        <!--FUENTES -->
        <link href="https://fonts.googleapis.com/css?family=Barrio" rel="stylesheet">
        <style>.BarrioFont{
                font-family: 'Barrio', cursive;
            } 

        </style>
    </head>

    <body>
    <main>
        <form:form method="POST" modelAttribute="log" id="perfil" enctype="multipart/form-data">

            <nav class="nav-wrapper amber accent-3">

                <a href="<%=request.getContextPath()%>/listado.htm" class="brand-logo"><img src="<%=request.getContextPath()%>/imgen/Captura.png" alt="" class=" responsive-img"></a>
                <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li> <input id="search" type="search" ></li>
                    <li> <label for="search"><i class="material-icons">search</i></label></li>
                    <li><a href="<%=request.getContextPath()%>/pAutorL.htm" class="material-icons">perm_identity</a></li>
                    <li><a href="" class="material-icons">library_add</a></li>
                    <li><a href="" class="material-icons">vpn_key</a></li>
                    <li><a href="" class="material-icons">input</a></li>     

                </ul>

                <ul class="side-nav" id="mobile-demo">
                    <li> <input id="search" type="search" ></li>
                    <li> <label for="search"><i class="material-icons">search</i></label></li>
                    <li><a href="<%=request.getContextPath()%>/pAutorL.htm" class="material-icons">perm_identity</a></li>
                    <li><a href="" class="material-icons">library_add</a></li>
                    <li><a href="" class="material-icons">vpn_key</a></li>
                    <li><a href="" class="material-icons">input</a></li>     

                </ul>

            </nav>

            <div class="row">
                <div class="col offset-l2 offset-m3 " style="color:white;">
                    l
                </div>
                <div class="col s12 m8 offset-m2 l7 offset-l3">
                    <div class="card-panel grey lighten-5 z-depth-1">
                        <div class="row valign-wrapper">
                            <div class="col s7">
                                <li class="collection-item avatar">

                                    <img src="data:image/jpeg;base64,${imgl}" alt="" class="circle responsive-img" id="image-holder" >
                                    <a href="#!" class="secondary-content"><i class="material-icons">grade</i></a>
                                    <div id="rcorners1" style="font-size: 15px; color: black; padding-left: 50px; padding-top: 10px; background-color: #ffc400"><b><label id="ns" style="color: black; font-size: 15px">${numseg}</label> <spring:message code="label.seguidores"/></b></div>
                                    <p></p>
                                    <!--<div id="image-holder"> </div>-->

                                    <!-- File input -->    
                                    <div class="custom-input-file wrapper" style="display: none" id="loadimg"><input type="file" class="input-file" id="fileUpload" name="file" accept="image/png,image/jpeg"/>
                                       <spring:message code="label.cambiarimgp"/>
                                        <div class="archivo">...</div>
                                    </div> 


                            </div>
                            <div class="col s12 " style="padding-right: 100px">
                                <span class="title"></span>                            

                                <div id="pseudo" style="font-size: 22px" class="BarrioFont"><b>${autor}</b> 
                                    <span id='clickableIcon'><i class="material-icons" id="seguir" style="font-size:36px; color: black; padding-top: 10px; display: " onclick="seguir()" title="<spring:message code="label.seguir"/>">rss_feed</i> 
                                        <i class="material-icons" id="dejarDeSeguir" style="font-size:30px; color: green;display: none " onclick="dejarDeSeguir()" title="<spring:message code="label.dejseguir"/>">done</i></span>
                                </div>
                                <br>

                                <div style="padding-bottom: 20px">
                                    <p><span style="font-size: 1em;" class="BarrioFont"><spring:message code="label.msjAutor"/></span></p>
                                    <label id="lmen" style="color: black;font-size: 15px; display: ">${mp}</label>
                                    <textarea id="msj" style="width: 500px; height: 30px; display: none"></textarea>

                                    <span id='clickableIcon' ><i class="material-icons" id="editmen" style="font-size: 15px; color: blueviolet;display: none" title="<spring:message code="label.editar"/>" onclick="hedmen()">mode_edit</i></span> 
                                    <button id="actualizamen" type="button" style="width: 30; height: 40; display: none" onclick="actualizaMen()"><spring:message code="label.guardar" /></button>
                                </div>
                                <div>
                                    <p><span style="font-size: 1em;" class="BarrioFont"><spring:message code="label.msjDescripcion"/></span></p>
                                    <label id="lmenp" style="color:black;font-size: 16px ;display: ">${sm}</label>
                                    <textarea id="mensajep" style="width: 700px; height: 100px; display: none"></textarea>
                                    <span id='clickableIcon'><i class="material-icons" id="editmp" style="font-size: 15px; color: blueviolet;display: none" title="<spring:message code="label.editar"/>" onclick="hedmp()">mode_edit</i></span>
                                    <button  id="actualizamp" type="button" style="width: 30; height: 40; display: none" onclick="actualizaMp()"><spring:message code="label.guardar" /></button>
                                </div> 

                            </div>
                        </div>
                    </div>
                </div>



            </div>
            <div class="row">
                <div class="col s12 ">
                    <ul class="pagination" style="color: transparent; padding-left: 350px">
                        <li id="izquierdo" class="waves-effect" onclick="anterior()"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
                        <li class="active" id="libro1" style="background: transparent; display: "><a id="l1" href="<%=request.getContextPath()%>/perfildelibro.htm?idLibro=${idl1}"><img id="p1" class="responsive-img col s6 m2 l2" src="data:image/jpeg;base64,${plib1}" style="width: 200px; height: 300px"><div id="t1" class="caption center-align" style="color: black"><h5>${titulo1}</h5></div></a></li>
                        <li class="active" id="libro2" style="background: transparent; display: "><a id="l2" href="<%=request.getContextPath()%>/perfildelibro.htm?idLibro=${idl2}"><img id="p2" class="responsive-img col s4 m2 l2" src="data:image/jpeg;base64,${plib2}" style="width: 200px; height: 300px"><div id="t2" class="caption center-align" style="color: black"><h5>${titulo2}</h5></div></a></li>
                        <li class="active" id="libro3"style="background: transparent; display: "><a id="l3" href="<%=request.getContextPath()%>/perfildelibro.htm?idLibro=${idl3}"><img id="p3" class="responsive-img col s4 m2 l2" src="data:image/jpeg;base64,${plib3}" style="width: 200px; height: 300px"><div id="t3" class="caption center-align" style="color: black"><h5>${titulo3}</h5></div></a></li>
                        <li class="active" id="libro4"style="background: transparent; display: "><a id="l4" href="<%=request.getContextPath()%>/perfildelibro.htm?idLibro=${idl4}"><img id="p4" class="responsive-img col s4 m2 l2" src="data:image/jpeg;base64,${plib4}" style="width: 200px; height: 300px"><div id="t4" class="caption center-align" style="color: black"><h5>${titulo4}</h5></div></a></li>
                        <li id="derecho" class="waves-effect" onclick="siguiente()"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
                    </ul>            

                    <label id="pag" style="display: none">1</label>
                    <label id="cantlib" style="display:none">1</label>
                    <label id="idp" style="display: none">${idp}</label>
                    <label id="sigueu" style="display: none">${sigu}</label>
                </div>
            </div>




        </form:form>
    </main>

    <footer class="amber accent-3" style="margin-top: 15%;">
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


    <script type="text/javascript">
        $(document).ready(function () {

            obtenerPerfil();
            $("#fileUpload").on('change', function () {

                if (typeof (FileReader) != "undefined") {
                    var arch = $(this)[0].files[0];
                    var image_holder = $("#image-holder");
                    image_holder.empty();

                    var reader = new FileReader();
                    reader.onload = function (e) {
                        /* $("<img />", {
                         "src": e.target.result,
                         "class": "thumb-image"
                         }).appendTo(image_holder);*/
                        $('#image-holder').attr('src', e.target.result);
                        $("#image-holder").css({"height": "150px", "width": "150px"});

                        uploadFile(arch);

                    }
                    image_holder.show();
                    reader.readAsDataURL($(this)[0].files[0]);
                } else {
                    alert("This browser does not support FileReader.");
                }
            });


            function uploadFile(files) {
                var oMyForm = new FormData();
                oMyForm.append("file", files);
//ActualizarFotoPerfil
                jQuery.ajax({dataType: 'json',
                    url: "<%=request.getContextPath()%>" + "/ActualizarFotoPerfil.htm",
                    data: oMyForm,
                    type: "POST",
                    enctype: 'multipart/form-data',
                    processData: false,
                    contentType: false,
                    success: function (data) {

                        alert(data);
                    },
                    error: function (result) {
                        //...;
                    }
                });
            }

            function obtenerPerfil() {
                jQuery.ajax({
                    url: "<%=request.getContextPath()%>" + "/traerFotoPerfil.htm",
                    type: "POST",
                    success: function (data) {
                        // alert("DATA"+data);
                        if (data != "") {
                            $('#image-holder').attr('src', "data:image/*;base64," + data);
                            $("#image-holder").css({"height": "150px", "width": "150px"});
                        } else {
                            $('#image-holder').attr('src', "<%=request.getContextPath()%>/imgen/default.jpg");
                            $("#image-holder").css({"height": "150px", "width": "150px"});

                        }
                    },
                    error: function () {

                    }
                });

            }











            var tam = ${nlib};
            inhabilitaL(tam);
            if ($('#sigueu').text() == 2) {
                $('#dejarDeSeguir').css("display", "none");
                $('#seguir').css("display", "none");
                $('#editmen').css("display", "");
                $('#editmp').css("display", "");
                $('#loadimg').css("display","");

            } else {
                if ($('#sigueu').text() == 1) {
                    $('#dejarDeSeguir').css("display", "");
                    $('#seguir').css("display", "none");
                } else {
                    $('#dejarDeSeguir').css("display", "none");
                    $('#seguir').css("display", "");
                }
            }

            if ($('#haylog').text()) {
                $('#nl').css("display", "");
                $('#sl').css("display", "none");

            } else {
                $('#nl').css("display", "none");
                $('#sl').css("display", "");
            }
        });



        function siguiente() {

            if ($('#cantlib').text() == 4) {

                var pagina = $('#pag').text();
                pagina++;
                jQuery.ajax({
                    url: "<%=request.getContextPath()%>" + "/masLA.htm",
                    data: {ida: $('#idp').text(), pag: pagina},
                    type: "POST",
                    success: function (data) {
                        if (data != "0") {
                            var array = data.split('|');
                            inhabilitaL(array[0]);
                            var tama = array[0] * 3 + 1;
                            var index = 1;
                            for (var i = 1; i < tama; i++) {
                                $('#l' + index).attr("href", "<%=request.getContextPath()%>/perfildelibro.htm?idLibro=" + array[i])
                                i++;
                                $('#t' + index).text(array[i]);
                                i++;
                                $('#p' + index).attr("src", "data:image/jpeg;base64," + array[i]);
                                index++;

                            }
                            $('#pag').text(pagina);

                        } else {


                        }
                    },
                    error: function () {

                    }
                });


            }
        }

        function anterior() {
            if ($('#pag').text() > 1) {
                var pagina = $('#pag').text();
                pagina--;
                jQuery.ajax({
                    url: "<%=request.getContextPath()%>" + "/masLA.htm",
                    data: {ida: $('#idp').text(), pag: pagina},
                    type: "POST",
                    success: function (data) {
                        if (data != "0") {
                            var array = data.split('|');
                            habilitaL();
                            //inhabilitaL(array[0]);                                        
                            var tama = array[0] * 3 + 1;
                            var index = 1;
                            for (var i = 1; i < tama; i++) {
                                $('#l' + index).attr("href", "<%=request.getContextPath()%>/perfildelibro.htm?idLibro=" + array[i])
                                i++;
                                $('#t' + index).text(array[i]);
                                i++;
                                $('#p' + index).attr("src", "data:image/jpeg;base64," + array[i]);
                                index++;

                            }
                            $('#pag').text(pagina);

                        } else {
                            alert("no hay que cargar");

                        }
                    },
                    error: function () {

                    }
                });
                $('#pag').text(pagina);

            }
        }
        //Funcion que guarda el seguimiento en la base
        function seguir() {
            jQuery.ajax({
                url: "<%=request.getContextPath()%>" + "/seguir.htm",
                data: 'ids=' + $('#idp').text(),
                type: "POST",
                success: function (data) {
                    if (data != "no") {
                        $('#dejarDeSeguir').css("display", "");
                        $('#seguir').css("display", "none");
                        $('#ns').text(data);

                    } else {

                    }
                },
                error: function () {

                }
            });

        }
        //Funcion que elimina el seguimiento de la base
        function dejarDeSeguir() {

            jQuery.ajax({
                url: "<%=request.getContextPath()%>" + "/dejarDeSeguir.htm",
                data: 'ids=' + $('#idp').text(),
                type: "POST",
                success: function (data) {
                    if (data != "no") {
                        $('#dejarDeSeguir').css("display", "none");
                        $('#seguir').css("display", "");
                        $('#ns').text(data);
                    } else {

                    }
                },
                error: function () {

                }
            });
        }

        //Funcion que habilita la edicion de un mensaje del usuario

        function hedmen() {
            var men = $('#lmen').text();
            $('#msj').text(men);
            $('#lmen').css("display", "none");
            $('#editmen').css("display", "none");
            $('#msj').css("display", "");
            $('#actualizamen').css("display", "");
        }

        //Funcion que habilita la edicion de un mensaje de perfil
        function hedmp() {
            var menp = $('#lmenp').text();
            $('#mensajep').text(menp);
            $('#lmenp').css("display", "none");
            $('#editmp').css("display", "none");
            $('#mensajep').css("display", "");
            $('#actualizamp').css("display", "");
        }

        //Funcion que actualiza el mensaje del usuario
        function actualizaMen() {

            jQuery.ajax({
                url: "<%=request.getContextPath()%>" + "/actualizaMsj.htm",
                data: 'msj=' + document.getElementById("msj").value,
                type: "POST",
                success: function (data) {
                    if (data === "si") {
                        $('#lmen').text(document.getElementById("msj").value);
                        $('#editmen').css("display", "");
                        $('#msj').css("display", "none");
                        $('#actualizamen').css("display", "none");
                        $('#lmen').css("display", "");
                    } else {

                    }
                },
                error: function () {

                }
            });
        }

        //Funcion que actualiza la descripcion del perfil

        function actualizaMp() {
            jQuery.ajax({
                url: "<%=request.getContextPath()%>" + "/mpActualiza.htm",
                data: 'msj=' + document.getElementById("mensajep").value,
                type: "POST",
                success: function (data) {
                    if (data === "si") {
                        $('#lmenp').text(document.getElementById("mensajep").value);
                        $('#editmp').css("display", "");
                        $('#mensajep').css("display", "none");
                        $('#actualizamp').css("display", "none");
                        $('#lmenp').css("display", "");
                    } else {

                    }
                },
                error: function () {

                }
            });
        }

        function cargamip() {
            document.getElementById('perfil').submit();
        }

        function inhabilitaL(nl) {
            $('#cantlib').text(nl);
            if (nl < 4) {
                nl++;
                for (var i = nl; i < 5; i++) {
                    $("#libro" + i).css("display", "none");
                }

            }
        }

        function habilitaL() {
            for (var i = 1; i < 5; i++) {
                $("#libro" + i).css("display", "");
            }
            $('#cantlib').text(4);
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
