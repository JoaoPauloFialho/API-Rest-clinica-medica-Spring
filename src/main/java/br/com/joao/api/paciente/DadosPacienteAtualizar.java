package br.com.joao.api.paciente;

import br.com.joao.api.endereco.DadosEndereco;
import br.com.joao.api.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosPacienteAtualizar(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
