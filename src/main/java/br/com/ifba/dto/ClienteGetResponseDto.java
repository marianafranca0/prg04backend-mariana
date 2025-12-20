package br.com.ifba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// --DTO que responde requisições REST.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteGetResponseDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "cnpj")
    private String cnpj;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "telefone")
    private String telefone;
}
