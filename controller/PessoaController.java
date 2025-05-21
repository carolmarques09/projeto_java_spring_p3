package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pessoa.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;
    private DadosCadastroPessoa dados;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoPessoa> cadastrar(@RequestBody DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder) {
        var pessoa = new Pessoa(dados);
        repository.save(pessoa); // a variável 'pessoa' já foi criada

        var uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoa(pessoa));
    }

    @GetMapping
    public Page<DadosListagemPessoa> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map((java.util.function.Function<? super Pessoa, ? extends DadosListagemPessoa>) DadosListagemPessoa::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoPessoa dados) {
        var pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var pessoa = repository.getReferenceById(id);
        pessoa.excluir();
    }
}
