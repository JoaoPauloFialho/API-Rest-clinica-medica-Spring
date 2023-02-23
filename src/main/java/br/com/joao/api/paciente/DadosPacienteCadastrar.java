package br.com.joao.api.paciente;

import br.com.joao.api.endereco.DadosEndereco;

public record DadosPacienteCadastrar(
        String nome,
        String email,
        String cpf,
        String telefone,
        DadosEndereco endereco
) {
}
