# 🔄 Sprint 15 — Melhorar a experiência visual do tabuleiro

## 🎯 Objetivo

Melhorar a apresentação visual do tabuleiro para tornar a interação mais intuitiva, organizada e confortável durante a partida, sem alterar as regras de negócio da aplicação.

---

## 📦 Escopo

-  US-015 — Melhorar a experiência visual do tabuleiro.

---

## ✅ Critérios de Aceitação

* Exibir um tabuleiro visualmente mais organizado.
* Destacar claramente a separação dos blocos 3×3.
* Exibir a identificação das colunas no topo e no rodapé do tabuleiro.
* Exibir a identificação das linhas nos lados esquerdo e direito.
* Melhorar o espaçamento e alinhamento das células.
* Utilizar caracteres Unicode para tornar a interface mais agradável.
* Preservar toda a lógica de negócio existente.
* Manter a responsabilidade da impressão concentrada na classe ConsolePrinter.

---

## Sprint Review

### User Stories concluídas

-   ✅ US-015 — Melhorar a experiência visual do tabuleiro.

---

### Melhorias realizadas

* Refatoração visual completa da impressão do tabuleiro.
* Utilização de caracteres Unicode para destacar os blocos 3×3.
* Identificação das colunas no cabeçalho e no rodapé.
* Identificação das linhas nos lados esquerdo e direito.
* Revisão do espaçamento e alinhamento das células.
* Melhoria da legibilidade geral da interface em modo texto.

### Débitos técnicos identificados

Nenhum débito técnico identificado nesta Sprint.

---

## 📌 Observações

Durante esta Sprint foram realizadas exclusivamente melhorias de apresentação da interface em modo texto.

**Nenhuma alteração impactou:**

* as regras de negócio do Sudoku;
* a estrutura das entidades do domínio;
* o fluxo da partida;
* o funcionamento da classe JogoSudoku.

A implementação permaneceu concentrada na classe `ConsolePrinter`,
preservando a separação de responsabilidades da arquitetura.

### Evolução do projeto

Esta Sprint foi dedicada exclusivamente ao refinamento da experiência do usuário, demonstrando que a evolução de um software não ocorre apenas pela adição de novas funcionalidades, mas também pelo aprimoramento contínuo da usabilidade, da legibilidade e da qualidade da interface.

Embora nenhuma regra de negócio tenha sido modificada, as melhorias na apresentação do tabuleiro tornaram a interação mais intuitiva, organizada e agradável para o jogador, reforçando a separação entre lógica da aplicação e camada de apresentação.

---

## Status

✅ Concluída

---