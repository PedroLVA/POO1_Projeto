package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a entidade central do sistema, o model.Filme.
 */
public class Filme {

    private Long id;
    private String nome;
    private LocalDate dataLancamento;
    private BigDecimal orcamento;
    private String descricao;
    private Diretor diretor;
    private List<Ator> atores;

    public Filme(String nome, LocalDate dataLancamento) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.atores = new ArrayList<>();
    }

    public void adicionarAtor(Ator ator) {
        // TODO: Implementar a lógica
    }

    public void removerAtor(Ator ator) {
        // TODO: Implementar a lógica
    }

    public boolean validarCamposObrigatorios() {
        // TODO: Implementar a lógica
        return false;
    }

    // --- Getters e Setters ---
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public LocalDate getDataLancamento() { return dataLancamento; }
    public void setDataLancamento(LocalDate dataLancamento) { this.dataLancamento = dataLancamento; }
    public BigDecimal getOrcamento() { return orcamento; }
    public void setOrcamento(BigDecimal orcamento) { this.orcamento = orcamento; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Diretor getDiretor() { return diretor; }
    public void setDiretor(Diretor diretor) { this.diretor = diretor; }
    public List<Ator> getAtores() { return atores; }
}