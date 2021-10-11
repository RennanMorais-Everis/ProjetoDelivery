package com.everis.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ClienteController {

    @GetMapping
    public String home() {
        return "cliente/home";
    }

    @GetMapping("cardapio")
    public String cardapio() {
        return "cliente/cardapio";
    }
}