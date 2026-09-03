# 🧩 Sudoku em Java

## 📖 Sobre o projeto

Este projeto foi desenvolvido em Java como parte da minha jornada de aprendizado em **Programação Orientada a Objetos e Engenharia de Software**.

Mais do que implementar um jogo de Sudoku, o objetivo é aplicar práticas de desenvolvimento profissional, utilizando:

- Arquitetura em camadas;
- Separação de responsabilidades;
- Documentação técnica;
- Decisões arquiteturais (ADRs);
- Desenvolvimento incremental;
- User Stories;
- Sprints;
- Persistência de dados;
- Evolução gradual da arquitetura.

O projeto começou como uma aplicação executada exclusivamente pelo **Console** e evoluiu progressivamente para uma aplicação desktop, incorporando persistência de partidas e uma primeira interface gráfica desenvolvida com **JavaFX**.

---

## 🎯 Objetivos

O principal objetivo é utilizar o desenvolvimento do Sudoku como um laboratório prático para consolidar conhecimentos em Java e Engenharia de Software.

Durante sua evolução, o projeto busca praticar:

- Programação Orientada a Objetos;
- Encapsulamento;
- Herança;
- Polimorfismo;
- Abstração;
- Interfaces;
- Separação de responsabilidades;
- Arquitetura em camadas;
- Persistência de dados;
- JDBC;
- PostgreSQL;
- Maven;
- JavaFX;
- Desenvolvimento incremental;
- Refatoração;
- Documentação técnica;
- Decisões arquiteturais.

---

## 🎮 Demonstração

O projeto atualmente possui duas interfaces:

- **Console** — versão mais completa e utilizada para validação das funcionalidades;
- **JavaFX** — primeira versão da interface gráfica, construída como um vertical slice funcional.

A interface gráfica encontra-se em evolução e ainda não possui paridade funcional com a interface Console.

---

# 🚀 Funcionalidades implementadas

## 🎲 Jogabilidade

A aplicação permite:

- Iniciar uma nova partida;
- Inserir números no tabuleiro;
- Remover números inseridos pelo jogador;
- Limpar jogadas realizadas;
- Registrar múltiplos candidatos em uma casa;
- Concluir uma partida;
- Verificar o estado atual do tabuleiro.

---

## 💻 Interface Console

A interface Console possui:

- Menu principal;
- Navegação por coordenadas de `A1` a `I9`;
- Representação visual do tabuleiro utilizando blocos Unicode;
- Identificação de linhas e colunas;
- Validação das jogadas;
- Gerenciamento das partidas;
- Persistência das partidas;
- Recuperação de partidas salvas.

A interface Console permanece no projeto como uma implementação funcional da aplicação e também como referência para a evolução das demais interfaces.

---

## 🖥️ Interface gráfica

O projeto possui uma primeira interface gráfica desenvolvida com **JavaFX**.

O vertical slice atualmente implementado permite:

1. Abrir a aplicação;
2. Visualizar o tabuleiro;
3. Selecionar uma casa;
4. Inserir um número;
5. Visualizar o resultado da ação.

A interface gráfica utiliza a mesma camada de domínio e orquestração da aplicação, evitando duplicar as regras do Sudoku na interface.

A GUI encontra-se em evolução e ainda não possui todas as funcionalidades disponíveis na interface Console.

---

## ✅ Validações

A aplicação realiza validações relacionadas a:

- Entrada de dados inválida;
- Valores não numéricos;
- Opções do menu;
- Confirmações de operações;
- Proteção de casas fixas;
- Regras para inserção de números;
- Regras de linhas;
- Regras de colunas;
- Regras das regiões `3x3`;
- Diferenciação entre candidatos e números definitivos.

---

## 💾 Persistência

A aplicação possui persistência de partidas utilizando **PostgreSQL e JDBC**.

É possível:

- Salvar uma partida em andamento;
- Recuperar uma partida salva;
- Continuar uma partida posteriormente;
- Persistir números definitivos;
- Persistir candidatos;
- Sobrescrever uma partida existente mediante confirmação.

A persistência atualmente está integrada à **interface Console**.

---

## 📊 Acompanhamento da partida

A aplicação permite verificar o estado atual do tabuleiro, identificando situações como:

- Partida incompleta;
- Tabuleiro válido;
- Tabuleiro inválido.

O estado da partida também é refletido pela interface após as ações realizadas pelo jogador.

---

# 🏗️ Arquitetura

A aplicação utiliza uma arquitetura organizada em camadas, buscando manter baixo acoplamento e separar responsabilidades.

A evolução arquitetural permitiu que diferentes interfaces utilizassem a mesma lógica de negócio e orquestração.

```text
                    ┌───────────────┐
                    │     Main      │
                    │    Console    │
                    └───────┬───────┘
                            │
                            ▼
                    ┌───────────────┐
                    │  JogoSudoku   │
                    │  Orquestração │
                    └───────┬───────┘
                            │
              ┌─────────────┴─────────────┐
              │                           │
              ▼                           ▼
      ┌───────────────┐           ┌───────────────┐
      │    Console    │           │    JavaFX     │
      │   Interface   │           │   Interface   │
      └───────┬───────┘           └───────┬───────┘
              │                           │
              └─────────────┬─────────────┘
                            │
                            ▼
                    ┌───────────────┐
                    │    Domínio    │
                    │ Tabuleiro/Casa│
                    └───────┬───────┘
                            │
                            ▼
                    ┌───────────────┐
                    │  Persistência │
                    │ Repositories  │
                    └───────────────┘
```

As interfaces são responsáveis pela interação com o usuário, enquanto as regras do Sudoku permanecem concentradas nas camadas responsáveis pelo domínio e pela orquestração.

A persistência é isolada por meio de **Repositories**, evitando que as interfaces tenham responsabilidade direta pelo acesso aos dados.

Mais detalhes sobre a arquitetura podem ser encontrados em:

- [`docs/04-arquitetura.md`](docs/04-arquitetura.md)

---

# 📁 Estrutura do projeto

```text
sudoku
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── enums/
│   │       ├── exception/
│   │       ├── model/
│   │       ├── persistence/
│   │       ├── service/
│   │       ├── ui/
│   │       │   └── javafx/
│   │       └── util/
│   │
│   └── test/
│
├── database/
│   └── schema.sql
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

| Diretório / Arquivo | Responsabilidade |
|---|---|
| `src/main/java/` | Código-fonte da aplicação |
| `model/` | Entidades e regras relacionadas ao domínio |
| `service/` | Orquestração e serviços da aplicação |
| `ui/` | Interfaces de interação com o usuário |
| `ui/javafx/` | Implementação da interface gráfica JavaFX |
| `persistence/` | Acesso e persistência de dados |
| `database/` | Scripts relacionados ao banco de dados |
| `docs/` | Documentação técnica e histórico de desenvolvimento |
| `pom.xml` | Configuração do Maven e dependências |
| `CHANGELOG.md` | Registro das principais alterações |
| `README.md` | Documentação principal do projeto |

---

# 📚 Documentação

A documentação acompanha a evolução técnica do projeto e registra não apenas o código, mas também as decisões e o processo de desenvolvimento.

| Documento | Descrição |
|---|---|
| [Guia de Desenvolvimento](docs/00-guia-de-desenvolvimento.md) | Processo e metodologia utilizados no projeto |
| [Requisitos](docs/01-requisitos.md) | Requisitos funcionais e não funcionais |
| [Modelagem](docs/02-modelagem.md) | Modelagem do domínio |
| [Arquitetura](docs/04-arquitetura.md) | Organização arquitetural da aplicação |
| [Backlog](docs/05-backlog.md) | User Stories e evolução planejada |
| [Roadmap](docs/06-roadmap.md) | Direcionamento futuro do projeto |
| [User Stories](docs/stories/) | Especificação das funcionalidades |
| [Sprints](docs/sprints/) | Histórico de desenvolvimento por Sprint |
| [Diário de Desenvolvimento](docs/03-diario-de-desenvolvimento.md) | Registro da evolução técnica |
| [ADRs](docs/decisoes/) | Decisões arquiteturais |
| [Marcos do Projeto](docs/07-marcos-do-projeto.md) | Principais marcos da evolução |
| [CHANGELOG](CHANGELOG.md) | Registro das alterações relevantes |

---

# 🛠️ Tecnologias e conceitos aplicados

| Tecnologia / Conceito | Utilização |
|---|---|
| **Java 26** | Linguagem principal |
| **JavaFX 26** | Interface gráfica |
| **Maven** | Gerenciamento do projeto e dependências |
| **PostgreSQL** | Banco de dados |
| **JDBC** | Integração com o banco de dados |
| **IntelliJ IDEA** | Ambiente de desenvolvimento |
| **Git** | Controle de versão |
| **GitHub** | Hospedagem e versionamento do projeto |
| **Markdown** | Documentação |
| **Programação Orientada a Objetos** | Modelagem e organização do domínio |
| **Arquitetura em camadas** | Separação de responsabilidades |
| **Repositories** | Abstração do acesso aos dados |
| **ADRs** | Registro de decisões arquiteturais |
| **User Stories e Sprints** | Organização do desenvolvimento incremental |

---

# 🚀 Como executar

## 1. Clone o repositório

```bash
git clone https://github.com/foliveiradark/dio-java-fundamentos.git
```

## 2. Acesse o projeto

```bash
cd dio-java-fundamentos/poo/sudoku
```

## 3. Requisitos

Para executar o projeto, são necessários:

- Java JDK 26 ou superior;
- Maven.

O PostgreSQL é necessário caso sejam utilizadas as funcionalidades de persistência.

---

## 4. Compile o projeto

Execute:

```bash
mvn clean package
```

---

## 5. Execute a interface gráfica

A aplicação JavaFX pode ser iniciada com:

```bash
mvn javafx:run
```

O vertical slice atualmente disponível segue o fluxo:

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

A interface gráfica está em evolução e ainda não possui todas as funcionalidades disponíveis na interface Console.

---

## 6. Execute a interface Console

A interface Console permanece disponível como implementação alternativa.

Para executá-la utilizando Maven:

### Linux / macOS

```bash
mvn exec:java -Dexec.mainClass=Main
```

### Windows PowerShell

```powershell
mvn exec:java "-Dexec.mainClass=Main"
```

A classe `Main` continua sendo a entrada da aplicação em modo texto.

---

# 🗄️ Configuração da persistência

Para utilizar as funcionalidades de persistência, é necessário possuir uma instalação do PostgreSQL em execução.

A aplicação utiliza atualmente as seguintes configurações:

> **Nota:** as credenciais abaixo são destinadas exclusivamente ao ambiente local de desenvolvimento.

| Configuração | Valor        |
|--------------|--------------|
| Host         | `localhost`  |
| Porta        | `5432`       |
| Banco        | `sudoku`     |
| Usuário      | `sudoku`     |
| Senha        | `sudoku_dev` |

A conexão é centralizada pela classe:

```text
persistence.ConnectionFactory
```

## 1. Criar o usuário

Conecte-se ao PostgreSQL utilizando um usuário com permissão administrativa e execute:

```sql
CREATE USER sudoku WITH PASSWORD 'sudoku_dev';
```

## 2. Criar o banco de dados

```sql
CREATE DATABASE sudoku OWNER sudoku;
```

## 3. Criar as tabelas

A partir da raiz do projeto `poo/sudoku`, execute:

### Linux / macOS

```bash
psql -U sudoku -d sudoku -f database/schema.sql
```

### Windows PowerShell

```powershell
psql -U sudoku -d sudoku -f database\schema.sql
```

O script cria as estruturas necessárias para a persistência das partidas, incluindo:

- `tabuleiro`;
- `casa`;
- `partida`;
- `estado_casa`;
- `candidato`.

---

## 7. Validar a persistência

Com o PostgreSQL configurado, a persistência pode ser validada pela interface Console.

Fluxo básico:

```text
Iniciar uma nova partida
        ↓
Realizar uma jogada
        ↓
Salvar a partida
        ↓
Retornar ao menu
        ↓
Selecionar "Continuar partida"
        ↓
Verificar o estado recuperado
```

Também é possível validar a persistência de candidatos registrados nas casas durante a partida.

---

# 🗺️ Roadmap

O projeto iniciou como uma aplicação Console e evoluiu progressivamente para uma aplicação desktop com persistência e interface gráfica.

### Próximas evoluções

- Refinamento da interface gráfica;
- Ampliação das funcionalidades disponíveis na GUI;
- Integração das funcionalidades existentes à interface gráfica;
- Estatísticas de partidas;
- Diferentes níveis de dificuldade;
- Geração automática de tabuleiros;
- Preparação para distribuição da aplicação.

O roadmap completo está disponível em:

- [`docs/06-roadmap.md`](docs/06-roadmap.md)

---

# 🧠 Principais conceitos praticados

Ao longo da evolução do projeto, foram praticados conceitos como:

### Programação

- Classes e objetos;
- Encapsulamento;
- Herança;
- Polimorfismo;
- Abstração;
- Interfaces;
- Coleções;
- Tratamento de exceções;
- Validação de regras.

### Engenharia de Software

- Separação de responsabilidades;
- Arquitetura em camadas;
- Baixo acoplamento;
- Refatoração;
- Desenvolvimento incremental;
- User Stories;
- Sprints;
- ADRs;
- Documentação técnica.

### Persistência

- PostgreSQL;
- JDBC;
- Repositories;
- Modelagem de dados;
- Persistência de estado.

### Interface

- Aplicação Console;
- JavaFX;
- Separação entre interface e lógica de negócio;
- Evolução para múltiplas interfaces.

---

# 📌 Status

### Primeiro vertical slice gráfico funcional

O projeto atualmente possui:

- ✅ Aplicação Console funcional;
- ✅ Regras do Sudoku implementadas;
- ✅ Sistema de candidatos;
- ✅ Persistência de partidas com PostgreSQL;
- ✅ Recuperação de partidas;
- ✅ Arquitetura preparada para múltiplas interfaces;
- ✅ Primeira interface gráfica JavaFX;
- ✅ Primeiro vertical slice funcional na GUI.

A interface gráfica continua em desenvolvimento e será gradualmente ampliada até incorporar as funcionalidades existentes na aplicação Console.

O objetivo de longo prazo é transformar o projeto em uma aplicação desktop completa, funcional e distribuível.

---

# 👨‍💻 Autor

**Flávio Oliveira**

Projeto desenvolvido como parte da minha jornada de aprendizado em Java, com foco em **Engenharia de Software, arquitetura, desenvolvimento incremental e construção de portfólio técnico**.

A evolução do projeto pode ser acompanhada através do histórico de commits, documentação técnica, User Stories, Sprints e decisões arquiteturais registradas no repositório.

**GitHub**: https://github.com/foliveiradark

**LinkedIn**: https://www.linkedin.com/in/flaviocoliveira/
