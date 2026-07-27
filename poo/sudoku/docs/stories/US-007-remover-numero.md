# US-007 — Remover um número

---

## Informações Gerais

> **ID:** US-007  
> **Sprint:** Sprint 7  
> **Prioridade:** Alta 🔴  
> **Status:** ✅ Concluída

---

## 🎯 Objetivo

Permitir que o jogador remova um número inserido anteriormente para corrigir uma jogada durante a partida.

---

## ✅ Critérios de Aceitação

* Permitir remover números inseridos pelo jogador;
* Não permitir remover números de casas fixas;
* Exibir uma mensagem de erro ao tentar remover o número de uma casa fixa;
* A casa deve retornar ao estado vazio (`null`) após a remoção;
* Reimprimir o tabuleiro após cada remoção.

---

# 🔧 Tarefas Técnicas

## TASK-001

Adicionar o método `removerJogada()` na classe `JogoSudoku`.

**Status:** ✅ Concluída.

---
## TASK-002

Solicitar confirmação da remoção (S/N).

**Status:** ✅ Concluída.

---
## TASK-003

Localizar a casa selecionada e executar a remoção.

**Status:** ✅ Concluída.

---
## TASK-004

Tratar a exceção ao tentar remover uma casa fixa.

**Status:** ✅ Concluída.

---

## TASK-005

Reimprimir o tabuleiro após a remoção.

**Status:** ✅ Concluída.

---

## Dependências

- US-004 — Inserir um número
- US-005 — Tratar jogadas inválidas

---

# Resultado

## Funcionalidades implementadas

- Permite remover números inseridos pelo jogador;
- Impede a remoção de números pertencentes ao tabuleiro inicial;
- Solicita confirmação antes da remoção;
- Atualiza automaticamente o tabuleiro após a remoção;
- Mantém a aplicação em execução após tentativas inválidas.

---

## 📌 Observações

> Durante a implementação foi identificado um comportamento do `Scanner`
> relacionado ao uso combinado de `nextInt()` e `nextLine()`, que causava a
> leitura incorreta da confirmação de remoção.

> A solução adotada foi padronizar a leitura de entradas utilizando
> `nextLine()` em conjunto com `Integer.parseInt()`, tornando o fluxo de
> entrada mais consistente e facilitando futuras evoluções da interface.
---
