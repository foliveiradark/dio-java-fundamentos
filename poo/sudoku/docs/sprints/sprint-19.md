# Sprint 19 — Preparação da arquitetura para múltiplas interfaces

---

## 📋 Informações Gerais

> **Projeto:** Sudoku Java
> **Sprint:** Sprint 19
> **User Story:** US-019 — Preparar arquitetura para múltiplas interfaces
> **Prioridade:** 🔴 Alta
> **Status:** 🟢 Concluída
> **Início:** 22/08/2026
> **Encerramento:** 24/08/2026

---

## 🎯 Objetivo da Sprint

Preparar a arquitetura da aplicação para permitir a utilização de
diferentes tecnologias de interface, preservando o domínio, as regras
do Sudoku, a persistência e o comportamento funcional existente.

A Sprint representa uma etapa arquitetural anterior à implementação
da primeira interface gráfica do produto.

---

## 🧭 Contexto

O projeto possui atualmente uma interface de console funcional.

A próxima evolução do produto será a criação de uma interface gráfica
desktop, com objetivo de transformar o projeto em um jogo real,
visualmente apresentado e futuramente distribuível ao usuário final.

Antes dessa evolução, foi realizada uma preparação arquitetural para
evitar que a nova interface seja construída diretamente sobre os
componentes específicos do console.

A arquitetura estabeleceu uma separação clara entre:

```text
Interface
    ↓
Orquestração da aplicação
    ↓
Domínio / Persistência
```

O `JogoSudoku` permanece responsável pela orquestração do fluxo da
aplicação, enquanto as interfaces são responsáveis pela interação
específica com o usuário.

---

## 🏁 Escopo da Sprint

### Incluído

* execução da US-019;
* mapeamento das responsabilidades da interface atual;
* identificação dos acoplamentos entre `JogoSudoku` e console;
* definição dos contratos necessários para a separação;
* refatoração incremental da arquitetura;
* manutenção do funcionamento do console;
* validação do comportamento existente;
* registro das decisões arquiteturais relevantes;
* avaliação da estratégia tecnológica da próxima fase;
* atualização da documentação.

### Não incluído

* implementação da interface gráfica;
* implementação do JavaFX;
* implementação do Maven;
* definição do design visual;
* distribuição do jogo;
* empacotamento da aplicação;
* novas funcionalidades de Sudoku.

---

## 🏛️ Direção Arquitetural

A Sprint consolidou a decisão de que o `JogoSudoku` deverá atuar como
orquestrador da aplicação, enquanto a interface será responsável pelo
canal de interação com o usuário.

Foram definidos os contratos:

* `InterfaceUsuario` — abstração das operações de entrada;
* `InterfaceApresentacao` — abstração das operações de apresentação.

A implementação Console utiliza esses contratos através de:

* `ConsoleInput`;
* `ConsolePrinter`.

A separação permite que uma futura interface gráfica utilize o fluxo
da aplicação sem duplicação das regras do Sudoku.

Não foram identificadas novas abstrações necessárias durante o
Code Review da Sprint.

---

## 🧩 User Story

**US-019 — Preparar arquitetura para múltiplas interfaces**

A User Story foi executada conforme seu escopo e critérios de
aceitação.

As Tasks 001 a 007 foram concluídas.

A validação manual confirmou a preservação dos principais fluxos
funcionais da aplicação através da interface Console, incluindo
criação, execução, alteração, remoção, limpeza, consulta de status,
salvamento, continuação e encerramento de partidas.

---

### ADRs relacionados

* ADR-011 — Separação entre interface e orquestração da aplicação

---

## 🛠️ Estratégia tecnológica definida

Durante a TASK-007 foram avaliadas as alternativas tecnológicas para
a próxima fase.

### Sistema de build

**Maven** foi definido como sistema de build recomendado para a
próxima fase, substituindo progressivamente o gerenciamento manual
atual de dependências e compilação através da IDE.

### Tecnologia gráfica

**JavaFX** foi definido como a tecnologia gráfica escolhida para a
futura interface desktop.

A implementação de Maven e JavaFX não faz parte da Sprint 19 e deverá
ser realizada em etapa posterior.

---

## 🔎 Resultado da Sprint

A arquitetura da aplicação foi preparada para suportar diferentes
interfaces sem duplicação das regras fundamentais do Sudoku.

O console permanece funcional e os fluxos existentes foram validados
após a refatoração.

O `JogoSudoku` não depende mais diretamente das implementações
específicas de Console utilizadas para entrada e apresentação.

O domínio e a persistência permanecem independentes da tecnologia de
interação.

A Sprint também estabeleceu a direção tecnológica para a próxima fase:

```text
Arquitetura desacoplada
        ↓
Maven
        ↓
JavaFX
        ↓
Interface gráfica
```

---

## 📝 Code Review

O Code Review da US-019 foi realizado após a conclusão das Tasks.

Resultado:

**🟢 Aprovado**

Não foram identificadas violações das decisões arquiteturais
registradas ou pontos de acoplamento relevantes que justifiquem novas
refatorações nesta Sprint.

A relação interna entre `ConsoleInput` e `ConsolePrinter` foi
considerada uma característica da implementação específica do Console,
não constituindo bloqueio arquitetural para a conclusão da US-019.

---

## ✅ Definition of Done da Sprint

* [x] US-019 concluída;
* [x] Arquitetura preparada para múltiplas interfaces;
* [x] Console funcionando;
* [x] Funcionalidades existentes preservadas;
* [x] Validação regressiva realizada;
* [x] Código revisado;
* [x] Documentação atualizada;
* [x] ADRs atualizadas quando necessário;
* [x] Build executado com sucesso;
* [x] Commit realizado;
* [x] Push realizado.

---

## 📌 Próximo Ponto de Retomada

Após o encerramento da Sprint 19, a próxima etapa deverá considerar
a implementação da estratégia tecnológica definida nesta Sprint,
começando pela configuração do sistema de build com Maven e,
posteriormente, pela introdução da interface gráfica JavaFX.

A implementação deverá ocorrer em uma nova User Story, mantendo a
separação arquitetural estabelecida pela US-019.