package br.com.joao.api.medico;

import br.com.joao.api.endereco.DadosEndereco;
import br.com.joao.api.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosMedicoAtualizar(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
