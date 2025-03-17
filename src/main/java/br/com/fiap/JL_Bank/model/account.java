package br.com.fiap.JL_Bank.model;

import java.time.LocalDate;


public class Account {
    private Long id;
    private String numero;
    private String agencia;

    private String nomeTitular;
    private String cpfTitular;
    private LocalDate dataAbertura;
    private Double saldoInicial;
    private Boolean ativa;
    private TipoConta tipoConta;

    public Account(Long id, String numero, String agencia, String nomeTitular, String cpfTitular,
            LocalDate dataAbertura, Double saldoInicial, Boolean ativa, TipoConta tipoConta) {
        this.id = id;
        this.numero = numero;
        this.agencia = agencia;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.dataAbertura = dataAbertura;
        this.saldoInicial = saldoInicial;
        this.ativa = ativa;
        this.tipoConta = tipoConta;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    

    
}

