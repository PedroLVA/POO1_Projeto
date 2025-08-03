import exception.PessoaNaoEncontradaException;
import model.Ator;
import model.Diretor;
import service.AtorService;
import service.DiretorService;

import java.util.List;
import java.util.Scanner;

public class Main {
    // Instância dos serviços que serão testados
    private static final AtorService atorService = new AtorService();
    private static final DiretorService diretorService = new DiretorService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    gerenciarAtores();
                    break;
                case 2:
                    gerenciarDiretores();
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

    private static void exibirMenuPrincipal() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Gerenciar Atores");
        System.out.println("2. Gerenciar Diretores");
        System.out.println("0. Sair");
        System.out.print("Escolha uma área para gerenciar: ");
    }

    // ========== LÓGICA PARA GERENCIAR ATORES ==========

    private static void gerenciarAtores() {
        int opcao;
        do {
            exibirMenuAtores();
            opcao = lerOpcao();

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
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenuAtores() {
        System.out.println("\n--- MENU DE ATORES ---");
        System.out.println("1. Cadastrar Ator");
        System.out.println("2. Listar Todos os Atores");
        System.out.println("3. Buscar Ator por ID");
        System.out.println("4. Buscar Ator por Nome");
        System.out.println("5. Atualizar Ator");
        System.out.println("6. Remover Ator");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarAtor() {
        System.out.print("Digite o nome do ator: ");
        String nome = scanner.nextLine();
        Ator novoAtor = new Ator(nome); // Supondo que Ator herda de Pessoa
        if (atorService.cadastrar(novoAtor)) {
            System.out.println("Ator cadastrado com sucesso! ID atribuído: " + novoAtor.getId());
        } else {
            System.out.println("Falha ao cadastrar o ator. Verifique os dados.");
        }
    }

    private static void listarTodosAtores() {
        System.out.println("\n--- LISTA DE ATORES ---");
        List<Ator> atores = atorService.listarTodos();
        if (atores.isEmpty()) {
            System.out.println("Nenhum ator cadastrado.");
        } else {
            atores.forEach(System.out::println);
        }
    }

    private static void buscarAtorPorId() {
        System.out.print("Digite o ID do ator: ");
        long id = lerLong();
        try {
            Ator ator = atorService.buscarPorId(id);
            System.out.println("Ator encontrado: " + ator);
        } catch (PessoaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarAtorPorNome() {
        System.out.print("Digite o nome exato do ator: ");
        String nome = scanner.nextLine();
        try {
            Ator ator = atorService.buscarPorNome(nome);
            System.out.println("Ator encontrado: " + ator);
        } catch (PessoaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void atualizarAtor() {
        System.out.print("Digite o ID do ator que deseja atualizar: ");
        long id = lerLong();
        try {
            Ator atorExistente = atorService.buscarPorId(id);
            System.out.println("Ator encontrado: " + atorExistente);
            System.out.print("Digite o novo nome para o ator: ");
            String novoNome = scanner.nextLine();
            atorExistente.setNome(novoNome);
            if (atorService.atualizar(atorExistente)) {
                System.out.println("Ator atualizado com sucesso!");
            } else {
                System.out.println("Falha ao atualizar o ator.");
            }
        } catch (PessoaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removerAtor() {
        System.out.print("Digite o ID do ator a ser removido: ");
        long id = lerLong();
        if (atorService.remover(id)) {
            System.out.println("Ator removido com sucesso!");
        } else {
            // Este 'else' pode ser redundante se o serviço sempre lançar exceção ao não encontrar
            System.out.println("Falha ao remover. Ator com ID " + id + " não encontrado.");
        }
    }


    // ========== LÓGICA PARA GERENCIAR DIRETORES ==========

    private static void gerenciarDiretores() {
        int opcao;
        do {
            exibirMenuDiretores();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarDiretor();
                    break;
                case 2:
                    listarTodosDiretores();
                    break;
                case 3:
                    buscarDiretorPorId();
                    break;
                case 4:
                    buscarDiretorPorNome();
                    break;
                case 5:
                    atualizarDiretor();
                    break;
                case 6:
                    removerDiretor();
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenuDiretores() {
        System.out.println("\n--- MENU DE DIRETORES ---");
        System.out.println("1. Cadastrar Diretor");
        System.out.println("2. Listar Todos os Diretores");
        System.out.println("3. Buscar Diretor por ID");
        System.out.println("4. Buscar Diretor por Nome");
        System.out.println("5. Atualizar Diretor");
        System.out.println("6. Remover Diretor");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarDiretor() {
        System.out.print("Digite o nome do diretor: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o estilo do diretor (opcional): ");
        String estilo = scanner.nextLine();

        Diretor novoDiretor = new Diretor(nome);
        if (estilo != null && !estilo.trim().isEmpty()) {
            novoDiretor.setEstilo(estilo);
        }

        if (diretorService.cadastrar(novoDiretor)) {
            System.out.println("Diretor cadastrado com sucesso! ID atribuído: " + novoDiretor.getId());
        } else {
            System.out.println("Falha ao cadastrar o diretor. Verifique os dados.");
        }
    }

    private static void listarTodosDiretores() {
        System.out.println("\n--- LISTA DE DIRETORES ---");
        List<Diretor> diretores = diretorService.listarTodos();
        if (diretores.isEmpty()) {
            System.out.println("Nenhum diretor cadastrado.");
        } else {
            diretores.forEach(System.out::println);
        }
    }

    private static void buscarDiretorPorId() {
        System.out.print("Digite o ID do diretor: ");
        long id = lerLong();
        try {
            Diretor diretor = diretorService.buscarPorId(id);
            System.out.println("Diretor encontrado: " + diretor);
        } catch (PessoaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarDiretorPorNome() {
        System.out.print("Digite o nome exato do diretor: ");
        String nome = scanner.nextLine();
        try {
            Diretor diretor = diretorService.buscarPorNome(nome);
            System.out.println("Diretor encontrado: " + diretor);
        } catch (PessoaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void atualizarDiretor() {
        System.out.print("Digite o ID do diretor que deseja atualizar: ");
        long id = lerLong();
        try {
            Diretor diretorExistente = diretorService.buscarPorId(id);
            System.out.println("Diretor encontrado: " + diretorExistente);
            System.out.print("Digite o novo nome para o diretor: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo estilo para o diretor: ");
            String novoEstilo = scanner.nextLine();

            diretorExistente.setNome(novoNome);
            diretorExistente.setEstilo(novoEstilo);

            if (diretorService.atualizar(diretorExistente)) {
                System.out.println("Diretor atualizado com sucesso!");
            } else {
                System.out.println("Falha ao atualizar o diretor.");
            }
        } catch (PessoaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removerDiretor() {
        System.out.print("Digite o ID do diretor a ser removido: ");
        long id = lerLong();
        if (diretorService.remover(id)) {
            System.out.println("Diretor removido com sucesso!");
        } else {
            System.out.println("Falha ao remover. Diretor com ID " + id + " não encontrado.");
        }
    }

    // ========== MÉTODOS UTILITÁRIOS ==========

    /**
     * Lê um número inteiro do console, garantindo que a entrada é válida.
     */
    private static int lerOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.next(); // Limpa o buffer do scanner
            System.out.print("Escolha uma opção: ");
        }
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha
        return opcao;
    }

    /**
     * Lê um número long do console, garantindo que a entrada é válida.
     */
    private static long lerLong() {
        while (!scanner.hasNextLong()) {
            System.out.println("Entrada inválida. Por favor, digite um número de ID válido.");
            scanner.next(); // Limpa o buffer
            System.out.print("Digite o ID: ");
        }
        long id = scanner.nextLong();
        scanner.nextLine(); // Consome a quebra de linha
        return id;
    }
}