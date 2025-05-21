package pessoa;

import endereco.Endereco;
import endereco.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

public record DadosCadastroPessoa(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotNull Endereco endereco) {
}
