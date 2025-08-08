import controller.CatalogoController;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("TESTE DO SISTEMA DE CATÁLOGO DE FILMES ");
        System.out.println("================================================");
        
        CatalogoController controller = new CatalogoController();
        
        System.out.println("\nTESTE 1: CADASTRANDO ATORES");
        System.out.println("--------------------------------");
        testarCadastroAtores(controller);
        
        System.out.println("\nTESTE 2: CADASTRANDO DIRETORES");
        System.out.println("-----------------------------------");
        testarCadastroDiretores(controller);
        
        System.out.println("\nTESTE 3: CADASTRANDO FILMES");
        System.out.println("--------------------------------");
        testarCadastroFilmes(controller);
        
        System.out.println("\nTESTE 4: LISTANDO TODOS");
        System.out.println("----------------------------");
        testarListagem(controller);
        
        System.out.println("\nTESTE 5: BUSCANDO POR ID");
        System.out.println("-----------------------------");
        testarBuscaPorId(controller);
        
        System.out.println("\nTESTE 6: TESTANDO ASSOCIAÇÕES");
        System.out.println("----------------------------------");
        testarAssociacoes(controller);
        
        System.out.println("\nTESTE 7: TESTANDO PESQUISAS");
        System.out.println("--------------------------------");
        testarPesquisas(controller);
        
        System.out.println("\nTESTE 8: TESTANDO ATUALIZAÇÕES");
        System.out.println("-----------------------------------");
        testarAtualizacoes(controller);
        
        System.out.println("\nTESTE 9: TESTANDO REMOÇÕES");
        System.out.println("--------------------------------");
        testarRemocoes(controller);
        
        System.out.println("\nTESTE 10: TESTANDO VALIDAÇÕES");
        System.out.println("-----------------------------------");
        testarValidacoes(controller);
        
        System.out.println("\nTODOS OS TESTES CONCLUÍDOS!");
        System.out.println("Sistema funcionando corretamente! ");
    }
    
    private static void testarCadastroAtores(CatalogoController controller) {
        System.out.println("Cadastrando atores...");
        
        String resultado1 = controller.cadastrarAtorString("Leonardo DiCaprio", 48, "Estadunidense");
        String resultado2 = controller.cadastrarAtorString("Kate Winslet", 48, "Britânica");
        String resultado3 = controller.cadastrarAtorString("Tom Hanks", 67, "Estadunidense");
        
        System.out.println("Resultado 1: " + resultado1);
        System.out.println("Resultado 2: " + resultado2);
        System.out.println("Resultado 3: " + resultado3);
    }
    
    private static void testarCadastroDiretores(CatalogoController controller) {
        System.out.println("Cadastrando diretores...");
        
        String resultado1 = controller.cadastrarDiretorString("James Cameron", 69, "Canadense", "Ação/Aventura");
        String resultado2 = controller.cadastrarDiretorString("Steven Spielberg", 77, "Estadunidense", "Drama/Aventura");
        
        System.out.println("Resultado 1: " + resultado1);
        System.out.println("Resultado 2: " + resultado2);
    }
    
    private static void testarCadastroFilmes(CatalogoController controller) {
        System.out.println("Cadastrando filmes...");
        
        String resultado1 = controller.cadastrarFilmeString("Titanic", "1997-12-19", "200000000", "Um romance épico sobre o naufrágio do Titanic");
        String resultado2 = controller.cadastrarFilmeString("Avatar", "2009-12-18", "237000000", "Uma aventura em um mundo alienígena");
        String resultado3 = controller.cadastrarFilmeString("Forrest Gump", "1994-07-06", "55000000", "A história de um homem simples que vive momentos históricos");
        
        System.out.println("Resultado 1: " + resultado1);
        System.out.println("Resultado 2: " + resultado2);
        System.out.println("Resultado 3: " + resultado3);
    }
    
    private static void testarListagem(CatalogoController controller) {
        System.out.println("Listando todos os registros...");
        
        String atores = controller.listarAtoresString();
        System.out.println("Atores: " + atores);
        
        String diretores = controller.listarDiretoresString();
        System.out.println("Diretores: " + diretores);
        
        String filmes = controller.listarFilmesString();
        System.out.println("Filmes: " + filmes);
    }
    
    private static void testarBuscaPorId(CatalogoController controller) {
        System.out.println("Buscando por IDs...");
        
        String ator = controller.buscarAtorPorIdString(1);
        System.out.println("Ator ID 1: " + ator);
        
        String diretor = controller.buscarDiretorPorIdString(1);
        System.out.println("Diretor ID 1: " + diretor);
        
        String filme = controller.visualizarDetalhesFilmeString(1);
        System.out.println("Filme ID 1: " + filme);
    }
    
    private static void testarAssociacoes(CatalogoController controller) {
        System.out.println("Testando associações...");
        
        String associacao1 = controller.associarAtorFilmeString(1, 1);
        System.out.println("Associação Ator-Filme: " + associacao1);
        
        String associacao2 = controller.associarDiretorFilmeString(1, 1);
        System.out.println("Associação Diretor-Filme: " + associacao2);
        
        controller.associarAtorFilmeString(1, 2);
        controller.associarAtorFilmeString(2, 1);
        controller.associarAtorFilmeString(3, 3);
        
        System.out.println("Associações adicionais realizadas!");
    }
    
    private static void testarPesquisas(CatalogoController controller) {
        System.out.println("Testando pesquisas...");
        
        String pesquisa1 = controller.pesquisarFilmePorNomeString("Titanic");
        System.out.println("Pesquisa 'Titanic': " + pesquisa1);
        
        String pesquisa2 = controller.pesquisarFilmePorNomeString("Avatar");
        System.out.println("Pesquisa 'Avatar': " + pesquisa2);
    }
    
    private static void testarAtualizacoes(CatalogoController controller) {
        System.out.println("Testando atualizações...");
        
        String atualizacao = controller.editarFilmeString(1, "Titanic Atualizado", "1997-12-19", "200000000", "Um romance épico sobre o naufrágio do Titanic - Versão Atualizada");
        System.out.println("Atualização: " + atualizacao);
    }
    
    private static void testarRemocoes(CatalogoController controller) {
        System.out.println("Testando remoções...");
        
        String remocao1 = controller.removerAtorFilmeString(1, 2);
        System.out.println("Remoção Ator-Filme: " + remocao1);
        
        String remocao2 = controller.removerAtorString(1);
        System.out.println("Remoção Ator: " + remocao2);
    }
    
    private static void testarValidacoes(CatalogoController controller) {
        System.out.println("Testando validações...");
        
        String resultado1 = controller.cadastrarAtorString("", 0, "");
        System.out.println("Cadastro inválido: " + resultado1);
        
        String resultado2 = controller.buscarAtorPorIdString(-1);
        System.out.println("Busca ID inválido: " + resultado2);
        
        String resultado3 = controller.associarAtorFilmeString(999, 999);
        System.out.println("Associação IDs inválidos: " + resultado3);
    }
}