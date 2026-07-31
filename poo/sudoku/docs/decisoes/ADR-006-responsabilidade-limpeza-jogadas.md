# ADR-006 — Responsabilidade pela limpeza das jogadas

## Status

Aceita

---

## Contexto

Durante a implementação da User Story **US-009 — Limpar Tabuleiro**, surgiu a necessidade de definir qual classe seria responsável por executar a limpeza das jogadas realizadas pelo jogador.

Foram consideradas duas alternativas:

### Opção A

A classe `JogoSudoku` percorreria todas as casas do tabuleiro, identificando quais poderiam ser limpas e executando a remoção.

### Opção B

A classe `JogoSudoku` apenas coordenaria o fluxo da aplicação, delegando toda a operação para a classe `Tabuleiro`, responsável por manipular seu próprio estado.

---

## Decisão

Foi adotada a **Opção B**.

A classe `JogoSudoku` apenas solicita a operação:

```text
tabuleiro.limparJogadas();
```

Toda a lógica de limpeza permanece concentrada na classe `Tabuleiro`.

---

## Justificativa

Esta decisão mantém as responsabilidades bem definidas.

- `JogoSudoku` continua responsável apenas pelo fluxo da aplicação;
- `Tabuleiro` permanece responsável pelo gerenciamento do estado do jogo;
- a lógica de domínio fica encapsulada no próprio domínio;
- evita aumento de acoplamento entre as camadas.

Além disso, a implementação reutiliza o método `removerNumero()` da classe `Casa`, evitando duplicação de código e preservando o encapsulamento.

---

## Consequências

### Positivas

- menor acoplamento;
- maior coesão das classes;
- reutilização de código;
- facilidade para futuras evoluções do domínio.

### Negativas

Nenhuma consequência negativa relevante foi identificada para o escopo atual do projeto.

---

## Relação com os princípios do projeto

Esta decisão reforça os princípios definidos para o projeto:

- Responsabilidade Única (SRP);
- Encapsulamento;
- Baixo acoplamento;
- Desenvolvimento incremental;
- Reutilização de código.