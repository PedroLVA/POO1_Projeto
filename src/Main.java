import controller.CatalogoController;
import model.Ator;
import model.Diretor;
import model.Filme;
import model.ResultadoOperacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    // The Main class now only needs to know about the Controller.
    private static final CatalogoController catalogoController = new CatalogoController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    menuAtores();
                    break;
                case 2:
                    menuDiretores();
                    break;
                case 3:
                    menuFilmes();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            if (opcao != 0) {
                pressioneEnterParaContinuar();
            }
        } while (opcao != 0);

        scanner.close();
    }

    // MENUS (No changes here, they just define the UI) ==========================
    private static void exibirMenuPrincipal() {
        System.out.println("\n===== SISTEMA DE GERENCIAMENTO DE FILMES (v2) =====");
        System.out.println("                (Controlado por Controller)");
        System.out.println("=================================================");
        System.out.println("1. Gerenciar Atores");
        System.out.println("2. Gerenciar Diretores");
        System.out.println("3. Gerenciar Filmes");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void menuAtores() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Atores ---");
            System.out.println("1. Cadastrar Ator");
            System.out.println("2. Buscar Ator por ID");
            System.out.println("3. Listar Todos os Atores");
            System.out.println("4. Remover Ator");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = lerOpcao();

            switch (opcao) {
                case 1: cadastrarAtor(); break;
                case 2: buscarAtorPorId(); break;
                case 3: listarTodosAtores(); break;
                case 4: removerAtor(); break;
                case 0: System.out.println("Retornando ao menu principal..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuDiretores() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Diretores ---");
            System.out.println("1. Cadastrar Diretor");
            System.out.println("2. Buscar Diretor por ID");
            System.out.println("3. Listar Todos os Diretores");
            System.out.println("4. Remover Diretor");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = lerOpcao();

            switch (opcao) {
                case 1: cadastrarDiretor(); break;
                case 2: buscarDiretorPorId(); break;
                case 3: listarTodosDiretores(); break;
                case 4: removerDiretor(); break;
                case 0: System.out.println("Retornando ao menu principal..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuFilmes() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Filmes ---");
            System.out.println("1. Cadastrar Filme");
            System.out.println("2. Buscar Filme por ID (Detalhes)");
            System.out.println("3. Buscar Filme por Nome");
            System.out.println("4. Listar Todos os Filmes");
            System.out.println("5. Atualizar Filme");
            System.out.println("6. Remover Filme");
            System.out.println("7. Associar Ator a Filme");
            System.out.println("8. Associar Diretor a Filme");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = lerOpcao();

            switch (opcao) {
                case 1: cadastrarFilme(); break;
                case 2: buscarFilmePorId(); break;
                case 3: buscarFilmePorNome(); break;
                case 4: listarTodosFilmes(); break;
                case 5: atualizarFilme(); break;
                case 6: removerFilme(); break;
                case 7: associarAtorAFilme(); break;
                case 8: associarDiretorAFilme(); break;
                case 0: System.out.println("Retornando ao menu principal..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }


    // OPERAÇÕES: ATORES (Calls to Controller) ===================================
    private static void cadastrarAtor() {
        System.out.print("Digite o nome do ator: ");
        String nome = scanner.nextLine();
        Ator ator = new Ator(nome);

        // A lógica é delegada ao controller
        ResultadoOperacao resultado = catalogoController.cadastrarAtor(ator);
        System.out.println(resultado.getMensagem());

        if(resultado.isSucesso()) {
            Ator atorCadastrado = (Ator) resultado.getDados();
            System.out.println("ID gerado: " + atorCadastrado.getId());
        }
    }

    private static void buscarAtorPorId() {
        System.out.print("Digite o ID do ator: ");
        int id = lerOpcao();
        // Assumed method in Controller
        Ator ator = catalogoController.buscarAtorPorId(id);
        if (ator != null) {
            System.out.println("Ator encontrado: " + ator.exibirInformacoes());
        } else {
            System.out.println("Ator com ID " + id + " não encontrado.");
        }
    }

    private static void listarTodosAtores() {
        // Assumed method in Controller
        List<Ator> atores = catalogoController.listarAtores();
        if (atores.isEmpty()) {
            System.out.println("Nenhum ator cadastrado.");
        } else {
            System.out.println("\n--- Lista de Atores ---");
            atores.forEach(ator -> System.out.println(ator.exibirInformacoes()));
        }
    }

    private static void removerAtor() {
        System.out.print("Digite o ID do ator a ser removido: ");
        int id = lerOpcao();
        // Assumed method in Controller
        ResultadoOperacao resultado = catalogoController.removerAtor(id);
        System.out.println(resultado.getMensagem());
    }


    // OPERAÇÕES: DIRETORES (Calls to Controller) ================================
    private static void cadastrarDiretor() {
        System.out.print("Digite o nome do diretor: ");
        String nome = scanner.nextLine();
        Diretor diretor = new Diretor(nome);

        ResultadoOperacao resultado = catalogoController.cadastrarDiretor(diretor);
        System.out.println(resultado.getMensagem());

        if(resultado.isSucesso()) {
            Diretor dirCadastrado = (Diretor) resultado.getDados();
            System.out.println("ID gerado: " + dirCadastrado.getId());
        }
    }

    private static void buscarDiretorPorId() {
        System.out.print("Digite o ID do diretor: ");
        int id = lerOpcao();
        // Assumed method in Controller
        Diretor diretor = catalogoController.buscarDiretorPorId(id);
        if (diretor != null) {
            System.out.println("Diretor encontrado: " + diretor.exibirInformacoes());
        } else {
            System.out.println("Diretor com ID " + id + " não encontrado.");
        }
    }

    private static void listarTodosDiretores() {
        // Assumed method in Controller
        List<Diretor> diretores = catalogoController.listarDiretores();
        if (diretores.isEmpty()) {
            System.out.println("Nenhum diretor cadastrado.");
        } else {
            System.out.println("\n--- Lista de Diretores ---");
            diretores.forEach(dir -> System.out.println(dir.exibirInformacoes()));
        }
    }

    private static void removerDiretor() {
        System.out.print("Digite o ID do diretor a ser removido: ");
        int id = lerOpcao();
        // Assumed method in Controller
        ResultadoOperacao resultado = catalogoController.removerDiretor(id);
        System.out.println(resultado.getMensagem());
    }


    // OPERAÇÕES: FILMES (Calls to Controller) ===================================
    private static void cadastrarFilme() {
        System.out.print("Digite o nome do filme: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a data de lançamento (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();
        try {
            LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Filme filme = new Filme(nome, data);

            ResultadoOperacao resultado = catalogoController.cadastrarFilme(filme);
            System.out.println(resultado.getMensagem());

            if (resultado.isSucesso()) {
                Filme filmeCadastrado = (Filme) resultado.getDados();
                System.out.println("ID gerado: " + filmeCadastrado.getId());
            }

        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
        }
    }

    private static void buscarFilmePorId() {
        System.out.print("Digite o ID do filme: ");
        int id = lerOpcao();
        // The controller method prints messages, we just need to display the result
        Filme filme = catalogoController.visualizarDetalhesFilme(id);
        if (filme != null) {
            System.out.println("Detalhes: " + filme.toString());
        }
    }

    private static void buscarFilmePorNome() {
        System.out.print("Digite o nome (ou parte do nome) do filme: ");
        String nome = scanner.nextLine();
        // The controller method prints messages, we just need to display the result
        List<Filme> filmes = catalogoController.pesquisarFilmePorNome(nome);
        if (filmes != null && !filmes.isEmpty()) {
            filmes.forEach(System.out::println);
        }
    }

    private static void listarTodosFilmes() {
        List<Filme> filmes = catalogoController.listarFilmes();
        if (filmes != null && !filmes.isEmpty()) {
            filmes.forEach(System.out::println);
        }
    }

    private static void atualizarFilme() {
        System.out.print("Digite o ID do filme que deseja atualizar: ");
        int id = lerOpcao();
        Filme filmeExistente = catalogoController.visualizarDetalhesFilme(id);

        if (filmeExistente == null) {
            return; // Message is already printed by the controller
        }

        System.out.print("Digite o novo nome para o filme (atual: '" + filmeExistente.getNome() + "'): ");
        String novoNome = scanner.nextLine();

        filmeExistente.setNome(novoNome); // Update the object in place

        ResultadoOperacao resultado = catalogoController.editarFilme(filmeExistente);
        System.out.println(resultado.getMensagem());
    }

    private static void removerFilme() {
        System.out.print("Digite o ID do filme a ser removido: ");
        int id = lerOpcao();
        ResultadoOperacao resultado = catalogoController.removerFilme(id);
        System.out.println(resultado.getMensagem());
    }

    private static void associarAtorAFilme() {
        System.out.print("Digite o ID do filme: ");
        int idFilme = lerOpcao();
        System.out.print("Digite o ID do ator: ");
        int idAtor = lerOpcao();

        ResultadoOperacao resultado = catalogoController.associarAtorFilme(idFilme, idAtor);
        System.out.println(resultado.getMensagem());
    }

    private static void associarDiretorAFilme() {
        System.out.print("Digite o ID do filme: ");
        int idFilme = lerOpcao();
        System.out.print("Digite o ID do diretor: ");
        int idDiretor = lerOpcao();

        ResultadoOperacao resultado = catalogoController.associarDiretorFilme(idFilme, idDiretor);
        System.out.println(resultado.getMensagem());
    }

    // UTILITÁRIOS ===============================================================
    private static int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.nextLine();
            return -1;
        }
    }

    private static void pressioneEnterParaContinuar() {
        System.out.print("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
}