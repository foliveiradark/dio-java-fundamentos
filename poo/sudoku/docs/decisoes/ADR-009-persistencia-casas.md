# ADR-009 — Persistência das casas do tabuleiro como registros individuais

## Status

Aceito

---

## Contexto

Durante a modelagem conceitual da persistência da US-018 — Continuar
partida, foi necessário definir como o estado de um tabuleiro será
representado no banco de dados.

O estado de uma partida precisa preservar:

* a posição de cada casa;
* o número inicialmente definido para a casa, quando existir;
* a indicação se a casa é fixa ou editável;
* o número atualmente jogado, quando existir;
* os candidatos registrados pelo jogador.

Uma possibilidade seria armazenar o tabuleiro completo como uma única
estrutura, por exemplo, utilizando uma matriz ou outro formato
serializado.

Outra possibilidade seria representar cada casa do tabuleiro como um
registro individual relacionado ao tabuleiro, enquanto o estado
específico de cada partida seria armazenado separadamente.

Considerando que o objetivo da US-018 também é proporcionar aprendizado
sobre modelagem e persistência de dados relacionais, foi analisada a
segunda abordagem.

---

## Decisão

Cada casa do tabuleiro será persistida como um registro individual na
tabela `CASA`.

A estrutura será separada entre os dados estruturais da casa e os dados
específicos de uma partida.

A tabela `CASA` será responsável por representar as características
permanentes da posição no tabuleiro, incluindo:

* o tabuleiro ao qual pertence;
* a linha;
* a coluna;
* o número inicial, quando existir;
* se a casa é fixa.

O estado que pode variar durante uma partida será representado pela
tabela `ESTADO_CASA`, relacionada à `PARTIDA` e à `CASA`.

`ESTADO_CASA` será responsável por representar:

* a partida à qual o estado pertence;
* a casa correspondente;
* o número atualmente jogado, quando existir.

Os candidatos associados ao estado da casa serão persistidos
separadamente na tabela `CANDIDATO`, relacionada ao respectivo registro
de `ESTADO_CASA`.

A estrutura resultante é:

```text
TABULEIRO
    │
    └── CASA
        ├── posição
        ├── número inicial
        └── fixa
              │
              │
              ▼
          PARTIDA
              │
              └── ESTADO_CASA
                  ├── número jogado
                  │
                  └── CANDIDATO
```

Dessa forma, o estado persistido de uma partida representa somente as
alterações realizadas pelo jogador em relação à estrutura original do
tabuleiro.

---

## Justificativa

Embora uma partida de Sudoku possua apenas 81 casas, a quantidade de
registros não representa um volume significativo para um banco de dados
relacional.

A representação individual das casas apresenta vantagens importantes
para o objetivo do projeto:

* permite aplicar conceitos reais de modelagem relacional;
* mantém os dados estruturados e consultáveis;
* facilita a utilização de chaves e relacionamentos;
* permite validar a relação entre um tabuleiro e suas casas;
* evita transformar o estado do tabuleiro em um bloco de dados
  serializado;
* separa informações estruturais das informações específicas de uma
  partida;
* aproxima o projeto de uma arquitetura utilizada em aplicações reais;
* cria uma base adequada para futuras funcionalidades.

A separação entre `CASA` e `ESTADO_CASA` também evita duplicar informações
estruturais do tabuleiro a cada nova partida.

O pequeno volume de dados de uma partida não justifica a adoção de uma
estrutura menos relacional apenas para reduzir a quantidade de
registros.

Além disso, a decisão mantém aberta a evolução futura do sistema para
múltiplos tabuleiros, níveis de dificuldade, histórico de partidas e
outras informações relacionadas ao jogo.

---

## Consequências

### Positivas

* Introduz conceitos reais de modelagem relacional.
* Permite estabelecer relacionamentos entre tabuleiro, casas e
  partidas.
* Mantém os dados estruturados.
* Separa informações permanentes das informações específicas de uma
  partida.
* Evita duplicação das características estruturais das casas.
* Facilita consultas específicas sobre uma partida.
* Favorece a evolução futura do modelo.
* Proporciona uma oportunidade prática de aprendizado sobre banco de
  dados relacionais e PostgreSQL.

### Negativas

* Uma partida será representada por múltiplos registros de estado.
* O processo de salvar e carregar uma partida envolverá várias
  operações de persistência.
* O modelo exige a definição de relacionamentos e chaves.
* A persistência dos candidatos exige uma estrutura adicional.
* A recuperação do estado completo envolve a composição de dados de
  diferentes tabelas.

---

## Artefatos afetados

* US-018 — Continuar partida
* Modelo conceitual da persistência
* Modelo lógico do banco de dados
* Modelo relacional
* Modelo de dados da aplicação
* PostgreSQL
* Camada de persistência

---

## Relação com princípios

Esta decisão reforça os princípios de:

> Modelar os dados de forma estruturada e coerente com o domínio da
> aplicação.

> Separar informações estruturais das informações que representam o
> estado mutável de uma partida.

> Separar o modelo de domínio da forma como seus dados são persistidos.

> Utilizar a evolução da implementação como oportunidade de aprendizado,
> sem introduzir complexidade desnecessária.

---

## Data

15/08/2026
