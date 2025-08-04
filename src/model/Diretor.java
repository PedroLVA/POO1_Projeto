package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Diretor - Representa um diretor no sistema
 * 
 * Esta classe herda da classe Pessoa, o que significa que:
 * - Diretor tem tudo que Pessoa tem (nome, idade, nacionalidade, id)
 * - Diretor pode ter coisas específicas de diretor (estilo, filmes dirigidos)
 * - Diretor DEVE implementar os métodos abstratos da classe Pessoa
 * 
 * Exemplo prático:
 * - James Cameron é um diretor
 * - Ele tem nome, idade, nacionalidade (herdados de Pessoa)
 * - Ele tem um estilo de direção e uma lista de filmes que dirigiu (específico de Diretor)
 */
public class Diretor extends Pessoa {

    // ===== ATRIBUTOS ESPECÍFICOS DO DIRETOR =====
    private String estilo; // Estilo de direção (ex: ação, drama, comédia)
    private List<Filme> filmesDigiridos; // Lista de filmes que o diretor dirigiu

    public Diretor(String nome) {
        super(nome);  // Chama o construtor da classe pai (Pessoa)
        this.filmesDigiridos = new ArrayList<>();  // Inicializa a lista vazia
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public List<Filme> getFilmesDigiridos() {
        // TODO: Implementar a lógica
        return null;
    }

    public void adicionarFilme(Filme filme) {
        // TODO: Implementar a lógica
    }

    public void removerFilme(Filme filme) {
        // TODO: Implementar a lógica
    }

    @Override
    public boolean validarDados() {
        // TODO: Implementar a lógica de validação específica para model.Diretor
        return true;
    }

    @Override
    public String exibirInformacoes() {
        // TODO: Implementar a lógica para exibir informações do model.Diretor
        return null;
    }
}