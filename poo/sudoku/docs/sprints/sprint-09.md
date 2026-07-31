# 🔄 Sprint 9 — Limpar o Tabuleiro

## 🎯 Objetivo

Permitir que o jogador remova todas as jogadas realizadas, mantendo apenas os números fixos.

---

## 📦 Escopo

- US-009 — Limpar Tabuleiro

---
### Critérios de Aceitação

* Permitir limpar todas as jogadas realizadas pelo jogador;
* Preservar todas as casas fixas do tabuleiro inicial;
* Restaurar todas as casas editáveis para o estado vazio (null);
* Não alterar os números do tabuleiro inicial;
* Reimprimir o tabuleiro após a limpeza;
* Solicitar confirmação antes da limpeza (S/N);
* A operação deve funcionar independentemente da quantidade de jogadas realizadas.

---

## Sprint Review

### User Stories concluídas

- ✅ US-009 — Limpar Tabuleiro.

---

### Melhorias realizadas

- Implementada a limpeza completa das jogadas do jogador;
- Reutilização do método `removerNumero()` da classe `Casa`;
- Preservação das casas fixas durante a limpeza;
- Inclusão de confirmação antes da remoção das jogadas;
- Atualização automática do tabuleiro após a operação.


### Débitos técnicos identificados

Nenhum débito técnico identificado nesta Sprint.

---

## Status

✅ Concluída

---