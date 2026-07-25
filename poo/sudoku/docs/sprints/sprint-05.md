# 🔄 Sprint 5 — Tratar jogadas inválidas

## 🎯 Objetivo

Permitir que a aplicação trate erros durante a partida sem encerrar o jogo.

---

## 📦 Escopo

- US-005 — Tratar jogadas inválidas

### Critérios de aceitação
* O jogo não deve ser encerrado após uma jogada inválida. 
* O erro deve ser informado ao jogador. 
* O jogador deve poder tentar novamente. 
* O fluxo da partida deve continuar normalmente.
---
## Sprint Review

### User Stories concluídas

- ✅ US-005 — Tratar jogadas inválidas.

---

### Melhorias realizadas

* Implementação do tratamento de jogadas inválidas;
* Continuidade da partida após erros de entrada;
* Centralização da exibição de mensagens de erro no `ConsolePrinter`;
* Preservação da arquitetura em camadas durante a implementação;
* Validação do comportamento da aplicação por meio de testes manuais.

### Débitos técnicos identificados

* Melhorar o fluxo de entrada para evitar que o jogador precise informar novamente linha e coluna após um erro no número.
* Exibir a identificação visual das linhas e colunas do tabuleiro para facilitar a navegação do jogador.
* Implementar validações específicas das regras do Sudoku após cada jogada.

---

## Status

✅ Concluída.

---