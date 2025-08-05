package service;

import interfaces.ICrudOperations;
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
    public Filme buscarPorId(Long id) {
        if (id == null) {
            return null;
        }
        return this.filmes.stream()
                .filter(filme -> Objects.equals(filme.getId(), id.intValue()))
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

        Filme filmeExistente = buscarPorId((long) filmeAtualizado.getId());
        if (filmeExistente == null) {
            return false;
        }

        int index = this.filmes.indexOf(filmeExistente);
        this.filmes.set(index, filmeAtualizado);
        return true;
    }

    @Override
    public boolean remover(Long id) {
        if (id == null) {
            return false;
        }
        return this.filmes.removeIf(filme -> Objects.equals(filme.getId(), id.intValue()));
    }

    public boolean associarAtor(Long filmeId, Long atorId) {
        // A implementação requer acesso ao AtorService para buscar o Ator pelo ID.
        // Sem essa dependência, a associação não pode ser concluída.
        return false;
    }

    public boolean removerAtor(Long filmeId, Long atorId) {
        // A implementação requer acesso ao AtorService para buscar o Ator pelo ID.
        // Sem essa dependência, a remoção não pode ser concluída.
        return false;
    }

    public boolean associarDiretor(Long filmeId, Long diretorId) {
        // A implementação requer acesso ao DiretorService para buscar o Diretor pelo ID.
        // Sem essa dependência, a associação não pode ser concluída.
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