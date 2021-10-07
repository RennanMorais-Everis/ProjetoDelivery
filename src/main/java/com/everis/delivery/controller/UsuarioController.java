package com.everis.delivery.controller;

import com.everis.delivery.model.Usuario;
import com.everis.delivery.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String newUser(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {

        if(result.hasErrors()) {
            attributes.addFlashAttribute("message", "Campos obrigatórios não preenchidos!");
            return "redirect:/cardapio";
        }

        usuarioService.save(usuario);
        return "redirect:/cardapio";
    }

}
