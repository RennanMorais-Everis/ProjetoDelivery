package com.everis.delivery.controller;

import com.everis.delivery.model.Produto;
import com.everis.delivery.service.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class ProdutosController {

    @Autowired
    CardapioService cardapioService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView getAdmin() {
        ModelAndView mv = new ModelAndView("admin");
        List<Produto> produtos = cardapioService.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public ModelAndView getProdutos() {
        ModelAndView mv = new ModelAndView("produtos");
        List<Produto> produtos = cardapioService.findAll();
        mv.addObject("produtos", produtos);
        return mv;

    }
}