# Como Usar a Classe ResultadoOperacao - Guia Simples

## 🎯 O que é esta classe?

A classe `ResultadoOperacao` é como uma "caixa" que guarda informações sobre se uma operação deu certo ou não.

### 📦 O que ela guarda:
- **sucesso**: true (deu certo) ou false (deu erro)
- **mensagem**: um texto explicando o que aconteceu
- **dados**: informações extras (opcional)

---

## 📝 Exemplos Práticos

### **1. Cadastrar um Filme (Sucesso)**
```java
// Vamos cadastrar um filme
Filme filme = new Filme("Titanic", "1997");
boolean cadastrou = filmeService.cadastrar(filme);

if (cadastrou) {
    // Deu certo!
    ResultadoOperacao resultado = ResultadoOperacao.criarSucesso("Filme cadastrado com sucesso!");
    resultado.setDados(filme);  // guardamos o filme como dado extra
} else {
    // Deu erro!
    ResultadoOperacao resultado = ResultadoOperacao.criarErro("Não foi possível cadastrar o filme");
}
```

### **2. Buscar um Filme**
```java
// Vamos buscar um filme pelo ID
Filme filmeEncontrado = filmeService.buscarPorId(1L);

if (filmeEncontrado != null) {
    // Encontrou o filme!
    ResultadoOperacao resultado = ResultadoOperacao.criarSucesso("Filme encontrado!");
    resultado.setDados(filmeEncontrado);
} else {
    // Não encontrou!
    ResultadoOperacao resultado = ResultadoOperacao.criarErro("Filme não encontrado");
}
```

### **3. Como Verificar o Resultado**
```java
// Vamos ver o que aconteceu
ResultadoOperacao resultado = cadastrarFilme(meuFilme);

if (resultado.isSucesso()) {
    System.out.println("✅ " + resultado.getMensagem());
    
    if (resultado.temDados()) {
        Filme filme = (Filme) resultado.getDados();
        System.out.println("📽️ Filme: " + filme.getTitulo());
    }
} else {
    System.out.println("❌ " + resultado.getMensagem());
}
```

---

## 🔧 Métodos Principais

### **Criar Resultados:**
```java
// Criar sucesso
ResultadoOperacao sucesso = ResultadoOperacao.criarSucesso("Operação realizada!");

// Criar erro
ResultadoOperacao erro = ResultadoOperacao.criarErro("Algo deu errado!");
```

### **Verificar Resultados:**
```java
// Ver se deu certo
boolean deuCerto = resultado.isSucesso();

// Pegar a mensagem
String mensagem = resultado.getMensagem();

// Ver se tem dados extras
boolean temDados = resultado.temDados();

// Pegar os dados (precisa fazer cast)
if (resultado.temDados()) {
    Filme filme = (Filme) resultado.getDados();
}
```

### **Adicionar Dados:**
```java
// Adicionar dados depois de criar
resultado.setDados(meuFilme);
```

---

## 🎨 Exemplo Completo no Controller

```java
public ResultadoOperacao cadastrarFilme(Filme filme) {
    // 1. Verificar se o filme não é nulo
    if (filme == null) {
        return ResultadoOperacao.criarErro("Filme não pode ser nulo!");
    }
    
    // 2. Tentar cadastrar
    boolean cadastrou = filmeService.cadastrar(filme);
    
    // 3. Verificar o resultado
    if (cadastrou) {
        // Deu certo!
        ResultadoOperacao resultado = ResultadoOperacao.criarSucesso("Filme cadastrado com sucesso!");
        resultado.setDados(filme);  // guardamos o filme
        return resultado;
    } else {
        // Deu erro!
        return ResultadoOperacao.criarErro("Não foi possível cadastrar o filme");
    }
}
```

---

## 💡 Dicas Importantes

### **✅ Boas Práticas:**
1. **Sempre verifique** se o resultado foi bem-sucedido antes de usar os dados
2. **Use mensagens claras** que expliquem o que aconteceu
3. **Adicione dados úteis** quando fizer sentido

### **❌ Evite:**
1. **Não verificar** se tem dados antes de usar `getDados()`
2. **Mensagens confusas** que não explicam o problema
3. **Esquecer de fazer cast** quando pegar os dados

---

## 🎯 Resumo

A classe `ResultadoOperacao` é simples e útil para:
- ✅ Informar se uma operação deu certo ou não
- ✅ Explicar o que aconteceu com uma mensagem
- ✅ Guardar dados extras quando necessário
- ✅ Padronizar o retorno de operações no sistema

É uma forma organizada de lidar com sucessos e erros no seu programa! 🚀 