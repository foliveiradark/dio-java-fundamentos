# 🔄 Sprint 13 — Validar respostas de confirmação (S/N)

## 🎯 Objetivo

Permitir que o jogador informe apenas respostas válidas (`S` ou `N`) nas solicitações de confirmação da aplicação, evitando interpretações incorretas e tornando a interação mais consistente.

---

## 📦 Escopo

-  US-013 — Validar respostas de confirmação (S/N).

---

## ✅ Critérios de Aceitação

- Permitir apenas as respostas `S` ou `N`.
- Aceitar letras maiúsculas e minúsculas (`S`, `s`, `N`, `n`).
- Ignorar espaços antes e depois da resposta.
- Tratar entradas vazias sem encerrar a aplicação.
- Exibir uma mensagem amigável quando a resposta for inválida.
- Solicitar novamente a resposta até que um valor válido seja informado.
- Manter a responsabilidade da validação concentrada na classe `ConsoleInput`.
- Não alterar as regras de negócio existentes.

---

## Sprint Review

### User Stories concluídas

-   ✅ US-013 — Validar respostas de confirmação (S/N).

---

### Melhorias realizadas

- Validação das respostas de confirmação (`S/N`) na classe `ConsoleInput`.
- Aceitação de letras maiúsculas e minúsculas (`S`, `s`, `N`, `n`).
- Normalização automática da entrada utilizando `trim()` e `toUpperCase()`.
- Tratamento de entradas vazias.
- Tratamento de respostas inválidas.
- Exibição de mensagens amigáveis para confirmações inválidas.
- Solicitação automática de nova resposta até que uma entrada válida seja informada.
- Preservação da responsabilidade da validação na camada de interface (`ConsoleInput`).

### Débitos técnicos identificados

Nenhum débito técnico identificado nesta Sprint.

---

## 📌 Observações

### Oportunidade de melhoria identificada

Durante os testes foi identificado que o Menu Principal ainda não valida opções inexistentes.

Atualmente, qualquer valor diferente das opções disponíveis apenas redesenha o menu, sem informar ao jogador que a opção informada é inválida.

Como melhoria futura, o menu poderá validar a opção escolhida, exibir uma mensagem amigável e solicitar uma nova entrada até que um valor válido seja informado.

Essa melhoria foi considerada fora do escopo desta Sprint e registrada no Product Backlog como uma nova User Story.

---

## Status

✅ Concluída

---