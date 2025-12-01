package br.com.proiecte.controller;

import br.com.proiecte.model.Projeto;
import br.com.proiecte.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.ArrayList;
//import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    ProjetoService projetoService;

  //  private List<Projeto> projetos = new ArrayList<>();

    // ---- POST ----
    @PostMapping(path = "/save", consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody Projeto projeto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projetoService.save(projeto));
    }

    // ---- GET ----
    @GetMapping(path = "/findall", produces = "application/json")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(projetoService.findAll());
    }

    // ---- PUT ----
    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody Projeto projeto){
        projetoService.update(projeto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ---- DELETE ----
    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        projetoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

