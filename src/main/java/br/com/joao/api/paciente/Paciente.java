package br.com.joao.api.paciente;

import br.com.joao.api.endereco.Endereco;
import br.com.joao.api.medico.DadosMedicoCadastrar;
import br.com.joao.api.medico.Especialidade;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name = "pacientes")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Paciente (DadosPacienteCadastrar dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarPaciente(DadosPacienteAtualizar dados){
        if(dados.nome() != null) this.nome = dados.nome();
        if(dados.endereco() != null) this.endereco = new Endereco(dados.endereco());
        if(dados.telefone() != null) this.telefone = dados.telefone();
    }

    @Override
    public String toString() {
        return "Paciente " + this.nome ;
    }

    public void excluir() {
        this.ativo = false;
    }
}
