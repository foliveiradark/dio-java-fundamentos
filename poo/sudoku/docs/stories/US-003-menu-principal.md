# US-003 — Menu Principal

---

## Informações Gerais

> **ID:** US-003  
> **Sprint:** Sprint 3  
> **Prioridade:** Alta 🔴  
> **Status:** ✅ Concluída

---

## 🎯 Objetivo

Permitir que o jogador visualize um menu inicial e escolha a primeira ação da aplicação.

---

## ✅ Critérios de Aceitação

* O sistema deve exibir um menu principal ao iniciar.
* O usuário deve poder escolher uma opção.
* O sistema deve ler a opção digitada.
* A opção "Sair" deve encerrar a aplicação.

---

# 🔧 Tarefas Técnicas

## TASK-001

Criar a classe `JogoSudoku`.

**Status:** ✅ Concluído

---

## TASK-002

Criar o método responsável por iniciar o jogo.

**Status:** ✅ Concluído

---

## TASK-003

Exibir o menu principal.

**Status:** ✅ Concluído

---

## TASK-004

Ler a opção do usuário.

**Status:** ✅ Concluído

---

## TASK-005

Encerrar a aplicação ao selecionar "Sair".

**Status:** ✅ Concluído

---

## Resultado

A aplicação passou a possuir um fluxo inicial de execução.

Ao iniciar o sistema, o jogador visualiza o menu principal, pode selecionar uma opção e permanecer na aplicação até escolher encerrar a execução.

---

## 📌 Observações

Nesta etapa foi criada a estrutura responsável por coordenar o fluxo inicial da aplicação, separando responsabilidades entre entrada de dados (`ConsoleInput`), apresentação do menu (`Menu`) e impressão de mensagens (`ConsolePrinter`).

A implementação foi construída de forma incremental, permitindo evoluções futuras sem alterar a arquitetura principal.