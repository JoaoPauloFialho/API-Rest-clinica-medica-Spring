package br.com.joao.api.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        @NotBlank
        String numero,
        @NotBlank
        String complemento
) {
}
