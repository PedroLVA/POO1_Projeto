![Alt text](https://ada-strapi-production.s3.sa-east-1.amazonaws.com/Thumb_Metatag_1c7d5326d2.jpg)

# Catálogo de Filmes 🎬

Desenvolvido como parte do desafio de projeto do Mercado Livre. O objetivo é criar um sistema de catálogo de filmes, similar ao IMDb, aplicando os principais conceitos de Programação Orientada a Objetos (POO).

## 📝 Descrição do Projeto

Desenvolvido como parte do desafio de projeto do Mercado Livre. O objetivo é criar um sistema de catálogo de filmes, similar ao IMDb, aplicando os principais conceitos de Programação Orientada a Objetos (POO).

## ✨ Funcionalidades

O projeto é uma aplicação de console que permite aos usuários gerenciar um catálogo de filmes. É possível cadastrar novos filmes com seus respectivos atributos (título, data de lançamento, orçamento, descrição), bem como cadastrar os diretores e atores que participaram dessas produções. O sistema também permite a associação entre filmes, atores e diretores, e oferece uma funcionalidade de busca para encontrar filmes pelo nome.

## 🏛️ O Pilar da Programação Orientada a Objetos

Este projeto foi estruturado para aplicar e demonstrar os quatro pilares fundamentais da POO:

#### 1\. **Herança e Classes Abstratas**

  - Foi criada uma classe abstrata `Pessoa` que contém atributos e métodos comuns a `Ator` e `Diretor`, como `nome` e `dataNascimento`.
  - As classes `Ator` e `Diretor` herdam de `Pessoa`, reutilizando código e estabelecendo uma relação de "é um".

#### 2\. **Encapsulamento**

  - Todos os atributos das classes (`Filme`, `Pessoa`, `Ator`, `Diretor`) são declarados como `private`. O acesso a eles é feito de forma controlada através de métodos públicos `getters` e `setters`, garantindo a integridade e a segurança dos dados dos objetos.

#### 3\. **Polimorfismo**

  - O polimorfismo é aplicado, por exemplo, em métodos que podem ter comportamentos diferentes nas subclasses. Um método `apresentar()` na classe `Pessoa` pode ser sobrescrito em `Ator` e `Diretor` para exibir informações específicas de cada papel (ex: "Atuou em X filmes" vs. "Dirigiu Y filmes").

#### 4\. **Associação entre Classes**

  - A estrutura do sistema demonstra a associação entre objetos:
      - Um `Filme` possui **um** objeto `Diretor`.
      - Um `Filme` possui uma **lista** de objetos `Ator`.

## UML - Diagrama de Classes

Abaixo está o diagrama de classes que representa a arquitetura do sistema:



## 🛠️ Tecnologias Utilizadas

  - **Linguagem:** Java (ou a linguagem que seu grupo escolher)
  - **IDE:** IntelliJ IDEA
  - **Controle de Versão:** Git e GitHub
  - **Organização:** Trello


## 👥 Equipe e Contribuições

Este projeto foi desenvolvido com a colaboração dos seguintes integrantes:
  - [Elaine Fabiola Soares](https://github.com/elainefabiola)
  - [Pedro Athayde](https://github.com/PedroLVA)




