package model;
/**
 * Classe simples para armazenar o resultado de uma operação.
 * Esta classe é usada para informar se uma operação foi bem-sucedida ou não,
 * junto com uma mensagem explicativa e dados opcionais.
 * 
 * Exemplo de uso:
 * - Quando cadastramos um filme: sucesso = true, mensagem = "Filme cadastrado com sucesso"
 * - Quando há erro: sucesso = false, mensagem = "Erro: filme não encontrado"
 */
public class ResultadoOperacao {

    // Atributos da classe
    private boolean sucesso;        
    private String mensagem;        // texto explicando o que aconteceu
    private Object dados;           // informações adicionais (pode ser qualquer coisa)

    public ResultadoOperacao(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.dados = null;  // inicialmente não há dados
    }
    /**
     * Método para criar um resultado de SUCESSO
     */
    public static ResultadoOperacao criarSucesso(String mensagem) {
        return new ResultadoOperacao(true, mensagem);
    }
    public static ResultadoOperacao criarErro(String mensagem) {
        return new ResultadoOperacao(false, mensagem);
    }
    // ===== MÉTODOS GETTERS =====
    public boolean isSucesso() { 
        return sucesso; 
    }
    public String getMensagem() { 
        return mensagem; 
    }
    public Object getDados() { 
        return dados; 
    }
    // ===== MÉTODOS SETTERS =====
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
