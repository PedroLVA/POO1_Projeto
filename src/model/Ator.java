package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Ator - Representa um ator no sistema
 * 
 * Esta classe herda da classe Pessoa usando "extends Pessoa"
 * Isso significa que Ator tem tudo que Pessoa tem, mais suas próprias características
 */
public class Ator extends Pessoa {
    private List<Filme> filmografia;

    public Ator(String nome) {
        super(nome);
        this.filmografia = new ArrayList<>();
    }

    public List<Filme> getFilmografia() {
        return new ArrayList<>(filmografia);
    }

    public void adicionarFilme(Filme filme) {
        if (filme == null) {
            throw new IllegalArgumentException("Erro: Filme não pode ser null!");
        }
        
        if (filmografia.contains(filme)) {
            throw new IllegalArgumentException("Erro: Filme já está na filmografia do ator!");
        }
        
        filmografia.add(filme);
        System.out.println("Filme '" + filme.getNome() + "' adicionado à filmografia!");
    }

    public void removerFilme(Filme filme) {
        if (filme == null) {
            throw new IllegalArgumentException("Erro: Filme não pode ser null!");
        }
        
        if (!filmografia.contains(filme)) {
            throw new IllegalArgumentException("Erro: Filme não está na filmografia do ator!");
        }
        
        filmografia.remove(filme);
        System.out.println("Filme '" + filme.getNome() + "' removido da filmografia!");
    }

    @Override
    public boolean validarDados() {
        if (getNome() == null || getNome().trim().isEmpty()) {
            System.out.println("Nome inválido!");
            return false;
        }
        
        if (getIdade() != null && getIdade() < 18) {
            System.out.println("Idade muito baixa para ator profissional!");
            return false;
        }
        
        if (getNacionalidade() == null || getNacionalidade().trim().isEmpty()) {
            System.out.println("Nacionalidade não informada!");
            return false;
        }
        
        System.out.println("Dados do ator estão válidos!");
        return true;
    }
    
    @Override
    public String exibirInformacoes() {
        StringBuilder informacoes = new StringBuilder();
        
        informacoes.append("ATOR\n");
        informacoes.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        informacoes.append("ID: ").append(getId()).append("\n");
        informacoes.append("Nome: ").append(getNome()).append("\n");
        
        if (getIdade() != null) {
            informacoes.append("Idade: ").append(getIdade()).append(" anos\n");
        }
        
        if (getNacionalidade() != null && !getNacionalidade().trim().isEmpty()) {
            informacoes.append("Nacionalidade: ").append(getNacionalidade()).append("\n");
        }
        
        informacoes.append("Filmografia: ");
        if (filmografia.isEmpty()) {
            informacoes.append("Nenhum filme registrado\n");
        } else {
            informacoes.append(filmografia.size()).append(" filme(s)\n");
            for (int i = 0; i < filmografia.size(); i++) {
                Filme filme = filmografia.get(i);
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
        return filmografia.size();
    }

    public boolean temFilme(Filme filme) {
        return filmografia.contains(filme);
    }

    public void limparFilmografia() {
        filmografia.clear();
        System.out.println("Filmografia do ator '" + getNome() + "' foi limpa!");
    }
}