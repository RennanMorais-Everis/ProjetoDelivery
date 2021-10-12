package com.everis.delivery.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@EntityScan
@Table(name = "conta")
public class Conta {
    private Integer id;
    private String name;
    private String comanda;
    private String conta;

    @OneToOne(mappedBy = "conta")
    private Pagamento pagamento;

    private double saldoDebito;
    private double saldoCredito;

    public Conta(String nome, String comanda, String conta, double saldoDebito, double saldoCredito, Pagamento pagamento) {
        super();
        this.name = nome;
        this.comanda = comanda;
        this.conta = conta;
        this.saldoDebito = saldoDebito;
        this.saldoCredito = saldoCredito;
        this.pagamento = pagamento;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComanda() {
        return comanda;
    }

    public void setComanda(String comanda) {
        this.comanda = comanda;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public double getSaldoDebito() {
        return saldoDebito;
    }

    public void setSaldoDebito(double saldoDebito) {
        this.saldoDebito = saldoDebito;
    }


}
