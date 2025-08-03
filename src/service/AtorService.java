package service;

import exception.PessoaNaoEncontradaException;
import interfaces.ICrudOperations;
import model.Ator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Contém a lógica de negócio para manipulação da entidade model.Ator.
 * Implementa as operações básicas de CRUD definidas em interfaces.ICrudOperations.
 */
public class AtorService implements ICrudOperations<Ator> {


    private final List<Ator> atores;

    public AtorService() {
        this.atores = new ArrayList<>();
    }

    /**
     * Cadastra um novo ator no sistema.
     * O ator não deve ser nulo e deve ter um nome.
     * Um ID único será atribuído automaticamente.
     * @param ator O objeto model.Ator a ser cadastrado.
     * @return true se o cadastro foi bem-sucedido, false caso contrário.
     */
    @Override
    public boolean cadastrar(Ator ator) {
        if (ator == null || ator.getNome() == null || ator.getNome().trim().isEmpty()) {
            return false;
        }

        this.atores.add(ator);
        return true;
    }

    /**
     * Busca um ator pelo seu ID.
     * @param id O ID do ator a ser buscado.
     * @return O objeto model.Ator encontrado, ou null se não existir.
     */
    @Override
    public Ator buscarPorId(Long id) {
        if (id == null) {
            return null;
        }
        return atores.stream()
                .filter(ator -> id.equals(ator.getId()))
                .findFirst()
                .orElseThrow(() -> new PessoaNaoEncontradaException("Ator com o ID: " + id + " não encontrado"));

    }

    /**
     * Busca um ator pelo seu nome exato.
     * @param nome O nome do ator.
     * @return O ator encontrado, ou null se não existir.
     */
    public Ator buscarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }

        return atores.stream()
                .filter(ator -> nome.equals(ator.getNome()))
                .findFirst()
                .orElseThrow(() -> new PessoaNaoEncontradaException("Ator com o nome: " + nome + " não encontrado"));
    }

    /**
     * Retorna uma cópia da lista com todos os atores cadastrados para proteger o encapsulamento.
     * @return Uma lista de objetos model.Ator.
     */
    @Override
    public List<Ator> listarTodos() {
        return new ArrayList<>(this.atores);
    }

    /**
     * Atualiza os dados de um ator existente.
     * O ator a ser atualizado é identificado pelo seu ID.
     * @param ator O objeto model.Ator com os dados atualizados.
     * @return true se a atualização foi bem-sucedida, false caso o ator não exista ou seja inválido.
     */
    @Override
    public boolean atualizar(Ator ator) {
        if (ator == null || ator.getId() == null) {
            return false;
        }

        for (int i = 0; i < atores.size(); i++) {
            if (atores.get(i).getId().equals(ator.getId())) {
                atores.set(i, ator);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove um ator do sistema pelo seu ID.
     * @param id O ID do ator a ser removido.
     * @return true se a remoção foi bem-sucedida, false caso contrário.
     */
    @Override
    public boolean remover(Long id) {
        if (id == null) {
            return false;
        }
        return atores.removeIf(ator -> id.equals(ator.getId()));
    }

    /**
     * Método privado para validar se um ator já existe no sistema pelo seu ID.
     * @param id O ID a ser verificado.
     * @return true se o ator existe, false caso contrário.
     */
    private boolean validarAtorExiste(Long id) {
        if (id == null) {
            return false;
        }

        return atores.stream().anyMatch(ator -> id.equals(ator.getId()));
    }
}