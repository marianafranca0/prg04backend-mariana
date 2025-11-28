package br.com.proiecte.controller;

import br.com.proiecte.model.Projeto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private List<Projeto> projetos = new ArrayList<>();

    @PostMapping
    public Projeto criarProjeto(@RequestBody Projeto projeto){
        projetos.add(projeto);
        return projeto;
    }
    @GetMapping
    public List<Projeto> listarProjetos(){
        return projetos;
    }
}

