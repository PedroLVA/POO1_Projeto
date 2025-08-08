package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Diretor - Representa um diretor no sistema
 * 
 * Esta classe herda da classe Pessoa usando "extends Pessoa"
 * Isso significa que Diretor tem tudo que Pessoa tem, mais suas próprias características
 */
public class Diretor extends Pessoa {

    private String estilo;
    private List<Filme> filmesDirigidos;

    public Diretor(String nome) {
        super(nome);
        this.filmesDirigidos = new ArrayList<>();
    }

    public String getEstilo() {
        return estilo;
    }
    
    public void setEstilo(String estilo) {
        this.estilo = estilo != null ? estilo.trim() : null;
    }
    
    public List<Filme> getFilmesDirigidos() {
        return new ArrayList<>(filmesDirigidos);
    }
    
    public void adicionarFilme(Filme filme) {
        if (filme == null) {
            throw new IllegalArgumentException("Erro: Filme não pode ser null!");
        }
        
        if (filmesDirigidos.contains(filme)) {
            throw new IllegalArgumentException("Erro: Filme já está na lista de filmes dirigidos!");
        }
        
        filmesDirigidos.add(filme);
        System.out.println("Filme '" + filme.getNome() + "' adicionado aos filmes dirigidos!");
    }
    
    public void removerFilme(Filme filme) {
        if (filme == null) {
            throw new IllegalArgumentException("Erro: Filme não pode ser null!");
        }
        
        if (!filmesDirigidos.contains(filme)) {
            throw new IllegalArgumentException("Erro: Filme não está na lista de filmes dirigidos!");
        }
        
        filmesDirigidos.remove(filme);
        System.out.println("Filme '" + filme.getNome() + "' removido dos filmes dirigidos!");
    }

    @Override
    public boolean validarDados() {
        if (getNome() == null || getNome().trim().isEmpty()) {
            System.out.println("Nome inválido!");
            return false;
        }
        
        if (getIdade() != null && getIdade() < 21) {
            System.out.println("Idade muito baixa para diretor profissional!");
            return false;
        }
        
        if (getNacionalidade() == null || getNacionalidade().trim().isEmpty()) {
            System.out.println("Nacionalidade não informada!");
            return false;
        }
        
        if (estilo == null || estilo.trim().isEmpty()) {
            System.out.println("Estilo de direção não informado!");
            return false;
        }
        
        System.out.println("Dados do diretor estão válidos!");
        return true;
    }
    
    @Override
    public String exibirInformacoes() {
        StringBuilder informacoes = new StringBuilder();
        
        informacoes.append("DIRETOR\n");
        informacoes.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        informacoes.append("ID: ").append(getId()).append("\n");
        informacoes.append("Nome: ").append(getNome()).append("\n");
        
        if (getIdade() != null) {
            informacoes.append("Idade: ").append(getIdade()).append(" anos\n");
        }
        
        if (getNacionalidade() != null && !getNacionalidade().trim().isEmpty()) {
            informacoes.append("Nacionalidade: ").append(getNacionalidade()).append("\n");
        }
        
        if (estilo != null && !estilo.trim().isEmpty()) {
            informacoes.append("Estilo: ").append(estilo).append("\n");
        }
        
        informacoes.append("Filmes Dirigidos: ");
        if (filmesDirigidos.isEmpty()) {
            informacoes.append("Nenhum filme registrado\n");
        } else {
            informacoes.append(filmesDirigidos.size()).append(" filme(s)\n");
            for (int i = 0; i < filmesDirigidos.size(); i++) {
                Filme filme = filmesDirigidos.get(i);
                informacoes.append("  ").append(i + 1).append(". ").append(filme.getNome()).append("\n");
            }
        }
        
        return informacoes.toString();
    }

    @Override
    public String toString() {
        return getNome();
    }

    public int contarFilmes() {
        return filmesDirigidos.size();
    }

    public boolean dirigiuFilme(Filme filme) {
        return filmesDirigidos.contains(filme);
    }

    public void limparFilmes() {
        filmesDirigidos.clear();
        System.out.println("Lista de filmes dirigidos do diretor '" + getNome() + "' foi limpa!");
    }

    public boolean definirEstilo(String estilo) {
        if (estilo == null || estilo.trim().isEmpty()) {
            System.out.println("Estilo não pode ser vazio!");
            return false;
        }
        
        this.estilo = estilo.trim();
        System.out.println("Estilo definido como: " + this.estilo);
        return true;
    }
}