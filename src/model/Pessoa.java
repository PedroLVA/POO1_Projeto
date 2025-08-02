package model;

/**
 * Classe abstrata que serve como base para model.Ator e model.Diretor,
 * definindo atributos e comportamentos comuns. Não pode ser instanciada
 * diretamente.
 */
public abstract class Pessoa {

    private static long proximoId = 1; // Variável estática para gerar IDs sequenciais

    private final long id;
    private String nome;
    private Integer idade;
    private String nacionalidade;

    public Pessoa(String nome) {
        this.id = proximoId++;
        this.nome = nome;
    }

    // --- Métodos Abstratos ---
    // Métodos sem implementação. As classes filhas (model.Ator, model.Diretor)
    // SÃO OBRIGADAS a fornecer uma implementação para eles.
    
    /**
     * Valida os dados específicos da entidade (model.Ator ou model.Diretor).
     * @return true se os dados forem válidos, caso contrário false.
     */
    public abstract boolean validarDados();

    /**
     * Retorna uma string formatada com as informações da pessoa.
     * @return Uma representação textual completa do objeto.
     */
    public abstract String exibirInformacoes();

    // --- Getters e Setters (Métodos Concretos) ---
    // Estes métodos são herdados e podem ser usados diretamente pelas classes filhas.
    
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return nome;
    }
}