# Modelagem do Sistema

---
## Visão Geral

O sistema será dividido em duas camadas principais:

- Domínio: responsável pelas regras do Sudoku.
- Interface: responsável pela interação com o usuário.

---

## Classes do Domínio

- Tabuleiro
- Casa

---

## Classes de Serviço

- JogoSudoku

---

## Classes da Interface

- Menu
- ConsoleInput
- ConsolePrinter

---

## Relacionamentos

* Main inicia `JogoSudoku`;
* `JogoSudoku` coordena a partida;
* `JogoSudoku` utiliza `ConsoleInput`, `ConsolePrinter` e `Menu`;
* `JogoSudoku` controla um `Tabuleiro`;
* `Tabuleiro` é composto por 81 objetos `Casa`.