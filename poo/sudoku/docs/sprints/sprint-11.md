# 🔄 Sprint 11 — Validar entradas vazias e inválidas do usuário

## 🎯 Objetivo

Permitir que o jogador informe apenas entradas válidas, evitando o encerramento inesperado da aplicação e proporcionando uma interação mais robusta.

---

## 📦 Escopo

-  US-011 — Validar entradas vazias e inválidas do usuário.

---

## ✅ Critérios de Aceitação

* Permitir que o usuário informe apenas entradas válidas para números inteiros.
* Tratar entradas vazias sem encerrar a aplicação.
* Tratar entradas não numéricas sem encerrar a aplicação.
* Exibir mensagens de erro claras ao usuário.
* Solicitar novamente a entrada até que um valor válido seja informado.
* Manter a responsabilidade da validação concentrada na camada `ConsoleInput`.
* Não alterar as regras de negócio existentes.

---

## Sprint Review

### User Stories concluídas

-   ✅ US-011 — Validar entradas vazias e inválidas do usuário.

---

### Melhorias realizadas

* Tratamento de entradas vazias utilizando `String.isBlank()`.
* Tratamento de entradas não numéricas (`NumberFormatException`).
* Exibição de mensagens amigáveis para entradas inválidas.
* Solicitação automática de nova entrada até que um valor válido seja informado.
* Centralização da validação de entrada na classe `ConsoleInput`, preservando a arquitetura da aplicação.

### Débitos técnicos identificados

Nenhum débito técnico identificado nesta Sprint.

---

## 📌 Observações

A implementação foi realizada sem necessidade de alterações na arquitetura do projeto.

A responsabilidade pela validação das entradas permaneceu concentrada na camada de interface (`ConsoleInput`), mantendo o domínio e a camada de serviço desacoplados da forma como os dados são informados pelo usuário.

Durante os testes também foi identificada uma funcionalidade ainda não implementada no Menu Principal ("Continuar Partida"), porém ela não faz parte do escopo desta Sprint e permanece registrada no Product Backlog para evolução futura.


---

## Status

✅ Concluída

---