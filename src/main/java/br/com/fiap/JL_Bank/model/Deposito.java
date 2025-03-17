package br.com.fiap.JL_Bank.model;

public class Deposito {
    private Long id;
    private Double valorDeposito;


    public Deposito(Long id, Double valorDeposito) {
        this.id = id;
        this.valorDeposito = valorDeposito;
    }


    public Long getId() {
        return id;
    }


    public Double getValorDeposito() {
        return valorDeposito;
    }

    
}
