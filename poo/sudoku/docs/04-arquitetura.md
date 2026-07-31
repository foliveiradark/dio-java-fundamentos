## 1. Visão Geral

O projeto Sudoku foi desenvolvido utilizando uma arquitetura em camadas simples, baseada na separação de responsabilidades entre domínio, serviços e interface de usuário.

A aplicação possui como objetivo principal servir como projeto de aprendizado em Java, Programação Orientada a Objetos e Engenharia de Software, priorizando código limpo, baixo acoplamento e evolução incremental.

A arquitetura foi planejada para permitir futuras evoluções, como persistência de partidas, interface gráfica e testes automatizados, sem exigir alterações significativas no domínio da aplicação.

---

## 2. Estrutura de pacotes

```text
src
├── model
├── service
├── ui
├── enums
├── exception
├── util
└── Main
```
---

## 3. Arquitetura da aplicação

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
      (estado da partida)
                  │
                  ▼
                Casa
```
---

## 4. Responsabilidades das Camadas
```text
Main
│
└── Inicializa a aplicação.

JogoSudoku
│
└── Coordena todo o fluxo da partida.

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
```
---

## 5. Fluxos de Negócio

### 5.1 Fluxo de uma Jogada
```text
Ler linha
↓
Ler coluna
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

---

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

---

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

---

## 6. Princípios Arquiteturais

Durante o desenvolvimento foram adotados os seguintes princípios:

- Separação de responsabilidades;
- Encapsulamento do domínio;
- Baixo acoplamento entre as camadas;
- Alta coesão das classes;
- Reutilização de código sempre que possível;
- Desenvolvimento incremental;
- Evolução contínua da arquitetura;
- Interface desacoplada da lógica de negócio;
- Coordenação do fluxo centralizada na camada de serviço (`JogoSudoku`).

---

## 7. Referência para ADRs

### Decisões Arquiteturais

As decisões arquiteturais que influenciaram a construção desta arquitetura encontram-se documentadas nas ADRs do projeto.

- ADR-001 — Separação domínio/interface
- ADR-002 — Responsabilidades do jogo
- ADR-003 — Construção do tabuleiro
- ADR-004 — Localização dos tabuleiros
- ADR-005 — Organização da interface de console
- ADR-006 — Responsabilidade de limpeza das jogadas

---
