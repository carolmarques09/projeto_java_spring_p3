package pessoa;

import endereco.Endereco;
import org.antlr.v4.runtime.misc.NotNull;

public record DadosAtualizacaoPessoa(
    @NotNull
    Long id,
    String nome,
    Boolean ativo,
    Endereco endereco) {
}
