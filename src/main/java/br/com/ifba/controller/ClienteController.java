package br.com.ifba.controller;


import br.com.ifba.dto.ClienteGetResponseDto;
import br.com.ifba.dto.ClientePostRequestDto;
import br.com.ifba.dto.ProjetoGetResponseDto;
import br.com.ifba.dto.ProjetoPostRequestDto;
import br.com.ifba.mapper.ObjectMapperUtil;
import br.com.ifba.model.Cliente;
import br.com.ifba.model.Projeto;
import br.com.ifba.service.ClienteService;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import java.util.List;


@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    private final ObjectMapperUtil objectMapperUtil;

    @PostMapping("/save")
    public ResponseEntity<ClienteGetResponseDto> save(@RequestBody ClientePostRequestDto dto) {

        // DTO → entidade
        Cliente cliente = objectMapperUtil.map(dto, Cliente.class);

        // chama o service
        Cliente salvo = clienteService.save(cliente);

        // entidade - DTO de resposta
        ClienteGetResponseDto response = objectMapperUtil.map(salvo, ClienteGetResponseDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ClienteGetResponseDto> login(@RequestBody ClientePostRequestDto dto) {
        Cliente cliente = clienteService.login(dto.getEmail(), dto.getSenha());
        ClienteGetResponseDto response = objectMapperUtil.map(cliente, ClienteGetResponseDto.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ClienteGetResponseDto>> listarTodos() {
        List<Cliente> clientes = clienteService.findAll();
        List<ClienteGetResponseDto> response = objectMapperUtil.mapAll(clientes, ClienteGetResponseDto.class);
        return ResponseEntity.ok(response);
    }


}
