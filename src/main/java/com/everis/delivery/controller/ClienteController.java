package com.everis.delivery.controller;

import com.everis.delivery.controller.dto.ClienteDto;
import com.everis.delivery.controller.form.ClienteForm;
import com.everis.delivery.model.Cliente;
import com.everis.delivery.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteDto> lista(String nomeCliente){
        ModelAndView mv= new ModelAndView("clientes");
        List<Cliente> clientes = clienteRepository.findByNome(nomeCliente);
        mv.addObject("clientes",clientes);
        return (List<ClienteDto>) mv;
    }

}