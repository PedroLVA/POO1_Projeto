package model;

/**
 * Classe Pessoa - Classe base para Ator e Diretor
 * 
 * Esta é uma classe "pai" (superclasse) que contém informações básicas
 * que tanto atores quanto diretores têm em comum.
 * 
 * É uma classe ABSTRATA, o que significa que:
 * - Não podemos criar objetos diretamente desta classe
 * - Ela serve apenas como "molde" para outras classes
 * - As classes filhas (Ator e Diretor) herdam tudo dela
 * 
 * Exemplo prático:
 * - Tanto atores quanto diretores têm nome, idade, nacionalidade
 * - Então colocamos essas informações aqui na classe Pessoa
 * - Assim não precisamos repetir o código nas outras classes
 */
public abstract class Pessoa {

    // ===== ATRIBUTOS =====
    // Estas são as informações que todas as pessoas têm
    
    private static int proximoId = 1; // Gera números únicos automaticamente (1, 2, 3...)
    
    private final int id;              // Número único de identificação
    private String nome;                // Nome da pessoa
    private Integer idade;              // Idade da pessoa
    private String nacionalidade;       // País de origem

    // ===== CONSTRUTOR =====
    /**
     * Construtor - cria uma nova pessoa
     * 
     * Quando criamos uma pessoa (ator ou diretor), ela automaticamente
     * recebe um número único de identificação.
     * 
     * @param nome o nome da pessoa
     */
    public Pessoa(String nome) {
        // VALIDAÇÃO: Verificar se o nome não é null ou vazio
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ Erro: Nome da pessoa não pode ser null ou vazio!");
        }
        
        this.id = proximoId++;  // Pega o próximo número disponível
        this.nome = nome.trim(); // Remove espaços em branco e define o nome
    }

    // ===== MÉTODOS ABSTRATOS =====
    // Estes métodos NÃO têm implementação aqui.
    // As classes filhas (Ator e Diretor) SÃO OBRIGADAS a implementá-los.
    public abstract boolean validarDados();

    public abstract String exibirInformacoes();

    // ===== MÉTODOS CONCRETOS (GETTERS E SETTERS) =====
    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ Erro: Nome da pessoa não pode ser null ou vazio!");
        }
        this.nome = nome.trim();
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        if (idade != null && idade < 0) {
            throw new IllegalArgumentException("❌ Erro: Idade não pode ser negativa!");
        }
        this.idade = idade;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade != null ? nacionalidade.trim() : null;
    }

    // ===== MÉTODOS ESPECIAIS =====
    
    /**
     * Converte a pessoa para texto (usado quando imprimimos no console)
     * 
     * Quando fazemos System.out.println(pessoa), este método é chamado
     * automaticamente para mostrar o nome da pessoa.
     * 
     * @return o nome da pessoa
     */
    @Override
    public String toString() {
        return nome;
    }
}