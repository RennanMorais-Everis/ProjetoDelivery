package com.everis.delivery.controller;

import com.everis.delivery.dto.UsuariosRequest;
import com.everis.delivery.model.Usuario;
import com.everis.delivery.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    //Metodo de cadastro do usuario
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastro(@Valid UsuariosRequest request, BindingResult result, RedirectAttributes attributes) {
        return "cadastro";
    }

    public String login() {
        return "lofin";
    }

}
