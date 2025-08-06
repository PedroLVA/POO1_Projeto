package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Diretor - Representa um diretor no sistema
 * 
 * CONCEITO DE HERANÇA:
 * Esta classe herda da classe Pessoa usando "extends Pessoa"
 * Isso significa que Diretor tem tudo que Pessoa tem, mais suas próprias características
 * 
 *   EXEMPLO PRÁTICO:
 * - James Cameron é um diretor
 * - Ele tem nome, idade, nacionalidade (herdados de Pessoa)
 * - Ele tem um estilo de direção e uma lista de filmes que dirigiu (específico de Diretor)
 * 
 */
public class Diretor extends Pessoa {

    private String estilo; // Estilo de direção (ex: ação, drama, comédia)
    private List<Filme> filmesDirigidos; // Lista de filmes que o diretor dirigiu

    // ===== CONSTRUTOR =====
    public Diretor(String nome) {
        super(nome);  // Chama o construtor da classe pai (Pessoa)
        this.filmesDirigidos = new ArrayList<>();  // Inicializa a lista vazia
    }

    // ===== MÉTODOS =====
    public String getEstilo() {
        return estilo;
    }
    public void setEstilo(String estilo) {
        this.estilo = estilo != null ? estilo.trim() : null;
    }
    public List<Filme> getFilmesDirigidos() {
        return new ArrayList<>(filmesDirigidos);
    }
    public void adicionarFilme(Filme filme) {
        // VALIDAÇÃO 1: Verificar se o filme não é null
        if (filme == null) {
            throw new IllegalArgumentException("Erro: Filme não pode ser null!");
        }
        
        // VALIDAÇÃO 2: Verificar se o filme já não está na lista
        if (filmesDirigidos.contains(filme)) {
            throw new IllegalArgumentException("Erro: Filme já está na lista de filmes dirigidos!");
        }
        
        // Se passou pelas validações, adiciona o filme à lista
        filmesDirigidos.add(filme);
        System.out.println("Filme '" + filme.getNome() + "' adicionado aos filmes dirigidos!");
    }
    public void removerFilme(Filme filme) {
        // VALIDAÇÃO 1: Verificar se o filme não é null
        if (filme == null) {
            throw new IllegalArgumentException("Erro: Filme não pode ser null!");
        }
        
        // VALIDAÇÃO 2: Verificar se o filme existe na lista
        if (!filmesDirigidos.contains(filme)) {
            throw new IllegalArgumentException("Erro: Filme não está na lista de filmes dirigidos!");
        }
        
        // Se passou pelas validações, remove o filme da lista
        filmesDirigidos.remove(filme);
        System.out.println("Filme '" + filme.getNome() + "' removido dos filmes dirigidos!");
    }

    @Override
    public boolean validarDados() {
        // VALIDAÇÃO 1: Verificar se o nome não é null ou vazio
        if (getNome() == null || getNome().trim().isEmpty()) {
            System.out.println("Nome inválido!");
            return false; // Nome inválido
        }
        
        // VALIDAÇÃO 2: Verificar se a idade é válida (mínimo 21 anos)
        if (getIdade() != null && getIdade() < 21) {
            System.out.println("Idade muito baixa para diretor profissional!");
            return false; // Idade muito baixa para diretor profissional
        }
        
        // VALIDAÇÃO 3: Verificar se a nacionalidade foi informada
        if (getNacionalidade() == null || getNacionalidade().trim().isEmpty()) {
            System.out.println("Nacionalidade não informada!");
            return false; // Nacionalidade não informada
        }
        
        // VALIDAÇÃO 4: Verificar se o estilo foi informado (específico de diretor)
        if (estilo == null || estilo.trim().isEmpty()) {
            System.out.println("Estilo de direção não informado!");
            return false; // Estilo não informado
        }
        
        // Se passou por todas as validações, os dados estão corretos
        System.out.println("Dados do diretor estão válidos!");
        return true;
    }
    @Override
    public String exibirInformacoes() {
        // StringBuilder é mais eficiente que concatenar strings com "+"
        StringBuilder informacoes = new StringBuilder();
        
        // Adicionamos as informações básicas (herdadas de Pessoa)
        informacoes.append("🎬 DIRETOR\n");
        informacoes.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        informacoes.append("ID: ").append(getId()).append("\n");
        informacoes.append("Nome: ").append(getNome()).append("\n");
        
        // Adicionamos idade (se informada)
        if (getIdade() != null) {
            informacoes.append("Idade: ").append(getIdade()).append(" anos\n");
        } else {
            informacoes.append("Idade: Não informada\n");
        }
        
        // Adicionamos nacionalidade (se informada)
        if (getNacionalidade() != null && !getNacionalidade().trim().isEmpty()) {
            informacoes.append("Nacionalidade: ").append(getNacionalidade()).append("\n");
        } else {
            informacoes.append("Nacionalidade: Não informada\n");
        }
        
        // Adicionamos informações específicas do diretor (estilo)
        if (estilo != null && !estilo.trim().isEmpty()) {
            informacoes.append("Estilo: ").append(estilo).append("\n");
        } else {
            informacoes.append("Estilo: Não informado\n");
        }
        
        // Adicionamos informações específicas do diretor (filmes dirigidos)
        informacoes.append("Filmes Dirigidos: ");
        if (filmesDirigidos.isEmpty()) {
            informacoes.append("Nenhum filme registrado\n");
        } else {
            informacoes.append(filmesDirigidos.size()).append(" filme(s)\n");
            // 🎯 Listamos os filmes numerados usando um loop for
            for (int i = 0; i < filmesDirigidos.size(); i++) {
                Filme filme = filmesDirigidos.get(i);
                informacoes.append("  ").append(i + 1).append(". ").append(filme.getNome());
                if (filme.getDataLancamento() != null) {
                    informacoes.append(" (").append(filme.getDataLancamento().getYear()).append(")");
                }
                informacoes.append("\n");
            }
        }
        
        // Retornamos a string completa
        return informacoes.toString();
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", estilo='" + estilo + '\'' +
                ", filmes=" + filmesDirigidos.size() + " filme(s)" +
                '}';
    }

    // ===== MÉTODOS ADICIONAIS ÚTEIS =====

    public int contarFilmes() {
        return filmesDirigidos.size();
    }
    public boolean dirigiuFilme(Filme filme) {
        return filmesDirigidos.contains(filme);
    }

    public void limparFilmes() {
        filmesDirigidos.clear();
        System.out.println("Lista de filmes dirigidos limpa!");
    }

    public boolean definirEstilo(String estilo) {
        if (estilo == null || estilo.trim().isEmpty()) {
            System.out.println("Estilo não pode ser vazio!");
            return false;
        }
        
        this.estilo = estilo.trim();
        System.out.println("Estilo definido como: " + this.estilo);
        return true;
    }
}
