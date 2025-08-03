# Como Usar o CatalogoController - Guia Simples

## 🎯 O que é o CatalogoController?

O `CatalogoController` é como um "gerente" do sistema de filmes. Ele organiza e coordena todas as operações relacionadas a filmes, atores e diretores.

### 📋 O que ele faz:
- ✅ Cadastra filmes, atores e diretores
- ✅ Busca informações no sistema
- ✅ Associa atores e diretores aos filmes
- ✅ Organiza todas as operações do sistema

---

## 📝 Exemplos Práticos

### **1. Criar o Controller**
```java
// Primeiro, criamos o controller (o "gerente")
CatalogoController controller = new CatalogoController();

// Agora podemos usar ele para fazer operações!
```

### **2. Cadastrar um Filme**
```java
// Vamos criar um filme
Filme titanic = new Filme("Titanic", "1997");

// Agora vamos cadastrar usando o controller
ResultadoOperacao resultado = controller.cadastrarFilme(titanic);

// Vamos ver o que aconteceu
if (resultado.isSucesso()) {
    System.out.println("✅ " + resultado.getMensagem());
} else {
    System.out.println("❌ " + resultado.getMensagem());
}
```

### **3. Buscar Filmes**
```java
// Buscar filmes pelo nome
List<Filme> filmesEncontrados = controller.pesquisarFilmePorNome("Titanic");

if (filmesEncontrados != null && !filmesEncontrados.isEmpty()) {
    System.out.println("🎬 Filmes encontrados:");
    for (Filme filme : filmesEncontrados) {
        System.out.println("- " + filme.getTitulo());
    }
} else {
    System.out.println("Nenhum filme encontrado");
}
```

### **4. Listar Todos os Filmes**
```java
// Ver todos os filmes cadastrados
List<Filme> todosOsFilmes = controller.listarFilmes();

if (todosOsFilmes != null) {
    System.out.println("📽️ Todos os filmes:");
    for (Filme filme : todosOsFilmes) {
        System.out.println("- " + filme.getTitulo() + " (" + filme.getAno() + ")");
    }
}
```

### **5. Ver Detalhes de um Filme**
```java
// Ver detalhes de um filme específico
Filme filmeDetalhado = controller.visualizarDetalhesFilme(1L);

if (filmeDetalhado != null) {
    System.out.println("🎭 Detalhes do filme:");
    System.out.println("Título: " + filmeDetalhado.getTitulo());
    System.out.println("Ano: " + filmeDetalhado.getAno());
    // ... outros detalhes
} else {
    System.out.println("Filme não encontrado");
}
```

---

## 🎭 Trabalhando com Atores e Diretores

### **Cadastrar um Ator**
```java
// Criar um ator
Ator leonardo = new Ator("Leonardo DiCaprio", "1974-11-11");

// Cadastrar o ator
ResultadoOperacao resultado = controller.cadastrarAtor(leonardo);

if (resultado.isSucesso()) {
    System.out.println("✅ Ator cadastrado: " + resultado.getMensagem());
} else {
    System.out.println("❌ Erro: " + resultado.getMensagem());
}
```

### **Cadastrar um Diretor**
```java
// Criar um diretor
Diretor cameron = new Diretor("James Cameron", "1954-08-16");

// Cadastrar o diretor
ResultadoOperacao resultado = controller.cadastrarDiretor(cameron);

if (resultado.isSucesso()) {
    System.out.println("✅ Diretor cadastrado: " + resultado.getMensagem());
} else {
    System.out.println("❌ Erro: " + resultado.getMensagem());
}
```

### **Associar Ator ao Filme**
```java
// Dizer que Leonardo participou do Titanic
ResultadoOperacao resultado = controller.associarAtorFilme(1L, 1L);

if (resultado.isSucesso()) {
    System.out.println("✅ " + resultado.getMensagem());
} else {
    System.out.println("❌ " + resultado.getMensagem());
}
```

---

## 🔧 Exemplo Completo de Uso

```java
public class ExemploUsoController {
    
    public static void main(String[] args) {
        // 1. Criar o controller
        CatalogoController controller = new CatalogoController();
        
        // 2. Cadastrar um filme
        Filme filme = new Filme("Avatar", "2009");
        ResultadoOperacao resultado = controller.cadastrarFilme(filme);
        
        if (resultado.isSucesso()) {
            System.out.println("🎬 Filme cadastrado com sucesso!");
            
            // 3. Buscar o filme
            List<Filme> filmes = controller.pesquisarFilmePorNome("Avatar");
            if (filmes != null && !filmes.isEmpty()) {
                System.out.println("✅ Filme encontrado: " + filmes.get(0).getTitulo());
            }
        } else {
            System.out.println("❌ Erro ao cadastrar filme: " + resultado.getMensagem());
        }
    }
}
```

---

## 📋 Resumo dos Métodos Principais

### **Para Filmes:**
- `cadastrarFilme(Filme)` - Cadastra um novo filme
- `pesquisarFilmePorNome(String)` - Busca filmes pelo nome
- `listarFilmes()` - Lista todos os filmes
- `visualizarDetalhesFilme(Long)` - Mostra detalhes de um filme
- `editarFilme(Filme)` - Edita um filme existente
- `removerFilme(Long)` - Remove um filme

### **Para Atores:**
- `cadastrarAtor(Ator)` - Cadastra um novo ator

### **Para Diretores:**
- `cadastrarDiretor(Diretor)` - Cadastra um novo diretor

### **Para Associações:**
- `associarAtorFilme(Long, Long)` - Liga um ator a um filme
- `associarDiretorFilme(Long, Long)` - Liga um diretor a um filme

---

## 💡 Dicas Importantes

### **✅ Boas Práticas:**
1. **Sempre verifique** o resultado das operações
2. **Use nomes descritivos** para variáveis
3. **Trate erros** adequadamente
4. **Organize o código** em seções lógicas

### **❌ Evite:**
1. **Não verificar** se as operações deram certo
2. **Usar nomes confusos** para variáveis
3. **Ignorar mensagens de erro**
4. **Misturar diferentes tipos** de operações

---

## 🎯 Resumo

O `CatalogoController` é sua interface principal com o sistema:
- ✅ **Centraliza** todas as operações
- ✅ **Organiza** o código de forma lógica
- ✅ **Facilita** o uso do sistema
- ✅ **Padroniza** as respostas

É como ter um "assistente" que organiza tudo para você! 🚀 