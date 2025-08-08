package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Filme - Representa um filme no sistema
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
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Nome do filme não pode ser null ou vazio!");
        }
        
        if (dataLancamento == null) {
            throw new IllegalArgumentException("Erro: Data de lançamento não pode ser null!");
        }
        
        if (dataLancamento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Erro: Data de lançamento não pode ser no futuro!");
        }
        
        this.nome = nome.trim();
        this.dataLancamento = dataLancamento;
        this.atores = new ArrayList<>();
    }

    public void adicionarAtor(Ator ator) {
        if (ator == null) {
            throw new IllegalArgumentException("Erro: Ator não pode ser null!");
        }
        
        if (atores.contains(ator)) {
            throw new IllegalArgumentException("Erro: Ator já está na lista do filme!");
        }
        
        atores.add(ator);
        System.out.println("Ator '" + ator.getNome() + "' adicionado ao filme '" + this.nome + "'!");
    }

    public void removerAtor(Ator ator) {
        if (ator == null) {
            throw new IllegalArgumentException("Erro: Ator não pode ser null!");
        }
        
        if (!atores.contains(ator)) {
            throw new IllegalArgumentException("Erro: Ator não está na lista do filme!");
        }
        
        atores.remove(ator);
        System.out.println("Ator '" + ator.getNome() + "' removido do filme '" + this.nome + "'!");
    }

    public boolean validarCamposObrigatorios() {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome do filme é obrigatório!");
            return false;
        }
        
        if (dataLancamento == null) {
            System.out.println("Data de lançamento é obrigatória!");
            return false;
        }
        
        if (dataLancamento.isAfter(LocalDate.now())) {
            System.out.println("Data de lançamento não pode ser no futuro!");
            return false;
        }
        
        System.out.println("Campos obrigatórios do filme estão válidos!");
        return true;
    }

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
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Nome do filme não pode ser null ou vazio!");
        }
        this.nome = nome.trim(); 
    }

    public LocalDate getDataLancamento() { 
        return dataLancamento; 
    }

    public void setDataLancamento(LocalDate dataLancamento) { 
        if (dataLancamento == null) {
            throw new IllegalArgumentException("Erro: Data de lançamento não pode ser null!");
        }
        if (dataLancamento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Erro: Data de lançamento não pode ser no futuro!");
        }
        this.dataLancamento = dataLancamento; 
    }

    public BigDecimal getOrcamento() { 
        return orcamento; 
    }

    public void setOrcamento(BigDecimal orcamento) { 
        if (orcamento != null && orcamento.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Erro: Orçamento não pode ser negativo!");
        }
        this.orcamento = orcamento; 
    }

    public String getDescricao() { 
        return descricao; 
    }

    public void setDescricao(String descricao) { 
        this.descricao = descricao != null ? descricao.trim() : null; 
    }

    public Diretor getDiretor() { 
        return diretor; 
    }

    public void setDiretor(Diretor diretor) { 
        this.diretor = diretor; 
    }

    public List<Ator> getAtores() { 
        return new ArrayList<>(atores);
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Filme filme = (Filme) obj;
        return id == filme.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    public int contarAtores() {
        return atores.size();
    }

    public boolean temAtor(Ator ator) {
        return atores.contains(ator);
    }

    public void limparAtores() {
        atores.clear();
        System.out.println("✅ Lista de atores do filme '" + this.nome + "' foi limpa!");
    }

    public String exibirInformacoes() {
        StringBuilder informacoes = new StringBuilder();
        
        informacoes.append("🎬 FILME\n");
        informacoes.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        informacoes.append("ID: ").append(id).append("\n");
        informacoes.append("Nome: ").append(nome).append("\n");
        
        if (dataLancamento != null) {
            informacoes.append("Data de Lançamento: ").append(dataLancamento).append("\n");
        }
        
        if (orcamento != null) {
            informacoes.append("Orçamento: R$ ").append(orcamento).append("\n");
        }
        
        if (descricao != null && !descricao.trim().isEmpty()) {
            informacoes.append("Descrição: ").append(descricao).append("\n");
        }
        
        if (diretor != null) {
            informacoes.append("Diretor: ").append(diretor.getNome()).append("\n");
        }
        
        informacoes.append("Atores: ");
        if (atores.isEmpty()) {
            informacoes.append("Nenhum ator registrado\n");
        } else {
            informacoes.append(atores.size()).append(" ator(es)\n");
            for (int i = 0; i < atores.size(); i++) {
                Ator ator = atores.get(i);
                informacoes.append("  ").append(i + 1).append(". ").append(ator.getNome()).append("\n");
            }
        }
        
        return informacoes.toString();
    }
}