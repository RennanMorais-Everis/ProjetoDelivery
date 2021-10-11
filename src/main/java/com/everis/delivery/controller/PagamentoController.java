package com.everis.delivery.controller;


import com.everis.delivery.model.Pagamento;
import com.everis.delivery.service.serviceImplements.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@RestController(value = "pagamento" )
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @PostMapping
    public ResponseEntity<Pagamento>add(@RequestBody Integer origem, Integer destino, double valor) {
        return service.pagamentoComanda(origem, destino, valor);
    }

    @DeleteMapping
    public ResponseEntity<Pagamento>delete(@RequestBody Integer idPagamento ) {
        return service.deletaPagamentoEFazRollback(idPagamento);
    }

    @PutMapping
    public ResponseEntity<Pagamento>update(@RequestBody Integer idPagamento, double valorAtualizado) {
        return service.atualizaPagamentoESaldos(idPagamento, valorAtualizado);
    }

    @GetMapping
    public Iterable<Pagamento> List(){
        return service.listaPagamento();

    }
}
