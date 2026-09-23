# Sprint 23 — Limpar jogadas pela interface JavaFX

> **Status:** 🟢 Concluída  
> **Fase:** 7 — Expansão da interface JavaFX  
> **Produto:** Sudoku Java  
> **US principal:** US-023 — Limpar jogadas pela interface JavaFX

---

## Objetivo

Disponibilizar na interface JavaFX a operação de limpeza das jogadas realizadas pelo jogador, reutilizando a regra já existente no domínio e preservando a arquitetura definida para múltiplas interfaces.

---

## Contexto

A aplicação já possui a operação `Tabuleiro.limparJogadas()`, utilizada pelo fluxo da aplicação em modo Console.

A interface JavaFX ainda não disponibiliza essa ação.

A Sprint tem como foco **expor essa funcionalidade existente na nova interface**, sem alterar sua semântica.

---

## Escopo da Sprint

* Disponibilizar a ação de limpar jogadas na interface JavaFX.
* Encaminhar a operação pela camada de aplicação existente.
* Reutilizar a regra de limpeza já presente no domínio.
* Atualizar a representação visual do tabuleiro após a operação.
* Preservar números fixos.
* Preservar candidatos existentes.
* Manter o funcionamento das demais operações já implementadas.
* Validar a não regressão da interface Console.

---

## Fora do escopo

* Alteração da regra de `Tabuleiro.limparJogadas()`.
* Criação de uma nova regra de limpeza específica para JavaFX.
* Remoção de candidatos durante a limpeza.
* Implementação de um mecanismo de reinício completo da partida.
* Alterações nas funcionalidades de salvar ou continuar partida.
* Refinamentos gerais de UX da interface.
* Preparação da distribuição desktop.

---

## Unidade de entrega

A entrega desta Sprint está concentrada na:

**US-023 — Limpar jogadas pela interface JavaFX**

Os critérios de aceitação, decisões técnicas e tarefas de implementação pertencem ao documento da US.

---

## Dependências

* US-022 — Candidatos pela interface JavaFX concluída.
* Arquitetura definida para múltiplas interfaces.
* Operação de limpeza existente no domínio.
* Interface JavaFX funcional.

---

## Encerramento

A Sprint será encerrada após:

* implementação da US;
* validação dos critérios de aceitação;
* Code Review;
* validação do DoD;
* atualização da documentação;
* commit conforme Conventional Commits;
* push para o repositório;
* confirmação de working tree limpo.

---

## Referências

* US-023 — Limpar jogadas pela interface JavaFX
* ADR-011 — Arquitetura para múltiplas interfaces
* US-022 — Candidatos pela interface JavaFX
