package br.com.ifba.controller;

import br.com.ifba.dto.ProjetoGetResponseDto;
import br.com.ifba.dto.ProjetoPostRequestDto;
import br.com.ifba.mapper.ObjectMapperUtil;
import br.com.ifba.model.Projeto;
import br.com.ifba.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    ProjetoService projetoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // - POST: cria um projeto (recebe DTO de entrada, devolve DTO de saída).
    //   FLUXO =  Cliente envia JSON → vira DTO → vira entidade → salva → devolve DTO de resposta.
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody ProjetoPostRequestDto projetoPostRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(objectMapperUtil.map(projetoService.save(
                                (objectMapperUtil.map(projetoPostRequestDto, Projeto.class))),
                                 ProjetoGetResponseDto.class));
    }

    // - GET: lista todos os projetos (devolve lista de DTOs de saída).
    //   FLUXO: Banco -> lista de entidades -> lista de DTOs -> resposta JSON
    @GetMapping(path = "/findall", produces = "application/json")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(objectMapperUtil.mapAll(
                        projetoService.findAll(),
                        ProjetoGetResponseDto.class));
    }

    // - PUT: atualiza um projeto
    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody Projeto projeto){
        projetoService.update(projeto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // - DELETE:  deleta um projeto pelo ID
    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        projetoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

