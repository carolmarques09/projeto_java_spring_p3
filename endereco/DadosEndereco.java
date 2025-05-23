package endereco;

import org.hibernate.annotations.processing.Pattern;

public record DadosEndereco(
    @NotBlank
    String logradouro,
    @NotBlank
    String bairro,
    @NotBlank
    @Pattern(regexp = "\\d{8}")
    String cep,
    @NotBlank
    String cidade,
    @NotBlank
    String complemento,
    String numero,
    String estado) {
}
