package br.com.ifba.controller;

import br.com.ifba.dto.EquipeGetResponseDto;
import br.com.ifba.dto.EquipePostRequestDto;
import br.com.ifba.mapper.ObjectMapperUtil;
import br.com.ifba.model.Equipe;
import br.com.ifba.service.EquipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipes")
@RequiredArgsConstructor
public class EquipeController {

    private final EquipeService equipeService;
    private final ObjectMapperUtil objectMapperUtil;

    // - POST: cria um membro da equipe
    @PostMapping("/save")
    public ResponseEntity<EquipeGetResponseDto> save(@RequestBody EquipePostRequestDto dto) {

        // DTO → entidade
        Equipe equipe = objectMapperUtil.map(dto, Equipe.class);

        // chama o service
        Equipe salvo = equipeService.save(equipe, dto.getIdProjeto());

        // entidade → DTO de resposta
        EquipeGetResponseDto response = objectMapperUtil.map(salvo, EquipeGetResponseDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // - GET: lista todos os membros da equipe
    @GetMapping(path = "/findall", produces = "application/json")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(objectMapperUtil.mapAll(
                        equipeService.findAll(),
                        EquipeGetResponseDto.class));
    }

    // - PUT: atualiza um membro da equipe
    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody Equipe equipe) {
        equipeService.update(equipe);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // - DELETE: deleta um membro da equipe pelo ID
    @DeleteMapping(path = "/delete/{id}", produces = "application/json")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        equipeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
