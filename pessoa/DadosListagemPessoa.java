package pessoa;

import endereco.Endereco;

public record DadosListagemPessoa(Long id, String nome, Boolean ativo, Endereco endereco) {
    public DadosListagemPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getAtivo(), pessoa.getEndereco());
    }
}
