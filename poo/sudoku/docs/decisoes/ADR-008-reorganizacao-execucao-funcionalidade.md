# ADR-008 — Reorganização da ordem de execução das funcionalidades futuras

## Status

Aceito

---

## Contexto

Durante a revisão do Roadmap e do Product Backlog do projeto Sudoku,
foi identificada uma divergência entre a ordem das funcionalidades
apresentadas nos dois artefatos.

A análise da evolução do produto demonstrou que a ordem numérica das
User Stories não representa necessariamente a melhor sequência de
implementação.

As funcionalidades futuras atualmente identificadas são:

- US-016 — Interface gráfica (Swing)
- US-017 — Sistema de rascunhos
- US-018 — Continuar partida
- US-019 — Estatísticas da partida

Considerando as dependências funcionais, a evolução incremental do
produto e a preservação da arquitetura existente, foi analisada uma
nova ordem de execução.

---

## Decisão

Reorganizar a ordem de execução das funcionalidades futuras sem alterar
os identificadores das User Stories.

A nova sequência planejada será:

1. US-017 — Sistema de rascunhos
2. US-018 — Continuar partida
3. US-019 — Estatísticas da partida
4. US-016 — Interface gráfica (Swing)

Os identificadores das User Stories permanecerão estáveis, sendo
utilizados exclusivamente para identificação e rastreabilidade.

A prioridade e a ordem de execução serão tratadas separadamente do
identificador da User Story.

---

## Justificativa

A reorganização permite evoluir primeiro as funcionalidades relacionadas
ao fluxo da partida antes da introdução de uma nova camada de
apresentação.

A interface gráfica utilizando Swing será desenvolvida posteriormente,
permitindo aproveitar a arquitetura e as regras de negócio já
construídas, reduzindo a necessidade de alterações estruturais no
domínio da aplicação.

A decisão também preserva a rastreabilidade histórica das User Stories,
evitando a renumeração de itens que já podem ser referenciados por outros
artefatos do projeto.

---

## Consequências

### Positivas

- Mantém estáveis os identificadores das User Stories.
- Preserva a rastreabilidade entre os artefatos.
- Permite organizar a execução conforme dependências funcionais.
- Favorece o desenvolvimento incremental.
- Permite que a interface gráfica seja construída sobre uma arquitetura
  já validada.

### Negativas

- A numeração das User Stories não representa a ordem de execução.
- Será necessário consultar a prioridade ou o Roadmap para compreender
  a sequência planejada.

## Artefatos afetados

- Product Backlog
- Roadmap
- Sprints futuras

---

## Relação com princípios

Esta decisão reforça o princípio:

> Identificadores de User Stories devem permanecer estáveis; prioridade
> e ordem de execução devem ser tratadas separadamente.

---

## Data

03/08/2026