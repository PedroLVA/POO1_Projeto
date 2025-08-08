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
 * Implementa as operações básicas de CRUD definidas em interfaces.ICrudOperations.
 */
public class FilmeService implements ICrudOperations<Filme> {

    private final List<Filme> filmes;
    private static int proximoId = 1;

    public FilmeService() {
        this.filmes = new ArrayList<>();
    }

    @Override
    public boolean cadastrar(Filme filme) {
        if (filme == null) {
            System.out.println("Filme não pode ser null!");
            return false;
        }
        
        if (!filme.validarCamposObrigatorios()) {
            System.out.println("Campos obrigatórios do filme não estão válidos!");
            return false;
        }
        
        List<Filme> filmesExistentes = buscarPorNome(filme.getNome());
        if (!filmesExistentes.isEmpty()) {
            System.out.println("Já existe um filme com o nome: " + filme.getNome());
            return false;
        }
        
        filme.setId(proximoId++);
        
        boolean adicionado = this.filmes.add(filme);
        if (adicionado) {
            System.out.println("Filme '" + filme.getNome() + "' cadastrado com sucesso! (ID: " + filme.getId() + ")");
        }
        
        return adicionado;
    }

    @Override
    public Filme buscarPorId(int id) {
        if (id <= 0) {
            System.out.println("ID inválido!");
            return null;
        }

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
                .filter(filme -> filme.getNome().equalsIgnoreCase(nome.trim()))
                .collect(Collectors.toList());
    }

    public List<Filme> buscarPorNomeParcial(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return new ArrayList<>();
        }
        String nomeLowerCase = nome.toLowerCase().trim();
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
            System.out.println("Filme não pode ser null!");
            return false;
        }

        if (!filmeAtualizado.validarCamposObrigatorios()) {
            System.out.println("Campos obrigatórios do filme não estão válidos!");
            return false;
        }

        Filme filmeExistente = buscarPorId(filmeAtualizado.getId());
        if (filmeExistente == null) {
            System.out.println("Filme com ID " + filmeAtualizado.getId() + " não encontrado!");
            return false;
        }

        List<Filme> filmesComMesmoNome = buscarPorNome(filmeAtualizado.getNome());
        for (Filme filme : filmesComMesmoNome) {
            if (filme.getId() != filmeAtualizado.getId()) {
                System.out.println("Já existe outro filme com o nome: " + filmeAtualizado.getNome());
                return false;
            }
        }

        int index = this.filmes.indexOf(filmeExistente);
        this.filmes.set(index, filmeAtualizado);
        System.out.println("Filme '" + filmeAtualizado.getNome() + "' atualizado com sucesso!");
        return true;
    }

    @Override
    public boolean remover(int id) {
        if (id <= 0) {
            System.out.println("ID inválido!");
            return false;
        }

        Filme filme = buscarPorId(id);
        if (filme == null) {
            System.out.println("Filme com ID " + id + " não encontrado!");
            return false;
        }

        boolean removido = this.filmes.removeIf(f -> f.getId() == id);
        if (removido) {
            System.out.println("Filme '" + filme.getNome() + "' removido com sucesso!");
        }
        
        return removido;
    }

    public boolean associarAtor(int filmeId, int atorId) {
        if (filmeId <= 0 || atorId <= 0) {
            System.out.println("IDs inválidos!");
            return false;
        }

        Filme filme = buscarPorId(filmeId);
        if (filme == null) {
            System.out.println("Filme com ID " + filmeId + " não encontrado!");
            return false;
        }

        Ator ator = new Ator("Ator Temporário");
        
        try {
            filme.adicionarAtor(ator);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(" " + e.getMessage());
            return false;
        }
    }

    public boolean associarAtor(Filme filme, Ator ator) {
        if (filme == null || ator == null) {
            System.out.println(" Filme e ator não podem ser null!");
            return false;
        }

        try {
            filme.adicionarAtor(ator);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(" " + e.getMessage());
            return false;
        }
    }

    public boolean removerAtor(int filmeId, int atorId) {
        if (filmeId <= 0 || atorId <= 0) {
            System.out.println(" IDs inválidos!");
            return false;
        }

        Filme filme = buscarPorId(filmeId);
        if (filme == null) {
            System.out.println(" Filme com ID " + filmeId + " não encontrado!");
            return false;
        }

        Ator ator = new Ator("Ator Temporário");
        
        try {
            filme.removerAtor(ator);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(" " + e.getMessage());
            return false;
        }
    }

    public boolean removerAtor(Filme filme, Ator ator) {
        if (filme == null || ator == null) {
            System.out.println(" Filme e ator não podem ser null!");
            return false;
        }

        try {
            filme.removerAtor(ator);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(" " + e.getMessage());
            return false;
        }
    }

    public boolean associarDiretor(int filmeId, int diretorId) {
        if (filmeId <= 0 || diretorId <= 0) {
            System.out.println(" IDs inválidos!");
            return false;
        }

        Filme filme = buscarPorId(filmeId);
        if (filme == null) {
            System.out.println(" Filme com ID " + filmeId + " não encontrado!");
            return false;
        }

        Diretor diretor = new Diretor("Diretor Temporário");
        
        filme.setDiretor(diretor);
        System.out.println(" Diretor associado ao filme '" + filme.getNome() + "' com sucesso!");
        return true;
    }

    public boolean associarDiretor(Filme filme, Diretor diretor) {
        if (filme == null || diretor == null) {
            System.out.println(" Filme e diretor não podem ser null!");
            return false;
        }

        filme.setDiretor(diretor);
        System.out.println(" Diretor '" + diretor.getNome() + "' associado ao filme '" + filme.getNome() + "' com sucesso!");
        return true;
    }

    private boolean validarFilmeExiste(int id) {
        if (id <= 0) {
            return false;
        }
        return this.filmes.stream()
                .anyMatch(filme -> filme.getId() == id);
    }

    public List<Filme> buscarPorDiretor(Diretor diretor) {
        if (diretor == null) {
            return new ArrayList<>();
        }
        return this.filmes.stream()
                .filter(filme -> diretor.equals(filme.getDiretor()))
                .collect(Collectors.toList());
    }

    public List<Filme> buscarPorAtor(Ator ator) {
        if (ator == null) {
            return new ArrayList<>();
        }
        return this.filmes.stream()
                .filter(filme -> filme.temAtor(ator))
                .collect(Collectors.toList());
    }

    public int contarFilmes() {
        return this.filmes.size();
    }

    public boolean filmeExiste(int id) {
        return validarFilmeExiste(id);
    }
}