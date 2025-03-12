package br.com.fiap.JL_Bank.controller;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;

public class Validation {
    
    public ResponseEntity<String> validaCpf(String cpf){
        if(cpf == null || cpf.length() != 11) {
            return ResponseEntity.status(400).body("CPF inválido");
        }   

        return ResponseEntity.status(201).body(cpf);
    }

    public ResponseEntity<String> validaNome(String nome){
        if (nome == null) {
            return ResponseEntity.status(400).body("Nome não pode ser nulo");
        }

        return ResponseEntity.status(201).body(nome);
    }

    public ResponseEntity<String> validaDataAbertura(LocalDate data){
        if(data.isAfter(LocalDate.now())) {
            return ResponseEntity.status(400).body("A data precisa ser maior do que a data atual");
        }

        return ResponseEntity.status(201).body(null);
    }
    public ResponseEntity<String> validaSaldo(Double saldo){
        if (saldo <= 0) {
            return ResponseEntity.status(400).body("O saldo não pode ser negativo");
        }
        return ResponseEntity.status(201).body(null);
    }

    public ResponseEntity<String> validaTipo(String tipo){
        if (tipo == null || tipo != "CORRENTE" || tipo != "POUPANÇA" || tipo != "SALÁRIO") {
            return ResponseEntity.status(400).body("Tipo de conta inválido");
        }

        return ResponseEntity.status(201).body(null);
    }
}
