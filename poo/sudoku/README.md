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

## ▶️ Como executar

### 1. Pré-requisitos

Para executar o projeto, é necessário ter instalado:

* **JDK 26 ou superior**
* **Maven**
* **Git**

O JavaFX é gerenciado pelo Maven. As dependências necessárias são baixadas automaticamente durante a execução do projeto, não sendo necessária uma instalação manual do JavaFX.

Para utilizar as funcionalidades de persistência, também é necessário:

* **PostgreSQL**

> O PostgreSQL não é necessário para validar o fluxo inicial da interface JavaFX. Ele é necessário para as funcionalidades que utilizam persistência de dados.

---

### 2. Clonar o projeto

Clone o repositório:

```bash
git clone https://github.com/foliveiradark/dio-java-fundamentos.git
```

Entre no diretório do projeto:

```bash
cd dio-java-fundamentos/poo/sudoku
```

---

### 3. Validar o ambiente Maven

Após clonar o projeto, valide inicialmente a configuração do ambiente:

```bash
mvn clean compile
```

Em seguida, execute os testes:

```bash
mvn test
```

A execução dessas etapas permite verificar, antes de iniciar a aplicação, se:

* o JDK está corretamente configurado;
* o Maven está disponível;
* as dependências do projeto podem ser resolvidas;
* o código pode ser compilado;
* os testes automatizados podem ser executados.

---

### 4. Executar a interface JavaFX

Para iniciar a aplicação gráfica:

```bash
mvn javafx:run
```

O Maven utiliza o plugin JavaFX configurado no `pom.xml` para iniciar a classe:

```text
ui.javafx.SudokuApplication
```

O fluxo atualmente implementado é:

```text
Abrir aplicação
      ↓
Visualizar tabuleiro
      ↓
Selecionar célula
      ↓
Inserir número
      ↓
Visualizar resultado
```

A interface JavaFX encontra-se em evolução e representa atualmente o **vertical slice inicial** da aplicação desktop.

---

### 5. Configurar o PostgreSQL

As funcionalidades de persistência utilizam PostgreSQL.

A aplicação está configurada para estabelecer a conexão utilizando os seguintes parâmetros:

```text
Host:     localhost
Porta:    5432
Banco:    sudoku
Usuário:  sudoku
Senha:    sudoku_dev
```

Esses parâmetros estão definidos atualmente na classe:

```text
persistence.ConnectionFactory
```

#### 5.1 Criar o usuário do banco

No PostgreSQL, crie o usuário utilizado pela aplicação:

```sql
CREATE USER sudoku WITH PASSWORD 'sudoku_dev';
```

#### 5.2 Criar o banco de dados

Crie o banco:

```sql
CREATE DATABASE sudoku OWNER sudoku;
```

#### 5.3 Criar as tabelas

Com o banco `sudoku` criado, execute o script:

```text
schema.sql
```

O script cria as estruturas necessárias para a persistência do Sudoku:

```text
tabuleiro
    ↓
casa

partida
    ↓
estado_casa
    ↓
candidato
```

A execução do script deve ser realizada no banco `sudoku`.

Por exemplo, utilizando o cliente `psql`:

```bash
psql -U sudoku -d sudoku -f schema.sql
```

> O comando acima pressupõe que o cliente `psql` esteja instalado e que o PostgreSQL esteja acessível em `localhost:5432`.

---

### 6. Executar a versão Console

A versão Console permanece disponível como uma das interfaces da aplicação.

Ela pode ser executada pela IDE, utilizando a classe `Main` como ponto de entrada.

A coexistência entre Console e JavaFX é intencional: as interfaces utilizam a mesma camada de orquestração e domínio, evitando duplicação das regras do Sudoku.

---

### 7. Sequência recomendada para uma nova estação

Para configurar e validar o projeto em uma nova estação de desenvolvimento, recomenda-se seguir esta sequência:

```text
Instalar JDK
      ↓
Instalar Maven
      ↓
Instalar Git
      ↓
Clonar repositório
      ↓
mvn clean compile
      ↓
mvn test
      ↓
mvn javafx:run
      ↓
Configurar PostgreSQL
      ↓
Criar banco sudoku
      ↓
Executar schema.sql
      ↓
Validar funcionalidades de persistência
```

Essa sequência permite separar a validação do ambiente Java da configuração específica necessária para persistência.

---

### 8. Ambiente de desenvolvimento

O projeto utiliza atualmente:

* Java 26
* JavaFX 26.0.1
* Maven
* PostgreSQL
* JDBC
* JUnit
* Git
* GitHub
* IntelliJ IDEA

As versões das principais dependências Java utilizadas pelo projeto estão definidas no arquivo `pom.xml`.

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
