# US-009 — Limpar Tabuleiro

---

## Informações Gerais

> **ID:** US-009  
> **Sprint:** Sprint 9  
> **Prioridade:** 🟠 Média  
> **Status:** Não Iniciada

---

## 🎯 Objetivo

Permitir que o jogador remova todas as jogadas realizadas, mantendo apenas os números fixos.

---

## ✅ Critérios de Aceitação

* Permitir limpar todas as jogadas realizadas pelo jogador;
* Preservar todas as casas fixas do tabuleiro inicial; 
* Restaurar todas as casas editáveis para o estado vazio (null); 
* Não alterar os números do tabuleiro inicial; 
* Reimprimir o tabuleiro após a limpeza; 
* Solicitar confirmação antes da limpeza (S/N); 
* A operação deve funcionar independentemente da quantidade de jogadas realizadas.

---

# 🔧 Tarefas Técnicas

## TASK-001

Adicionar o método `limparJogadas()` na classe `Tabuleiro`.

**Status:** ✅ Concluída.

---

## TASK-002

Implementar a limpeza apenas das casas não fixas.

**Status:** ✅ Concluída.

---

## TASK-003

Adicionar a operação correspondente em `JogoSudoku`.

**Status:** ✅ Concluída.

---

## TASK-004

Validar que a funcionalidade `limparJogadas` funciona corretamente em todos os 
cenários previstos.

**Status:** ✅ Concluída.

---

## TASK-005

Reimprimir o tabuleiro após a limpeza

**Status:** ✅ Concluída.

---

## TASK-006

Validar a Definition of Done da US-009

**Status:** ✅ Concluída.

---

## Dependências

- US-007 — Remover Número

---

# Resultado

## Funcionalidades implementadas

* Método `limparJogadas()` implementado na classe `Tabuleiro`;
* Limpeza apenas das casas editáveis;
* Casas fixas preservadas durante a operação;
* Casas já vazias ignoradas automaticamente;
* Solicitação para limpar todas as jogadas;
* Confirmação antes da limpeza;
* Reimpressão automática do tabuleiro após a limpeza;
* Mensagem de confirmação exibida ao jogador.

---

## 📌 Observações

A implementação reutilizou o método `removerNumero()` da classe `Casa`,
preservando o encapsulamento e evitando duplicação de lógica.

A responsabilidade pela limpeza permaneceu centralizada na classe
`Tabuleiro`, enquanto `JogoSudoku` apenas coordena o fluxo da aplicação,
mantendo a separação de responsabilidades adotada desde as Sprints
anteriores.

Foi adicionada uma confirmação antes da limpeza para evitar a perda
acidental das jogadas realizadas pelo jogador.

---