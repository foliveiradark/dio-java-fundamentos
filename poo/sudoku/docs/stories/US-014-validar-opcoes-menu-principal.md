# US-014 — Validar opções do Menu Principal

---

## Informações Gerais

> **ID:** US-014  
> **Sprint:** Sprint 14  
> **Prioridade:** 🟢 Baixa  
> **Status:** ✅ Concluída

---

## 🎯 Objetivo

Melhorar a experiência do jogador durante a navegação no Menu Principal, impedindo que opções inexistentes sejam aceitas silenciosamente.

---

## ✅ Critérios de Aceitação

- Permitir apenas opções existentes no Menu Principal.
- Exibir uma mensagem amigável quando uma opção inválida for informada.
- Solicitar novamente a opção até que um valor válido seja informado.
- Não encerrar a aplicação após uma opção inválida.
- Não redesenhar o fluxo da aplicação desnecessariamente.
- Manter a validação concentrada na camada de entrada (`ConsoleInput`).
- Não alterar as regras de negócio existentes.

---

# 🔧 Tarefas Técnicas

## TASK-001

Adicionar validação das opções disponíveis no Menu Principal.

**Status:** ✅ Concluída.

---

## TASK-002

Exibir mensagem amigável para opções inválidas.

**Status:** ✅ Concluída.

---

## TASK-003

Solicitar novamente a opção até que uma entrada válida seja informada.

**Status:** ✅ Concluída.

---

## TASK-004

Validar todos os cenários previstos.

**Status:** ✅ Concluída.

---

## TASK-005

Validar a Definition of Done da US-014.

**Status:** ✅ Concluída.

---

## Dependências

- US-003 - Menu Principal.

---

# Resultado

## Funcionalidades implementadas

- Validação das opções do Menu Principal.
- Aceitação apenas das opções disponíveis (`0`, `1` e `2`).
- Tratamento de entradas vazias.
- Tratamento de entradas não numéricas.
- Tratamento de opções inexistentes.
- Exibição de mensagens amigáveis para opções inválidas.
- Solicitação automática de nova opção até que uma entrada válida seja informada.
- Refatoração do fluxo do Menu Principal utilizando `switch`.
- Preservação da responsabilidade da validação na classe `ConsoleInput`.
---

## 📌 Observações

Durante a implementação foi realizada uma pequena refatoração no método `executarMenuPrincipal()`,
substituindo a estrutura baseada em `if/else` por um `switch`.

A alteração não modificou o comportamento da aplicação, mas tornou o código mais legível e 
preparado para a evolução do Menu Principal, que deverá receber novas opções nas próximas 
User Stories.

Essa refatoração foi considerada uma melhoria de legibilidade e não gerou impacto nas regras 
de negócio.

---