package controller;

import endereco.Endereco;
import pessoa.Pessoa;

public record DadosDetalhamentoPessoa(Long id, String nome, Endereco endereco) {

    public DadosDetalhamentoPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getEndereco());
    }
}
