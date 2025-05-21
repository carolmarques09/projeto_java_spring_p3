import jakarta.persistence.*;
import pessoa.Pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private BigDecimal valor;
    private String observacao;

    @Enumerated(EnumType.STRING)
    private TipoLancamento RECEITA;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}

// Pessoa -> Endereço (embedded)
// Lançamento -> Categoria (ManyToOne)
// Lançamento -> Pessoa (ManyToOne)
