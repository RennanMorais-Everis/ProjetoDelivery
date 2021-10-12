package com.everis.delivery.service.serviceImplements;

import com.everis.delivery.model.Conta;
import com.everis.delivery.model.Pagamento;
import com.everis.delivery.repository.ContasRepository;
import com.everis.delivery.repository.PagamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
    public class PagamentosService {

        @Autowired
        private PagamentosRepository pagamentoRepository;
        @Autowired
        private ContasRepository contaRepository;

    public ResponseEntity<Pagamento> pagamentoComanda(Integer origem, Integer destino, double valor) {
            // busca se conta de origem existe e traz o saldo
            Conta contaOrigem = this.contaRepository.findbyId(origem);

            if (contaOrigem != null) {
                Conta contaDestino = this.contaRepository.findbyId(destino);
                if (contaDestino != null) {
                    if (contaOrigem.getSaldoDebito () >= valor) {
                        transferenciaPagamento(contaOrigem, contaDestino, valor);
                        return new ResponseEntity<Pagamento>(salvaPagamento(contaOrigem, contaDestino, valor), HttpStatus.OK);
                    }
                }
            }
            return new ResponseEntity<Pagamento>(HttpStatus.BAD_REQUEST);
        }

        private void transferenciaPagamento(Conta origem, Conta destino, double valor) {
            double saldoOrigem = origem.getSaldoDebito() - valor;
            origem.setSaldoDebito(saldoOrigem);
            double saldoDestino = destino.getSaldoDebito() + valor;
            destino.setSaldoDebito(saldoDestino);
            salvarConta(origem, destino);
        }

        private Pagamento salvaPagamento(Conta origem, Conta destino, double valor) {
            Pagamento pagamento = new Pagamento(origem, destino, valor);
            pagamentoRepository.save(pagamento);
            return pagamento;
        }

        private void pagamantoDestino(Conta origem, Conta destino, double valor) {
            double saldoOrigem = origem.getSaldoDebito() - valor;
            origem.setSaldoDebito(saldoOrigem);
            double saldoDestino = destino.getSaldoDebito() + valor;
            destino.setSaldoDebito(saldoDestino);
            salvarConta(origem, destino);
        }

        private void salvarConta(Conta origem, Conta destino) {
            contaRepository.save(origem);
            contaRepository.save(destino);
        }

        public ResponseEntity<Pagamento> deletaPagamentoEFazRollback(Integer idPagamento) {
            Pagamento pagamento = pagamentoRepository.findbyId(idPagamento);
            pagamentoRollback(pagamento.getOrigem(), pagamento.getDestino(), pagamento.getValorPagamento());

            pagamentoRepository.delete(pagamento);
            return new ResponseEntity<Pagamento>(HttpStatus.OK);


        }

        private void pagamentoRollback(Conta origem, Conta destino, double valorPagamento) {
        }

        public ResponseEntity<Pagamento> atualizaPagamentoESaldos(Integer idPagamento, double valorAtualizado) {

            //busca transferencia
            Pagamento pagamento = pagamentoRepository.findbyId(idPagamento);

            //faz rollback
            pagamentoRollback(pagamento.getOrigem(), pagamento.getDestino(), pagamento.getValorPagamento());


            Conta contaOrigem = this.contaRepository.findbyId(pagamento.getOrigem().getId());
            if (contaOrigem != null) {
                Conta contaDestino = this.contaRepository.findbyId(pagamento.getDestino().getId());
                if (contaDestino != null) {
                    if (contaOrigem.getSaldoDebito() >= valorAtualizado) {
                        transferenciaPagamento(contaOrigem, contaDestino, valorAtualizado);
                        return new ResponseEntity<Pagamento>(salvaPagamento(contaOrigem, contaDestino, valorAtualizado), HttpStatus.OK);
                    }
                }
            }
            return new ResponseEntity<Pagamento>(HttpStatus.BAD_REQUEST);
        }



        public Iterable<Pagamento>listaPagamento() {
            return pagamentoRepository.findAll();
        }

    }


