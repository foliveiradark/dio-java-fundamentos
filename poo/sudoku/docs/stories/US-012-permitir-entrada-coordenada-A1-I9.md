# US-012 — Permitir entrada de coordenadas em formato A1–I9

---

## Informações Gerais

> **ID:** US-012  
> **Sprint:** Sprint 12  
> **Prioridade:** 🟢 Baixa  
> **Status:** ✅ Concluída

---

## 🎯 Objetivo

Permitir que o jogador informe as coordenadas do tabuleiro utilizando o formato A1–I9, tornando a interação mais intuitiva.

---

## ✅ Critérios de Aceitação

- Permitir que o jogador informe a posição utilizando o formato A1–I9.
- Converter automaticamente a coordenada informada para os índices internos utilizados pela aplicação.
- Aceitar letras maiúsculas e minúsculas (ex.: `A1` e `a1`).
- Validar o formato da coordenada antes da execução da jogada.
- Exibir uma mensagem amigável quando a coordenada informada for inválida.
- Solicitar novamente a coordenada até que um valor válido seja informado.
- Manter o domínio da aplicação utilizando exclusivamente índices numéricos internos.
- Não alterar as regras de negócio existentes.

---

# 🔧 Tarefas Técnicas

## TASK-001

Criar um método responsável por converter a coordenada informada pelo jogador (ex.: `A1`)
em índices internos (`linha` e `coluna`).

**Status:** ✅ Concluída.

---

## TASK-002

Refatorar o fluxo da partida para utilizar uma única entrada de coordenada em substituição 
às solicitações separadas de linha e coluna.

**Status:** ✅ Concluída.

---

## TASK-003

Validar o formato da coordenada informada pelo jogador.

Critérios:

- aceitar apenas coordenadas entre **A1** e **I9**;
- aceitar letras maiúsculas e minúsculas;
- impedir formatos inválidos.

**Status:** ✅ Concluída.

---

## TASK-004

Exibir mensagens amigáveis quando a coordenada informada for inválida e solicitar 
uma nova entrada até que uma coordenada válida seja informada.

**Status:** ✅ Concluída.

---

## TASK-005

Validar todos os cenários previstos.

**Status:** ✅ Concluída.

---

## TASK-006

Validar a Definition of Done da US-012.

**Status:** ✅ Concluída.

---

## Dependências

- US-003 - Menu Principal.
- US-004 - Inserir um número.
- US-007 - Remover um número.
- US-011 - Validar entradas vazias e inválidas do usuário.

---

# Resultado

## Funcionalidades implementadas

* Leitura de coordenadas no formato A1–I9.
* Conversão automática da coordenada para índices internos (`linha` e `coluna`).
* Aceitação de letras maiúsculas e minúsculas.
* Normalização automática da entrada (`trim()` e `toUpperCase()`).
* Validação do formato da coordenada antes da execução da jogada.
* Tratamento de entradas vazias.
* Tratamento de coordenadas inválidas.
* Solicitação automática de nova coordenada até que uma entrada válida seja informada.
* Refatoração do fluxo da partida para utilizar uma única entrada de coordenada.
* Preservação do domínio utilizando apenas índices numéricos internos.

---

## 📌 Observações

### Oportunidade de melhoria identificada

Durante os testes foi identificado que as confirmações do sistema (`S/N`) ainda utilizam o método `lerConfirmacao()`, que aceita qualquer entrada diferente de `S` como resposta negativa.

Exemplo:

```text
Deseja remover o número? (S/N): d7
```

Nesse cenário, a aplicação interpreta a entrada como **"Não"**, embora o valor informado não represente uma resposta válida.

Como melhoria futura, o método poderá receber uma validação semelhante à implementada em `lerCoordenada()` e `lerInteiro()`, solicitando uma nova entrada até que o usuário informe apenas `S` ou `N`.

Essa melhoria foi considerada fora do escopo desta Sprint.

---

### Evolução arquitetural

Durante a implementação foi identificado que o método `converterCoordenada()` retorna um vetor (`int[]`) contendo os índices de linha e coluna.

Para este projeto, essa abordagem foi considerada suficiente por manter a implementação simples e alinhada ao objetivo de aprendizado.

Como possível evolução arquitetural, poderá ser criada futuramente uma classe de valor (`Coordenada`) para representar explicitamente uma posição do tabuleiro, aumentando a legibilidade do código, reduzindo o uso de índices posicionais (`posicao[0]` e `posicao[1]`) e tornando a API do domínio mais expressiva.

Essa melhoria foi considerada fora do escopo desta Sprint e registrada como oportunidade de evolução futura.


---