package service;

import interfaces.ICrudOperations;
import model.Ator;

import java.util.ArrayList;
import java.util.List;

/**
 * Contém a lógica de negócio para manipulação da entidade model.Ator.
 * Implementa as operações básicas de CRUD definidas em interfaces.ICrudOperations.
 */
public class AtorService implements ICrudOperations<Ator> {

    // Simula um repositório ou uma tabela do banco de dados em memória
    private final List<Ator> atores;
    private long proximoId = 1; // Simula a geração de ID autoincremental

    public AtorService() {
        this.atores = new ArrayList<>();
    }

    /**
     * Cadastra um novo ator no sistema.
     * @param ator O objeto model.Ator a ser cadastrado.
     * @return true se o cadastro foi bem-sucedido, false caso contrário.
     */
    @Override
    public boolean cadastrar(Ator ator) {
        // TODO: Implementar a lógica (validações, etc.)
        // Ex: if (ator.validarDados()) { ... }
        return false;
    }

    /**
     * Busca um ator pelo seu ID.
     * @param id O ID do ator a ser buscado.
     * @return O objeto model.Ator encontrado, ou null se não existir.
     */
    @Override
    public Ator buscarPorId(Long id) {
        // TODO: Implementar a lógica
        return null;
    }

    /**
     * Busca um ator pelo seu nome exato.
     * @param nome O nome do ator.
     * @return O ator encontrado, ou null se não existir.
     */
    public Ator buscarPorNome(String nome) {
        // TODO: Implementar a lógica
        return null;
    }

    /**
     * Retorna uma lista com todos os atores cadastrados.
     * @return Uma lista de objetos model.Ator.
     */
    @Override
    public List<Ator> listarTodos() {
        // TODO: Implementar a lógica
        return null;
    }

    /**
     * Atualiza os dados de um ator existente.
     * @param ator O objeto model.Ator com os dados atualizados.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     */
    @Override
    public boolean atualizar(Ator ator) {
        // TODO: Implementar a lógica
        return false;
    }

    /**
     * Remove um ator do sistema pelo seu ID.
     * @param id O ID do ator a ser removido.
     * @return true se a remoção foi bem-sucedida, false caso contrário.
     */
    @Override
    public boolean remover(Long id) {
        // TODO: Implementar a lógica
        return false;
    }

    /**
     * Método privado para validar se um ator já existe no sistema.
     * @param id O ID a ser verificado.
     * @return true se o ator existe.
     */
    private boolean validarAtorExiste(Long id) {
        // TODO: Implementar a lógica
        return false;
    }
}