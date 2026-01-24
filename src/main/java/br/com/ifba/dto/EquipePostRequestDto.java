package br.com.ifba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipePostRequestDto {

    @JsonProperty(value = "nome")
    @NotBlank(message = "O nome do membro deve ser preenchido!")
    private String nome;

    @JsonProperty(value = "cargo")
    @NotBlank(message = "O cargo deve ser preenchido!")
    private String cargo;

    @JsonProperty(value = "idProjeto")
    @NotNull(message = "O projeto associado deve ser informado!")
    private Long idProjeto; // chave estrangeira para vincular ao projeto
}


