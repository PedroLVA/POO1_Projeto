package service;

import interfaces.ICrudOperations;
import model.Filme;

import java.util.List;

/**
 * Contém a lógica de negócio para manipulação de Filmes.
 */
public class FilmeService implements ICrudOperations<Filme> {

    private List<Filme> filmes; // Simula um banco de dados em memória

    @Override
    public boolean cadastrar(Filme filme) {
        // TODO: Implementar a lógica
        return false;
    }

    @Override
    public Filme buscarPorId(Long id) {
        // TODO: Implementar a lógica
        return null;
    }

    public List<Filme> buscarPorNome(String nome) {
        // TODO: Implementar a lógica
        return null;
    }
    
    public List<Filme> buscarPorNomeParcial(String nome) {
        // TODO: Implementar a lógica
        return null;
    }

    @Override
    public List<Filme> listarTodos() {
        // TODO: Implementar a lógica
        return null;
    }
    
    public List<Filme> listarOrdenadoPorNome() {
        // TODO: Implementar a lógica
        return null;
    }
    
    public List<Filme> listarOrdenadoPorData() {
        // TODO: Implementar a lógica
        return null;
    }

    @Override
    public boolean atualizar(Filme filme) {
        // TODO: Implementar a lógica
        return false;
    }

    @Override
    public boolean remover(Long id) {
        // TODO: Implementar a lógica
        return false;
    }
    
    public boolean associarAtor(Long filmeId, Long atorId) {
        // TODO: Implementar a lógica
        return false;
    }
    
    public boolean removerAtor(Long filmeId, Long atorId) {
        // TODO: Implementar a lógica
        return false;
    }
    
    public boolean associarDiretor(Long filmeId, Long diretorId) {
        // TODO: Implementar a lógica
        return false;
    }
    
    private boolean validarFilmeExiste(Long id) {
        // TODO: Implementar a lógica
        return false;
    }
}