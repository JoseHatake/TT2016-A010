/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Lock
 */
@Controller
@RequestMapping("/logout")
public class ControladorLogout {
    @RequestMapping(method = RequestMethod.POST)
    public void logout(HttpSession ses){        
        ses.removeAttribute("use");       
    }
    
}
