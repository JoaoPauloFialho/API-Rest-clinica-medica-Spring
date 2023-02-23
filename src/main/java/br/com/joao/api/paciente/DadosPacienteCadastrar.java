package br.com.joao.api.paciente;

import br.com.joao.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosPacienteCadastrar(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String cpf,
        @NotBlank
        String telefone,
        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
