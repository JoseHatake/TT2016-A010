/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function eliminarCapitulo(ContextPath,idCapitulo){
    jQuery.ajax({
        url: ContextPath + "/eliminaCapitulo.htm",
        data: 'idCapitulo=' + idCapitulo,
        type: "POST",
        success: function (data) {
            if (data === "true") {
                var tmp = '#'+idCapitulo;
                $(tmp).closest('tr').remove();
            }
        },
        error: function () {
            alert("No se eliminó el capítulo");
        }
    });
}