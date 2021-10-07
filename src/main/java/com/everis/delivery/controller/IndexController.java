package com.everis.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    //@RequestMapping - Denomina a URL @ResponseBody- Responsavel por retornar a frase

    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "Em construção, volte mais tarde";
    }
}