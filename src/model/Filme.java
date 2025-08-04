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

    // ===== ATRIBUTOS =====
    // Estas são as informações básicas do filme
    
    private int id;                    // Número único de identificação do filme
    private String nome;               // Nome/título do filme
    private LocalDate dataLancamento;  // Data quando o filme foi lançado
    private BigDecimal orcamento;      // Quanto custou para fazer o filme
    private String descricao;          // Sinopse/descrição do filme
    private Diretor diretor;           // Quem dirigiu o filme
    private List<Ator> atores;         // Lista de atores que participaram

    public Filme(String nome, LocalDate dataLancamento) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.atores = new ArrayList<>();  // Inicializa a lista vazia de atores
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
        return nome;
    }
}