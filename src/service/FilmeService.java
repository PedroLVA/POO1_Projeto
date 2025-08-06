package service;

import interfaces.ICrudOperations;
import model.Ator;
import model.Diretor;
import model.Filme;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Contém a lógica de negócio para manipulação de Filmes.
 */
public class FilmeService implements ICrudOperations<Filme> {

    private final List<Filme> filmes;
    private static int proximoId = 1;

    public FilmeService() {
        this.filmes = new ArrayList<>();
    }

    @Override
    public boolean cadastrar(Filme filme) {
        if (filme == null || validarFilmeExiste(filme.getId())) {
            return false;
        }
        filme.setId(proximoId++);
        return this.filmes.add(filme);
    }

    @Override
    public Filme buscarPorId(int id) {

        return this.filmes.stream()
                .filter(filme -> filme.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Filme> buscarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return this.filmes.stream()
                .filter(filme -> filme.getNome().equalsIgnoreCase(nome))
                .collect(Collectors.toList());
    }

    public List<Filme> buscarPorNomeParcial(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return new ArrayList<>();
        }
        String nomeLowerCase = nome.toLowerCase();
        return this.filmes.stream()
                .filter(filme -> filme.getNome().toLowerCase().contains(nomeLowerCase))
                .collect(Collectors.toList());
    }

    @Override
    public List<Filme> listarTodos() {
        return new ArrayList<>(this.filmes);
    }

    public List<Filme> listarOrdenadoPorNome() {
        return this.filmes.stream()
                .sorted(Comparator.comparing(Filme::getNome))
                .collect(Collectors.toList());
    }

    public List<Filme> listarOrdenadoPorData() {
        return this.filmes.stream()
                .sorted(Comparator.comparing(Filme::getDataLancamento))
                .collect(Collectors.toList());
    }


    @Override
    public boolean atualizar(Filme filmeAtualizado) {
        if (filmeAtualizado == null) {
            return false;
        }

        Filme filmeExistente = buscarPorId((int) filmeAtualizado.getId());
        if (filmeExistente == null) {
            return false;
        }

        int index = this.filmes.indexOf(filmeExistente);
        this.filmes.set(index, filmeAtualizado);
        return true;
    }

    @Override
    public boolean remover(int id) {
        return this.filmes.removeIf(filme -> filme.getId() == id);
    }

    public boolean associarAtor(Filme filme, Ator ator) {
        if (filme != null && ator != null) {
            filme.adicionarAtor(ator);
            return true;
        }
        return false;
    }

    /**
     * Remove a associação de um ator com um filme.
     */
    public boolean removerAtor(Filme filme, Ator ator) {
        if (filme != null && ator != null) {
            filme.removerAtor(ator);
            return true;
        }
        return false;
    }

    /**
     * Associa um diretor a um filme.
     */
    public boolean associarDiretor(Filme filme, Diretor diretor) {
        if (filme != null && diretor != null) {
            filme.setDiretor(diretor);
            return true;
        }
        return false;
    }


    private boolean validarFilmeExiste(long id) {
        if (id <= 0) {
            return false;
        }
        return this.filmes.stream()
                .anyMatch(filme -> filme.getId() == id);
    }
}