package br.com.joao.api.controller;

import br.com.joao.api.paciente.DadosPacienteAtualizar;
import br.com.joao.api.paciente.DadosPacienteCadastrar;
import br.com.joao.api.paciente.DadosPacienteListar;
import br.com.joao.api.paciente.Paciente;
import br.com.joao.api.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastarPaciente(@RequestBody DadosPacienteCadastrar dados){
        Paciente paciente = new Paciente(dados);
        this.repository.save(paciente);
        System.out.println(paciente);
    }

    @GetMapping
    public Page<DadosPacienteListar> listarPacientes(Pageable pageable){
        return this.repository.findAllByAtivoTrue(pageable).map(p -> new DadosPacienteListar(p));
    }

    @PutMapping
    @Transactional
    public void atualizarPaciente(@RequestBody DadosPacienteAtualizar dados){
        Paciente paciente = this.repository.getReferenceById(dados.id());
        paciente.atualizarPaciente(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarPaciente(@PathVariable Long id){
        Paciente paciente = this.repository.getReferenceById(id);
        paciente.excluir();
    }

}
