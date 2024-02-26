package controle.loja.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import controle.loja.api.domain.loja.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("lojas")
public class LojaController {

    @Autowired
    private LojaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLoja dados, UriComponentsBuilder uriComponentsBuilder) {

        var loja = new Loja(dados);
        repository.save(loja);
        var uri = uriComponentsBuilder.path("/lojas/{id}").buildAndExpand(loja.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoLoja(loja));
    }

//    @GetMapping
//    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
//
//        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
//        return ResponseEntity.ok(page);
//    }
//
//    @PutMapping
//    @Transactional
//    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
//        var medico = repository.getReferenceById(dados.id());
//        medico.AtualizarInformacoes(dados);
//
//        return ResponseEntity.ok(new DetalhamentoMedico(medico));
//    }
//
//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity excluir(@PathVariable Long id){
//        var medico = repository.getReferenceById(id);
//        medico.excluir();
////        repository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity detalhar(@PathVariable Long id){
//        var medico = repository.getReferenceById(id);
//        return ResponseEntity.ok(new DetalhamentoMedico(medico));
//    }

}
