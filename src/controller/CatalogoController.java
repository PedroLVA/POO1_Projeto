package controller;

import model.Ator;
import model.Diretor;
import model.Filme;
import model.ResultadoOperacao;
import service.AtorService;
import service.DiretorService;
import service.FilmeService;

import java.util.List;

/**
 * Fachada (Facade) do sistema. Centraliza as operações e delega
 * para as classes de serviço apropriadas.
 */
public class CatalogoController {

    private final FilmeService filmeService;
    private final AtorService atorService;
    private final DiretorService diretorService;

    public CatalogoController() {
        this.filmeService = new FilmeService();
        this.atorService = new AtorService();
        this.diretorService = new DiretorService();
    }

    public ResultadoOperacao<Filme> cadastrarFilme(Filme filme) {
        // TODO: Implementar a lógica
        return null;
    }
    
    public ResultadoOperacao<Ator> cadastrarAtor(Ator ator) {
        // TODO: Implementar a lógica
        return null;
    }
    
    public ResultadoOperacao<Diretor> cadastrarDiretor(Diretor diretor) {
        // TODO: Implementar a lógica
        return null;
    }
    
    public List<Filme> pesquisarFilmePorNome(String nome) {
        // TODO: Implementar a lógica
        return null;
    }
    
    public List<Filme> listarFilmes() {
        // TODO: Implementar a lógica
        return null;
    }
    
    public Filme visualizarDetalhesFilme(Long id) {
        // TODO: Implementar a lógica
        return null;
    }
    
    public ResultadoOperacao<Filme> editarFilme(Filme filme) {
        // TODO: Implementar a lógica
        return null;
    }
    
    public ResultadoOperacao<Void> removerFilme(Long id) {
        // TODO: Implementar a lógica
        return null;
    }
    
    public ResultadoOperacao<Void> associarAtorFilme(Long filmeId, Long atorId) {
        // TODO: Implementar a lógica
        return null;
    }
    
    public ResultadoOperacao<Void> associarDiretorFilme(Long filmeId, Long diretorId) {
        // TODO: Implementar a lógica
        return null;
    }
}