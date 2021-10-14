package com.everis.delivery.controller;

import com.everis.delivery.dto.ProdutoRequest;
import com.everis.delivery.model.Pedido;
import com.everis.delivery.model.Produto;
import com.everis.delivery.model.StatusPedido;
import com.everis.delivery.repository.PedidoRepository;
import com.everis.delivery.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping
    public String admin(Model model) {
        long countProdutos = produtoRepository.count();
        List<Pedido> pedidos = pedidoRepository.findAllByStatusPedido(StatusPedido.APROVADO);
        Long countPedidos = pedidoRepository.count();

        model.addAttribute("countProdutos", countProdutos);
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("countPedidos", countPedidos);
        return "admin/home";
    }

    @GetMapping("/produtos")
    public String produtos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "admin/produtos";
    }

    @PostMapping("/produtos/add")
    public String addProduto(@Valid ProdutoRequest request) {
        Produto produto = request.addProduto();
        produtoRepository.save(produto);
        return "redirect:/admin/produtos";
    }

    @GetMapping("/produto/edit/{id}")
    public String editProduto(@PathVariable("id") Long id, Model model) {
        Produto produto = produtoRepository.getById(id);
        model.addAttribute("produto", produto);
        return "admin/editproduto";
    }

    @PostMapping("/produto/edit/save")
    public String saveproduto(ProdutoRequest request, Model model) {
        Produto produto = produtoRepository.getById(request.getId());
        produto = request.update(produto);
        produtoRepository.save(produto);
        return "redirect:/admin/produtos";
    }

    @GetMapping("/produto/delete/{id}")
    public String removerProduto(@PathVariable("id") Long id, Model model) {
        Produto produto = produtoRepository.getById(id);

        if(produto != null) {
            produtoRepository.delete(produto);
            return "redirect:/admin/produtos";
        }

        return "redirect:/admin/produtos";
    }

    @GetMapping("/pedidos")
    public String pedidos() {
        List<Pedido> pedidos = pedidoRepository.findAllByStatusPedido(StatusPedido.CONCLUIDO);
        return "admin/pedidos";
    }

    @GetMapping("/pedidos-recebidos")
    public String pedidosRecebidos() {
        return "admin/pedidosRecebidos";
    }

}