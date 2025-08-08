package service;

import exception.PessoaNaoEncontradaException;
import interfaces.ICrudOperations;
import model.Ator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Contém a lógica de negócio para manipulação da entidade model.Ator.
 * Implementa as operações básicas de CRUD definidas em interfaces.ICrudOperations.
 */
public class AtorService implements ICrudOperations<Ator> {

    private final List<Ator> atores;

    public AtorService() {
        this.atores = new ArrayList<>();
    }

    @Override
    public boolean cadastrar(Ator ator) {
        if (ator == null || ator.getNome() == null || ator.getNome().trim().isEmpty()) {
            return false;
        }

        this.atores.add(ator);
        return true;
    }

    @Override
    public Ator buscarPorId(int id) {
        return atores.stream()
                .filter(ator -> id == ator.getId())
                .findFirst()
                .orElseThrow(() -> new PessoaNaoEncontradaException("Ator com o ID: " + id + " não encontrado"));
    }

    public Ator buscarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }

        return atores.stream()
                .filter(ator -> nome.equals(ator.getNome()))
                .findFirst()
                .orElseThrow(() -> new PessoaNaoEncontradaException("Ator com o nome: " + nome + " não encontrado"));
    }

    @Override
    public List<Ator> listarTodos() {
        return new ArrayList<>(this.atores);
    }

    @Override
    public boolean atualizar(Ator ator) {
        if (ator == null || ator.getId() == null) {
            return false;
        }

        for (int i = 0; i < atores.size(); i++) {
            if (atores.get(i).getId().equals(ator.getId())) {
                atores.set(i, ator);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remover(int id) {
        return atores.removeIf(ator -> id == ator.getId());
    }

    private boolean validarAtorExiste(int id) {
        return atores.stream().anyMatch(ator -> id == ator.getId());
    }
}