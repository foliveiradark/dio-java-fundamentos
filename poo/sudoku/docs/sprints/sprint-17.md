# 🔄 Sprint 17 — Sistema de rascunhos

## 🎯 Objetivo

Implementar o sistema de rascunhos do Sudoku, permitindo que o jogador registre números candidatos nas casas editáveis durante a resolução da partida.

A funcionalidade deverá preservar a separação entre domínio e interface e considerar a futura evolução do projeto para uma interface gráfica.

---

## 📦 Escopo

- US-017 — Sistema de rascunhos.

---

## ✅ Critérios de Aceitação

- Permitir que uma casa editável possua múltiplos números candidatos.
- Permitir adicionar e remover candidatos por meio de uma operação de toggle.
- Informar ao jogador se o candidato foi adicionado ou removido.
- Impedir operações de rascunho em casas fixas.
- Impedir operações de rascunho em casas que já possuem número definitivo.
- Utilizar `Set<Integer>` para representar os candidatos no domínio.
- Remover automaticamente os candidatos quando um número definitivo for atribuído à casa.
- Não restaurar candidatos anteriores quando um número definitivo for removido.
- Manter a interpretação da sintaxe de rascunho na interface de console.
- Não permitir que a representação do domínio dependa da sintaxe utilizada pela interface.
- Preservar a possibilidade de utilização da mesma operação por uma futura interface gráfica.
- Apresentar múltiplos candidatos dentro da própria célula do tabuleiro.
- Preservar as regras de negócio e responsabilidades existentes.

---

# 📋 Planejamento da Sprint

A implementação foi realizada de forma incremental.

As tarefas técnicas foram definidas e refinadas durante a análise da User Story, antes e durante a implementação.

A execução foi organizada em etapas envolvendo:

1. representação dos candidatos no domínio;
2. implementação da operação de toggle;
3. definição das regras de consistência;
4. proteção de casas fixas e preenchidas;
5. interpretação da sintaxe de rascunho na interface;
6. feedback ao jogador;
7. apresentação visual dos candidatos;
8. integração ao fluxo da partida;
9. validação dos principais cenários;
10. validação da Definition of Done.

---

## Sprint Review

### User Stories concluídas

- ✅ US-017 — Sistema de rascunhos.

---

### Entregas realizadas

#### Domínio

- Representação dos candidatos na entidade `Casa`.
- Utilização de `Set<Integer>` para armazenamento dos candidatos.
- Operação de toggle para adicionar e remover candidatos.
- Validação dos candidatos utilizando as regras existentes da entidade.
- Bloqueio de candidatos em casas fixas.
- Bloqueio de candidatos em casas que possuem número definitivo.
- Remoção automática dos candidatos ao atribuir um número definitivo.
- Não restauração de candidatos após a remoção do número definitivo.
- Encapsulamento da coleção de candidatos por meio de uma cópia imutável na consulta.

#### Fluxo da aplicação

- Criação da representação `Jogada`.
- Criação do enum `TipoJogada`.
- Integração das jogadas definitivas e de candidato ao fluxo de `JogoSudoku`.
- Preservação da responsabilidade da entidade `Casa` sobre as regras de domínio.

#### Interface

- Interpretação da sintaxe `*1` até `*9` para candidatos.
- Manutenção da sintaxe específica do console exclusivamente na camada `ui`.
- Mensagem de confirmação para candidato adicionado.
- Mensagem de confirmação para candidato removido.
- Mensagens para entradas de jogada inválidas.
- Apresentação dos candidatos dentro da célula do tabuleiro.
- Representação visual dos candidatos utilizando uma grade interna 3×3.
- Preservação da representação centralizada para números definitivos.
- Preservação da estrutura visual do tabuleiro.

#### Validação

- Validação de candidatos únicos.
- Validação de múltiplos candidatos.
- Validação da operação de toggle.
- Validação da remoção de candidatos.
- Validação de casas fixas.
- Validação de casas preenchidas.
- Validação da limpeza automática dos candidatos.
- Validação da não restauração dos candidatos.
- Validação da integração com o fluxo da partida.
- Validação da apresentação visual.
- Validação da Definition of Done da US-017.

---

### Débitos técnicos

Não foram identificados débitos técnicos bloqueadores para o encerramento da Sprint.

Possíveis evoluções futuras deverão ser tratadas como novas tarefas ou User Stories, evitando ampliar o escopo da US-017 após sua conclusão.

---

## 📌 Observações

Esta Sprint introduziu uma nova capacidade de interação do jogador, preservando a separação existente entre domínio e interface.

A sintaxe utilizada no console para representar uma operação de rascunho é tratada exclusivamente como detalhe da interface.

O domínio recebe a intenção da operação por meio de `TipoJogada` e o valor numérico correspondente, sem conhecimento do prefixo `*`.

A representação dos candidatos permanece no domínio, permitindo que uma futura interface gráfica utilize a mesma funcionalidade sem depender da sintaxe adotada no console.

A implementação segue o princípio registrado em:

- PR-001 — Independência do domínio em relação à interface.

Também respeita as decisões arquiteturais relacionadas à separação entre domínio, serviço e interface.

---

## 🔗 Relações

### Roadmap

- Fase 6 — Evolução do Produto.
- Fase 7 — Interface Gráfica.

### Princípios

- PR-001 — Independência do domínio em relação à interface.

### ADRs relacionados

- ADR-001 — Separação entre domínio e interface.
- ADR-005 — Organização da interface de console.
- ADR-008 — Reorganização da execução das funcionalidades.

### User Story

- US-017 — Sistema de rascunhos.

---

## Status

✅ Concluída
