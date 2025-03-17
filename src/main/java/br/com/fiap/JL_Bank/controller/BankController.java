package br.com.fiap.JL_Bank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.JL_Bank.model.Account;

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
    public ResponseEntity<Account> create(@RequestBody Account account) {
        log.info("Cadastrando uma nova conta " + account.getAgencia());
        repository.add(account);
        return ResponseEntity.status(201).body(account);
    }

    //bucas todas as contas
    @GetMapping("/contas")
    public List<Account> index() {
        log.info("Retornando todas as contas");
        return repository;
    }


    //buscar conta pelo ID
    @GetMapping("/contas/{id}")
    public ResponseEntity<Account> get(@PathVariable Long id) {
        log.info("Buscando conta..." + id);
        return ResponseEntity.ok(getAccountId(id));
            }

    //buscar conta pelo CPF
    @GetMapping("/contas/{cpfTitular}")
    public ResponseEntity<Account> get(@PathVariable String cpfTitular) {
        log.info("Buscando conta do Titular..." + cpfTitular);
        return ResponseEntity.ok(getAccountCpf(cpfTitular));
                    }
                
        
        
        
        
        
                    
                private Object getAccountCpf(String cpfTitular) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getAccountCpf'");
            }
        
                private Account getAccountId(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getAccount'");
        }


}
