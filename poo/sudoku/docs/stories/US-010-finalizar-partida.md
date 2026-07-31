# US-010 — Finalizar Partida

---

## Informações Gerais

> **ID:** US-010  
> **Sprint:** Sprint 10  
> **Prioridade:** 🟠 Média  
> **Status:** ✅ Concluída.

---

## 🎯 Objetivo

Permitir que o jogador finalize corretamente uma partida quando o Sudoku estiver completo e válido.

---

## ✅ Critérios de Aceitação

* Encerrar automaticamente a partida quando o Sudoku estiver completo e válido;
* Exibir uma mensagem de conclusão ao jogador;
* Impedir novas jogadas após o encerramento da partida;
* Retornar automaticamente ao Menu Principal após a conclusão da partida;
* Não encerrar a partida enquanto existirem casas vazias;
* Não encerrar a partida quando o tabuleiro estiver completo, mas possuir erros.

---

# 🔧 Tarefas Técnicas

## TASK-001

Encerrar automaticamente a partida quando `StatusPartida` for `COMPLETA_VALIDA`.

**Status:** ✅ Concluída.

---

## TASK-002

Exibir mensagem de conclusão antes do encerramento.

**Status:** ✅ Concluída.

---

## TASK-003

Impedir novas jogadas após a conclusão da partida.

> Na prática, sair do laço `executarPartida()`.

**Status:** ✅ Concluída.

---

## TASK-004

Retornar automaticamente ao Menu Principal após o encerramento da partida.

**Status:** ✅ Concluída.

---

## TASK-005

Validar todos os cenários de encerramento.

**Status:** ✅ Concluída.

---

## TASK-006

Validar a Definition of Done da US-010.

**Status:** ✅ Concluída.

---

## Dependências

- US-004 - Inserir Número
- US-007 - Remover Número
- US-008 - Verificar Status do Jogo

---

# Resultado

## Funcionalidades implementadas

* Encerramento automático da partida quando o Sudoku é concluído corretamente.
* Exibição de mensagem de conclusão ao jogador.
* Retorno automático ao Menu Principal após o encerramento da partida.
* Bloqueio de novas jogadas após a conclusão da partida por meio do encerramento do fluxo da partida.

---

## 📌 Observações

O encerramento da partida foi implementado reutilizando o mecanismo de verificação de status (`StatusPartida`), evitando duplicação de regras de negócio.

A interrupção da partida ocorre por meio do encerramento natural do laço `executarPartida()`, preservando o fluxo da aplicação e retornando automaticamente ao Menu Principal.


---