package exception;

/**
 * Exceção customizada para tratar erros específicos do domínio do catálogo.
 */
public class CatalogoException extends Exception {

    private final String codigo;

    public CatalogoException(String codigo, String mensagem) {
        super(mensagem);
        this.codigo = codigo;
    }
    
    public String getCodigo() {
        return codigo;
    }
}