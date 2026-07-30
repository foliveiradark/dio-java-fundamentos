# 🔄 Sprint 8 — Verificar o status do jogo

## 🎯 Objetivo

Permitir que o jogador verifique o estado atual da partida durante a resolução do Sudoku.

---

## 📦 Escopo

- US-008 — Verificar o status do jogo

---
### Critérios de Aceitação

* Informar quando o jogo estiver incompleto;
* Informar quando o jogo estiver completo e válido;
* Informar quando o jogo estiver completo, porém com erros;
* Não alterar o estado do tabuleiro durante a verificação;
* Exibir uma mensagem clara ao jogador.
* A verificação deve considerar todas as regras do Sudoku.

---

## Sprint Review

### User Stories concluídas

- ✅ US-008 — Verificar o status do jogo.

---

### Melhorias realizadas

- Implementação da verificação de casas vazias;
- Implementação da verificação de erros nas linhas;
- Implementação da verificação de erros nas colunas;
- Implementação da verificação de erros nos blocos 3×3;
- Criação do enum `StatusPartida`;
- Implementação da consulta do status da partida;
- Exibição do resultado ao jogador através da camada `ConsolePrinter`.




### Débitos técnicos identificados

Nenhum débito técnico identificado.

---

## Status

✅ Concluída

---