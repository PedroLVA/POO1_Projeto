package model;

/**
 * Objeto de Valor para padronizar o retorno das operações,
 * informando o sucesso, uma mensagem e dados opcionais.
 * 
 * @param <T> Tipo dos dados que podem ser retornados
 */
public class ResultadoOperacao<T> {

    private final boolean sucesso;
    private final String mensagem;
    private final T dados;

    /**
     * Construtor principal com validações.
     * 
     * @param sucesso Indica se a operação foi bem-sucedida
     * @param mensagem Mensagem descritiva do resultado
     * @param dados Dados opcionais relacionados à operação
     * @throws IllegalArgumentException se a mensagem for nula
     */
    public ResultadoOperacao(boolean sucesso, String mensagem, T dados) {
        if (mensagem == null) {
            throw new IllegalArgumentException("Mensagem não pode ser nula");
        }
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.dados = dados;
    }

    /**
     * Construtor para operações sem dados de retorno.
     * 
     * @param sucesso Indica se a operação foi bem-sucedida
     * @param mensagem Mensagem descritiva do resultado
     * @throws IllegalArgumentException se a mensagem for nula
     */
    public ResultadoOperacao(boolean sucesso, String mensagem) {
        this(sucesso, mensagem, null);
    }
    
    /**
     * Cria um resultado de sucesso sem dados.
     * 
     * @param mensagem Mensagem de sucesso
     * @return ResultadoOperacao indicando sucesso
     */
    public static <T> ResultadoOperacao<T> criarSucesso(String mensagem) {
        return new ResultadoOperacao<>(true, mensagem, null);
    }
    
    /**
     * Cria um resultado de sucesso com dados.
     * 
     * @param mensagem Mensagem de sucesso
     * @param dados Dados a serem retornados
     * @return ResultadoOperacao indicando sucesso com dados
     */
    public static <T> ResultadoOperacao<T> criarSucesso(String mensagem, T dados) {
        return new ResultadoOperacao<>(true, mensagem, dados);
    }
    
    /**
     * Cria um resultado de erro.
     * 
     * @param mensagem Mensagem de erro
     * @return ResultadoOperacao indicando erro
     */
    public static <T> ResultadoOperacao<T> criarErro(String mensagem) {
        return new ResultadoOperacao<>(false, mensagem, null);
    }

    /**
     * Verifica se a operação foi bem-sucedida.
     * 
     * @return true se a operação foi bem-sucedida, false caso contrário
     */
    public boolean isSucesso() { 
        return sucesso; 
    }
    
    /**
     * Obtém a mensagem do resultado.
     * 
     * @return Mensagem descritiva do resultado
     */
    public String getMensagem() { 
        return mensagem; 
    }
    
    /**
     * Obtém os dados do resultado.
     * 
     * @return Dados relacionados à operação, ou null se não houver dados
     */
    public T getDados() { 
        return dados; 
    }
    
    /**
     * Verifica se há dados no resultado.
     * 
     * @return true se há dados, false caso contrário
     */
    public boolean temDados() {
        return dados != null;
    }
}