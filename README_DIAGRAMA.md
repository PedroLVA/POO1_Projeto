# Diagrama de Classes - Sistema de Catálogo de Filmes

## 📊 Visão Geral

Este diagrama de classes no PlantUML representa a arquitetura completa do **Sistema de Catálogo de Filmes**, destacando todos os princípios de **Programação Orientada a Objetos (POO)** e o **padrão Facade** implementados.

## 🎯 Como Usar o Diagrama

### 1. **Visualização Online**
- Copie o conteúdo do arquivo `diagrama_classes.puml`
- Acesse: https://tinyurl.com/3u58ywea

### 2. **Cores e Diferenciação Visual**
O diagrama utiliza um **esquema de cores** para facilitar a identificação das camadas:

- 🔵 **Azul (Model)**: Entidades e classes de domínio
- 🟢 **Verde (Service)**: Lógica de negócio e operações CRUD  
- 🟡 **Amarelo (Controller)**: Fachada e controle do sistema
- 🟣 **Rosa (Exception)**: Tratamento de exceções

## 🏗️ Estrutura do Diagrama

### **Camadas Arquiteturais com Cores**

#### **1. Camada Model (6 classes) - 🔵 AZUL**
- **`Pessoa`**: Classe abstrata base
- **`Ator`**: Representa atores com filmografia
- **`Diretor`**: Representa diretores com filmes dirigidos
- **`Filme`**: Entidade principal do sistema
- **`FilmeAtor`**: Classe associativa para relacionamento N:N
- **`ResultadoOperacao`**: Classe utilitária com factory methods

#### **2. Camada Service (3 classes) - 🟢 VERDE**
- **`ICrudOperations<T>`**: Interface genérica para CRUD
- **`FilmeService`**: Lógica de negócio para filmes
- **`AtorService`**: Lógica de negócio para atores
- **`DiretorService`**: Lógica de negócio para diretores

#### **3. Camada Controller (1 classe) - 🟡 AMARELO**
- **`CatalogoController`**: Implementa o padrão Facade

#### **4. Camada Exception (3 classes) - 🟣 ROSA**
- **`CatalogoException`**: Exceção base do domínio
- **`PessoaNaoEncontradaException`**: Exceção específica para pessoas
- **`FIlmeNaoEncontradoException`**: Exceção específica para filmes

### **🎨 Esquema de Cores**

| Cor | Camada | Descrição | Emoji |
|-----|--------|-----------|-------|
| 🔵 **Azul** | Model | Entidades e classes de domínio | 📦 |
| 🟢 **Verde** | Service | Lógica de negócio e operações CRUD | ⚙️ |
| 🟡 **Amarelo** | Controller | Fachada e controle do sistema | 🎭 |
| 🟣 **Rosa** | Exception | Tratamento de exceções | ⚠️ |

## 🎨 Princípios de POO Destacados

### **1. Herança (Inheritance)**
```plantuml
Pessoa <|-- Ator : extends
Pessoa <|-- Diretor : extends
```
- **`Pessoa`**: Classe abstrata base
- **`Ator` e `Diretor`**: Classes filhas que herdam atributos e métodos

### **2. Polimorfismo (Polymorphism)**
- **Métodos Abstratos**: `validarDados()` e `exibirInformacoes()`
- **Sobrescrita**: Cada classe filha implementa de forma específica
- **Comportamento Dinâmico**: Mesmo método, comportamentos diferentes

### **3. Encapsulamento (Encapsulation)**
- **Atributos Privados**: `-` indica visibilidade privada
- **Getters/Setters**: Controle de acesso aos dados
- **Validação**: Nos setters para garantir integridade

### **4. Interface e Generics**
```plantuml
ICrudOperations <|.. FilmeService : implements
ICrudOperations <|.. AtorService : implements
ICrudOperations <|.. DiretorService : implements
```
- **Contrato**: Interface define métodos obrigatórios
- **Reutilização**: Generics permitem uso com diferentes tipos

### **5. Composição e Agregação**
```plantuml
CatalogoController *-- FilmeService : compõe
Filme o-- Ator : "0..* atores"
Filme o-- Diretor : "0..1 diretor"
```
- **Composição** (`*--`): Relacionamento forte, parte integrante
- **Agregação** (`o--`): Relacionamento fraco, pode existir independentemente

### **6. Padrão Facade**
- **`CatalogoController`**: Fachada que simplifica a interface
- **Orquestração**: Coordena múltiplos services
- **Abstração**: Esconde complexidade interna

## 🔗 Relacionamentos Representados

### **Herança**
- `Pessoa` → `Ator` e `Diretor`
- `CatalogoException` → `PessoaNaoEncontradaException` e `FIlmeNaoEncontradoException`

### **Implementação**
- `ICrudOperations<T>` implementado por `FilmeService`, `AtorService`, `DiretorService`

### **Composição**
- `CatalogoController` compõe `FilmeService`, `AtorService`, `DiretorService`

### **Agregação**
- `Filme` agrega `Ator` (0..*) e `Diretor` (0..1)
- `Ator` e `Diretor` agregam `Filme` (0..*)

### **Associação N:N**
- `Filme` ↔ `FilmeAtor` ↔ `Ator`

---

**Desenvolvido com PlantUML**
