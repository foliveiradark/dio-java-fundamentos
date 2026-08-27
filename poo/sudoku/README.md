# 🧩 Sudoku em Java

## 📖 Sobre o projeto

Projeto desenvolvido em Java como parte da minha jornada de aprendizado em Programação Orientada a Objetos e Engenharia de Software.

Mais do que implementar um jogo de Sudoku, o objetivo deste projeto é aplicar práticas de desenvolvimento profissional, utilizando arquitetura em camadas, documentação técnica, decisões arquiteturais (ADRs) e desenvolvimento incremental orientado por User Stories e Sprints.

O projeto evoluiu de uma aplicação inicialmente orientada ao Console para um jogo desktop com persistência de partidas e uma primeira interface gráfica desenvolvida com JavaFX.

---

## 🎯 Objetivos

* Desenvolver um jogo de Sudoku funcional em Java utilizando Programação Orientada a Objetos.
* Aplicar conceitos de arquitetura de software e separação de responsabilidades durante a implementação.
* Exercitar um fluxo de desenvolvimento incremental baseado em User Stories, Sprints e decisões arquiteturais.
* Aplicar persistência de dados utilizando PostgreSQL e JDBC.
* Explorar o desenvolvimento de interfaces gráficas desktop utilizando JavaFX.
* Construir um projeto organizado e bem documentado que possa compor um portfólio técnico.

---

## 🎮 Demonstração

> 🚧 Em construção.

O projeto possui atualmente uma primeira versão gráfica funcional desenvolvida com JavaFX, ainda em evolução.

---

## ✨ Funcionalidades implementadas

### 🎮 Jogabilidade

* Início de uma nova partida.
* Inserção e remoção de números no tabuleiro.
* Limpeza das jogadas realizadas pelo jogador.
* Sistema de rascunhos com múltiplos candidatos por casa.
* Encerramento automático quando o Sudoku é concluído corretamente.

### 📋 Interface Console

* Menu principal para navegação.
* Entrada de coordenadas no formato **A1–I9**.
* Tabuleiro organizado com separação visual dos blocos 3×3 utilizando caracteres Unicode.
* Identificação das linhas e colunas para facilitar a navegação.
* Validação de entradas e confirmações.
* Preservação da interface Console após a introdução da interface gráfica.

### 🖥️ Interface gráfica

* Primeira aplicação gráfica utilizando JavaFX.
* Apresentação gráfica do tabuleiro.
* Seleção de casas.
* Inserção de números através da interface gráfica.
* Atualização visual do tabuleiro após uma jogada.
* Primeiro vertical slice jogável do produto.

> A interface JavaFX ainda não possui paridade funcional com a interface Console. Sua evolução ocorrerá de forma incremental nas próximas etapas do projeto.

### ✔ Validações

* Tratamento de entradas inválidas e não numéricas.
* Validação das opções do menu principal.
* Validação das respostas de confirmação (S/N).
* Proteção das casas fixas contra alterações.
* Validação das regras das jogadas.
* Verificação de linhas, colunas e blocos 3×3.
* Validação da consistência entre candidatos e números definitivos.

### 💾 Persistência

* Persistência do estado da partida.
* Salvamento de partidas em andamento.
* Restauração de partidas previamente salvas.
* Continuação da partida a partir do estado persistido.
* Persistência de números definitivos e candidatos.
* Confirmação antes da sobrescrita de uma partida existente.

### 📊 Acompanhamento da partida

* Verificação do status da partida.
* Identificação de tabuleiro incompleto, válido ou inválido.
* Atualização da interface após cada ação do jogador.

---

## 🏗 Arquitetura

A aplicação utiliza uma arquitetura em camadas simples, com foco na separação de responsabilidades, baixo acoplamento e evolução incremental.

A partir da Sprint 19, a arquitetura passou a permitir múltiplas interfaces de interação. A Sprint 20 validou essa abordagem através da introdução do JavaFX.

O fluxo de alto nível pode ser representado da seguinte forma:

```text
                         Main
                          │
                          ▼
                     JogoSudoku
                    Orquestração
                          │
              ┌───────────┴───────────┐
              ▼                       ▼
          Console                  JavaFX
          Interface               Interface
              │                       │
              └───────────┬───────────┘
                          ▼
                       Domínio
                    ┌─────┴─────┐
                    ▼           ▼
                Tabuleiro      Casa
                          │
                          ▼
                     Persistência
```

A interface de usuário não deve assumir responsabilidades pertencentes ao domínio ou à persistência.

A persistência é realizada por meio de repositórios, mantendo o acesso aos dados separado das regras do jogo.

📖 A documentação arquitetural completa, incluindo fluxos de negócio, responsabilidades das camadas e decisões arquiteturais (ADRs), está disponível em [docs/04-arquitetura.md](docs/04-arquitetura.md).

---

## 📂 Estrutura do projeto

O projeto utiliza a estrutura padrão de aplicações Java com Maven, mantendo o código-fonte separado da documentação técnica.

```text
sudoku
├── src/
│   └── main/
│       └── java/
│           ├── enums/
│           ├── model/
│           ├── persistence/
│           ├── service/
│           ├── ui/
│           │   └── javafx/
│           └── util/
│
├── docs/
│   ├── decisoes/
│   ├── diagramas/
│   ├── sprints/
│   ├── stories/
│   ├── 00-guia-de-desenvolvimento.md
│   ├── 01-requisitos.md
│   ├── 02-modelagem.md
│   ├── 03-diario-de-desenvolvimento.md
│   ├── 04-arquitetura.md
│   ├── 05-backlog.md
│   ├── 06-roadmap.md
│   └── 07-marcos-do-projeto.md
│
├── pom.xml
├── CHANGELOG.md
└── README.md
```

### Principais diretórios

| Diretório/Arquivo | Descrição                                                                                               |
| ----------------- | ------------------------------------------------------------------------------------------------------- |
| `src/main/java/`  | Código-fonte principal da aplicação.                                                                    |
| `model/`          | Entidades e regras relacionadas ao domínio do Sudoku.                                                   |
| `service/`        | Orquestração e serviços da aplicação.                                                                   |
| `ui/`             | Interfaces de interação com o usuário.                                                                  |
| `ui/javafx/`      | Implementação da interface gráfica JavaFX.                                                              |
| `persistence/`    | Repositórios e infraestrutura de persistência.                                                          |
| `docs/`           | Documentação técnica, requisitos, arquitetura, backlog, decisões, User Stories e histórico das Sprints. |
| `pom.xml`         | Configuração do Maven e gerenciamento das dependências do projeto.                                      |
| `CHANGELOG.md`    | Registro das funcionalidades e melhorias implementadas ao longo do projeto.                             |
| `README.md`       | Visão geral do projeto e ponto de entrada para a documentação.                                          |

---

# 📚 Documentação

A documentação foi construída de forma incremental durante todo o desenvolvimento do projeto, registrando tanto a evolução técnica quanto as decisões de engenharia adotadas em cada etapa.

Ela está organizada em diferentes categorias:

| Documento                                 | Objetivo                                                                             |
| ----------------------------------------- | ------------------------------------------------------------------------------------ |
| **Guia de Desenvolvimento**               | Define o fluxo de trabalho utilizado durante a implementação do projeto.             |
| **Requisitos e Modelagem**                | Descrevem o problema, as funcionalidades e a estrutura do domínio.                   |
| **Arquitetura**                           | Documenta a organização da aplicação e a responsabilidade das camadas.               |
| **Product Backlog**                       | Centraliza as User Stories e sua priorização.                                        |
| **Roadmap**                               | Apresenta a evolução planejada do projeto.                                           |
| **User Stories**                          | Especificam cada funcionalidade implementada.                                        |
| **Sprints**                               | Registram o planejamento, execução e encerramento de cada ciclo de desenvolvimento.  |
| **Diário de Desenvolvimento**             | Documenta aprendizados, decisões e dificuldades encontradas durante a implementação. |
| **ADRs (Architectural Decision Records)** | Registram as principais decisões arquiteturais tomadas ao longo do projeto.          |
| **Marcos do Projeto**                     | Consolidam as principais entregas e a evolução do sistema.                           |
| **CHANGELOG**                             | Histórico das funcionalidades e melhorias implementadas.                             |

Toda essa documentação é mantida sincronizada com a evolução do código, permitindo acompanhar não apenas o resultado, mas também o processo utilizado para construí-lo.

---

# 🛠 Tecnologias e conceitos aplicados

| Tecnologia        | Aplicação no projeto                                                                                                    |
| ----------------- | ----------------------------------------------------------------------------------------------------------------------- |
| **Java**          | Desenvolvimento da aplicação utilizando Programação Orientada a Objetos.                                                |
| **JavaFX**        | Desenvolvimento da primeira interface gráfica desktop.                                                                  |
| **Maven**         | Gerenciamento do projeto, dependências e processo de build.                                                             |
| **PostgreSQL**    | Persistência das partidas.                                                                                              |
| **JDBC**          | Comunicação entre a aplicação Java e o banco de dados.                                                                  |
| **Docker**        | Execução do ambiente PostgreSQL durante o desenvolvimento.                                                              |
| **JUnit**         | Testes automatizados e validação do comportamento da aplicação.                                                         |
| **IntelliJ IDEA** | Ambiente de desenvolvimento utilizado durante a implementação.                                                          |
| **Git**           | Controle de versão baseado em commits incrementais durante cada Sprint.                                                 |
| **GitHub**        | Versionamento, documentação e publicação do projeto.                                                                    |
| **Markdown**      | Documentação técnica do projeto, incluindo requisitos, arquitetura, backlog, Sprints, ADRs e diário de desenvolvimento. |

---

# 🚀 Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/foliveiradark/dio-java-fundamentos.git
```

### 2. Acesse o projeto

```bash
cd dio-java-fundamentos/poo/sudoku
```

### 3. Requisitos

* Java JDK 26 ou superior;
* Maven;
* PostgreSQL, caso sejam utilizadas as funcionalidades de persistência.

### 4. Compile o projeto

Utilize o Maven para realizar o build:

```bash
mvn clean package
```

### 5. Execute a interface gráfica

A primeira interface gráfica do projeto utiliza JavaFX.

Para iniciar a aplicação configurada no Maven:

```bash
mvn javafx:run
```

A aplicação será iniciada apresentando o primeiro vertical slice jogável do Sudoku.

O fluxo atualmente disponível na interface gráfica contempla:

```text
Abrir aplicação
↓
Visualizar tabuleiro
↓
Selecionar casa
↓
Inserir número
↓
Visualizar resultado
```

### 6. Execute a interface Console

A interface Console permanece disponível como implementação alternativa.

A classe `Main` continua sendo a entrada da aplicação em modo texto.

A execução pela IDE pode ser realizada utilizando a classe:

```text
Main
```

> A interface gráfica JavaFX e a interface Console coexistem no projeto. A GUI encontra-se em evolução e ainda não possui paridade funcional com a interface Console.

---

# 🗺 Roadmap

O projeto iniciou como uma aplicação Java em modo texto e evoluiu progressivamente para um jogo desktop com persistência e interface gráfica.

Atualmente, o projeto encontra-se na fase de evolução da interface gráfica utilizando JavaFX.

### Próximas etapas

* 🎨 Refinamento progressivo da interface gráfica;
* 🧩 Ampliação das funcionalidades disponíveis na GUI;
* 📋 Integração progressiva das funcionalidades existentes à interface gráfica;
* 📊 Estatísticas da partida;
* 🎯 Novos níveis de dificuldade;
* 🧩 Geração automática de tabuleiros;
* 📦 Preparação da aplicação para distribuição.

O planejamento completo, incluindo as fases concluídas e as possibilidades futuras, está disponível em:

📄 [docs/06-roadmap.md](docs/06-roadmap.md)

---

# 🎓 Principais conceitos praticados

Ao longo do desenvolvimento deste projeto foram aplicados conceitos fundamentais de Java e Engenharia de Software, entre eles:

* Programação Orientada a Objetos;
* Encapsulamento e abstração;
* Arquitetura em camadas;
* Separação de responsabilidades;
* Baixo acoplamento e alta coesão;
* Desenvolvimento incremental;
* Refatoração contínua;
* Persistência de dados;
* Desenvolvimento de aplicações desktop;
* Desenvolvimento orientado por User Stories e Sprints;
* Documentação técnica;
* Versionamento com Git e GitHub;
* Registro de Decisões Arquiteturais (ADR);
* Evolução arquitetural incremental.

Para conhecer em mais detalhes a evolução do projeto, consulte:

* 📐 [Arquitetura](docs/04-arquitetura.md)
* 🗺️ [Roadmap](docs/06-roadmap.md)
* 📝 [Diário de Desenvolvimento](docs/03-diario-de-desenvolvimento.md)
* 📚 [Decisões Arquiteturais (ADRs)](docs/decisoes)

---

# 📌 Status

**Status atual:** Primeiro vertical slice gráfico funcional

O projeto possui uma versão funcional em modo texto, persistência de partidas e uma primeira interface gráfica JavaFX capaz de executar uma operação real de uma partida.

A interface gráfica continua em desenvolvimento e não possui paridade funcional com a interface Console. Sua evolução continuará de forma incremental, utilizando a arquitetura preparada nas Sprints anteriores.

O objetivo de longo prazo é transformar o projeto em um jogo desktop completo, jogável e distribuível, mantendo o foco simultâneo no desenvolvimento técnico, na qualidade arquitetural e na documentação da evolução.

---

## 👨‍💻 Autor

Desenvolvido por **Flávio Oliveira** como parte da construção do meu portfólio de desenvolvimento de software, documentando a evolução técnica ao longo do processo.

Este projeto representa não apenas o aprendizado da linguagem, mas também a aplicação prática de princípios de Arquitetura de Software, Engenharia de Software e desenvolvimento incremental orientado por documentação.

* GitHub: https://github.com/foliveiradark
* LinkedIn: https://www.linkedin.com/in/flaviocoliveira/
