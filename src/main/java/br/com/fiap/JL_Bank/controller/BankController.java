package br.com.fiap.JL_Bank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.JL_Bank.model.Account;
import br.com.fiap.JL_Bank.model.Deposito;
import br.com.fiap.JL_Bank.model.Pix;
import br.com.fiap.JL_Bank.model.Saque;

@RestController
public class BankController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private List<Account> repository = new ArrayList<>();


    //endpoint que retorna integrantes
    @GetMapping("/")
    public String team() {
        return "JL BANK - Integrantes: Julia, João, Maria";
    }

    //endpoint que cadastra conta
    @PostMapping("/contas")
    public ResponseEntity<Account> criarConta(@RequestBody Account account) {
        log.info("Cadastrando uma nova conta " + account.getAgencia());
        repository.add(account);
        return ResponseEntity.status(201).body(account);
    }

    //bucas todas as contas
    @GetMapping("/contas")
    public List<Account> listarTodasConta() {
        log.info("Retornando todas as contas");
        return repository;
    }


    //buscar conta pelo ID
    @GetMapping("/contas/{id}")
    public ResponseEntity<Account> getContaId(@PathVariable Long id) {
        log.info("Buscando conta..." + id);
        return ResponseEntity.ok(getAccountId(id));
            }

    //buscar conta pelo CPF
    @GetMapping("/contas/{cpfTitular}")
    public ResponseEntity<Object> getContaCpf(@PathVariable String cpfTitular) {
        log.info("Buscando conta do Titular..." + cpfTitular);
        return ResponseEntity.ok(getAccountCpf(cpfTitular));
    }

                
    //tornar conta inativa
    @DeleteMapping("/contas/{id}")
    public ResponseEntity<Object> encerrarCosnta(@PathVariable Long id) {
        log.info("Tornando conta inativa: " + id);
        var account = getAccountId(id);
        account.setAtiva(Boolean.FALSE);
        return ResponseEntity.ok(account);
    }
    
    //realizar depósito
    @PutMapping("/contas/depósito")
    public ResponseEntity<Account> depositar(@RequestBody Deposito deposito) {
        log.info("Realizando depósito na conta...");
        var account = getAccountId(deposito.getId());
        account.setSaldoInicial(account.getSaldoInicial()+ deposito.getValorDeposito());
        return ResponseEntity.ok(account);
    }

    //realizar saque
    @PutMapping("/contas/sacar")
    public ResponseEntity<Account> sacar(@RequestBody Saque saque) {
        log.info("Realizando saque na conta...");
        var account = getAccountId(saque.getIdConta()); 
        account.setSaldoInicial(account.getSaldoInicial() - saque.getValorSaque()); 
        return ResponseEntity.ok(account);
    }

    //efetuar pix
    @PutMapping("/pix")
    public ResponseEntity<Account> realizarPix(@RequestBody Pix pix) {
        Account contaOrigem = getAccountId(pix.getIdOrigem());
        Account contaDestino = getAccountId(pix.getIdDestino());

        contaOrigem.setSaldoInicial(contaOrigem.getSaldoInicial() - pix.getValorPix());
        contaDestino.setSaldoInicial(contaDestino.getSaldoInicial() + pix.getValorPix());

        return ResponseEntity.ok(contaOrigem); // Retorna conta de origem atualizada
    }

        
        
        
        
                    
                private Object getAccountCpf(String cpfTitular) {
                    return repository.stream()
                    .filter(c -> c.getCpfTitular().equals(cpfTitular))
                    .findFirst()
                    .orElseThrow(
                            () -> new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "Conta não encontrada"));
                }
        
                private Account getAccountId(Long id) {
                    return repository.stream()
                    .filter(c -> c.getId().equals(id))
                    .findFirst()
                    .orElseThrow(
                            () -> new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "Conta não encontrada"));
}

}
