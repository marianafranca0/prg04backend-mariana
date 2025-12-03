package br.com.ifba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// -- ProjetoGetResponseDto: DTO que responde requisições REST.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoGetResponseDto {

        @JsonProperty(value = "nome")
        private String nome;

        @JsonProperty(value = "descricao")
        private String descricao;
}
