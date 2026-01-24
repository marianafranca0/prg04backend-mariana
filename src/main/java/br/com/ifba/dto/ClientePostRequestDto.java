package br.com.ifba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// --DTO que recebe requisições REST.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientePostRequestDto {

    @JsonProperty(value = "nome")
    @NotBlank(message = "O campo deve ser preenchido!")
    private String nome;

    @JsonProperty(value = "senha")
    @NotBlank(message = "o campo deve ser preenchido!")
    private String senha;

    @JsonProperty(value = "email")
    @NotBlank(message = "O campo email deve ser preenchido!")

    @Email(message = "O campo deve ser preenchido!")
    private String email;

    @JsonProperty(value = "telefone")
    private String telefone;
}
