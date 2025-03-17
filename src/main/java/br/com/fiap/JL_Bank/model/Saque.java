package br.com.fiap.JL_Bank.model;

public class Saque {
    
    private Long id;
    private Double valorSaque;


    public Saque(Long id, Double valorSaque) {
        this.id = id;
        this.valorSaque = valorSaque;
    }


    public Long getId() {
        return id;
    }


    public Double getValorSaque() {
        return valorSaque;
    }

    

    
}
