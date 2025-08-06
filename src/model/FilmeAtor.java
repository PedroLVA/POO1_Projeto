package model;

/**
 * Classe FilmeAtor - Representa a associação entre um filme e um ator
 * 
 * Esta é uma classe associativa que representa o relacionamento N:N (Muitos-para-Muitos)
 * entre Filme e Ator. Ela armazena os IDs de ambos e também atributos
 * específicos dessa relação, como o nome do personagem interpretado.
 * 
 * Exemplo prático:
 * - Leonardo DiCaprio interpretou Jack Dawson no filme Titanic
 * - Esta classe guarda: filmeId (Titanic), atorId (Leonardo), personagem (Jack Dawson)
 * 
 * Relacionamento N:N:
 * - Um filme pode ter vários atores
 * - Um ator pode participar de vários filmes
 * - Esta classe conecta os dois
 */
public class FilmeAtor {

    // ===== ATRIBUTOS =====
    private int filmeId;        // ID do filme
    private int atorId;         // ID do ator
    private String personagem;  // Nome do personagem que o ator interpretou

    public FilmeAtor(int filmeId, int atorId) {
        this.filmeId = filmeId;
        this.atorId = atorId;
    }

    // ===== MÉTODOS CONCRETOS (GETTERS E SETTERS) =====
    public int getFilmeId() {
        return filmeId;
    }
    public int getAtorId() {
        return atorId;
    }

    public String getPersonagem() {
        return personagem;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }

    @Override
    public String toString() {
        return "model.FilmeAtor{" +
                "filmeId=" + filmeId +
                ", atorId=" + atorId +
                ", personagem='" + personagem + '\'' +
                '}';
    }
}
