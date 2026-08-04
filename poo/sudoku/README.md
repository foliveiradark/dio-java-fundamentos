# 🧩 Sudoku em Java

## 📖 Sobre o projeto
Projeto desenvolvido em Java como parte da minha jornada de aprendizado em Programação Orientada a Objetos e Engenharia de Software.

Mais do que implementar um jogo de Sudoku em modo texto, o objetivo deste projeto foi aplicar práticas de desenvolvimento profissional, utilizando arquitetura em camadas, documentação técnica, decisões arquiteturais (ADRs) e desenvolvimento incremental orientado por User Stories e Sprints.

---

## 🎯 Objetivos

* Desenvolver um jogo de Sudoku funcional em Java utilizando Programação Orientada a Objetos.
* Aplicar conceitos de arquitetura de software e separação de responsabilidades durante a implementação.
* Exercitar um fluxo de desenvolvimento incremental baseado em User Stories, Sprints e decisões arquiteturais.
* Construir um projeto organizado e bem documentado que possa compor um portfólio técnico.

---

## 🎮 Demonstração

> 🚧 Em construção.
---

## ✨ Funcionalidades implementadas

### 🎮 Jogabilidade

* Início de uma nova partida.
* Inserção e remoção de números no tabuleiro.
* Limpeza das jogadas realizadas pelo jogador.
* Encerramento automático quando o Sudoku é concluído corretamente.

### 📋 Interface

* Menu principal para navegação.
* Entrada de coordenadas no formato **A1–I9**.
* Tabuleiro organizado com separação visual dos blocos 3×3 utilizando caracteres Unicode.
* Identificação das linhas e colunas para facilitar a navegação.

### ✔ Validações

* Tratamento de entradas inválidas e não numéricas.
* Validação das opções do menu principal.
* Validação das respostas de confirmação (S/N).
* Proteção das casas fixas contra alterações.

### 📊 Acompanhamento da partida

* Verificação do status da partida.
* Identificação de tabuleiro incompleto, válido ou inválido.
* Atualização automática da interface após cada ação do jogador.

---

## 🏗 Arquitetura

A aplicação foi desenvolvida utilizando uma arquitetura em camadas simples, com foco na separação de responsabilidades, baixo acoplamento e evolução incremental.

O fluxo da aplicação é coordenado pela classe `JogoSudoku`, enquanto a lógica de negócio permanece isolada da interface de usuário, permitindo futuras evoluções, como persistência de partidas, testes automatizados e interface gráfica, sem alterar o domínio da aplicação.

```text
                 Main
                  │
                  ▼
            JogoSudoku
          (coordena o fluxo)
                  │
      ┌───────────┴───────────┐
      ▼                       ▼
ConsoleInput           ConsolePrinter
      │
      ▼
            Tabuleiro
                  │
                  ▼
                Casa
```

📖 A documentação arquitetural completa, incluindo fluxos de negócio, responsabilidades das
camadas e decisões arquiteturais (ADRs), está disponível em
[docs/04-arquitetura.md](docs/04-arquitetura.md).

---

## 📂 Estrutura do projeto

O projeto está organizado de forma a separar claramente o código-fonte da documentação técnica, facilitando a manutenção, a evolução da aplicação e a rastreabilidade das decisões tomadas durante o desenvolvimento.
```text
sudoku
├── src/
│   ├── model/
│   ├── service/
│   ├── ui/
│   ├── util/
│   └── Main.java
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
├── CHANGELOG.md
└── README.md
```

### Principais diretórios

| Diretório      | Descrição                                                                                                                    |
| -------------- | ---------------------------------------------------------------------------------------------------------------------------- |
| `src/`         | Código-fonte da aplicação, organizado por responsabilidade.                                                                  |
| `docs/`        | Documentação técnica, requisitos, arquitetura, backlog, decisões arquiteturais (ADRs), User Stories e histórico das Sprints. |
| `CHANGELOG.md` | Registro das funcionalidades e melhorias implementadas ao longo do projeto.                                                  |
| `README.md`    | Visão geral do projeto e ponto de entrada para a documentação.                                                               |

Essa organização foi planejada para aproximar o projeto de uma estrutura utilizada em ambientes profissionais, integrando código, documentação e histórico de evolução em um único repositório.

---

# 📚 Documentação

A documentação foi construída de forma incremental durante todo o desenvolvimento do projeto, registrando tanto a evolução técnica quanto as decisões de engenharia adotadas em cada etapa.

Ela está organizada em diferentes categorias:

| Documento | Objetivo |
|-----------|----------|
| **Guia de Desenvolvimento** | Define o fluxo de trabalho utilizado durante a implementação do projeto. |
| **Requisitos e Modelagem** | Descrevem o problema, as funcionalidades e a estrutura do domínio. |
| **Arquitetura** | Documenta a organização da aplicação e a responsabilidade das camadas. |
| **Product Backlog** | Centraliza as User Stories e sua priorização. |
| **Roadmap** | Apresenta a evolução planejada do projeto. |
| **User Stories** | Especificam cada funcionalidade implementada. |
| **Sprints** | Registram o planejamento, execução e encerramento de cada ciclo de desenvolvimento. |
| **Diário de Desenvolvimento** | Documenta aprendizados, decisões e dificuldades encontradas durante a implementação. |
| **ADRs (Architectural Decision Records)** | Registram as principais decisões arquiteturais tomadas ao longo do projeto. |
| **Marcos do Projeto** | Consolidam as principais entregas e a evolução do sistema. |
| **CHANGELOG** | Histórico das funcionalidades e melhorias implementadas. |

Toda essa documentação foi mantida sincronizada com a evolução do código, permitindo acompanhar não apenas o resultado final, mas também o processo utilizado para construí-lo.

---

# 🛠 Tecnologias e conceitos aplicados

| Tecnologia | Aplicação no projeto |
|------------|----------------------|
| **Java** | Desenvolvimento de toda a aplicação utilizando Programação Orientada a Objetos. |
| **Programação Orientada a Objetos** | Aplicação de encapsulamento, responsabilidade das classes, separação de camadas e organização do domínio. |
| **IntelliJ IDEA** | Ambiente de desenvolvimento utilizado durante toda a implementação. |
| **Git** | Controle de versão baseado em commits incrementais durante cada Sprint. |
| **GitHub** | Versionamento, documentação e publicação do projeto. |
| **Markdown** | Documentação técnica do projeto, incluindo requisitos, arquitetura, backlog, sprints, ADRs e diário de desenvolvimento. |

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

### 3. Abra o projeto

Abra a pasta `poo/sudoku` em sua IDE Java de preferência (IntelliJ IDEA, Eclipse ou VS Code).

### 4. Execute a aplicação

Execute a classe `Main`


A aplicação será iniciada em modo texto, exibindo o Menu Principal do jogo.

---

### Requisitos

- Java JDK 21 ou superior *(ou a versão utilizada no projeto)*
- IDE compatível com Java

---

# 🗺 Roadmap

O MVP em modo texto foi concluído e documentado.

A partir deste ponto, o projeto entra em uma nova fase de evolução, mantendo a arquitetura construída e ampliando gradualmente suas funcionalidades.

### Próximas etapas

- 📊 Estatísticas da partida;
- 💾 Continuação e persistência de partidas;
- 🧪 Testes automatizados;
- 🖥️ Interface gráfica utilizando Swing;
- 🎯 Novos níveis de dificuldade;
- 🧩 Gerador automático de tabuleiros.

Para conhecer o planejamento completo da evolução do projeto, consulte o documento:

📄 [docs/06-roadmap.md](docs/06-roadmap.md)

---

# 🎓 Principais conceitos praticados

Ao longo do desenvolvimento deste projeto foram aplicados conceitos fundamentais de Java e Engenharia de Software, entre eles:

- Programação Orientada a Objetos;
- Encapsulamento e abstração;
- Arquitetura em camadas;
- Separação de responsabilidades;
- Baixo acoplamento e alta coesão;
- Desenvolvimento incremental;
- Refatoração contínua;
- Documentação técnica;
- Versionamento com Git e GitHub.

Para conhecer em mais detalhes a evolução do projeto, consulte:

- 📐 [Arquitetura](docs/04-arquitetura.md)
- 🗺️ [Roadmap](docs/06-roadmap.md)
- 📝 [Diário de Desenvolvimento](docs/03-diario-de-desenvolvimento.md)
- 📚 [Decisões Arquiteturais (ADRs)](docs/decisoes)

---

# 📌 Status

**Versão atual:** MVP Estável (Release 1.0)

O projeto possui uma versão funcional em modo texto, com todas as funcionalidades previstas para o MVP implementadas e documentadas.

A partir deste ponto, a evolução do projeto estará concentrada na adição de novas funcionalidades, como persistência de partidas, estatísticas, testes automatizados e, futuramente, uma interface gráfica com Swing, preservando a arquitetura construída durante o desenvolvimento.

---

## 👨‍💻 Autor

Desenvolvido por **Flávio Oliveira** como parte da construção do meu portfólio de desenvolvimento de software, documentando a evolução técnica ao longo do processo.

Este projeto representa não apenas o aprendizado da linguagem, mas também a aplicação prática de princípios de Arquitetura de Software, Engenharia de Software e desenvolvimento incremental orientado por documentação.

- GitHub: https://github.com/foliveiradark
- LinkedIn: https://www.linkedin.com/in/flaviocoliveira/