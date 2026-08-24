# ADR-011 — Separação entre interface e aplicação

## Status

Aceito

---

## Contexto

A evolução do projeto Sudoku definiu como objetivo transformar a
aplicação atualmente executada em modo console em um jogo desktop
gráfico, mantendo a possibilidade de evolução futura do produto.

A implementação inicial concentrava no `JogoSudoku` responsabilidades
de diferentes naturezas.

Entre elas estavam:

* controle do fluxo da partida;
* interação com o usuário através do console;
* apresentação de mensagens;
* execução de operações do jogo;
* coordenação da persistência;
* parte das regras relacionadas ao estado da partida.

Essa organização foi adequada durante a evolução inicial do projeto,
quando havia apenas uma interface de console.

Com a introdução prevista de uma segunda interface, essa concentração
representava um risco arquitetural, pois a lógica da aplicação poderia
ficar acoplada à tecnologia utilizada para interação com o usuário.

A futura interface gráfica deverá ser apenas um novo canal de
interação com a aplicação, sem duplicar as regras do Sudoku ou acessar
diretamente a camada de persistência.

---

## Decisão

A aplicação será estruturada de forma que a **interface seja
responsável pela interação e apresentação**, enquanto a **aplicação
será responsável pela coordenação dos casos de uso do Sudoku**.

O domínio permanecerá responsável por representar o estado e o
comportamento relacionado às regras do Sudoku.

A persistência continuará responsável pelo acesso e armazenamento dos
dados.

A direção arquitetural adotada será:

```text
Interface
    │
    ▼
Aplicação
    │
    ├──► Domínio
    │
    └──► Persistência
```

As interfaces de usuário deverão utilizar os casos de uso da aplicação
sem depender diretamente de detalhes de implementação do domínio ou da
persistência.

O projeto deverá permitir que diferentes interfaces, como Console e
GUI, utilizem a mesma lógica de aplicação.

A implementação dessa separação foi realizada de forma incremental
durante a US-019, preservando as responsabilidades e comportamentos
já validados sempre que não houve necessidade arquitetural de alterá-los.

A implementação concreta resultou na definição dos contratos:

* `InterfaceUsuario` — abstração das operações de entrada;
* `InterfaceApresentacao` — abstração das operações de apresentação.

A implementação Console utiliza esses contratos através de:

* `ConsoleInput`;
* `ConsolePrinter`.

O `JogoSudoku` passou a utilizar os contratos de interação em vez de
depender diretamente das implementações específicas do Console.

Essa estrutura permite que uma futura interface gráfica implemente os
contratos necessários e utilize o fluxo da aplicação sem duplicar as
regras existentes.

Não foram introduzidas abstrações adicionais além das necessárias para
atender ao requisito de múltiplas interfaces.

---

## Justificativa

A interface gráfica representa um novo canal de interação com o
usuário e não uma nova implementação das regras do jogo.

Manter a lógica de aplicação independente da tecnologia de interface
permite que o mesmo comportamento seja utilizado por diferentes
clientes.

A arquitetura resultante mantém o seguinte princípio:

```text
Console ─────┐
             │
GUI ─────────┼──► Aplicação Sudoku ──► Domínio
             │                       └► Persistência
Futura GUI ──┘
```

A implementação da US-019 demonstrou que a interface Console pode ser
mantida funcional após a separação, enquanto a aplicação deixa de
depender diretamente de suas implementações específicas de entrada e
apresentação.

Essa abordagem reduz o acoplamento entre a lógica do sistema e a forma
como o usuário interage com ele.

Também permite que a evolução futura do produto ocorra sem que cada
nova interface exija a reimplementação das regras do Sudoku.

A decisão não implica a criação antecipada de uma arquitetura
complexa. A estrutura foi evoluída somente na medida necessária para
atender ao requisito de múltiplas interfaces.

---

## Consequências

### Positivas

* Permite a utilização da mesma lógica por diferentes interfaces.
* Reduz o acoplamento entre a aplicação e o console.
* Evita que a GUI precise conhecer detalhes de implementação da
  persistência.
* Facilita futuras evoluções da interface.
* Preserva o domínio construído durante as Sprints anteriores.
* Cria uma separação mais clara entre interação, aplicação, domínio e
  persistência.
* Aproxima a arquitetura do projeto de uma estrutura utilizada em
  aplicações reais.
* Permite a futura introdução de JavaFX sem alteração das regras
  fundamentais do domínio.

### Negativas

* A arquitetura passou a possuir contratos adicionais entre a
  aplicação e a interface.
* A quantidade de classes e abstrações aumentou.
* Novas interfaces deverão implementar os contratos necessários para
  interação e apresentação.
* A implementação Console ainda possui detalhes internos específicos
  de sua própria tecnologia, que não são compartilhados com futuras
  interfaces.

---

## Artefatos afetados

* `service.JogoSudoku`
* `ui.InterfaceUsuario`
* `ui.InterfaceApresentacao`
* `ui.ConsoleInput`
* `ui.ConsolePrinter`
* Camada `model`
* Camada `persistence`
* Arquitetura do projeto
* US-019 — Preparar arquitetura para múltiplas interfaces
* Futura interface gráfica

---

## Validação da decisão

A decisão arquitetural foi validada durante a US-019 através da
refatoração e dos testes manuais da aplicação.

Foi confirmado que:

* o Console continua funcional;
* `JogoSudoku` não depende diretamente das implementações específicas
  do Console;
* o domínio permanece independente da interface;
* a persistência permanece independente da interface;
* as operações existentes continuam disponíveis através do fluxo da
  aplicação;
* os principais fluxos funcionais foram executados sem regressões;
* uma futura interface poderá utilizar os contratos existentes sem
  duplicação das regras fundamentais do Sudoku.

O Code Review da US-019 não identificou novos pontos de acoplamento
relevantes que justifiquem novas abstrações nesta etapa.

A relação interna entre `ConsoleInput` e `ConsolePrinter` permanece
como característica da implementação específica do Console e não
representa bloqueio arquitetural para esta decisão.

---

## Relação com princípios

Esta decisão reforça o princípio de **separação de responsabilidades**,
evitando que a tecnologia de interface determine o comportamento da
aplicação.

Também reforça a ideia de **baixo acoplamento**, permitindo que a
interface seja substituída ou expandida sem exigir a reimplementação
do domínio e das regras do Sudoku.

A decisão favorece ainda a **reutilização da lógica de aplicação** por
diferentes canais de interação.

---

## Relação com a próxima fase

A US-019 definiu **JavaFX** como tecnologia gráfica escolhida para a
próxima fase e **Maven** como sistema de build recomendado.

Essas decisões são consequência da preparação arquitetural realizada,
mas sua implementação não faz parte deste ADR nem da US-019.

A futura interface JavaFX deverá utilizar a separação arquitetural
estabelecida por esta decisão.

---

## Data

22/08/2026

### Atualização

24/08/2026 — ADR atualizado após a conclusão da implementação da
US-019, validação regressiva e Code Review.