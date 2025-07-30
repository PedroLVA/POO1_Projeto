import java.util.ArrayList;
import java.util.List;

/**
 * Representa um Ator, especialização de Pessoa.
 */
public class Ator extends Pessoa {

    private List<Filme> filmografia;

    public Ator(String nome) {
        super(nome);
        this.filmografia = new ArrayList<>();
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

    @Override
    public boolean validarDados() {
        // TODO: Implementar a lógica de validação específica para Ator
        return false;
    }

    @Override
    public String exibirInformacoes() {
        // TODO: Implementar a lógica para exibir informações do Ator
        return null;
    }
}