package model;

/**
 * Objeto de Valor para padronizar o retorno das operações,
 * informando o sucesso, uma mensagem e dados opcionais.
 */
public class ResultadoOperacao {

    private final boolean sucesso;
    private final String mensagem;
    private Object dados;

    public ResultadoOperacao(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }
    
    public static ResultadoOperacao criarSucesso(String mensagem) {
        return new ResultadoOperacao(true, mensagem);
    }
    
    public static ResultadoOperacao criarErro(String mensagem) {
        return new ResultadoOperacao(false, mensagem);
    }

    public boolean isSucesso() { return sucesso; }
    public String getMensagem() { return mensagem; }
    public Object getDados() { return dados; }
    public void setDados(Object dados) { this.dados = dados; }
}