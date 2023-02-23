package br.com.joao.api.medico;

import br.com.joao.api.endereco.DadosEndereco;

public record DadosMedicoCadastrar(
        String nome,
        String email,
        String crm,
        String telefone,
        Especialidade especialidade,
        DadosEndereco endereco
) {
}
