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
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">    
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="<%=request.getContextPath()%>/css/test.css" rel="stylesheet" type="text/css">
        <title>Perfil Autor Con Login</title>
    </head>

    <body>
    <main>
        <form:form method="POST" modelAttribute="log" id="perfil">
            <nav>
                <div class="nav-wrapper amber accent-3">
                    <a href="<%=request.getContextPath()%>/listado.htm"><img src="<%=request.getContextPath()%>/imgen/Captura.png" alt="" class=" responsive-img"></a>
                    <ul class="right hide-on-med-and-down" id="nl" style="display: none">
                        <li> <input id="search" type="search" ></li>
                        <li> <label for="search"><i class="material-icons">search</i></label></li>
                        <li><a href="<%=request.getContextPath()%>/pAutorL.htm" class="material-icons">perm_identity</a></li>
                        <li><a href="<%=request.getContextPath()%>/nuevoLibro.htm" class="material-icons">library_add</a></li>
                        <li><a href="<%=request.getContextPath()%>/CambiaPass.htm" class="material-icons">vpn_key</a></li>
                        <li><a href="<%=request.getContextPath()%>/main.htm" class="material-icons" onclick="logout()">input</a></li>     

                    </ul>

                    <ul class="right hide-on-med-and-down" id="sl" style="display: ">
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


            <div class="col s12 m8 offset-m2 l6 offset-l3">
                <div class="card-panel grey lighten-5 z-depth-1">
                    <div class="row valign-wrapper">
                        <div class="col s2">
                            <li class="collection-item avatar">
                                <a href="#!" class="secondary-content"><i class="material-icons">grade</i></a>
                                <img src="<%=request.getContextPath()%>${imgl}" alt="" class="circle responsive-img">
                                <div id="rcorners1" style="font-size: 15px; color: black; padding-left: 50px; padding-top: 10px; background-color: #ffc400"><b><label id="ns" style="color: black; font-size: 15px">${numseg}</label> <spring:message code="label.seguidores"/></b></div>
                        </div>

                        <div class="col s10" style="padding-right: 100px">
                            <span class="title"></span>                            

                            <div id="pseudo" style="font-size: 22px"><b>${autor}</b> 
                                <span id='clickableIcon'><i class="material-icons" id="seguir" style="font-size:36px; color: black; padding-top: 10px; display: " onclick="seguir()" title="<spring:message code="label.seguir"/>">rss_feed</i> 
                                    <i class="material-icons" id="dejarDeSeguir" style="font-size:30px; color: green;display: none " onclick="dejarDeSeguir()" title="<spring:message code="label.dejseguir"/>">done</i></span>
                            </div>
                            <br>
                            <div style="padding-bottom: 20px">
                                <label id="lmen" style="color: black;font-size: 15px; display: ">${mp}</label>
                                <textarea id="msj" style="width: 500px; height: 30px; display: none"></textarea>
                                <span id='clickableIcon'><i class="material-icons" id="editmen" style="font-size: 15px; color: black;display: none" title="<spring:message code="label.editar"/>" onclick="hedmen()">mode_edit</i></span> 
                                <button id="actualizamen" type="button" style="width: 30; height: 40; display: none" onclick="actualizaMen()"><spring:message code="label.guardar" /></button>
                            </div>
                            <div>
                                <label id="lmenp" style="color:black;font-size: 16px ;display: ">${sm}</label>
                                <textarea id="mensajep" style="width: 800px; height: 100px; display: none"></textarea>
                                <span id='clickableIcon'><i class="material-icons" id="editmp" style="font-size: 15px; color: black;display: none" title="<spring:message code="label.editar"/>" onclick="hedmp()">mode_edit</i></span>
                                <button id="actualizamp" type="button" style="width: 30; height: 40; display: none" onclick="actualizaMp()"><spring:message code="label.guardar" /></button>
                            </div> 

                        </div>
                    </div>
                </div>
            </div>




            <ul class="pagination" style="color: transparent">
                <li id="izquierdo" class="waves-effect" onclick="anterior()"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
                <li class="active" id="libro1" style="background: transparent; display: " onclick="cargaLibro($('#idlib1').text())" ><a href="#!"><img id="p1" class="responsive-img col s6 m2 l2" src="<%=request.getContextPath()%>${plib1}" ><div id="t1" class="caption center-align" style="color: black"><h5>${titulo1}</h5></div><label id="idlib1" style="display: none">${idl1}</label></a></li>
                <li class="active" id="libro2" style="background: transparent; display: " onclick="cargaLibro($('#idlib2').text())"><a href="#!"><img id="p2" class="responsive-img col s4 m2 l2" src="<%=request.getContextPath()%>${plib2}" ><div id="t2" class="caption center-align" style="color: black"><h5>${titulo2}</h5></div><label id="idlib2" style="display: none">${idl2}</label></a></li>
                <li class="active" id="libro3"style="background: transparent; display: " onclick="cargaLibro($('#idlib3').text())"><a href="#!"><img id="p3" class="responsive-img col s4 m2 l2" src="<%=request.getContextPath()%>${plib3}" ><div id="t3" class="caption center-align" style="color: black"><h5>${titulo3}</h5></div><label id="idlib3" style="display: none">${idl3}</label></a></li>
                <li class="active" id="libro4"style="background: transparent; display: " onclick="cargaLibro($('#idlib4').text())"><a href="#!"><img id="p4" class="responsive-img col s4 m2 l2" src="<%=request.getContextPath()%>${plib4}" ><div id="t4" class="caption center-align" style="color: black"><h5>${titulo4}</h5></div><label id="idlib4" style="display: none">${idl4}</label></a></li>
                <li id="derecho" class="waves-effect" onclick="siguiente()"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
            </ul>            

            <label id="pag" style="display: none">1</label>
            <label id="cantlib" style="display:none">1</label>
            <label id="idp" style="display: none">${idp}</label>
            <label id="sigueu" style="display: none">${sigu}</label>
            <label id="haylog" style="display: none">${log}</label>

        </form:form>
    </main>

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

    <!--  Scripts-->
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="js/materialize.js"></script>
    <script src="js/init.js"></script>



    <script type="text/javascript">
                    $(document).ready(function () {
                        var tam = ${nlib};
                        inhabilitaL(tam);
                        if ($('#sigueu').text() == 2) {
                            $('#dejarDeSeguir').css("display", "none");
                            $('#seguir').css("display", "none");
                            $('#editmen').css("display", "");
                            $('#editmp').css("display", "");

                        } else {
                            if ($('#sigueu').text() == 1) {
                                $('#dejarDeSeguir').css("display", "");
                                $('#seguir').css("display", "none");
                            } else {
                                $('#dejarDeSeguir').css("display", "none");
                                $('#seguir').css("display", "");
                            }
                        }
                      
                        if($('#haylog').text()){
                            $('#nl').css("display","");
                            $('#sl').css("display","none");
                            
                        }else{
                            $('#nl').css("display","none");
                            $('#sl').css("display","");
                        }
                    });

                    function cargaLibro(idlibro) {
                        alert(idlibro);
                    }

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
                                            $('#idlib' + index).text(array[i]);
                                            i++;
                                            $('#t' + index).text(array[i]);
                                            i++;
                                            $('#p' + index).attr("src", "<%=request.getContextPath()%>" + array[i]);
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
                                            $('#idlib' + index).text(array[i]);
                                            i++;
                                            $('#t' + index).text(array[i]);
                                            i++;
                                            $('#p' + index).attr("src", "<%=request.getContextPath()%>" + array[i]);
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
