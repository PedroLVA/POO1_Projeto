package service;

import interfaces.ICrudOperations;
import model.Diretor;

import java.util.ArrayList;
import java.util.List;

/**
 * Contém a lógica de negócio para manipulação da entidade model.Diretor.
 * Implementa as operações básicas de CRUD definidas em interfaces.ICrudOperations.
 */
import interfaces.ICrudOperations;
import model.Diretor;

import java.util.ArrayList;
import java.util.List;

/**
 * Contém a lógica de negócio para manipulação da entidade model.Diretor.
 * Implementa as operações básicas de CRUD definidas em interfaces.ICrudOperations.
 */
public class DiretorService implements ICrudOperations<Diretor> {

    // Simula um repositório ou uma tabela do banco de dados em memória
    private final List<Diretor> diretores;
    private long proximoId = 1; // Simula a geração de ID autoincremental

    public DiretorService() {
        this.diretores = new ArrayList<>();
    }

    /**
     * Cadastra um novo diretor no sistema.
     * @param diretor O objeto model.Diretor a ser cadastrado.
     * @return true se o cadastro foi bem-sucedido, false caso contrário.
     */
    @Override
    public boolean cadastrar(Diretor diretor) {
        if (diretor == null || !diretor.validarDados()) {
            return false;
        }
        this.diretores.add(diretor);
        return true;
    }

    /**
     * Busca um diretor pelo seu ID.
     * @param id O ID do diretor a ser buscado.
     * @return O objeto model.Diretor encontrado, ou null se não existir.
     */
    @Override
    public Diretor buscarPorId(int id) {
        return diretores.stream()
                .filter(d -> id == d.getId())
                .findFirst()
                .orElse(null);
    }

    /**
     * Busca um diretor pelo seu nome exato.
     * @param nome O nome do diretor.
     * @return O diretor encontrado, ou null se não existir.
     */
    public Diretor buscarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }
        return diretores.stream()
                .filter(d -> nome.equals(d.getNome()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Retorna uma lista com todos os diretores cadastrados.
     * @return Uma cópia da lista de objetos model.Diretor.
     */
    @Override
    public List<Diretor> listarTodos() {
        return new ArrayList<>(this.diretores);
    }

    /**
     * Atualiza os dados de um diretor existente.
     * @param diretor O objeto model.Diretor com os dados atualizados.
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     */
    @Override
    public boolean atualizar(Diretor diretor) {
        // Assuming getId() on the Diretor object returns a primitive int as well.
        if (diretor == null) {
            return false;
        }

        for (int i = 0; i < diretores.size(); i++) {
            // Use the '==' operator for primitive type comparison.
            if (diretores.get(i).getId() == diretor.getId()) {
                diretores.set(i, diretor);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove um diretor do sistema pelo seu ID.
     * @param id O ID do diretor a ser removido.
     * @return true se a remoção foi bem-sucedida, false caso contrário.
     */
    @Override
    public boolean remover(int id) {
        // No null check is needed for a primitive int.
        // Use the '==' operator for primitive type comparison.
        return diretores.removeIf(d -> id == d.getId());
    }



    /**
     * Método privado para validar se um diretor já existe no sistema.
     * @param id O ID a ser verificado.
     * @return true se o diretor existe.
     */
    private boolean validarDiretorExiste(Long id) {
        if (id == null) {
            return false;
        }
        return diretores.stream().anyMatch(d -> id.equals(d.getId()));
    }
}