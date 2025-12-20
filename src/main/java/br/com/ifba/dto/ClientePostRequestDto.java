package br.com.ifba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
   // @NotBlank(message = "O campo deve ser preenchido!")
    private String nome;

    @JsonProperty(value = "cnpj")
  //  @NotBlank(message = "o campo deve ser preenchido!")
    private String cnpj;

    @JsonProperty(value = "email")
  //  @NotBlank(message = "O campo deve ser preenchido!")
    private String email;

    @JsonProperty(value = "telefone")
  //  @NotBlank(message = "O campo deve ser preenchido!")
    private String telefone;
}
