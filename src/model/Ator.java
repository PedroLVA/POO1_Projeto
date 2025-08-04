package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Ator - Representa um ator no sistema
 * 
 * Esta classe herda da classe Pessoa, o que significa que:
 * - Ator tem tudo que Pessoa tem (nome, idade, nacionalidade, id)
 * - Ator pode ter coisas específicas de ator (filmografia)
 * - Ator DEVE implementar os métodos abstratos da classe Pessoa
 * 
 * Exemplo prático:
 * - Leonardo DiCaprio é um ator
 * - Ele tem nome, idade, nacionalidade (herdados de Pessoa)
 * - Ele tem uma lista de filmes onde atuou (específico de Ator)
 */
public class Ator extends Pessoa {

    // ===== ATRIBUTOS ESPECÍFICOS DO ATOR =====
    private List<Filme> filmografia; // Lista de filmes onde o ator participou

    public Ator(String nome) {
        super(nome);  // Chama o construtor da classe pai (Pessoa)
        this.filmografia = new ArrayList<>();  // Inicializa a lista vazia
    }

    public List<Filme> getFilmografia() {
        // TODO: Implementar a lógica
        return null;
    }

    public void adicionarFilme(Filme filme) {
        // TODO: Implementar a lógica
    }

    public void removerFilme(Filme filme) {
        // TODO: Implementar a lógica
    }

    // ===== MÉTODOS ABSTRATOS HERDADOS DE PESSOA =====
    // Estes métodos SÃO OBRIGATÓRIOS porque a classe Pessoa é abstrata
    
    /**
     * Valida se os dados do ator estão corretos
     * 
     * Regras específicas para ator:
     * - Deve ter pelo menos 18 anos
     * - Nome não pode ser vazio
     * - Nacionalidade deve ser informada
     */
    @Override
    public boolean validarDados() {
        // TODO: Implementar a lógica de validação específica para model.Ator
        return false;
    }

    @Override
    public String exibirInformacoes() {
        // TODO: Implementar a lógica para exibir informações do model.Ator
        return null;
    }

    @Override
    public String toString() {
        return "Ator{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                '}';
    }
}