# 🔄 Sprint 17 — Sistema de rascunhos

## 🎯 Objetivo

Implementar o sistema de rascunhos do Sudoku, permitindo que o jogador registre números candidatos nas casas editáveis durante a resolução da partida.

A funcionalidade deverá preservar a separação entre domínio e interface e considerar a futura evolução do projeto para uma interface gráfica.

---

## 📦 Escopo

- US-017 — Sistema de rascunhos.

---

## ✅ Critérios de Aceitação

- Permitir que uma casa editável possua múltiplos números candidatos.
- Permitir adicionar e remover candidatos por meio de uma operação de toggle.
- Informar ao jogador se o candidato foi adicionado ou removido.
- Impedir operações de rascunho em casas fixas.
- Utilizar `Set<Integer>` para representar os candidatos no domínio.
- Remover automaticamente os candidatos quando um número definitivo for atribuído à casa.
- Manter a interpretação da sintaxe de rascunho na interface de console.
- Não permitir que a representação do domínio dependa da sintaxe utilizada pela interface.
- Preservar a possibilidade de utilização da mesma operação por uma futura interface gráfica.
- Preservar as regras de negócio e responsabilidades existentes.

---

# 📋 Planejamento da Sprint

A implementação será realizada de forma incremental.

As tarefas técnicas serão definidas e refinadas durante a análise da User Story, antes da implementação.

---

## Sprint Review

### User Stories concluídas

- ⏳ US-017 — Sistema de rascunhos.

---

### Melhorias previstas

- Representação de candidatos na entidade `Casa`.
- Operação de adição e remoção de candidatos.
- Integração da operação ao fluxo atual da partida.
- Interpretação da sintaxe de rascunho pela interface de console.
- Feedback ao jogador sobre as operações realizadas.
- Atualização da apresentação do tabuleiro para representar o estado dos candidatos.

### Débitos técnicos

A serem avaliados durante a implementação.

---

## 📌 Observações

Esta Sprint introduz uma nova capacidade de interação do jogador, mas deverá preservar a separação existente entre domínio e interface.

A sintaxe utilizada no console para representar uma operação de rascunho será tratada como detalhe da interface.

A representação dos candidatos deverá permanecer no domínio, permitindo que uma futura interface gráfica utilize a mesma funcionalidade sem depender da sintaxe adotada no console.

A implementação deverá seguir o princípio registrado em:

- PR-001 — Independência do domínio em relação à interface.

Também deverá respeitar as decisões arquiteturais existentes relacionadas à separação entre domínio e interface.

---

## 🔗 Relações

### Roadmap

- Fase 6 — Evolução do Produto.

### Princípios

- PR-001 — Independência do domínio em relação à interface.

### ADRs relacionados

- ADR-001 — Separação entre domínio e interface.
- ADR-005 — Organização da interface de console.

### User Story

- US-017 — Sistema de rascunhos.

---

## Status

🟡 Em andamento