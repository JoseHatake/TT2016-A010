/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.PaisesDAO;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Lock
 */
@Controller
@RequestMapping("/obtenPaises")
public class ControladorListaPaises {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getPaises() {
        List<String> paises;
        PaisesDAO dao = new PaisesDAO();
        paises = dao.obtenTodosPaises();
        String lista="";
        for(int i=0;i<paises.size();i++){
            lista+=paises.get(i)+",";
        }       
        return lista;
    }
}
