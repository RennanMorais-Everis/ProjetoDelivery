package com.everis.delivery.controller;

import com.everis.delivery.dto.PedidoRequest;
import com.everis.delivery.model.*;
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
        List<Produto> pizzas = produtoRepository.findByCategoria(Categoria.PIZZA); //metodo findByCategoria a palavra Categoria identifica a coluna da tabela produtos não necessitando realizar uma query
        List<Produto> esfihas = produtoRepository.findByCategoria(Categoria.ESFIHA);
        List<Produto> bebidas = produtoRepository.findByCategoria(Categoria.BEBIDA);
        model.addAttribute("pizzas", pizzas);
        model.addAttribute("esfihas", esfihas);
        model.addAttribute("bebidas", bebidas);
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

    @PostMapping("/newpedido")
    public String addPedido(PedidoRequest request, @RequestParam("produtos") List<Produto> produtos, Model model) {

        //Enviando lista de produtos para o pedido
        request.setProduto(produtos);

        Pedido pedido = request.addPedido();
        pedidoRepository.save(pedido);

        return "redirect:/newpedido/pedido";
    }

    @GetMapping("/newpedido/pedido")
    public String pendingPedido(Model model) {
        Pedido pedido = pedidoRepository.findByStatusPedido(StatusPedido.PENDENTE);
        model.addAttribute("pedido", pedido);
        List<Produto> produto = pedido.getProduto();
        return "cliente/pedido";
    }

    @PostMapping("/newpedido/pedido/save")
    public String updatePedido(PedidoRequest request) {
        Pedido pedido = pedidoRepository.getById(request.getId());
        pedido = request.update(pedido);
        pedidoRepository.save(pedido);
        return "redirect:/cardapio";
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "cliente/sobre";
    }
}