# US-011 — Validar entradas vazias e inválidas do usuário

---

## Informações Gerais

> **ID:** US-011  
> **Sprint:** Sprint 11  
> **Prioridade:** 🟢 Baixa  
> **Status:** ✅ Concluída

---

## 🎯 Objetivo

Permitir que o jogador informe apenas entradas válidas, evitando o encerramento inesperado da aplicação e proporcionando uma interação mais robusta.

---

## ✅ Critérios de Aceitação

* Permitir que o usuário informe apenas entradas válidas para números inteiros.
* Tratar entradas vazias sem encerrar a aplicação.
* Tratar entradas não numéricas sem encerrar a aplicação.
* Exibir mensagens de erro claras ao usuário.
* Solicitar novamente a entrada até que um valor válido seja informado.
* Manter a responsabilidade da validação concentrada na camada `ConsoleInput`.
* Não alterar as regras de negócio existentes.
---

# 🔧 Tarefas Técnicas

## TASK-001

Preparar o método `ConsoleInput.lerInteiro()` para validar a entrada do usuário antes da conversão para inteiro.

**Status:** ✅ Concluída

---

## TASK-002

Implementar o fluxo de repetição para tratar entradas vazias e valores não numéricos, garantindo que o método retorne apenas um inteiro válido.

**Status:** ✅ Concluída

---

## TASK-003

Exibir mensagens amigáveis ao usuário quando a entrada for inválida.

**Status:** ✅ Concluída

---

## TASK-004

Solicitar novamente a entrada até que um valor válido seja informado.

**Status:** ✅ Concluída

---

## TASK-005

Validar todos os cenários previstos.

**Status:** ✅ Concluída

---

## TASK-006

Validar a Definition of Done da US-011.

**Status:** ✅ Concluída

---

## Dependências

- US-003 - Menu Principal.

---

# Resultado

## Funcionalidades implementadas

* Tratamento de entradas vazias utilizando `String.isBlank()`.
* Tratamento de entradas não numéricas (`NumberFormatException`).
* Exibição de mensagens amigáveis para entradas inválidas.
* Solicitação automática de nova entrada até que um valor válido seja informado.
* Centralização da validação de entrada na classe `ConsoleInput`, preservando a arquitetura da aplicação.
 
---

## 📌 Observações

Durante o Sprint Planning foi definido que toda a validação das entradas permaneceria concentrada na classe `ConsoleInput`, preservando a separação de responsabilidades adotada pela arquitetura da aplicação.

Como essa decisão representa apenas a aplicação de princípios arquiteturais já estabelecidos no projeto, não houve necessidade de criação de uma nova ADR.

---