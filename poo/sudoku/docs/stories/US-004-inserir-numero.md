# US-004 — Inserir um número

---

## Informações Gerais

> **ID:** US-004  
> **Sprint:** Sprint 4  
> **Prioridade:** Alta 🔴  
> **Status:** ✅ Concluída

---

## 🎯 Objetivo

Permitir que o jogador insira um número em uma posição para resolver o Sudoku.

---

## ✅ Critérios de Aceitação

* O jogador deve informar a linha.
* O jogador deve informar a coluna. 
* O jogador deve informar o número. 
* O sistema deve localizar a casa correspondente. 
* Apenas casas não fixas podem ser alteradas. 
* O tabuleiro deve ser atualizado. 
* O tabuleiro deve ser exibido novamente após a jogada.

---

# 🔧 Tarefas Técnicas

## TASK-001

Adicionar um método genérico na classe `ConsoleInput`.

**Status:** ✅ Concluído

---

## TASK-002

Implementar o fluxo para iniciar uma nova partida.

**Status:** ✅ Concluído

---

## TASK-003

Exibir o `tabuleiro`.

**Status:** ✅ Concluído

---

## TASK-004

Iniciar o fluxo da partida.

**Status:** ✅ Concluído

---

## TASK-005

Solicitar a `linha:` ao jogador.

**Status:** ✅ Concluído

---

## TASK-006

Solicitar a `coluna:` ao jogador.

**Status:** ✅ Concluído

---

## TASK-007

Solicitar o `numero:` ao jogador.

**Status:** ✅ Concluído

---

## TASK-008

Localizar a `casa`.

**Status:** ✅ Concluído.

---

## TASK-009

Preencher a `casa`.

**Status:** ✅ Concluído

---

## TASK-010

Reimprimir o  `tabuleiro`.

**Status:** ✅ Concluído

---
# Resultado

## Funcionalidades implementadas

- Solicitação da linha;
- Solicitação da coluna;
- Solicitação do número;
- Localização da casa selecionada;
- Inserção de números em casas editáveis;
- Validação de casas fixas;
- Atualização do estado do tabuleiro;
- Reimpressão do tabuleiro após cada jogada.

---

## 📌 Observações

>Esta User Story trata apenas da inserção de números no tabuleiro.  
A validação das regras do Sudoku será implementada em uma User Story específica.

>Durante os testes foi identificado um problema na inicialização das casas fixas.  
A solução adotada consistiu em refatorar o carregamento do tabuleiro para que casas fixas sejam
criadas diretamente durante a inicialização, em vez de serem preenchidas posteriormente.  
Essa alteração tornou o modelo mais consistente e eliminou o problema de edição de casas fixas.

---