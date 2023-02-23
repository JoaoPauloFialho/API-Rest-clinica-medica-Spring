package br.com.joao.api.medico;

public record DadosMedicoListar(
        Long id,
        String nome,
        String telefone,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosMedicoListar (Medico medico){
        this(medico.getId() ,medico.getNome(), medico.getTelefone() ,medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
