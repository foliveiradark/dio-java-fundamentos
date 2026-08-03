# US-015 — Melhorar a experiência visual do tabuleiro

---

## Informações Gerais

> **ID:** US-015  
> **Sprint:** Sprint 15  
> **Prioridade:** 🟢 Baixa  
> **Status:** ✅ Concluída.

---

## 🎯 Objetivo

Melhorar a apresentação visual do tabuleiro para tornar a interação mais intuitiva, organizada e confortável durante a partida, sem alterar as regras de negócio da aplicação.

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

# 🔧 Tarefas Técnicas

## TASK-001

Analisar a impressão atual do tabuleiro e identificar oportunidades de melhoria na experiência visual do jogador.

**Status:** ✅ Concluída.

---

## TASK-002

Refatorar a impressão do tabuleiro utilizando caracteres Unicode para melhorar a separação visual dos blocos 3×3.

**Status:** ✅ Concluída.

---

## TASK-003

Adicionar a identificação das colunas também no rodapé do tabuleiro.

**Status:** ✅ Concluída.

---

## TASK-004

Adicionar a identificação das linhas no lado direito do tabuleiro.

**Status:** ✅ Concluída.

---

## TASK-005

Revisar o espaçamento, o alinhamento e a legibilidade geral da impressão do tabuleiro.

**Status:** ✅ Concluída.

---

## TASK-006

Validar a impressão do tabuleiro em diferentes estágios da partida.

**Critérios mínimos:**

* tabuleiro inicial;
* tabuleiro parcialmente preenchido;
* tabuleiro completo;
* casas fixas;
* jogadas do usuário.

**Status:** ✅ Concluída.

---

## TASK-007

Validar a Definition of Done da US-015.

**Status:** ✅ Concluída.

---

## Dependências

- US-001 — Visualizar o tabuleiro.
- US-006 — Melhorar a identificação das coordenadas do tabuleiro.
- US-012 — Permitir entrada de coordenadas em formato A1–I9.
- US-014 — Validar opções do Menu Principal.

---

# Resultado

## Funcionalidades implementadas

- Impressão do tabuleiro utilizando caracteres Unicode.
- Separação visual aprimorada dos blocos 3×3.
- Identificação das colunas no cabeçalho e rodapé.
- Identificação das linhas nos lados esquerdo e direito.
- Revisão do alinhamento e espaçamento da interface.
- Melhoria da legibilidade durante toda a partida.

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

Esta Sprint foi dedicada exclusivamente ao refinamento da experiência do usuário, demonstrando que a evolução de um software não ocorre apenas pela adição de funcionalidades, mas também pelo aprimoramento contínuo da usabilidade e da apresentação da interface.

Embora nenhuma regra de negócio tenha sido modificada, a melhoria na legibilidade do tabuleiro tornou a interação mais intuitiva e agradável ao jogador.

---