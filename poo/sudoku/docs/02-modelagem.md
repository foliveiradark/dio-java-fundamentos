# Modelagem do Sistema

---
## Visão Geral

O sistema será dividido em duas camadas principais:

- Domínio: responsável pelas regras do Sudoku.
- Interface: responsável pela interação com o usuário.

---

## Classes do Domínio

- JogoSudoku
- Tabuleiro
- Casa

---

## Classes da Interface

- Menu

---

## Relacionamentos

- O Menu interage com o JogoSudoku.
- O JogoSudoku controla uma partida e utiliza um Tabuleiro.
- O Tabuleiro é composto por 81 objetos Casa.
- Cada Casa representa uma posição do tabuleiro e conhece seu próprio estado.