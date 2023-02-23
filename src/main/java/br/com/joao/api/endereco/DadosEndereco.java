package br.com.joao.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

public record DadosEndereco(
        String logradouro,
        String bairro,
        String cep,
        String cidade,
        String uf,
        String numero,
        String complemento
) {
}
