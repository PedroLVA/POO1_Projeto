package service;

import interfaces.ICrudOperations;
import model.Diretor;

import java.util.ArrayList;
import java.util.List;

/**
 * Contém a lógica de negócio para manipulação da entidade model.Diretor.
 * Implementa as operações básicas de CRUD definidas em interfaces.ICrudOperations.
 */
public class DiretorService implements ICrudOperations<Diretor> {

    private final List<Diretor> diretores;
    private int proximoId = 1;

    public DiretorService() {
        this.diretores = new ArrayList<>();
    }

    @Override
    public boolean cadastrar(Diretor diretor) {
        if (diretor == null || !diretor.validarDados()) {
            return false;
        }
        this.diretores.add(diretor);
        return true;
    }

    @Override
    public Diretor buscarPorId(int id) {
        return diretores.stream()
                .filter(d -> id == d.getId())
                .findFirst()
                .orElse(null);
    }

    public Diretor buscarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }
        return diretores.stream()
                .filter(d -> nome.equals(d.getNome()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Diretor> listarTodos() {
        return new ArrayList<>(this.diretores);
    }

    @Override
    public boolean atualizar(Diretor diretor) {
        if (diretor == null) {
            return false;
        }

        for (int i = 0; i < diretores.size(); i++) {
            if (diretores.get(i).getId() == diretor.getId()) {
                diretores.set(i, diretor);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remover(int id) {
        return diretores.removeIf(d -> id == d.getId());
    }

    private boolean validarDiretorExiste(int id) {
        return diretores.stream().anyMatch(d -> id == d.getId());
    }
}