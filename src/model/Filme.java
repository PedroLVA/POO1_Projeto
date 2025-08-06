package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Filme - Representa um filme no sistema
 *
 * Esta é a classe principal do sistema, que representa um filme
 * com todas as suas informações básicas e relacionamentos.
 *
 * Exemplo prático:
 * - Titanic é um filme
 * - Tem nome, data de lançamento, orçamento, descrição
 * - Tem um diretor (James Cameron)
 * - Tem uma lista de atores (Leonardo DiCaprio, Kate Winslet)
 */
public class Filme {

    private int id;
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
        if (ator != null && !this.atores.contains(ator)) {
            this.atores.add(ator);
            ator.adicionarFilme(this); // Mantém a consistência bidirecional
        }
    }

    public void removerAtor(Ator ator) {
        if (ator != null && this.atores.contains(ator)) {
            this.atores.remove(ator);
            ator.removerFilme(this); // Mantém a consistência bidirecional
        }
    }

    public boolean validarCamposObrigatorios() {
        boolean nomeValido = this.nome != null && !this.nome.trim().isEmpty();
        boolean dataValida = this.dataLancamento != null;
        return nomeValido && dataValida;
    }

    // ===== MÉTODOS CONCRETOS (GETTERS E SETTERS) =====

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    @Override
    public String toString() {
        // Retornar o nome do filme é uma boa representação em texto.
        // A classe Ator usa o método getTitulo(), então vamos renomear getNome() para getTitulo()
        // ou criar um método getTitulo() que chama getNome(). Para manter a consistência, vamos
        // simplesmente usar getNome() como está. O código na classe Ator precisaria chamar getNome().
        return nome;
    }

    // Para consistência com o código em Ator.exibirInformacoes(), que chama getTitulo()
    public String getTitulo() {
        return this.nome;
    }
}