package controller;

import model.Ator;
import model.Diretor;
import model.Filme;
import model.ResultadoOperacao;
import service.AtorService;
import service.DiretorService;
import service.FilmeService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * CatalogoController - Classe principal que controla o sistema de filmes
 * 
 * Padrão: Facade (Fachada) - Centraliza operações e simplifica o uso
 * 
 * Esta classe implementa o padrão Facade fornecendo uma interface simplificada
 * que esconde a complexidade dos serviços internos e modelos.
 */
public class CatalogoController {

    private final FilmeService filmeService;
    private final AtorService atorService;
    private final DiretorService diretorService;

    public CatalogoController() {
        this.filmeService = new FilmeService();
        this.atorService = new AtorService();
        this.diretorService = new DiretorService();
        System.out.println("🎬 CatalogoController criado!");
    }

    // ========== MÉTODOS PÚBLICOS QUE SEGUEM O PADRÃO FACADE ==========
    
    /**
     * Cadastra um ator usando apenas parâmetros primitivos (padrão Facade)
     */
    public String cadastrarAtorString(String nome, int idade, String nacionalidade) {
        if (nome == null || nome.trim().isEmpty()) {
            return "Nome do ator não pode ser vazio!";
        }
        
        try {
            Ator ator = new Ator(nome);
            ator.setIdade(idade);
            if (nacionalidade != null && !nacionalidade.trim().isEmpty()) {
                ator.setNacionalidade(nacionalidade);
            }
            
            boolean cadastrou = atorService.cadastrar(ator);
            return cadastrou ? "Ator cadastrado!" : "Erro ao cadastrar ator";
        } catch (Exception e) {
            return "Erro ao criar ator: " + e.getMessage();
        }
    }
    
    /**
     * Cadastra um diretor usando apenas parâmetros primitivos (padrão Facade)
     */
    public String cadastrarDiretorString(String nome, int idade, String nacionalidade, String estilo) {
        if (nome == null || nome.trim().isEmpty()) {
            return "Nome do diretor não pode ser vazio!";
        }
        
        try {
            Diretor diretor = new Diretor(nome);
            diretor.setIdade(idade);
            if (nacionalidade != null && !nacionalidade.trim().isEmpty()) {
                diretor.setNacionalidade(nacionalidade);
            }
            if (estilo != null && !estilo.trim().isEmpty()) {
                diretor.setEstilo(estilo);
            }
            
            boolean cadastrou = diretorService.cadastrar(diretor);
            return cadastrou ? "Diretor cadastrado!" : "Erro ao cadastrar diretor";
        } catch (Exception e) {
            return "Erro ao criar diretor: " + e.getMessage();
        }
    }
    
    /**
     * Cadastra um filme usando apenas parâmetros primitivos (padrão Facade)
     */
    public String cadastrarFilmeString(String nome, String dataLancamento, String orcamento, String descricao) {
        if (nome == null || nome.trim().isEmpty()) {
            return "Nome do filme não pode ser vazio!";
        }
        
        try {
            Filme filme = new Filme(nome, LocalDate.parse(dataLancamento));
            if (orcamento != null && !orcamento.trim().isEmpty()) {
                filme.setOrcamento(new BigDecimal(orcamento));
            }
            if (descricao != null && !descricao.trim().isEmpty()) {
                filme.setDescricao(descricao);
            }
            
            boolean cadastrou = filmeService.cadastrar(filme);
            return cadastrou ? "Filme cadastrado!" : "Erro ao cadastrar filme";
        } catch (Exception e) {
            return "Erro ao criar filme: " + e.getMessage();
        }
    }
    
    /**
     * Edita um filme usando apenas parâmetros primitivos (padrão Facade)
     */
    public String editarFilmeString(int id, String nome, String dataLancamento, String orcamento, String descricao) {
        if (id <= 0) {
            return "ID do filme inválido!";
        }
        
        try {
            Filme filmeExistente = filmeService.buscarPorId(id);
            if (filmeExistente == null) {
                return "Filme ID " + id + " não encontrado!";
            }
            
            if (nome != null && !nome.trim().isEmpty()) {
                filmeExistente.setNome(nome);
            }
            if (dataLancamento != null && !dataLancamento.trim().isEmpty()) {
                filmeExistente.setDataLancamento(LocalDate.parse(dataLancamento));
            }
            if (orcamento != null && !orcamento.trim().isEmpty()) {
                filmeExistente.setOrcamento(new BigDecimal(orcamento));
            }
            if (descricao != null && !descricao.trim().isEmpty()) {
                filmeExistente.setDescricao(descricao);
            }
            
            boolean atualizou = filmeService.atualizar(filmeExistente);
            return atualizou ? "Filme atualizado!" : "Erro ao atualizar filme";
        } catch (Exception e) {
            return "Erro ao atualizar filme: " + e.getMessage();
        }
    }
    
    /**
     * Lista todos os atores (padrão Facade)
     */
    public String listarAtoresString() {
        List<Ator> atores = atorService.listarTodos();
        if (atores != null && !atores.isEmpty()) {
            return "🎭 Total: " + atores.size() + " ator(es)";
        } else {
            return "Nenhum ator cadastrado";
        }
    }
    
    /**
     * Lista todos os diretores (padrão Facade)
     */
    public String listarDiretoresString() {
        List<Diretor> diretores = diretorService.listarTodos();
        if (diretores != null && !diretores.isEmpty()) {
            return "Total: " + diretores.size() + " diretor(es)";
        } else {
            return "Nenhum diretor cadastrado";
        }
    }
    
    /**
     * Lista todos os filmes (padrão Facade)
     */
    public String listarFilmesString() {
        List<Filme> filmes = filmeService.listarTodos();
        if (filmes != null && !filmes.isEmpty()) {
            return "📽️ Total: " + filmes.size() + " filme(s)";
        } else {
            return "📽️ Nenhum filme cadastrado";
        }
    }
    
    /**
     * Busca um ator por ID (padrão Facade)
     */
    public String buscarAtorPorIdString(int id) {
        if (id <= 0) {
            return "ID do ator inválido";
        }
        
        try {
            Ator ator = atorService.buscarPorId(id);
            return ator != null ? "Ator encontrado: " + ator.getNome() : "Ator ID " + id + " não encontrado";
        } catch (Exception e) {
            return "Erro ao buscar ator: " + e.getMessage();
        }
    }
    
    /**
     * Busca um diretor por ID (padrão Facade)
     */
    public String buscarDiretorPorIdString(int id) {
        if (id <= 0) {
            return "ID do diretor inválido";
        }
        
        Diretor diretor = diretorService.buscarPorId(id);
        return diretor != null ? "🎬 Diretor encontrado: " + diretor.getNome() : "Diretor ID " + id + " não encontrado";
    }
    
    /**
     * Visualiza detalhes de um filme por ID (padrão Facade)
     */
    public String visualizarDetalhesFilmeString(int id) {
        if (id <= 0) {
            return "ID do filme inválido";
        }
        
        Filme filme = filmeService.buscarPorId(id);
        return filme != null ? "Filme encontrado: " + filme.getNome() : "Filme ID " + id + " não encontrado";
    }
    
    /**
     * Associa um ator a um filme (padrão Facade)
     */
    public String associarAtorFilmeString(int filmeId, int atorId) {
        if (filmeId <= 0 || atorId <= 0) {
            return "IDs inválidos!";
        }
        
        Filme filme = filmeService.buscarPorId(filmeId);
        if (filme == null) {
            return "Filme não encontrado!";
        }
        
        try {
            Ator ator = atorService.buscarPorId(atorId);
            if (ator == null) {
                return "Ator não encontrado!";
            }
            
            boolean associou = filmeService.associarAtor(filme, ator);
            return associou ? "Ator associado ao filme!" : "Erro ao associar ator";
        } catch (Exception e) {
            return "Erro ao buscar ator: " + e.getMessage();
        }
    }
    
    /**
     * Associa um diretor a um filme (padrão Facade)
     */
    public String associarDiretorFilmeString(int filmeId, int diretorId) {
        if (filmeId <= 0 || diretorId <= 0) {
            return "IDs inválidos!";
        }
        
        Filme filme = filmeService.buscarPorId(filmeId);
        if (filme == null) {
            return "Filme não encontrado!";
        }
        
        Diretor diretor = diretorService.buscarPorId(diretorId);
        if (diretor == null) {
            return "Diretor não encontrado!";
        }
        
        boolean associou = filmeService.associarDiretor(filme, diretor);
        return associou ? "Diretor associado ao filme!" : "Erro ao associar diretor";
    }
    
    /**
     * Remove um ator de um filme (padrão Facade)
     */
    public String removerAtorFilmeString(int filmeId, int atorId) {
        if (filmeId <= 0 || atorId <= 0) {
            return "IDs inválidos!";
        }
        
        Filme filme = filmeService.buscarPorId(filmeId);
        if (filme == null) {
            return "Filme não encontrado!";
        }
        
        try {
            Ator ator = atorService.buscarPorId(atorId);
            if (ator == null) {
                return "Ator não encontrado!";
            }
            
            boolean removeu = filmeService.removerAtor(filme, ator);
            return removeu ? "Ator removido do filme!" : "Erro ao remover ator do filme";
        } catch (Exception e) {
            return "Erro ao buscar ator: " + e.getMessage();
        }
    }
    
    /**
     * Remove um ator (padrão Facade)
     */
    public String removerAtorString(int id) {
        if (id <= 0) {
            return "ID do ator inválido!";
        }
        
        boolean removeu = atorService.remover(id);
        return removeu ? "Ator removido!" : "Erro ao remover ator";
    }
    
    /**
     * Pesquisa filmes por nome (padrão Facade)
     */
    public String pesquisarFilmePorNomeString(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return "Nome do filme não pode ser vazio";
        }
        
        List<Filme> filmes = filmeService.buscarPorNome(nome);
        if (filmes != null && !filmes.isEmpty()) {
            return "🎬 Encontrados " + filmes.size() + " filme(s)";
        } else {
            return "🔍 Nenhum filme encontrado: " + nome;
        }
    }
}