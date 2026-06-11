# 📚 Fundamentos Java - DIO

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-black?style=for-the-badge&logo=intellijidea)
![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-8.x-02303A?style=for-the-badge&logo=gradle&logoColor=white)

![Curso](https://img.shields.io/badge/DIO-Java%20Developer-purple?style=for-the-badge)
![Status](https://img.shields.io/badge/status-em%20aprendizado-blue?style=for-the-badge)
---

## 📖 Sobre o projeto

Repositório com exercícios práticos desenvolvidos durante minha formação em Java pela plataforma Digital Innovation One (DIO).

Este projeto documenta minha evolução desde os fundamentos da linguagem até conceitos mais avançados como tratamento de exceções, organização em camadas e gerenciamento de dependências com Maven.

O objetivo é registrar minha jornada de aprendizado e a evolução das boas práticas aplicadas ao desenvolvimento Java.

---

## 📂 Estrutura do projeto

```text
gradle/
  └── gradle-project

maven/
  └── maven-project

src/
    ├── controle
    ├── desafios
    ├── excecoes
    └── fundamentos
```

### Módulos

* **fundamentos** → conceitos básicos e operações iniciais
* **controle** → estruturas condicionais e estruturas de repetição
* **excecoes** → tratamento de erros, validações e CRUD de usuários
* **desafios** → Validação de cadastro, Contagem de códigos, Processamento de comandos
* **maven** → primeiros estudos sobre gerenciamento de dependências e build de projetos Java
* **Gradle** → primeiros estudos sobre gerenciamento de dependências e build de projetos Java

---

## 🔄 Evolução do projeto

### 📦 v1 — Implementação base (DIO)

Versão desenvolvida acompanhando as aulas da DIO, com foco em:

* Estrutura inicial de CRUD
* Introdução ao tratamento de exceções
* Organização básica do código

---

### 🚀 v2 — Versão refatorada (recomendada)

Refatoração completa aplicando boas práticas de desenvolvimento:

* Separação de responsabilidades (DAO, Validator, Model e Exceptions)
* Correção de bugs encontrados durante os estudos
* Padronização de exceções (checked e unchecked)
* Validação centralizada
* Código mais limpo e legível
* Estrutura mais próxima de aplicações reais

👉 Esta é a versão recomendada para análise.

---

## 🧠 Conceitos aplicados

### Fundamentos Java

* Entrada de dados com Scanner
* Tipos primitivos (`int`, `double`, `boolean`)
* Operações matemáticas
* Formatação de saída com `printf`

### Estruturas de Controle

* Condicionais (`if`, `else if`, `switch`)
* Operador ternário
* Estruturas de repetição (`for`, `while`, `do while`)
* Controle de fluxo

### Tratamento de Exceções

* `try`, `catch` e `finally`
* Checked Exceptions
* Unchecked Exceptions
* Exceptions customizadas
* Validação de regras de negócio

### Maven

* Instalação e configuração do Maven
* Estrutura padrão de projetos Maven
* Gerenciamento de dependências
* Configuração do `pom.xml`
* Ciclo de vida de build
* Integração de bibliotecas externas

### Gradle

* Instalação e configuração do Gradle
* Estrutura padrão de projetos Gradle
* Gerenciamento de dependências
* Configuração do arquivo `build.gradle` e`build.gradle.kts`
* Ciclo de vida de build e tasks
* Integração de bibliotecas externas
---

## 📌 Funcionalidades desenvolvidas

### ✔ Fundamentos

* Cálculo de idade
* Área do quadrado
* Área do retângulo
* Diferença de idade

### ✔ Estruturas de Controle

* Classificação de números
* Classificação por faixa etária
* Menu interativo
* Tabuada
* Soma acumulada
* Média de valores
* Loops com validações

### ✔ Tratamento de Exceções

* Entrada segura de dados
* Validação de regras de negócio
* Exceptions customizadas
* Simulação de CRUD com tratamento de erros

### ✔ Maven

* Criação de projeto Maven
* Configuração de dependências
* Build automatizado
* Organização padrão de projetos Java

### ✔ Gradle

* Criação de projetos Gradle
* Configuração de dependências
* Build automatizado com tasks personalizadas
* Estrutura flexível de projetos Java
* Uso de DSL (Groovy/Kotlin) para configuração do build

### 🔄 Migração entre Maven e Gradle

* Conversão de dependências entre pom.xml e build.gradle
* Adaptação de plugins e configurações de build
* Entendimento da equivalência entre scopes do Maven e configurations do Gradle
* Reestruturação da configuração do projeto durante a migração
* Comparação de ciclo de vida de build entre Maven e Gradle
* Identificação de diferenças de sintaxe e paradigma (XML vs DSL)
---

## 🛠 Tecnologias

* Java
* Maven
* Gradle
* IntelliJ IDEA
* Git
* GitHub

---

## 📈 Próximos passos

* Arrays e Collections
* Programação Orientada a Objetos (POO)
* Streams API
* Spring Boot
* APIs REST
* Banco de Dados
* JPA/Hibernate

---

## 🚀 Autor

Flávio Oliveira

GitHub:
https://github.com/foliveiradark