package br.com.fiap.JL_Bank.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;


public class Acount{
    private Long id;
    private String numero;
    private String agencia;

    @NotNull(message = "O nome do titular é obrigatorio")
    private String nomeTitular;
    
    @NotNull(message = "O CPF do titular é obrigatorio")
    private String cpfTitular;

    @NotNull
    @PastOrPresent(message = "A data de abertura deve ser hoje ou no passado")
    private LocalDate dataAbertura;

    @NotNull
    @PositiveOrZero(message = "O saldo inicial deve ser maior ou igual a zero!")
    private Double saldoInicial;

    private Boolean ativa;

    @NotNull(message = "O tipo da conta é obrigatorio")
    private TipoConta tipoConta;

    public Acount(Long id, String numero, String agencia, String nomeTitular, String cpfTitular,
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

    
    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    @Override
    public String toString() {
        return id + ", " + numero + ", " + agencia + ", " + nomeTitular + ", " +
            cpfTitular + ", " + dataAbertura + ", " + saldoInicial + ", " + ativa + ", " + tipoConta;
    }
    
}

