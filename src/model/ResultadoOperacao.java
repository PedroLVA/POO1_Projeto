package model;

/**
 * Esta classe é usada para informar se uma operação foi bem-sucedida ou não,
 * junto com uma mensagem explicativa e dados opcionais.
 */
public class ResultadoOperacao {

    private boolean sucesso;
    private String mensagem;
    private Object dados;

    public ResultadoOperacao(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.dados = null;
    }

    public static ResultadoOperacao criarSucesso(String mensagem) {
        return new ResultadoOperacao(true, mensagem);
    }
    
    public static ResultadoOperacao criarErro(String mensagem) {
        return new ResultadoOperacao(false, mensagem);
    }

    public boolean isSucesso() { 
        return sucesso; 
    }

    public String getMensagem() { 
        return mensagem; 
    }

    public Object getDados() { 
        return dados; 
    }

    public void setDados(Object dados) { 
        this.dados = dados; 
    }

    public boolean temDados() {
        return dados != null;
    }

    @Override
    public String toString() {
        String resultado = "Resultado: ";
        if (sucesso) {
            resultado += "SUCESSO";
        } else {
            resultado += "ERRO";
        }
        resultado += " - " + mensagem;
        
        if (temDados()) {
            resultado += " (com dados)";
        }
        
        return resultado;
    }
}