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
 * CatalogoController - Classe principal que controla o sistema de filmes
 * 
 * Esta classe é como um "gerente" que organiza todas as operações.
 * Ela usa outras classes (services) para fazer o trabalho pesado.
 * 
 * Padrão: Facade (Fachada) - Centraliza operações e simplifica o uso
 */
public class CatalogoController {

    // ===== ATRIBUTOS =====
    private final FilmeService filmeService;
    private final AtorService atorService;
    private final DiretorService diretorService;

    // ===== CONSTRUTOR =====
    public CatalogoController() {
        this.filmeService = new FilmeService();
        this.atorService = new AtorService();
        this.diretorService = new DiretorService();
        System.out.println("CatalogoController criado!");
    }

    // ===== MÉTODOS PARA FILMES =====

    /**
     * Cadastra um novo filme
     */
    public ResultadoOperacao cadastrarFilme(Filme filme) {
        if (filme == null) {
            return ResultadoOperacao.criarErro("Filme não pode ser nulo!");
        }
        
        boolean cadastrou = filmeService.cadastrar(filme);
        
        if (cadastrou) {
            ResultadoOperacao resultado = ResultadoOperacao.criarSucesso("Filme cadastrado!");
            resultado.setDados(filme);
            return resultado;
        } else {
            return ResultadoOperacao.criarErro(" Erro ao cadastrar filme");
        }
    }
    
    /**
     * Busca filmes pelo nome
     */
    public List<Filme> pesquisarFilmePorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome do filme não pode ser vazio");
            return null;
        }
        
        List<Filme> filmes = filmeService.buscarPorNome(nome);
        
        if (filmes != null && !filmes.isEmpty()) {
            System.out.println("🎬 Encontrados " + filmes.size() + " filme(s)");
        } else {
            System.out.println("🔍 Nenhum filme encontrado: " + nome);
        }
        
        return filmes;
    }
    
    /**
     * Lista todos os filmes
     */
    public List<Filme> listarFilmes() {
        List<Filme> filmes = filmeService.listarTodos();
        
        if (filmes != null) {
            System.out.println("📽️ Total: " + filmes.size() + " filme(s)");
        } else {
            System.out.println("📽️ Nenhum filme cadastrado");
        }
        
        return filmes;
    }
    
    /**
     * Mostra detalhes de um filme
     */
    public Filme visualizarDetalhesFilme(int id) {
        if (id <= 0) {
            System.out.println("ID do filme inválido");
            return null;
        }
        
        Filme filme = filmeService.buscarPorId(id);
        
        if (filme != null) {
            System.out.println("🎭 Filme: " + filme.getNome());
        } else {
            System.out.println("🔍 Filme ID " + id + " não encontrado");
        }
        
        return filme;
    }
    
    /**
     * Edita um filme
     */
    public ResultadoOperacao editarFilme(Filme filme) {
        if (filme == null) {
            return ResultadoOperacao.criarErro("Filme não pode ser nulo!");
        }
        
        boolean atualizou = filmeService.atualizar(filme);
        
        if (atualizou) {
            return ResultadoOperacao.criarSucesso("Filme atualizado!");
        } else {
            return ResultadoOperacao.criarErro("Erro ao atualizar filme");
        }
    }
    
    /**
     * Remove um filme
     */
    public ResultadoOperacao removerFilme(int id) {
        if (id <= 0) {
            return ResultadoOperacao.criarErro("ID do filme inválido!");
        }
        
        boolean removeu = filmeService.remover(id);
        
        if (removeu) {
            return ResultadoOperacao.criarSucesso("Filme removido!");
        } else {
            return ResultadoOperacao.criarErro("Erro ao remover filme");
        }
    }

    // ===== MÉTODOS PARA ATORES =====
    /**
     * Cadastra um novo ator
     */
    public ResultadoOperacao cadastrarAtor(Ator ator) {
        if (ator == null) {
            return ResultadoOperacao.criarErro("Ator não pode ser nulo!");
        }
        
        boolean cadastrou = atorService.cadastrar(ator);
        
        if (cadastrou) {
            ResultadoOperacao resultado = ResultadoOperacao.criarSucesso("Ator cadastrado!");
            resultado.setDados(ator);
            return resultado;
        } else {
            return ResultadoOperacao.criarErro("Erro ao cadastrar ator");
        }
    }

    // ===== MÉTODOS PARA DIRETORES =====
    
    /**
     * Cadastra um novo diretor
     */
    public ResultadoOperacao cadastrarDiretor(Diretor diretor) {
        if (diretor == null) {
            return ResultadoOperacao.criarErro("Diretor não pode ser nulo!");
        }
        
        boolean cadastrou = diretorService.cadastrar(diretor);
        
        if (cadastrou) {
            ResultadoOperacao resultado = ResultadoOperacao.criarSucesso("Diretor cadastrado!");
            resultado.setDados(diretor);
            return resultado;
        } else {
            return ResultadoOperacao.criarErro("Erro ao cadastrar diretor");
        }
    }

    // ===== MÉTODOS PARA ASSOCIAÇÕES =====
    
    /**
     * Associa um ator a um filme
     */
    public ResultadoOperacao associarAtorFilme(int filmeId, int atorId) {
        if (filmeId <= 0 || atorId <= 0) {
            return ResultadoOperacao.criarErro("IDs inválidos!");
        }
        
        // Verificar se filme e ator existem
        Filme filme = filmeService.buscarPorId(filmeId);
        if (filme == null) {
            return ResultadoOperacao.criarErro("Filme não encontrado!");
        }
        
        Ator ator = atorService.buscarPorId(atorId);
        if (ator == null) {
            return ResultadoOperacao.criarErro("Ator não encontrado!");
        }
        
        // Fazer a associação
        boolean associou = filmeService.associarAtor(filmeId, atorId);
        
        if (associou) {
            return ResultadoOperacao.criarSucesso("Ator associado ao filme!");
        } else {
            return ResultadoOperacao.criarErro("Erro ao associar ator");
        }
    }
    
    /**
     * Associa um diretor a um filme
     */
    public ResultadoOperacao associarDiretorFilme(int filmeId, int diretorId) {
        if (filmeId <= 0 || diretorId <= 0) {
            return ResultadoOperacao.criarErro("IDs inválidos!");
        }
        
        // Verificar se filme e diretor existem
        Filme filme = filmeService.buscarPorId(filmeId);
        if (filme == null) {
            return ResultadoOperacao.criarErro("Filme não encontrado!");
        }
        
        Diretor diretor = diretorService.buscarPorId(diretorId);
        if (diretor == null) {
            return ResultadoOperacao.criarErro("Diretor não encontrado!");
        }
        
        // Fazer a associação
        boolean associou = filmeService.associarDiretor(filmeId, diretorId);
        
        if (associou) {
            return ResultadoOperacao.criarSucesso("Diretor associado ao filme!");
        } else {
            return ResultadoOperacao.criarErro("Erro ao associar diretor");
        }
    }
}