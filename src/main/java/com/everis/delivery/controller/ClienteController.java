package com.everis.delivery.controller;

import com.everis.delivery.model.Produto;
import com.everis.delivery.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ClienteController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public String home() {
        return "cliente/home";
    }

    @GetMapping("cardapio")
    public String cardapio(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "cliente/cardapio";
    }
}