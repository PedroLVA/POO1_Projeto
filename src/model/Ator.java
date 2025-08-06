package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Ator - Representa um ator no sistema
 * 
 * CONCEITO DE HERANÇA:
 * Esta classe herda da classe Pessoa usando "extends Pessoa"
 * Isso significa que Ator tem tudo que Pessoa tem, mais suas próprias características
 * 
 * EXEMPLO PRÁTICO:
 * - Leonardo DiCaprio é um ator
 * - Ele tem nome, idade, nacionalidade (herdados de Pessoa)
 * - Ele tem uma lista de filmes onde atuou (específico de Ator)
 * 
 */
public class Ator extends Pessoa {
    private List<Filme> filmografia; // Lista de filmes onde o ator participou

    // ===== CONSTRUTOR ===
    public Ator(String nome) {
        super(nome);  // Chama o construtor da classe pai (Pessoa)
        this.filmografia = new ArrayList<>();  // Inicializa a lista vazia
    }

    // ===== MÉTODOS =====
    public List<Filme> getFilmografia() {
        return new ArrayList<>(filmografia);
    }

    public void adicionarFilme(Filme filme) {
        // VALIDAÇÃO: Verificar se o filme não é null
        if (filme == null) {
            throw new IllegalArgumentException("Erro: Filme não pode ser null!");
        }
        
        // VALIDAÇÃO: Verificar se o filme já não está na lista
        if (filmografia.contains(filme)) {
            throw new IllegalArgumentException("Erro: Filme já está na filmografia do ator!");
        }
        
        // Se passou pelas validações, adiciona o filme à lista
        filmografia.add(filme);
        System.out.println("Filme '" + filme.getNome() + "' adicionado à filmografia!");
    }

    public void removerFilme(Filme filme) {
        // VALIDAÇÃO: Verificar se o filme não é null
        if (filme == null) {
            throw new IllegalArgumentException("Erro: Filme não pode ser null!");
        }
        
        // VALIDAÇÃO: Verificar se o filme existe na lista
        if (!filmografia.contains(filme)) {
            throw new IllegalArgumentException("Erro: Filme não está na filmografia do ator!");
        }
        
        // Se passou pelas validações, remove o filme da lista
        filmografia.remove(filme);
        System.out.println("Filme '" + filme.getNome() + "' removido da filmografia!");
    }

    // ===== MÉTODOS ABSTRATOS HERDADOS DE PESSOA =====
    @Override
    public boolean validarDados() {
        // VALIDAÇÃO 1: Verificar se o nome não é null ou vazio
        // (Esta validação já é feita no construtor, mas vamos garantir)
        if (getNome() == null || getNome().trim().isEmpty()) {
            System.out.println("Nome inválido!");
            return false; // Nome inválido
        }
        
        // VALIDAÇÃO 2: Verificar se a idade é válida (mínimo 18 anos)
        if (getIdade() != null && getIdade() < 18) {
            System.out.println("Idade muito baixa para ator profissional!");
            return false; // Idade muito baixa para ator profissional
        }
        
        // VALIDAÇÃO 3: Verificar se a nacionalidade foi informada
        if (getNacionalidade() == null || getNacionalidade().trim().isEmpty()) {
            System.out.println("Nacionalidade não informada!");
            return false; // Nacionalidade não informada
        }
        //Se passou por todas as validações, os dados estão corretos
        System.out.println("Dados do ator estão válidos!");
        return true;
    }
    @Override
    public String exibirInformacoes() {
        // Criamos uma StringBuilder para construir a string de forma eficiente
        StringBuilder informacoes = new StringBuilder();
        
        // Adicionamos as informações básicas (herdadas de Pessoa)
        informacoes.append("ATOR\n");
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
        
        // Adicionamos informações específicas do ator (filmografia)
        informacoes.append("Filmografia: ");
        if (filmografia.isEmpty()) {
            informacoes.append("Nenhum filme registrado\n");
        } else {
            informacoes.append(filmografia.size()).append(" filme(s)\n");
            // Listamos os filmes numerados
            for (int i = 0; i < filmografia.size(); i++) {
                Filme filme = filmografia.get(i);
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

    // ===== MÉTODO toString() =====
    @Override
    public String toString() {
        return "Ator{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", filmes=" + filmografia.size() + " filme(s)" +
                '}';
    }

    // ===== MÉTODOS ADICIONAIS ÚTEIS =====
    public int contarFilmes() {
        return filmografia.size();
    }
    public boolean temFilme(Filme filme) {
        return filmografia.contains(filme);
    }
    public void limparFilmografia() {
        filmografia.clear();
        System.out.println("Filmografia limpa!");
    }
}
