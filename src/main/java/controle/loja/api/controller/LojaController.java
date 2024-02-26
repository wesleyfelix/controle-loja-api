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

    @GetMapping
    public ResponseEntity<Page<DadosListagemLoja>> listar(@PageableDefault(size = 10, sort = {"razaoSocial"}) Pageable paginacao) {

        var page = repository.findAll(paginacao).map(DadosListagemLoja::new);
        return ResponseEntity.ok(page);
    }
//
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLoja dados){
        var loja = repository.getReferenceById(dados.id());
        loja.AtualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoLoja(loja));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var loja = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoLoja(loja));
    }

}
