/**
 * Classe associativa que representa o relacionamento N:N (Muitos-para-Muitos)
 * entre Filme e Ator. Ela armazena os IDs de ambos e também atributos
 * específicos dessa relação, como o nome do personagem interpretado.
 */
public class FilmeAtor {

    private Long filmeId;
    private Long atorId;
    private String personagem;

    /**
     * Construtor para criar a associação entre um filme e um ator.
     * @param filmeId O ID do filme.
     * @param atorId O ID do ator.
     */
    public FilmeAtor(Long filmeId, Long atorId) {
        this.filmeId = filmeId;
        this.atorId = atorId;
    }

    // --- Getters e Setters ---

    /**
     * Retorna o ID do filme associado.
     * @return O ID do filme.
     */
    public Long getFilmeId() {
        return filmeId;
    }

    /**
     * Retorna o ID do ator associado.
     * @return O ID do ator.
     */
    public Long getAtorId() {
        return atorId;
    }

    /**
     * Retorna o nome do personagem que o ator interpretou no filme.
     * @return O nome do personagem.
     */
    public String getPersonagem() {
        return personagem;
    }

    /**
     * Define o nome do personagem que o ator interpretou no filme.
     * @param personagem O nome do personagem.
     */
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