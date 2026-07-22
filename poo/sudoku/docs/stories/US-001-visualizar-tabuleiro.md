# US-001 — Visualizar o Tabuleiro

---
## Informações Gerais
>**ID:** US-001  
>**Sprint:** Sprint 1  
>**Prioridade:** Alta 🔴  
>**Status:** Concluído ✅

---

# História do Usuário

Como jogador,

Quero visualizar o tabuleiro,

Para acompanhar o estado atual da partida.

---

# Critérios de Aceitação

- [X] O tabuleiro deve ser exibido no terminal.
- [X] As 81 casas devem aparecer organizadas em uma grade 9x9.
- [X] Casas vazias devem ser exibidas como espaço em branco ou caractere definido pela equipe.
- [X] Casas preenchidas devem exibir seus respectivos números.
- [X] Os blocos 3x3 devem possuir separação visual.

---

# Análise Técnica

## Classes envolvidas

- Tabuleiro
- Casa
- ConsolePrinter
- Main

---

# Tarefas Técnicas

## TASK-001

Criar  `UI`.

Status:

✅ Concluído

## TASK-002

Criar a classe `ConsolePrinter`.

Status:

✅ Concluído

---

## TASK-003

Implementar `imprimir()`.

Status:

✅ Concluído

---

## TASK-004

Implementar `formatarValor()`.

Status:

✅ Concluído

---

## TASK-005

Implementar impressão da linha.

Status:

✅ Concluído

---

## TASK-006

Formatar visualmente os blocos 3x3.

Criar método `imprimirSeparadorVertical()`

Criar método `imprimirSeparadorHorizontal()`

Status:

✅ Concluído

---

## TASK-007

Criar primeiro teste utilizando a classe `Main`.

Status:

✅ Concluído

---

# Decisões

- A lógica de impressão ficará fora do domínio.
- O Tabuleiro não conhecerá detalhes da interface.
- A apresentação será responsabilidade da camada `ui`.

---

# Definition of Done

A história será considerada concluída quando:

- o tabuleiro puder ser exibido corretamente;
- todos os critérios de aceitação forem atendidos;
- os testes manuais forem executados;
- a documentação estiver atualizada;
- o código for aprovado na revisão técnica.

---

# Design do Algoritimo

```
Receber Tabuleiro

Receber Linha

Para cada coluna

↓

???

↓

???

↓

Se coluna == 2 ou coluna == 5

↓

???

↓

Fim do laço

↓

Pular linha
```

# Observações

Nenhuma.