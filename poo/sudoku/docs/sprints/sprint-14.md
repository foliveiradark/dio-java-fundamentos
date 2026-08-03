# 🔄 Sprint 14 — Validar opções do Menu Principal

## 🎯 Objetivo

Melhorar a experiência do jogador durante a navegação no Menu Principal, impedindo que opções inexistentes sejam aceitas silenciosamente.

---

## 📦 Escopo

-  US-014 — Validar opções do Menu Principal.

---

## ✅ Critérios de Aceitação

- Permitir apenas opções existentes no Menu Principal.
- Exibir uma mensagem amigável quando uma opção inválida for informada.
- Solicitar novamente a opção até que um valor válido seja informado.
- Não encerrar a aplicação após uma opção inválida.
- Não redesenhar o fluxo da aplicação desnecessariamente.
- Manter a validação concentrada na camada de entrada (`ConsoleInput`).
- Não alterar as regras de negócio existentes.

---

## Sprint Review

### User Stories concluídas

-   ✅ US-014 — Validar opções do Menu Principal.

---

### Melhorias realizadas

- Validação das opções do Menu Principal.
- Aceitação apenas das opções existentes.
- Tratamento de entradas vazias.
- Tratamento de entradas não numéricas.
- Tratamento de opções inexistentes.
- Exibição de mensagens amigáveis para opções inválidas.
- Solicitação automática de nova opção até que uma entrada válida seja informada.
- Centralização da validação na classe `ConsoleInput`.
- Refatoração do fluxo do Menu Principal utilizando `switch`.

### Débitos técnicos identificados

Nenhum débito técnico identificado nesta Sprint.

---

## 📌 Observações

Durante a implementação foi realizada uma pequena refatoração no fluxo do Menu Principal, 
substituindo a estrutura baseada em `if/else` por `switch`, tornando a implementação mais alinhada ao crescimento futuro do menu e às boas práticas do Java moderno.

---

## Status

✅ Concluída

---