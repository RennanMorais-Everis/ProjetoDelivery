package com.everis.delivery.controller;

import com.everis.delivery.dto.ProdutoRequest;
import com.everis.delivery.model.Produto;
import com.everis.delivery.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    /*@GetMapping("/produto/delete/{id}")
    public String removerProduto(@PathVariable("id") Long id, Model model) {
        return "redirect:/admin/produtos";
    }*/

    @GetMapping("/produto/edit/{id}")
    public String editProduto(@PathVariable("id") Long id, Model model) {
        Produto produto = produtoRepository.getById(id);
        model.addAttribute("produto", produto);
        return "admin/editproduto";
    }

    /*@PatchMapping("/produto/edit/{id}")
    public String saveproduto(ProdutoRequest request, Model model) {
        Produto produto = produtoRepository.getById(request.getId());
        produto = request.toProduto();
        produtoRepository.save(produto);
        return "redirect:/produto/editproduto";
    }*/

    @GetMapping("pedidos")
    public String pedidos() {
        return "admin/pedidos";
    }

}