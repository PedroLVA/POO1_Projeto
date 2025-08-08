package model;

/**
 * Classe FilmeAtor - Representa a associação entre um filme e um ator
 * 
 * Esta é uma classe associativa que representa o relacionamento N:N (Muitos-para-Muitos)
 * entre Filme e Ator. Ela armazena os IDs de ambos e também atributos
 * específicos dessa relação, como o nome do personagem interpretado.
 */
public class FilmeAtor {

    private int filmeId;
    private int atorId;
    private String personagem;

    public FilmeAtor(int filmeId, int atorId) {
        this.filmeId = filmeId;
        this.atorId = atorId;
    }

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
        return "FilmeAtor{" +
                "filmeId=" + filmeId +
                ", atorId=" + atorId +
                ", personagem='" + personagem + '\'' +
                '}';
    }
}
