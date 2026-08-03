# ADR-007 — Não diferenciar visualmente casas fixas na interface de console

## Status

Aceita

---

## Contexto

Durante a Sprint 15 foi avaliada a possibilidade de destacar visualmente as casas fixas do Sudoku na interface de console (por exemplo, utilizando colchetes ou outros marcadores).

---

## Decisão

Optou-se por manter a representação visual uniforme para todas as casas do tabuleiro.

A diferenciação visual das casas fixas será implementada futuramente apenas em uma interface gráfica (Swing), onde poderão ser utilizados recursos como cores, estilos de fonte e componentes específicos.

---

## Justificativa

* evita poluição visual na interface em modo texto;
* preserva a simplicidade da leitura do tabuleiro;
* reduz retrabalho quando a interface gráfica for desenvolvida;
* mantém a Sprint focada exclusivamente no refinamento da organização visual do tabuleiro.

---

## Consequências

### Positivas

* interface de console permanece limpa e objetiva;
* menor complexidade na `ConsolePrinter`;
* evolução futura mais natural para Swing.

### Negativas

* o jogador não consegue distinguir visualmente casas fixas e casas preenchidas por ele apenas pela aparência.

---