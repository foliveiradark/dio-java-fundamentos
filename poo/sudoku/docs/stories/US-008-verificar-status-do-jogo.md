# US-008 — Verificar o status do jogo

---

## Informações Gerais

> **ID:** US-008  
> **Sprint:** Sprint 8  
> **Prioridade:** 🟠 Média  
> **Status:** ✅ Concluída

---

## 🎯 Objetivo

Permitir que o jogador verifique o estado atual da partida durante a resolução do Sudoku.

---

## ✅ Critérios de Aceitação

* Informar quando o jogo estiver incompleto;
* Informar quando o jogo estiver completo e válido;
* Informar quando o jogo estiver completo, porém com erros;
* Não alterar o estado do tabuleiro durante a verificação;
* Exibir uma mensagem clara ao jogador.
* A verificação deve considerar todas as regras do Sudoku.

---

# 🔧 Tarefas Técnicas

## TASK-001

Adicionar um método responsável por verificar se ainda existem casas vazias.

**Status:** ✅ Concluída

---

## TASK-002

Adicionar um método responsável por verificar se existem erros nas linhas.

**Status:** ✅ Concluída

---

## TASK-003

Adicionar um método responsável por verificar se existem erros nas colunas.

**Status:** ✅ Concluída

---

## TASK-004

Adicionar um método responsável por verificar se existem erros nos blocos 3×3.

**Status:** ✅ Concluída

---

## TASK-005

Determinar o status atual da partida.

**Status:** ✅ Concluída

---

## TASK-006

Exibir o resultado ao jogador.

**Status:** ✅ Concluída

---

## Dependências

- US-005 — Tratar jogadas inválidas

---

# Resultado

## Funcionalidades implementadas

- Verificação de casas vazias;
- Verificação de erros nas linhas;
- Verificação de erros nas colunas;
- Verificação de erros nos blocos 3×3;
- Criação do enum `StatusPartida`;
- Determinação automática do estado da partida;
- Exibição do status da partida ao jogador mediante solicitação.

---

## 📌 Observações

Durante a implementação foi decidido que a consulta ao status da partida faria parte do fluxo de execução de uma jogada.

Após cada tentativa de inserção de número, o jogador pode optar por consultar o estado atual da partida.

Essa abordagem evita verificações desnecessárias durante remoções de jogadas e mantém a coordenação do fluxo na classe `JogoSudoku`, enquanto a apresentação das mensagens permanece sob responsabilidade da camada `ui`, conforme definido na ADR-005.

Para validação dos estados `COMPLETA_VALIDA` e `COMPLETA_INVALIDA` foi utilizada temporariamente uma solução do tabuleiro obtida por meio do resolvedor Playoku, mantendo como origem do desafio o tabuleiro oficial disponibilizado pela DIO. Após os testes, o tabuleiro inicial foi restaurado, não permanecendo alterações permanentes no código-fonte.


---