package br.com.ifba.service;

import br.com.ifba.model.Cliente;
import br.com.ifba.model.Projeto;
import br.com.ifba.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClienteService {


    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }


    // método findAll()
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente login(String email, String senha) {
        return clienteRepository.findByEmailAndSenha(email, senha)
                .orElseThrow(() -> new RuntimeException("Credenciais inválidas"));
    }

}
