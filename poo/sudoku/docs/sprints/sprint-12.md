# 🔄 Sprint 12 — Permitir entrada de coordenadas em formato A1–I9

## 🎯 Objetivo

Permitir que o jogador informe as coordenadas do tabuleiro no formato A1–I9, tornando a interação mais intuitiva e aproximando a interface da forma como jogadores de Sudoku costumam identificar as posições do tabuleiro.

---

## 📦 Escopo

-  US-012 — Permitir entrada de coordenadas em formato A1–I9.

---

## ✅ Critérios de Aceitação

- Permitir que o jogador informe a posição utilizando o formato A1–I9.
- Converter automaticamente a coordenada informada para os índices internos utilizados pela aplicação.
- Aceitar letras maiúsculas e minúsculas (ex.: `A1` e `a1`).
- Validar o formato da coordenada antes da execução da jogada.
- Exibir uma mensagem amigável quando a coordenada informada for inválida.
- Solicitar novamente a coordenada até que um valor válido seja informado.
- Manter o domínio da aplicação utilizando exclusivamente índices numéricos internos.
- Não alterar as regras de negócio existentes.

---

## Sprint Review

### User Stories concluídas

-   ✅ US-012 — Permitir entrada de coordenadas em formato A1–I9.

---

### Melhorias realizadas

* Refatoração do fluxo da partida para utilizar uma única entrada de coordenada.
* Implementação da leitura de coordenadas no formato A1–I9.
* Aceitação de letras maiúsculas e minúsculas.
* Normalização automática da entrada (`trim()` e `toUpperCase()`).
* Validação do formato da coordenada antes da execução da jogada.
* Tratamento de entradas vazias.
* Tratamento de coordenadas inválidas.
* Solicitação automática de nova coordenada até que uma entrada válida seja informada.
* Conversão automática da coordenada para índices internos (`linha` e `coluna`).
* Preservação do domínio utilizando apenas índices numéricos internos.

### Débitos técnicos identificados

Nenhum débito técnico identificado nesta Sprint.

---

## 📌 Observações

### Oportunidade de melhoria identificada

Durante os testes foi identificado que as confirmações do sistema (`S/N`) ainda utilizam o método `lerConfirmacao()`, que aceita qualquer entrada diferente de `S` como resposta negativa.

Exemplo:

```text
Deseja remover o número? (S/N): d7
```

Nesse cenário, a aplicação interpreta a entrada como **"Não"**, embora o valor informado não represente uma resposta válida.

Como melhoria futura, o método poderá receber uma validação semelhante à implementada em `lerCoordenada()` e `lerInteiro()`, solicitando uma nova entrada até que o usuário informe apenas `S` ou `N`.

Essa melhoria foi considerada fora do escopo desta Sprint.

---

### Evolução arquitetural

Durante a implementação foi identificado que o método `converterCoordenada()` retorna um vetor (`int[]`) contendo os índices de linha e coluna.

Para este projeto, essa abordagem foi considerada suficiente por manter a implementação simples e alinhada ao objetivo de aprendizado.

Como possível evolução arquitetural, poderá ser criada futuramente uma classe de valor (`Coordenada`) para representar explicitamente uma posição do tabuleiro, aumentando a legibilidade do código, reduzindo o uso de índices posicionais (`posicao[0]` e `posicao[1]`) e tornando a API do domínio mais expressiva.

Essa melhoria foi considerada fora do escopo do MVP e registrada como oportunidade de evolução arquitetural.

---

## Status

✅ Concluída

---