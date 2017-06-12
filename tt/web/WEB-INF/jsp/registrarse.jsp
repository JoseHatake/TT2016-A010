<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
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


        <script type="text/javascript">
            $(document).ready(function () {
                // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
                $('.modal').modal();
                $('select').material_select();
                $('#botonCerrar').click(function () {
                    //alert("Handler for .click() called.");
                    $('#modal1').modal('close');
                });

                $("#formID").validationEngine();

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
                        alert("woops, la peticion ajax fallÛ");
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

            //FunciÛn para calcular el hash de la contraseÒa

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

        <title>Registrarse</title> 


    </head>
    <body>
        <nav>
            <div class="amber accent-3">
                <a href="<%=request.getContextPath()%>/main.htm"><img src="<%=request.getContextPath()%>/imgen/Captura.png" alt="" class=" responsive-img"></a>
                <ul class="right hide-on-med-and-down"></ul>
            </div>
        </nav>
        <form action="registrarse.htm" method="POST" class="col s12" style="margin-top: 1%; margin-left: 10%;" id="formID">
            <div class="row">

                <div class="col s12 m10" style="margin-left: 1.5%; background: #eceff1;" >
                    <div class="card-panel grey lighten-5">
                        <span class="black-text" style="font-size: 1.5em;"><spring:message code="label.registrarUsuario"/>
                        </span>
                        <div class="line-separator">

                        </div>
                        <div class="row">
                            <div class="input-field col s12 m4">

                                <spring:bind path="us.Nombre">
                                    <i class="material-icons prefix">perm_identity</i>
                                    <input id="Nombre" type="text" name="Nombre" class="validate" data-validation-engine="validate[required]" data-errormessage-value-missing="${campoObligatorio}" />
                                    <label for="Nombre"><spring:message code="label.nombre" /></label>

                                </spring:bind>


                            </div>
                            <div class="input-field col s12 m4">

                                <spring:bind path="us.aPaterno">
                                    <input id="aPaterno" type="text" name="aPaterno" class="validate" data-validation-engine="validate[required]" data-errormessage-value-missing="${campoObligatorio}"/>
                                    <label for="aPaterno"><spring:message code="label.apaterno" /></label>
                                </spring:bind>
                            </div>

                            <div class="input-field col s12 m4">
                                <spring:bind path="us.aMaterno">

                                    <input id="aMaterno" type="text" name="aMaterno" class="validate" data-validation-engine="validate[required]" data-errormessage-value-missing="${campoObligatorio}"/>
                                    <label for="aMaterno"><spring:message code="label.amaterno" /></label>
                                </spring:bind>

                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s12 m4">

                                <spring:bind path="cu.Pseudonimo">
                                    <i class="material-icons prefix">person_pin</i>
                                    <input id="Pseudonimo" type="text" name="Pseudonimo" class="validate" onblur="checaP()" data-validation-engine="validate[required]" data-errormessage-value-missing="${campoObligatorio}"/>
                                    <label for="Pseudonimo"><spring:message code="label.pseudo" /></label>

                                </spring:bind>
                            </div>
                            <div class="input-field col s12 m4">

                                <spring:bind path="cu.email">

                                    <i class="material-icons prefix">email</i>
                                    <input id="email" type="tel" name= "email" class="validate" data-validation-engine="validate[required],custom[email]]" data-errormessage-value-missing="${campoObligatorio}"/>
                                    <label for="email"><spring:message code="label.correo" /></label>

                                </spring:bind>

                            </div>

                            <div class="input-field col s12 m4">
                                
                                    <i class="material-icons prefix">vpn_key</i>
                                    <input type="password" id="Pass" name="Pass" data-validation-engine="validate[required]" data-errormessage-value-missing="${campoObligatorio}" onblur="mhash()"/>
                                    <label for="password"><spring:message code="label.contra" /></label>
                              

                                <spring:bind path="cu.Password">

                                    <input type="number" id="Password" name="Password"  hidden="true"/>

                                </spring:bind>


                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s12 m4">

                                <spring:bind path="us.Sexo">

                                    <select name="Sexo">

                                        <option value="M"><spring:message code="label.masculino" />
                                        <option value="F"><spring:message code="label.femenino" />                      
                                    </select>        
                                    <label><spring:message code="label.sexo" /></label>

                                </spring:bind>  
                            </div>
                            <div class="input-field col s12 m4">

                                <spring:bind path="us.Pais">

                                    <select name="Pais" id="Pais">


                                    </select>
                                    <label><spring:message code="label.pais" /></label>
                                </spring:bind>

                            </div>

                            <div class="input-field col s12 m4">
                                <spring:bind path="us.Fecha_Nacimiento">

                                    <input id="Fecha_Nacimiento" type="text" name="Fecha_Nacimiento"  data-validation-engine="validate[required]" data-errormessage-value-missing="${campoObligatorio}" />
                                    <label for="Fecha_Nacimiento"><spring:message code="label.nacimiento" /></label>

                                </spring:bind>

                            </div>
                        </div>
                        <div class="row">
                            <div class="col s12 m3">
                                <button class="btn center waves-effect waves-light black" type="submit" name="cancelar" > <i class="material-icons center">not_interested</i><spring:message code="label.cancelar"/>

                                </button>
                                <div style="color: red">${param.error}</div>
                            </div>
                            <div class="col s12 m3">
                                <a class="btn next modal-trigger waves-effect waves-light btn" href="#modal1" ><i class="material-icons center">thumb_up</i> Enviar <i class="material-icons center">send</i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <!-- Modal Structure -->
            <div id="modal1" class="modal modal-fixed-footer " >
                <div class="modal-content" >
                    <h4>Términos y condiciones de uso</h4>
                    <p>1. Objeto y aceptación<br>
                        Puede ponerse en contacto con El sitio a través del siguiente medio.
                        email aquí.
                        El presente documento recoge las condiciones generales que regulan el acceso, navegación y uso del Sitio, así como de los contenidos que lo integran.
                        El acceso a y/o uso del Sitio Web es totalmente voluntario y atribuye a quien lo realiza la condición de Usuario. Todo Usuario acepta, desde el mismo momento en el que accede, sin ningún tipo de reserva, las Condiciones de Uso del Sitio Web contenidas en este documento.
                        En cualquier caso, el Sitio se reserva el derecho de, en cualquier momento y sin necesidad de previo aviso, denegar el acceso al Sitio Web a aquellos Usuarios que incumplan cualesquiera de estas condiciones, así como de dar por terminado, suspender o interrumpir, en cualquier momento y sin necesidad de preaviso, el acceso a los servicios y/o contenidos del Sitio, sin posibilidad por parte del Usuario de reclamar ni exigir indemnización alguna.
                    </p>
                    <p>2. Condiciones de acceso y utilización del Sitio Web</p><br>
                    El Usuario será responsable de aportar información veraz y lícita, garantizando la autenticidad de todos aquellos datos que introduzca a la hora de cumplimentar los formularios preestablecidos para acceder a los servicios del Sitio. Si como consecuencia del registro, el Usuario tuviera que hacer uso de una contraseña, éste se compromete a su uso diligente y a mantener la confidencialidad de la misma y se compromete a no ceder su uso a terceros, ya sea temporal o permanente, ni a permitir su utilización por personas ajenas. Será responsabilidad exclusiva del Usuario la utilización de los productos y/ o servicios ofrecidos a través del Sitio, por parte de cualquier tercero que, de forma ilegítima, emplee a tal efecto una contraseña o identificador suministrado al Usuario, a causa de una actuación no diligente o de la pérdida de la misma por el Usuario, a menos que lo haya comunicado inmediatamente al Titular. Mientras no se comuniquen tales hechos, el Titular quedará eximido de cualquier responsabilidad que pudiera derivarse del uso indebido de los identificadores o contraseñas por parte de terceros no autorizados.
                    El Usuario se compromete expresamente a hacer un uso adecuado de los contenidos y servicios ofrecidos a través del Sitio Web y a no emplearlos para, entre otros:
                    Difundir contenidos delictivos, violentos, pornográficos, racistas, xenófobos, ofensivos, de apología del terrorismo o, en general, contrarios a la ley o al orden público.
                    Introducir en la red virus informáticos o realizar actuaciones susceptibles de alterar, estropear, interrumpir o generar errores o daños en los documentos electrónicos, datos o sistemas físicos y lógicos del sitio o de terceras personas; así como obstaculizar el acceso de otros Usuarios al Sitio Web y a sus servicios mediante el consumo masivo de los recursos informáticos a través de los cuales El sitio presta sus servicios.
                    Intentar acceder a las cuentas de correo electrónico de otros Usuarios o a áreas restringidas de los sistemas informáticos de El sitio o de terceros y, en su caso, extraer información.
                    Vulnerar los derechos de propiedad intelectual o industrial, así como violar la confidencialidad de la información de El sitio o de terceros.
                    Suplantar la identidad de otro Usuario, de las administraciones públicas o de un tercero.
                    Reproducir, copiar, distribuir, poner a disposición o de cualquier otra forma comunicar públicamente, transformar o modificar los contenidos, a menos que se cuente con la autorización del titular de los correspondientes derechos o ello resulte legalmente permitido.
                    Recabar datos con finalidad publicitaria y de remitir publicidad de cualquier clase y comunicaciones con fines de venta u otras de naturaleza comercial sin que medie su previa solicitud o consentimiento.
                    Una vez registrado en el Sitio, el Usuario podrá subir contenidos, acceder a los contenidos subidos por otros Usuarios y en su caso, comentar dichos contenidos, además de seguir a los autores y/o libros de su interés.
                    <p> 3. Comentarios en El sitio</p><br>
                    Una vez registrado en el Sitio, el Usuario podrá compartir contenidos con terceros y realizar comentarios a los contenidos subidos por otros Usuarios.
                    El Usuario podrá eliminar en cualquier momento los comentarios que haya realizado en El sitio. No obstante, otras personas pueden haber copiado y utilizado la información que haya sido compartida por el Usuario sin que El sitio tenga ninguna responsabilidad en este sentido.
                    La realización de comentarios por parte del usuario en El sitio no es obligatoria.
                    Con respecto a los comentarios, el usuario se compromete a hacer un uso adecuado de los contenidos y servicios (como por ejemplo comentarios) que el Sitio ofrece, y con carácter enunciativo, pero no limitativo, a no emplearlos para (i) incurrir en actividades ilícitas, ilegales o contrarias a la buena fe y al orden público; (ii) difundir contenidos o propaganda de carácter racista, xenófobo, pornográfico-ilegal, de apología del terrorismo o atentatorio contra los derechos humanos. Asimismo el  contenido de los  comentarios y otros contenidos no podrá ser amenazante, difamatorio, invasor de la privacidad, infringir los derechos de propiedad intelectual o de otra manera perjudicar a terceros y no podrá consistir o contener virus informáticos, campañas políticas, solicitudes comerciales, correos masivos o cualquier forma de "spam"; El Sitio se reserva el derecho de retirar todos aquellos comentarios que vulneren la dignidad de la persona, xenófobos, racistas, pornográficos, que sean discriminatorios, o que, a su juicio, no resulten adecuados para su publicación. En cualquier caso, el Sitio no será responsable de las opiniones vertidas por los Usuarios a través de los comentarios u otras herramientas de participación.
                    El Sitio se reserva el derecho, pero no la obligación, de eliminar o editar los comentarios realizados por los Usuarios a través del Sitio Web.
                    <p>4. Subida de contenidos en el Sitio Web</p><br>
                    Al registrarse a través del Sitio Web, el Usuario tendrá derecho a comentar en los textos subidos al Sitio por otros Usuarios y el Usuario acepta expresamente que otros Usuarios puedan comentar los textos que el Usuario publique a través del Sitio Web.
                    El acceso a los contenidos subidos a través del Sitio Web es público por lo que no será necesario estar registrado y por tanto revestir la naturaleza de Usuario para acceder a ellos.
                    La publicación de contenidos en el Sitio se somete a lo previsto en este documento respecto a los Derechos de Propiedad Intelectual del Usuario. En este sentido, los textos publicados por los Usuarios a través del Sitio serán titularidad y responsabilidad única y exclusiva de cada uno de los Usuarios sin que la publicación de los contenidos por el Usuario a través del Sitio implique la cesión de sus derechos de explotación.
                    Al subir un contenido en el Sitio a su perfil acepta que terceros Usuarios lo comenten (revistiendo dichos comentarios el carácter de públicos para cualquier otro Usuario).
                    <p>5. Portadas</p><br>
                    El usuario al subir un manuscrito a el Sitio podrá subirlo con una portada propia. En ese caso declara que dispone de todos los derechos de propiedad intelectual necesarios al efecto.
                    <p>6. Derechos de Propiedad Intelectual</p><br>
                    El Sitio Web, su código fuente, diseño, iconos, marcas, bases de datos, estructura y contenido propio de la misma, es titularidad del Sitio. Queda estrictamente prohibido su reproducción, modificación, transmisión a terceros o plagio.
                    Todos los contenidos del Sitio Web, como textos, fotografías, gráficos, imágenes, iconos, tecnología, software, así como su diseño gráfico y códigos fuente, constituyen una obra cuya propiedad pertenece a el Sitio, sin que puedan entenderse cedidos al Usuario ninguno de los derechos de explotación sobre los mismos más allá de lo estrictamente necesario para el correcto uso del Sitio Web.
                    En definitiva, los Usuarios que accedan al Sitio pueden visualizar los contenidos y efectuar, en su caso, copias privadas autorizadas siempre que los elementos reproducidos no sean cedidos posteriormente a terceros, ni se instalen a servidores conectados a redes, ni sean objeto de ningún tipo de explotación.
                    El Sitio no se responsabiliza del uso que cada Usuario le dé a los materiales puestos a disposición en este Sitio Web ni de las actuaciones que realice en base a los mismos.
                    El material publicado por los Usuarios será titularidad y responsabilidad única y exclusiva de cada uno de los Usuarios. Dentro de este material se encuentra incluido con carácter enunciativo y no limitativo los textos que puedan subir los Usuarios, así como cualquier material gráfico incluido en el mismo o que forme parte de la portada.
                    A este respecto, cada Usuario, se hace responsable frente a el Sitio de todas las cargas pecuniarias que pudieran derivarse para el Sitio en favor de terceros, con motivo de acciones, reclamaciones o conflictos derivados del incumplimiento de estas obligaciones por parte del Usuario, autor de cualquier comentario, material o contenido (incluyendo textos), comprometiéndose a mantenerlo indemne de cualquier reclamación instada por estos motivos.
                    A los efectos de preservar los posibles derechos de propiedad intelectual, en el caso de que cualquier Usuario o un tercero considere que se ha producido una violación de sus legítimos derechos por la introducción de un determinado contenido en el Sitio Web, deberá notificar dicha circunstancia, por escrito, a el Sitio indicando:
                    Datos de carácter personal identificativos del interesado titular de los derechos presuntamente infringidos. Si la reclamación la presenta un tercero distinto del interesado, deberá indicar la representación que ostenta y con la que actúa.
                    Indicación de los contenidos protegidos por los derechos de propiedad intelectual y su ubicación en el Sitio Web.
                    Acreditación de la existencia, titularidad y vigencia de los citados derechos de propiedad intelectual. *
                    Declaración expresa en la que el interesado se responsabilice de la veracidad de los datos e información facilitados en la notificación a que se refiere este punto.
                    La subida de contenidos por parte de los Usuarios a través del Sitio Web no se deberá interpretar como una cesión de los derechos de explotación de dicho contenido por parte del Usuario. En este sentido, el Usuario se reserva la potestad de retirar los contenidos que haya publicado a través del Sitio Web y el Usuario asume el riesgo de copia, reproducción, distribución y comunicación pública de los contenidos que haya publicado a través del Sitio Web debiendo dejar a el Sitio indemne de cualquier reclamación en este sentido.
                    *Si dicha acreditación consiste en un certificado emitido por el Indautor o una entidad equivalente y esta ha sido registrada bajo un seudónimo, deberá incluir además una autorización por escrito en la que autorice al Sitio a consultar la información del registro, con la finalidad, de ser necesario, de confirmar la identidad del propietario de los derechos de autor.
                    <p>7. Exclusión de garantías y de responsabilidad</p><br>
                    El sitio excluye, hasta donde permite el ordenamiento jurídico, cualquier responsabilidad por los daños y perjuicios de toda naturaleza derivados del incumplimiento por parte del Usuario de estas condiciones así como de la imposibilidad de acceso al Sitio Web o la falta de veracidad, exactitud, exhaustividad y/o actualidad del Sitio Web, la existencia de vicios y defectos de toda clase de los servicios que se ofrecen a los Usuarios y la presencia de virus o de otros elementos en el Sitio Web que puedan producir alteraciones en los sistemas informáticos, documentos electrónicos o datos de los Usuarios.
                    Asimismo, el Sitio no garantiza ni se hace responsable, en ningún caso ni circunstancia, de los siguientes hechos y contenidos, ni de cualesquiera daños y perjuicios que pudieran, en su caso, derivarse de los mismos:
                    <br> a)       Del uso ilícito, negligente, fraudulento, suplantando la personalidad de un tercero o contrario al contenido de estas condiciones generales, a la buena fe, a los usos generalmente admitidos o al orden público, del Sitio Web, de sus servicios y contenidos, por los Usuarios.
                    <br>b)        De las vulneraciones o infracciones de las leyes, usos o costumbres vigentes en materia de derechos de propiedad intelectual, propiedad industrial, secretos empresariales o contractuales, derechos de intimidad, honor, imagen, propiedad, publicidad o competencia, entre otros, de terceros.
                    <br>c)       Por la recepción, almacenamiento, obtención, difusión o transmisión por parte de los Usuarios, de los contenidos del Sitio Web.
                    <p>8. Responsabilidad del Usuario</p><br>
                    El Usuario se obliga a hacer un uso correcto del Sitio Web de conformidad con las leyes, la buena fe, el orden público, los usos del tráfico y el presente documento. El Usuario responderá frente a el Sitio o frente a terceros, de cualesquiera daños y perjuicios que pudieran causarse como consecuencia del incumplimiento de dicha obligación.
                    Por tanto, queda prohibido todo uso con fines ilícitos, que perjudiquen o impidan, puedan dañar y/o sobrecargar, de cualquier forma, la utilización y normal funcionamiento del Sitio Web, o bien, que directa o indirectamente atenten contra el mismo o contra cualquier tercero.
                    El Usuario no transmitirá a través del Sitio Web nada que atente contra los valores y la dignidad de las personas, de acuerdo con las normas nacionales e internacionales.
                    El Usuario se compromete a suministrar información verdadera y exacta. Asimismo, queda prohibida la reproducción, distribución, transmisión, adaptación o modificación, por cualquier medio y en cualquier forma, de los contenidos del Sitio Web (textos, diseños, gráficos, informaciones, bases de datos, archivos de sonido y/o imagen, logos, etc.) y demás elementos de este sitio, salvo autorización previa de sus legítimos titulares o cuando así resulte permitido por la ley.
                    El Usuario deberá cumplir con las leyes, la buena fe, el orden público, los usos del tráfico y el presente documento como consecuencia del uso del Sitio Web y el Sitio no se hará responsable de las actuaciones de los Usuarios que vulneren derechos de propiedad intelectual e industrial, secretos empresariales, derechos al honor, a la intimidad personal y familiar y a la propia imagen, así como la normativa en materia de competencia desleal y publicidad ilícita
                    B) Proceso de atención a denuncias
                    Requisitos
                    Denuncia de contenido inapropiado:
                    Deberá incluir una descripción del tipo de contenido inapropiado, así como su ubicación dentro del libro.
                    Una liga al libro cuyo contenido infringe las normas de contenido
                    Denuncia de vulneración de derechos de autor:
                    Deberá incluir:
                    Datos que identifiquen a la persona cuyos derechos han sido presuntamente infringidos o, de ser el caso, la representación que ostenta.
                    Indicación de los contenidos protegidos y su ubicación en el sitio.
                    Acreditación de los derechos de autor (preferentemente un certificado emitido por el Indautor o su equivalente de otro país)
                    Declaración expresa por parte del interesado, responsabilizándose de la veracidad de la información proporcionada.
                    Si las denuncias no incluyen toda la información solicitada, deberá notificarse al interesado de la información faltante. Si este no proporciona la información faltante en los próximos 14 días, la denuncia deberá descartarse.
                    Réplica de acreditación de derechos de publicación:
                    Un usuario podrá acreditar sus derechos de publicación sobre una obra presentando:
                    Acuerdo de licencia de derechos de autor o una autorización firmada por el propietario de los derechos de autor.
                    Acreditación de los derechos de autor (preferentemente un certificado emitido por el Indautor o su equivalente de otro país).

                    <br>
                    <p>
                        Procedimiento
                        Denuncia de contenido inapropiado:</p><br>
                    <p>1).- Verificar que la denuncia mencione la presencia de alguno de los siguientes contenidos ya sea en la portada o contenido del libro:
                        Pornografía
                        Contenido o escenas sexuales que involucren menores de edad
                        Imágenes que representen actos sexuales o muestren genitales explícitamente.
                        Parafernalia de drogas en la portada
                        Apologías al:
                        Terrorismo
                        Racismo
                        Discriminación ideológica
                        Incitación al odio o a la violencia 
                        Difamación o vulneración de la privacidad de un tercero
                        En caso de no caer en ninguna de las categorías, queda a discreción del administrador evaluar si el contenido se considera inapropiado.
                    </p><br><p>2).-Si se determina que el libro incluye material inapropiado. Se bloqueará el libro, para que este no pueda ser accesado por los usuarios del sitio.</p><br>
                    <p>3).- Se notificará al autor del libro, mediante el correo electrónico registrado, las razones por las que su obra ha sido bloqueada, otorgándole 30 días para corregir el contenido. </p><br>
                    <p> 4).-Si el autor modifica el contenido considerado inapropiado, se procederá a desbloquear el libro para que quede disponible a todos los usuarios nuevamente. Si no, se eliminará definitivamente del sitio.</p><br>
                    <br>
                    <p>Denuncia por infringir los derechos de autor:</p>
                    1).-Verificar que esta no haya entrado en el dominio público. <br>
                    2).-Si no es así, se procederá a bloquear dicha obra.<br>
                    3).-Se notificará al usuario, mediante un correo electrónico enviado a la dirección registrada, la razón del bloqueo, otorgando un periodo de 30 días para acreditar los derechos de publicación sobre la obra.<br>
                    4).-Si el usuario no acredita los derechos de publicación al término de los 30 días, se procederá a eliminar el libro de forma definitiva.<br>
                    5).- Si el usuario acredita sus derechos de publicación, se le notificará al denunciante de dicha acreditación. Otorgando 14 días a partir de esa fecha para presentar alguna replica (El libro permanecerá bloqueado durante este tiempo).<br>
                    6).- Si al término de esos 14 días el denunciante no ha presentado nueva información, el libro será desbloqueado.<br>
                    7).-Si el denunciante presenta nueva información, se notificará al usuario de nueva cuenta, otorgando un nuevo periodo de 14 días. Se procede a partir del punto 4.<br>
                    Si ambos implicados llegaran a presentar un certificado, deberá consultarse con la institución correspondiente para esclarecer la propiedad de los derechos de autor.<br>
                    <br>

                    <p>Sanciones</p><br>
                    Si se prueba que un libro tiene contenido inapropiado y este no es modificado durante el periodo otorgado deberá eliminarse del sitio.
                    Si se demuestra que un libro infringe los derechos de autor, dicho libro deberá ser eliminado del sitio.
                    Un usuario que infrinja los derechos de propiedad intelectual de terceros será baneado del sitio.
                    Un usuario que incluya material inapropiado en sus libros será amonestado.
                    Si un usuario es amonestado en repetidas ocasiones será baneado del sitio.
                    Si un usuario hace mal uso de la herramienta de denuncia será baneado del sitio.

                    </p>
                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn modal-action modal-close waves-effect waves-green btn-flat" name="registrarse"><i class="material-icons center">thumb_up</i>Aceptar</button>
                    <button class="btn center waves-effect waves-light black" type="submit" name="cancelar" id="botonCerrar" ><i class="material-icons center">not_interested</i><spring:message code="label.cancelar"/>

                    </button>
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
                    <a class="orange-text text-lighten-3" href="http://materializecss.com"></a>
                </div>
            </div>
        </footer>
    </body>
</html>
