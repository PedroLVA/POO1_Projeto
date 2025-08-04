package interfaces;

import java.util.List;

/**
 * Interface ICrudOperations - Define as operações básicas que todas as classes de serviço devem ter
 * 
 * Esta interface é como um "contrato" que diz quais métodos uma classe deve ter.
 * CRUD significa: Create (Criar), Read (Ler), Update (Atualizar), Delete (Deletar)
 * 
 * Exemplo: Se uma classe implementa esta interface, ela DEVE ter todos estes métodos.
 * 
 * @param <T> O tipo de objeto que será manipulado (ex: Filme, Ator, Diretor)
 */
public interface ICrudOperations<T> {

    /**
     * Cadastra um novo objeto no sistema
     * 
     * @param entidade o objeto que queremos cadastrar (filme, ator, diretor, etc.)
     * @return true se cadastrou com sucesso, false se deu erro
     */
    boolean cadastrar(T entidade);
    
    /**
     * Busca um objeto pelo seu número de identificação (ID)
     * 
     * @param id o número que identifica o objeto
     * @return o objeto encontrado, ou null se não encontrar
     */
    T buscarPorId(Long id);
    
    /**
     * Lista todos os objetos cadastrados
     * 
     * @return uma lista com todos os objetos
     */
    List<T> listarTodos();
    
    /**
     * Atualiza as informações de um objeto existente
     * 
     * @param entidade o objeto com as informações atualizadas
     * @return true se atualizou com sucesso, false se deu erro
     */
    boolean atualizar(T entidade);
    
    /**
     * Remove um objeto do sistema
     * 
     * @param id o número que identifica o objeto a ser removido
     * @return true se removeu com sucesso, false se deu erro
     */
    boolean remover(Long id);
}