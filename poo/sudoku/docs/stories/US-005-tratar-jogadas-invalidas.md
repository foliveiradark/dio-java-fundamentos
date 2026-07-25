# US-005 — Tratar jogadas inválidas

---

## Informações Gerais

> **ID:** US-005  
> **Sprint:** Sprint 5  
> **Prioridade:** Alta 🔴  
> **Status:** ✅ Concluída.

---

## 🎯 Objetivo

Permitir que a aplicação trate erros durante a partida sem encerrar o jogo.

---

## ✅ Critérios de Aceitação

* O jogo não deve ser encerrado após uma jogada inválida. 
* O erro deve ser informado ao jogador. 
* O jogador deve poder tentar novamente. 
* O fluxo da partida deve continuar normalmente.

---

# 🔧 Tarefas Técnicas

## TASK-001

Identificar onde as exceções devem ser capturadas.

**Status:** ✅ Concluída.

---
## TASK-002

Capturar exceções durante a execução da jogada.

**Status:** ✅ Concluída.

---
## TASK-003

Exibir mensagem amigável ao jogador.

**Status:** ✅ Concluída.

---
## TASK-004

Garantir que a partida continue após o erro.

**Status:** ✅ Concluída.

---
## TASK-005

Validar comportamento com testes manuais.

**Status:** ✅ Concluída.

---
# Resultado

## Funcionalidades implementadas

* Tratamento de exceções durante a execução das jogadas;
* Continuidade da partida após erros de entrada;
* Exibição de mensagens de erro ao jogador através da camada de interface (`ConsolePrinter`);
* Preservação da separação de responsabilidades entre `model`, `service` e `ui`;
* Reutilização das mensagens de exceção definidas no domínio.

---

## 📌 Observações

> Esta User Story teve como objetivo melhorar a robustez da aplicação sem alterar as regras de negócio do Sudoku.

> O tratamento das exceções foi implementado na camada de serviço (`JogoSudoku`), mantendo as classes do domínio responsáveis apenas por validar regras e lançar exceções quando necessário.

> A comunicação dos erros ao usuário permaneceu centralizada na camada de interface (`ConsolePrinter`), preservando a arquitetura definida para o projeto.

> Durante os testes manuais foi identificada uma oportunidade de melhoria na experiência do usuário: após uma entrada inválida, o sistema solicita novamente linha, coluna e número. A possibilidade de reaproveitar as informações já informadas poderá ser avaliada em uma Sprint futura.
