# Sprint 21 — Remover número pela interface JavaFX

---

## 📋 Informações Gerais

> **Projeto:** Sudoku Java
> **Sprint:** Sprint 21
> **User Story:** US-021 — Remover número pela interface JavaFX
> **Prioridade:** 🔴 Alta
> **Status:** 🟢 Concluída

---

## 🎯 Objetivo da Sprint

Implementar a possibilidade de remover uma jogada realizada pelo jogador através da interface gráfica JavaFX, dando continuidade à evolução incremental da GUI iniciada na Sprint 20.

---

## 🧭 Contexto

A Sprint 21 representa a primeira evolução funcional da interface gráfica após a conclusão da US-020 — Primeiro vertical slice jogável com JavaFX.

A Sprint parte da arquitetura consolidada nas Sprints 19 e 20, mantendo a separação entre interface, aplicação, domínio e persistência.

A evolução da GUI continua sendo realizada de forma incremental, sem buscar paridade funcional completa com a interface Console.

---

## 🧩 User Story

**US-021 — Remover número pela interface JavaFX**

**Como jogador**

Quero remover uma jogada pela interface gráfica

Para corrigir um número inserido anteriormente.

A definição completa da User Story, incluindo critérios de aceitação, escopo, dependências, TASKs, validações e Definition of Done, está registrada em:

`docs/stories/US-021-remover-numero-javafx.md`

---

## 🏛️ Referências

A Sprint utiliza como principais referências:

* `US-021 — Remover número pela interface JavaFX`;
* `ADR-011 — Separação entre interface e orquestração da aplicação`;
* documentação da Sprint 20;
* Product Backlog;
* Roadmap.

---

## 📌 Ponto de Partida

A Sprint 21 iniciou a partir do estado consolidado ao final da Sprint 20.

O projeto já possuía:

* interface JavaFX funcional;
* primeiro vertical slice jogável;
* seleção de casas;
* inserção de números;
* atualização visual do tabuleiro;
* arquitetura preparada para múltiplas interfaces;
* interface Console preservada.

A Sprint concentrou-se exclusivamente na evolução definida pela US-021.

---

## 📊 Execução

A implementação da US-021 foi realizada de forma incremental conforme o planejamento definido para a Sprint.

As atividades executadas, respectivas validações e resultados estão documentados na própria User Story:

`docs/stories/US-021-remover-numero-javafx.md`

Durante a execução, foi identificada uma inconsistência preexistente no fluxo de remoção do Console, relacionada à apresentação da mensagem de confirmação após tentativas inválidas.

A correção foi realizada de forma incidental, diretamente relacionada à funcionalidade em desenvolvimento, sem alteração do escopo da Sprint ou da arquitetura existente.

---

## 🔍 Code Review

O Code Review foi realizado após a implementação.

A revisão confirmou que a solução permaneceu alinhada à arquitetura estabelecida nas Sprints anteriores, sem duplicação das regras do Sudoku na interface JavaFX e sem introdução de abstrações ou refatorações desnecessárias.

Nenhuma decisão arquitetural existente precisou ser reaberta.

---

## 🏁 Encerramento

A Sprint 21 atingiu seu objetivo.

A interface JavaFX passou a permitir a remoção de jogadas realizadas pelo jogador, mantendo a responsabilidade da regra de remoção no domínio e utilizando o fluxo arquitetural existente.

A funcionalidade foi validada nos cenários definidos pela US-021, incluindo operações válidas, tentativas inválidas, atualização visual, continuidade da interação e preservação do funcionamento do Console.

Não foi identificada necessidade de criação de novo ADR.

A US-021 encontra-se **🟢 Concluída**.

---

## 📚 Resultado da Sprint

A evolução funcional do projeto passa a representar:

```text
Sprint 20
Primeiro vertical slice JavaFX
        ↓
Sprint 21
Remoção de jogadas pela GUI
        ↓
Próximas evoluções
definidas no Product Backlog
```

A Sprint mantém a estratégia estabelecida para a evolução do produto: implementar funcionalidades de forma incremental, validar cada etapa e preservar a arquitetura existente antes de avançar para a próxima evolução.

---

## 🔗 Documentação Relacionada

* `docs/stories/US-021-remover-numero-javafx.md`
* `docs/adr/ADR-011-*.md`
* `docs/sprints/sprint-20.md`
* `docs/05-backlog.md`
* `docs/06-roadmap.md`
