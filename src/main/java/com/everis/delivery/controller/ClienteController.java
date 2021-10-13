package com.everis.delivery.controller;

import com.everis.delivery.dto.PedidoRequest;
import com.everis.delivery.model.Pedido;
import com.everis.delivery.model.Produto;
import com.everis.delivery.model.TipoPagamento;
import com.everis.delivery.repository.PedidoRepository;
import com.everis.delivery.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ClienteController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping
    public String home() {
        return "cliente/home";
    }

    @GetMapping("/cardapio")
    public String cardapio(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "cliente/cardapio";
    }

    @GetMapping("/newpedido")
    public String newPedido(Model model) {

        List<Produto> produtos = produtoRepository.findAll();
        TipoPagamento[] tipoPagamentos = TipoPagamento.values();

        model.addAttribute("produtos", produtos);
        model.addAttribute("tipoPagamentos", tipoPagamentos);
        return "cliente/novoPedido";
    }

    @PostMapping("/newpedido/teste")
    public String addPedido(PedidoRequest request, @RequestParam("produtos") List<Produto> produtos) {
        request.setProduto(produtos);
        Pedido pedido = request.addPedido();
        pedidoRepository.save(pedido);
        return "cliente/cardapio";
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "cliente/sobre";
    }
}