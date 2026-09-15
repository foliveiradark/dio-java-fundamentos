# Sprint 22

## 📋 Informações Gerais

> **Projeto:** Sudoku Java  
> **Sprint:** Sprint 22  
> **User Story:** US-022 — Utilizar candidatos pela interface JavaFX  
> **Prioridade:** 🔴 Alta  
> **Status:** ✅ Concluído.

---

## 🧭 Contexto

A Sprint 22 dá continuidade à evolução da interface JavaFX iniciada nas Sprints anteriores.

A funcionalidade de candidatos já existe no domínio e na aplicação desde a US-017. A Sprint 22 tem como objetivo disponibilizar essa capacidade pela interface JavaFX, sem duplicar regras de negócio ou alterar o comportamento existente da aplicação Console.

A implementação deverá preservar a arquitetura estabelecida nas Sprints 19, 20 e 21, mantendo a interface responsável pela interação e apresentação e `JogoSudoku` como ponto de orquestração das operações.

---

## User Story

**Como** jogador,

**quero** inserir e remover números de rascunho pela interface gráfica,

**para** registrar e ajustar possibilidades durante a resolução do Sudoku.

---

## 🏛️ Referências

- **US-017 — Sistema de rascunhos**
- **US-019 — Preparar arquitetura para múltiplas interfaces**
- **US-020 — Implementar JavaFX GUI**
- **US-021 — Remover número pela interface JavaFX**
- **ADR-011 — Separação entre interface e orquestração**

---

## 📌 Ponto de Partida

- A funcionalidade de candidatos já está implementada no domínio.
- `Casa` possui a operação `alternarCandidato(Integer candidato)`.
- `Casa` mantém os candidatos encapsulados e disponibiliza seu estado por meio de `getCandidatos()`.
- `TipoJogada` já possui o tipo `CANDIDATO`.
- `JogoSudoku.executarJogada(...)` já trata operações do tipo `CANDIDATO`.
- A interface Console já utiliza a funcionalidade de candidatos.
- A arquitetura estabelecida na US-019 separa interface, orquestração e domínio.
- A JavaFX já possui seleção de casas e integração com `JogoSudoku`.
- A US-021 consolidou o fluxo de seleção e interação com casas pela JavaFX.

---

## 📊 Execução

A Sprint 22 foi executada conforme o planejamento definido para a **US-022 — Utilizar candidatos pela interface JavaFX**.

A implementação, validação funcional e Code Review da User Story foram concluídos com sucesso.

**Resultado da US-022:** ✅ Concluída.

---

## 🔍 Code Review

**Status:** ✅ Aprovado.

A implementação da **US-022** foi revisada e aprovada.

Não foram identificadas alterações adicionais de código ou decisões arquiteturais que justificassem mudanças na estrutura existente.

Nenhuma nova ADR foi necessária.

---

## 🏁 Encerramento

A Sprint 22 foi concluída com o objetivo definido para a **US-022** alcançado.

A funcionalidade de candidatos foi disponibilizada na interface JavaFX, mantendo as regras existentes no domínio, a separação de responsabilidades estabelecida nas Sprints anteriores e o funcionamento da interface Console.

A US-022 foi implementada, validada e aprovada em Code Review.

Os pontos de melhoria identificados durante a validação permanecem fora do escopo desta Sprint e poderão ser tratados em trabalhos futuros.

### Situação final

- **US-022:** ✅ Concluída
- **Code Review:** ✅ Aprovado
- **Nova ADR:** ❌ Não necessária
- **Objetivo da Sprint:** ✅ Alcançado

---

## 📚 Resultado da Sprint

**Resultado:** ✅ Objetivo alcançado.

A funcionalidade de candidatos passou a estar disponível na interface gráfica, incluindo inclusão, remoção, visualização e tratamento das restrições existentes.

A implementação preservou a arquitetura estabelecida nas Sprints anteriores e não exigiu novas decisões arquiteturais.

A Sprint encerra a etapa prevista para a US-022 com implementação, validação e Code Review concluídos.

---

## 🔗 Documentação Relacionada

- `docs/stories/US-022-utilizar-candidatos-javafx.md`
- `docs/roadmap.md`
- `docs/backlog.md`
- `docs/guide.md`
- `docs/development-diary.md`
- `docs/changelog.md`
- `docs/adr/ADR-011-*.md`
