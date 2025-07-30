import java.util.ArrayList;
import java.util.List;

/**
 * Representa um Diretor, especialização de Pessoa.
 */
public class Diretor extends Pessoa {

    private String estilo;
    private List<Filme> filmesDigiridos;

    public Diretor(String nome) {
        super(nome);
        this.filmesDigiridos = new ArrayList<>();
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
        // TODO: Implementar a lógica de validação específica para Diretor
        return false;
    }

    @Override
    public String exibirInformacoes() {
        // TODO: Implementar a lógica para exibir informações do Diretor
        return null;
    }
}