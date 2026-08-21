# 04 — Arquitetura

## 1. Visão Geral

O projeto Sudoku foi desenvolvido utilizando uma arquitetura em camadas simples, baseada na separação de responsabilidades entre domínio, serviços, interface de usuário e persistência.

A aplicação possui como objetivo principal servir como projeto de aprendizado em Java, Programação Orientada a Objetos e Engenharia de Software, priorizando código limpo, baixo acoplamento e evolução incremental.

A arquitetura foi planejada para permitir futuras evoluções, como persistência de partidas, interface gráfica e testes automatizados, sem exigir alterações significativas no domínio da aplicação.

A persistência foi incorporada de forma incremental, mantendo o domínio desacoplado do mecanismo de armazenamento.

---

## 2. Estrutura de pacotes

```text
src
├── model
├── service
├── repository
├── persistence
├── ui
├── enums
├── exception
├── util
└── Main
```

### Responsabilidade geral

* `model` — entidades e regras do domínio;
* `service` — coordenação dos casos de uso e operações de aplicação;
* `repository` — acesso aos dados persistidos;
* `persistence` — infraestrutura de conexão e comunicação com o banco;
* `ui` — entrada e apresentação das informações;
* `enums` — tipos enumerados utilizados pelo sistema;
* `exception` — exceções específicas da aplicação;
* `util` — utilitários de apoio;
* `Main` — ponto de entrada da aplicação.

---

## 3. Arquitetura da aplicação

```text
                         Main
                          │
                          ▼
                    JogoSudoku
               (coordena o fluxo)
                          │
             ┌────────────┴────────────┐
             │                         │
             ▼                         ▼
        Interface                  Domínio
             │                         │
    ┌────────┴────────┐          ┌─────┴─────┐
    ▼                 ▼          ▼           ▼
ConsoleInput   ConsolePrinter  Tabuleiro    Casa
             │
             │
             │ Persistência
             ▼
      PersistenciaService
             │
       ┌─────┴─────┐
       ▼           ▼
TabuleiroRepository  PartidaRepository
       │           │
       └─────┬─────┘
             ▼
     ConnectionFactory
             │
             ▼
        PostgreSQL
```

A camada de persistência não faz parte das regras do domínio.

O domínio representa o estado e as regras do Sudoku, enquanto a persistência é responsável por armazenar e recuperar esse estado.

---

## 4. Responsabilidades das Camadas

```text
Main
│
└── Inicializa a aplicação.


JogoSudoku
│
└── Coordena o fluxo da aplicação e os casos de uso da partida.


Tabuleiro
│
└── Representa o estado do Sudoku.


Casa
│
└── Representa uma posição do tabuleiro.


ConsoleInput
│
└── Responsável exclusivamente pela entrada de dados.


ConsolePrinter
│
└── Responsável exclusivamente pela saída de informações.


PersistenciaService
│
└── Coordena operações de persistência e suas transações.


TabuleiroRepository
│
└── Executa operações de acesso a TABULEIRO e CASA.


PartidaRepository
│
└── Executa operações de acesso a PARTIDA, ESTADO_CASA e CANDIDATO.


ConnectionFactory
│
└── Responsável por criar conexões JDBC com o PostgreSQL.
```

Os repositories não são responsáveis por criar ou controlar a própria conexão.

A `Connection` utilizada em uma operação de persistência será fornecida pela camada responsável por coordenar a operação, permitindo que diferentes repositories participem da mesma transação.

---

## 5. Fluxos de Negócio

### 5.1 Fluxo de uma Jogada

```text
Ler coordenada (A1–I9)
↓
Converter para linha/coluna
↓
Perguntar remoção
      │
      ├── Sim
      │      ↓
      │ removerJogada(linha,coluna)
      │
      └── Não
             ↓
         Ler número
             ↓
executarJogada(linha,coluna,numero)
             ↓
verificarStatusPartida()
             │
             ├── COMPLETA_VALIDA
             │        ↓
             │ Encerrar partida
             │
             ├── INCOMPLETA
             │
             └── COMPLETA_INVALIDA
                      ↓
             Continua partida
```

### 5.2 Remoção

```text
Ler linha
↓
Ler coluna
↓
Perguntar confirmação
      │
      ├── Sim
      │      ↓
      │ removerJogada(linha,coluna)
      │      ↓
      │ Reimprimir tabuleiro
      │
      └── Não
             ↓
        Continua fluxo normal
```

### 5.3 Limpeza

```text
Jogador solicita limpeza
        │
        ▼
Solicitar confirmação
        │
        ├── Não
        │       ▼
        │ Continua a partida
        │
        └── Sim
                │
                ▼
        Tabuleiro.limparJogadas()
                │
                ▼
        Reimprimir tabuleiro
```

### 5.4 Verificação do Status

```text
Possui casas vazias?
│
├── Sim
│      ↓
│  INCOMPLETA
│
└── Não
       │
       ├── Possui erro nas linhas?
       │
       ├── Possui erro nas colunas?
       │
       ├── Possui erro nos blocos?
       │
       ├── Sim
       │      ↓
       │ COMPLETA_INVALIDA
       │
       └── Não
              ↓
        COMPLETA_VALIDA
```

### 5.5 Finalização

```text
Jogador realiza uma jogada
        │
        ▼
Sistema verifica StatusPartida
        │
        ├── INCOMPLETA
        │       continua
        │
        ├── COMPLETA_INVALIDA
        │       continua
        │
        └── COMPLETA_VALIDA
                │
                ▼
        encerrar partida
```

### 5.6 Salvar Partida

O salvamento representa a persistência do **progresso da partida**.

A configuração do tabuleiro (`TABULEIRO` e `CASA`) já deve estar persistida e não faz parte da operação de salvamento do progresso.

```text
┌─────────────────────┐
│     JogoSudoku      │
│                     │
│ Jogador solicita    │
│ "Salvar partida"    │
└──────────┬──────────┘
           │
           │ salvar(partida)
           ▼
┌──────────────────────────┐
│   PersistenciaService    │
│                          │
│ Coordena o salvamento    │
│ e a transação            │
└────────────┬─────────────┘
             │
             │ obterConexao()
             ▼
┌──────────────────────────┐
│    ConnectionFactory     │
└────────────┬─────────────┘
             │
             │ Connection
             ▼
      ┌─────────────────────┐
      │     TRANSAÇÃO       │
      │                     │
      │  PartidaRepository  │
      │         │           │
      │         ├── PARTIDA │
      │         ├── ESTADO_CASA
      │         └── CANDIDATO
      │                     │
      │       COMMIT        │
      └──────────┬──────────┘
                 │
                 ▼
             PostgreSQL
```

O `PersistenciaService` controla a transação.

O `PartidaRepository` executa as operações SQL relacionadas ao progresso da partida.

Os dados de `TABULEIRO` e `CASA` são apenas referenciados pela partida e não são recriados durante o salvamento.

Caso qualquer etapa do salvamento falhe, a transação deverá ser revertida por meio de `ROLLBACK`.

### 5.7 Carregar Partida

O carregamento recupera a configuração do tabuleiro e o progresso persistido da partida para reconstruir o estado do domínio.

```text
┌─────────────────────┐
│     JogoSudoku      │
│                     │
│ jogador escolhe     │
│ "2 - Continuar"     │
└──────────┬──────────┘
           │
           │ carregarPartida()
           ▼
┌──────────────────────────┐
│   PersistenciaService    │
│                          │
│ Coordena o carregamento  │
└────────────┬─────────────┘
             │
             │ obterConexao()
             ▼
┌──────────────────────────┐
│    ConnectionFactory     │
└────────────┬─────────────┘
             │
             │ Connection
             ▼
      ┌─────────────────────┐
      │     PostgreSQL      │
      └──────────┬──────────┘
                 │
        ┌────────┴──────────────┐
        ▼                       ▼
TabuleiroRepository     PartidaRepository
        │                       │
        ├── TABULEIRO            ├── PARTIDA
        └── CASA                 ├── ESTADO_CASA
                                 └── CANDIDATO
                 │
                 └────────┬──────┘
                          ▼
                 Reconstrução do domínio
                          │
                          ▼
                     JogoSudoku
```

O `TabuleiroRepository` recupera a configuração permanente do desafio.

O `PartidaRepository` recupera o progresso da partida.

O `PersistenciaService` coordena a operação e utiliza os dados recuperados para reconstruir o estado necessário para continuar a partida.

---

## 6. Princípios Arquiteturais

Durante o desenvolvimento foram adotados os seguintes princípios:

* Separação de responsabilidades;
* Encapsulamento do domínio;
* Baixo acoplamento entre as camadas;
* Alta coesão das classes;
* Reutilização de código sempre que possível;
* Desenvolvimento incremental;
* Evolução contínua da arquitetura;
* Interface desacoplada da lógica de negócio;
* Coordenação do fluxo da aplicação centralizada na camada de serviço (`JogoSudoku`);
* Coordenação das operações de persistência centralizada em `PersistenciaService`;
* Repositories responsáveis exclusivamente pelo acesso aos dados;
* Conexão JDBC compartilhada durante uma operação transacional de persistência;
* Domínio independente do mecanismo de persistência.

---

## 7. Referência para ADRs

### Decisões Arquiteturais

As decisões arquiteturais que influenciaram a construção desta arquitetura encontram-se documentadas nas ADRs do projeto.

* ADR-001 - Separação domínio/interface
* ADR-002 - Responsabilidades do jogo
* ADR-003 - Construção do tabuleiro
* ADR-004 - Localização dos tabuleiros
* ADR-005 - Organização da interface de console
* ADR-006 - Responsabilidade de limpeza das jogadas
* ADR-007 - Não diferenciar visualmente casas fixas na interface de console
* ADR-010 - Integridade entre tabuleiro, partida e estado da casa
