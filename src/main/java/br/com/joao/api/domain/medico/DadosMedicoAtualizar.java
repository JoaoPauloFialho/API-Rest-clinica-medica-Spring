package br.com.joao.api.domain.medico;

import br.com.joao.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosMedicoAtualizar(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
