package br.com.joao.api.controller;

import br.com.joao.api.domain.medico.*;
import br.com.joao.api.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarMedico(@RequestBody @Valid DadosMedicoCadastrar dados, UriComponentsBuilder uriBuilder){
        Medico medico = new Medico(dados);
        this.repository.save(medico);
        URI uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosMedicoListar>> listarMedico(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable pageable){
        Page page = this.repository.findAllByAtivoTrue(pageable).map(DadosMedicoListar::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")//parametro dinamico para apagar medicos /medicos/id
    public ResponseEntity detalharMedico(@PathVariable Long id){
        Medico medico = this.repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarMedico(@RequestBody DadosMedicoAtualizar dados){
        Medico medico = this.repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")//parametro dinamico para apagar medicos /medicos/id
    @Transactional
    public ResponseEntity excluirMedico(@PathVariable Long id){
        Medico medico = this.repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }

}
