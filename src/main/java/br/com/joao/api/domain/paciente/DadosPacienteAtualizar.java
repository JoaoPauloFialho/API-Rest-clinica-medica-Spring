package br.com.joao.api.domain.paciente;

import br.com.joao.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosPacienteAtualizar(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
