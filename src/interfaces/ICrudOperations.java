package interfaces;

import java.util.List;

/**
 * Interface ICrudOperations - Define as operações básicas que todas as classes de serviço devem ter
 * Esta interface é como um "contrato" que diz quais métodos uma classe deve ter.
 * CRUD significa: Create (Criar), Read (Ler), Update (Atualizar), Delete (Deletar)
 * Exemplo: Se uma classe implementa esta interface, ela DEVE ter todos estes métodos.
 */
public interface ICrudOperations<T> {

    boolean cadastrar(T entidade);
    T buscarPorId(Long id);
    List<T> listarTodos();
    boolean atualizar(T entidade);
    boolean remover(Long id);
}
