package com.everis.delivery.controller;

import com.everis.delivery.model.Produto;
import com.everis.delivery.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public String admin(Model model) {
        return "admin/home";
    }

    @GetMapping("produtos")
    public String produtos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "admin/produtos";
    }

    @GetMapping("/produto/edit/{id}")
    public String editProduto(@PathVariable("id") Long id, Model model) {
        /*Produto produto = produtoRepository.findById();*/
        /*model.addAttribute("produto", ´produto);*/
        return "admin/edit";
    }
}
