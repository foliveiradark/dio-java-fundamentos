# US-013 — Validar respostas de confirmação (S/N)

---

## Informações Gerais

> **ID:** US-013  
> **Sprint:** Sprint 13  
> **Prioridade:** 🟢 Baixa  
> **Status:** ✅ Concluída

---

## 🎯 Objetivo

Permitir que o jogador informe apenas respostas válidas (`S` ou `N`) nas solicitações de confirmação da aplicação, evitando interpretações incorretas e tornando a interação mais consistente.

---

## ✅ Critérios de Aceitação

- Permitir apenas as respostas `S` ou `N`.
- Aceitar letras maiúsculas e minúsculas (`S`, `s`, `N`, `n`).
- Ignorar espaços antes e depois da resposta.
- Tratar entradas vazias sem encerrar a aplicação.
- Exibir uma mensagem amigável quando a resposta for inválida.
- Solicitar novamente a resposta até que um valor válido seja informado.
- Manter a responsabilidade da validação concentrada na classe `ConsoleInput`.
- Não alterar as regras de negócio existentes.

---

# 🔧 Tarefas Técnicas

## TASK-001

Refatorar o método `ConsoleInput.lerConfirmacao()` para validar a entrada do usuário antes de interpretar a resposta.

**Status:** ✅ Concluída.

---

## TASK-002

Permitir apenas as respostas `S` e `N`, aceitando letras maiúsculas e minúsculas.

**Status:** ✅ Concluída.

---

## TASK-003

Tratar entradas vazias e respostas inválidas exibindo mensagens amigáveis ao usuário.

**Status:** ✅ Concluída.

---

## TASK-004

Solicitar novamente a resposta até que um valor válido seja informado.

**Status:** ✅ Concluída.

---

## TASK-005

Validar todos os cenários previstos.

**Status:** ✅ Concluída.

---

## TASK-006

Validar a Definition of Done da US-013.

**Status:** ✅ Concluída.

---

## Dependências

- US-003 - Menu Principal.
- US-011 — Validar entradas vazias e inválidas do usuário
- US-012 — Permitir entrada de coordenadas em formato A1–I9

---

# Resultado

## Funcionalidades implementadas

- Validação das respostas de confirmação (`S/N`) na classe `ConsoleInput`.
- Aceitação de letras maiúsculas e minúsculas (`S`, `s`, `N`, `n`).
- Normalização automática da entrada utilizando `trim()` e `toUpperCase()`.
- Tratamento de entradas vazias.
- Tratamento de respostas inválidas.
- Exibição de mensagens amigáveis para confirmações inválidas.
- Solicitação automática de nova resposta até que uma entrada válida seja informada.
- Preservação da responsabilidade da validação na camada de interface (`ConsoleInput`).

---

## 📌 Observações

Durante os testes foi identificado que o Menu Principal ainda não valida opções inexistentes. Atualmente qualquer valor diferente das opções disponíveis apenas redesenha o menu, sem informar ao jogador que a opção é inválida.

Essa melhoria foi considerada fora do escopo desta Sprint e registrada no Product Backlog como uma nova User Story.

---