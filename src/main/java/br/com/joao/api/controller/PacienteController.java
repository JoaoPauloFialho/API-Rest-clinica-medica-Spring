package br.com.joao.api.controller;

import br.com.joao.api.paciente.*;
import br.com.joao.api.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastarPaciente(@RequestBody @Valid DadosPacienteCadastrar dados, UriComponentsBuilder uriBuilder){
        Paciente paciente = new Paciente(dados);
        this.repository.save(paciente);
        URI uri = uriBuilder.path("/medicos/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosPacienteListar>> listarPacientes(Pageable pageable){
        Page page = this.repository.findAllByAtivoTrue(pageable).map(p -> new DadosPacienteListar(p));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalharPaciente(@PathVariable Long id){
        Paciente paciente = this.repository.getReferenceById(id);
        return  ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPaciente(@RequestBody DadosPacienteAtualizar dados){
        Paciente paciente = this.repository.getReferenceById(dados.id());
        paciente.atualizarPaciente(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPaciente(@PathVariable Long id){
        Paciente paciente = this.repository.getReferenceById(id);
        paciente.excluir();
        return  ResponseEntity.ok().build();
    }

}
