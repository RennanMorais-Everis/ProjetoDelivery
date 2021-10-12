package com.everis.delivery.controller;

import com.everis.delivery.dto.ProdutoRequest;
import com.everis.delivery.model.Produto;
import com.everis.delivery.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public String admin(Model model) {
        long countProdutos = produtoRepository.count();
        model.addAttribute("countProdutos", countProdutos);
        return "admin/home";
    }

    @GetMapping("produtos")
    public String produtos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "admin/produtos";
    }

    @PostMapping("/produtos/add")
    public String addProduto( ProdutoRequest request, BindingResult result) {
        Produto produto = request.toProduto();
        produtoRepository.save(produto);
        return "redirect:/admin/produtos";
    }

   /* @GetMapping("/produto/delete/{id}")
    public String removerProduto(@PathVariable("id") Long id, Model model) {
        Optional<Produto> produto = produtoRepository.findById(id);
        produtoRepository.delete(produto);
        return "redirect:/admin/produtos";
    }*/

    /*@GetMapping("/produto/edit/{id}")
    public String editProduto(@PathVariable("id") Long id, Model model) {
        return "admin/edit";
    }*/
}
