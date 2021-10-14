package com.everis.delivery.controller;

import com.everis.delivery.dto.UsuariosRequest;
import com.everis.delivery.model.Usuario;
import com.everis.delivery.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "cadastrar";
    }

    @PostMapping("/cadastrar")
    public String newCadastro(UsuariosRequest request, RedirectAttributes attributes) {
        Usuario usuario = request.toUsuario();

        /*if() {
            attributes.addFlashAttribute("message", "Já existe um usuário com o e-mail cadasstrado!");
            return "redirect:/cadastrar";
        }*/

        usuarioRepository.save(usuario);

        return "redirect:/cardapio";
    }
}