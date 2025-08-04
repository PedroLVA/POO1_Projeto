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
 * Esta classe é como um "gerente" que organiza todas as operações do sistema.
 * Ela usa outras classes (services) para fazer o trabalho pesado.
 * 
 * Exemplo prático:
 * - Quando você quer cadastrar um filme, você chama esta classe
 * - Ela se encarrega de organizar tudo e te dar uma resposta clara
 * - É como ter um "assistente" que faz tudo para você!
 * 
 * Fachada (Facade) do sistema. Centraliza as operações e delega
 */
public class CatalogoController {

    // ===== ATRIBUTOS =====
    // Estas são as "ferramentas" que o controller usa para fazer seu trabalho
    
    private final FilmeService filmeService;    // Para trabalhar com filmes
    private final AtorService atorService;      // Para trabalhar com atores
    private final DiretorService diretorService; // Para trabalhar com diretores

    // ===== CONSTRUTOR =====
    public CatalogoController() {
        // Criamos as ferramentas que vamos usar
        this.filmeService = new FilmeService();
        this.atorService = new AtorService();
        this.diretorService = new DiretorService();
        
        System.out.println("🎬 CatalogoController criado com sucesso!");
    }

    // ===== MÉTODOS PARA FILMES =====

    public ResultadoOperacao cadastrarFilme(Filme filme) {
        // PASSO 1: Verificar se o filme não é nulo
        if (filme == null) {
            return ResultadoOperacao.criarErro("❌ Erro: Filme não pode ser nulo!");
        }
        
        // PASSO 2: Tentar cadastrar usando filmeService
        boolean cadastrou = filmeService.cadastrar(filme);
        
        // PASSO 3: Retornar resultado (sucesso ou erro)
        if (cadastrou) {
            ResultadoOperacao resultado = ResultadoOperacao.criarSucesso("✅ Filme cadastrado com sucesso!");
            resultado.setDados(filme);  // guardamos o filme como dado extra
            return resultado;
        } else {
            return ResultadoOperacao.criarErro("❌ Não foi possível cadastrar o filme");
        }
    }
    
    public List<Filme> pesquisarFilmePorNome(String nome) {
        // PASSO 1: Verificar se o nome não é nulo ou vazio
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("⚠️ Aviso: Nome do filme não pode ser vazio");
            return null;  // retorna null se o nome for inválido
        }
        
        // PASSO 2: Buscar filmes usando filmeService
        List<Filme> filmesEncontrados = filmeService.buscarPorNome(nome);
        
        // PASSO 3: Retornar lista de filmes encontrados
        if (filmesEncontrados != null && !filmesEncontrados.isEmpty()) {
            System.out.println("🎬 Encontrados " + filmesEncontrados.size() + " filme(s)");
        } else {
            System.out.println("🔍 Nenhum filme encontrado com o nome: " + nome);
        }
        
        return filmesEncontrados;
    }
    
    public List<Filme> listarFilmes() {
        // PASSO 1: Pedir para filmeService listar todos os filmes
        List<Filme> todosOsFilmes = filmeService.listarTodos();
        
        // PASSO 2: Mostrar quantos filmes foram encontrados
        if (todosOsFilmes != null) {
            System.out.println("📽️ Total de filmes cadastrados: " + todosOsFilmes.size());
        } else {
            System.out.println("📽️ Nenhum filme cadastrado ainda");
        }
        
        // PASSO 3: Retornar a lista
        return todosOsFilmes;
    }
    
    public Filme visualizarDetalhesFilme(Long id) {
        // PASSO 1: Verificar se o ID não é nulo
        if (id == null) {
            System.out.println("⚠️ Aviso: ID do filme não pode ser nulo");
            return null;  // retorna null se o ID for inválido
        }
        
        // PASSO 2: Buscar filme pelo ID usando filmeService
        Filme filmeEncontrado = filmeService.buscarPorId(id);
        
        // PASSO 3: Mostrar resultado da busca
        if (filmeEncontrado != null) {
            System.out.println("🎭 Filme encontrado: " + filmeEncontrado.getNome());
        } else {
            System.out.println("🔍 Filme com ID " + id + " não encontrado");
        }
        
        // PASSO 4: Retornar o filme encontrado
        return filmeEncontrado;
    }
    
    public ResultadoOperacao editarFilme(Filme filme) {
        // PASSO 1: Verificar se o filme não é nulo
        if (filme == null) {
            return ResultadoOperacao.criarErro("❌ Erro: Filme não pode ser nulo!");
        }
        
        // PASSO 2: Tentar atualizar usando filmeService
        boolean atualizou = filmeService.atualizar(filme);
        
        // PASSO 3: Retornar resultado
        if (atualizou) {
            return ResultadoOperacao.criarSucesso("✅ Filme atualizado com sucesso!");
        } else {
            return ResultadoOperacao.criarErro("❌ Não foi possível atualizar o filme");
        }
    }
    
    public ResultadoOperacao removerFilme(Long id) {
        // PASSO 1: Verificar se o ID não é nulo
        if (id == null) {
            return ResultadoOperacao.criarErro("❌ Erro: ID do filme não pode ser nulo!");
        }
        
        // PASSO 2: Tentar remover usando filmeService
        boolean removeu = filmeService.remover(id);
        
        // PASSO 3: Retornar resultado
        if (removeu) {
            return ResultadoOperacao.criarSucesso("✅ Filme removido com sucesso!");
        } else {
            return ResultadoOperacao.criarErro("❌ Não foi possível remover o filme");
        }
    }

    public ResultadoOperacao cadastrarAtor(Ator ator) {
        // PASSO 1: Verificar se o ator não é nulo
        if (ator == null) {
            return ResultadoOperacao.criarErro("❌ Erro: Ator não pode ser nulo!");
        }
        
        // PASSO 2: Tentar cadastrar usando atorService
        boolean cadastrou = atorService.cadastrar(ator);
        
        // PASSO 3: Retornar resultado
        if (cadastrou) {
            ResultadoOperacao resultado = ResultadoOperacao.criarSucesso("✅ Ator cadastrado com sucesso!");
            resultado.setDados(ator);  // guardamos o ator como dado extra
            return resultado;
        } else {
            return ResultadoOperacao.criarErro("❌ Não foi possível cadastrar o ator");
        }
    }

    public ResultadoOperacao cadastrarDiretor(Diretor diretor) {
        // PASSO 1: Verificar se o diretor não é nulo
        if (diretor == null) {
            return ResultadoOperacao.criarErro("❌ Erro: Diretor não pode ser nulo!");
        }
        
        // PASSO 2: Tentar cadastrar usando diretorService
        boolean cadastrou = diretorService.cadastrar(diretor);
        
        // PASSO 3: Retornar resultado
        if (cadastrou) {
            ResultadoOperacao resultado = ResultadoOperacao.criarSucesso("✅ Diretor cadastrado com sucesso!");
            resultado.setDados(diretor);  // guardamos o diretor como dado extra
            return resultado;
        } else {
            return ResultadoOperacao.criarErro("❌ Não foi possível cadastrar o diretor");
        }
    }

    public ResultadoOperacao associarAtorFilme(Long filmeId, Long atorId) {
        // PASSO 1: Verificar se os IDs não são nulos
        if (filmeId == null || atorId == null) {
            return ResultadoOperacao.criarErro("❌ Erro: IDs do filme e ator não podem ser nulos!");
        }
        
        // PASSO 2: Verificar se filme e ator existem
        Filme filme = filmeService.buscarPorId(filmeId);
        if (filme == null) {
            return ResultadoOperacao.criarErro("❌ Erro: Filme não encontrado!");
        }
        
        Ator ator = atorService.buscarPorId(atorId);
        if (ator == null) {
            return ResultadoOperacao.criarErro("❌ Erro: Ator não encontrado!");
        }
        
        // PASSO 3: Fazer a associação
        boolean associou = filmeService.associarAtor(filmeId, atorId);
        
        // PASSO 4: Retornar resultado
        if (associou) {
            return ResultadoOperacao.criarSucesso("✅ Ator associado ao filme com sucesso!");
        } else {
            return ResultadoOperacao.criarErro("❌ Não foi possível associar o ator ao filme");
        }
    }
    
    public ResultadoOperacao associarDiretorFilme(Long filmeId, Long diretorId) {
        // PASSO 1: Verificar se os IDs não são nulos
        if (filmeId == null || diretorId == null) {
            return ResultadoOperacao.criarErro("❌ Erro: IDs do filme e diretor não podem ser nulos!");
        }
        
        // PASSO 2: Verificar se filme e diretor existem
        Filme filme = filmeService.buscarPorId(filmeId);
        if (filme == null) {
            return ResultadoOperacao.criarErro("❌ Erro: Filme não encontrado!");
        }
        
        Diretor diretor = diretorService.buscarPorId(diretorId);
        if (diretor == null) {
            return ResultadoOperacao.criarErro("❌ Erro: Diretor não encontrado!");
        }
        
        // PASSO 3: Fazer a associação
        boolean associou = filmeService.associarDiretor(filmeId, diretorId);
        
        // PASSO 4: Retornar resultado
        if (associou) {
            return ResultadoOperacao.criarSucesso("✅ Diretor associado ao filme com sucesso!");
        } else {
            return ResultadoOperacao.criarErro("❌ Não foi possível associar o diretor ao filme");
        }
    }
}
