package model;

/**
 * Classe Pessoa - Classe base para Ator e Diretor
 * 
 * É uma classe ABSTRATA, o que significa que:
 * - Não podemos criar objetos diretamente desta classe
 * - Ela serve apenas como "molde" para outras classes
 * - As classes filhas (Ator e Diretor) herdam tudo dela
 */
public abstract class Pessoa {

    private static int proximoId = 1;
    
    private final int id;
    private String nome;
    private Integer idade;
    private String nacionalidade;

    public Pessoa(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Nome da pessoa não pode ser null ou vazio!");
        }
        
        this.id = proximoId++;
        this.nome = nome.trim();
    }

    public abstract boolean validarDados();
    public abstract String exibirInformacoes();

    public Integer getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Nome da pessoa não pode ser null ou vazio!");
        }
        this.nome = nome.trim();
    }
    
    public Integer getIdade() {
        return idade;
    }
    
    public void setIdade(Integer idade) {
        if (idade != null && idade < 0) {
            throw new IllegalArgumentException("Erro: Idade não pode ser negativa!");
        }
        this.idade = idade;
    }
    
    public String getNacionalidade() {
        return nacionalidade;
    }
    
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade != null ? nacionalidade.trim() : null;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}