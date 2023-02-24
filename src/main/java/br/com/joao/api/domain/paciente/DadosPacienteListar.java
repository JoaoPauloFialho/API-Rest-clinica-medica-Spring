package br.com.joao.api.domain.paciente;

public record DadosPacienteListar(Long id, String nome, String email, String telefone) {
    public DadosPacienteListar(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone());
    }
}
