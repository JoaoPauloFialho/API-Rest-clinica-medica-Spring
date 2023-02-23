package br.com.joao.api.controller;

import br.com.joao.api.medico.DadosMedicoAtualizar;
import br.com.joao.api.medico.DadosMedicoCadastrar;
import br.com.joao.api.medico.DadosMedicoListar;
import br.com.joao.api.medico.Medico;
import br.com.joao.api.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody DadosMedicoCadastrar dados){
        Medico medico = new Medico(dados);
        this.repository.save(medico);
        System.out.println(medico);
    }

    @GetMapping
    public Page<DadosMedicoListar> listarMedico(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable pageable){
        return this.repository.findAllByAtivoTrue(pageable).map(DadosMedicoListar::new);
    }

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody DadosMedicoAtualizar dados){
        Medico medico = this.repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")//parametro dinamico para apagar medicos /medicos/id
    @Transactional
    public void excluirMedico(@PathVariable Long id){
        Medico medico = this.repository.getReferenceById(id);
        medico.excluir();
    }

}
