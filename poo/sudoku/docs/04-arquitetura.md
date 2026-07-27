## 1. Visão geral do sistema

O Sudoku foi desenvolvido utilizando uma arquitetura em camadas simples, separando domínio, regras de negócio e interface de usuário. O objetivo é manter baixo acoplamento entre as classes e facilitar futuras evoluções, como persistência e interface gráfica.

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

## 3. Fluxo da aplicação

```text
Main
 │
 ▼
JogoSudoku (ainda vazio)
 │
 ▼
Tabuleiro
 │
 ▼
Casa
```
---
```text
Ler linha
↓
Ler coluna
↓
Perguntar confirmação
      │
      ├── true
      │      ↓
      │ removerJogada(linha,coluna)
      │
      └── false
             ↓
             Ler número
             ↓
             executarJogada(linha,coluna,numero)
```

---

## 4. Responsabilidades das camadas

```text
Main
│
├── Inicializa a aplicação
│
JogoSudoku
│
├── Coordena o fluxo da partida
│
Tabuleiro
│
├── Representa o estado do jogo
│
Casa
│
├── Representa cada posição do tabuleiro
│
ConsolePrinter
│
├── Responsável apenas pela saída
│
ConsoleInput
│
└── Responsável apenas pela entrada
```
---

## 5. Referência para ADRs

### Decisões Arquiteturais

As principais decisões arquiteturais do projeto estão documentadas nas ADRs:

- ADR-001 — Separação domínio/interface
- ADR-002 — Responsabilidades do jogo
- ADR-003 — Construção do tabuleiro
- ADR-004 — Localização dos tabuleiros
- ADR-005 — Organização da interface de console
---
