package interfaces;

import java.util.List;

/**
 * Interface que define um contrato padrão para operações de
 * Cadastro, Leitura, Atualização e Deleção (CRUD).
 * @param <T> O tipo da entidade que será manipulada.
 */
public interface ICrudOperations<T> {

    boolean cadastrar(T entidade);
    T buscarPorId(Long id);
    List<T> listarTodos();
    boolean atualizar(T entidade);
    boolean remover(Long id);
}