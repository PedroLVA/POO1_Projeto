import exception.PessoaNaoEncontradaException;
import model.Ator;
import model.Filme;
import service.AtorService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final AtorService atorService = new AtorService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Opção inválida. Por favor, digite um número.");
                scanner.next();
                System.out.print("Escolha uma opção: ");
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAtor();
                    break;
                case 2:
                    listarTodosAtores();
                    break;
                case 3:
                    buscarAtorPorId();
                    break;
                case 4:
                    buscarAtorPorNome();
                    break;
                case 5:
                    atualizarAtor();
                    break;
                case 6:
                    removerAtor();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- MENU DE TESTE - ATOR SERVICE ---");
        System.out.println("1. Cadastrar Ator");
        System.out.println("2. Listar Todos os Atores");
        System.out.println("3. Buscar Ator por ID");
        System.out.println("4. Buscar Ator por Nome");
        System.out.println("5. Atualizar Ator");
        System.out.println("6. Remover Ator");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarAtor() {
        System.out.print("Digite o nome do ator: ");
        String nome = scanner.nextLine();

        Ator novoAtor = new Ator(nome);
        if (atorService.cadastrar(novoAtor)) {
            System.out.println("Ator cadastrado com sucesso! ID atribuído: " + novoAtor.getId());
        } else {
            System.out.println("Falha ao cadastrar o ator. Verifique os dados.");
        }
    }

    private static void listarTodosAtores() {
        System.out.println("\n--- LISTA DE ATORES CADASTRADOS ---");
        List<Ator> atores = atorService.listarTodos();
        if (atores.isEmpty()) {
            System.out.println("Nenhum ator cadastrado.");
        } else {
            atores.forEach(System.out::println); // Usa o método toString() do Ator
        }
    }

    private static void buscarAtorPorId() {
        System.out.print("Digite o ID do ator a ser buscado: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        try{
            Ator ator = atorService.buscarPorId(id);
            System.out.println("Ator encontrado: " + ator);
        }
        catch(PessoaNaoEncontradaException e){
            System.out.println(e.getMessage());
        }

    }

    private static void buscarAtorPorNome() {
        System.out.print("Digite o nome exato do ator a ser buscado: ");
        String nome = scanner.nextLine();


        try{
            Ator ator = atorService.buscarPorNome(nome);
            System.out.println("Ator encontrado: " + ator);
        }
        catch(PessoaNaoEncontradaException e){
            System.out.println(e.getMessage());
        }
    }

    private static void atualizarAtor() {
        System.out.print("Digite o ID do ator que deseja atualizar: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consome a quebra de linha

        Ator atorExistente = atorService.buscarPorId(id);
        if (atorExistente == null) {
            System.out.println("Ator com ID " + id + " não encontrado. Impossível atualizar.");
            return;
        }

        System.out.println("Ator encontrado: " + atorExistente);
        System.out.print("Digite o novo nome para o ator: ");
        String novoNome = scanner.nextLine();

        atorExistente.setNome(novoNome);

        if (atorService.atualizar(atorExistente)) {
            System.out.println("Ator atualizado com sucesso!");
        } else {
            System.out.println("Falha ao atualizar o ator.");
        }
    }

    private static void removerAtor() {
        System.out.print("Digite o ID do ator a ser removido: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consome a quebra de linha

        if (atorService.remover(id)) {
            System.out.println("Ator removido com sucesso!");
        } else {
            System.out.println("Falha ao remover. Ator com ID " + id + " não encontrado.");
        }
    }
}