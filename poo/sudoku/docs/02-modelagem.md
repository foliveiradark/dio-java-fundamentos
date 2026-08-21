# Modelagem do Sistema

---

## Visão Geral

O sistema será dividido em camadas responsáveis por diferentes aspectos
da aplicação:

* **Domínio:** responsável pelas regras e estruturas do Sudoku.
* **Serviços:** responsável pela coordenação dos casos de uso.
* **Interface:** responsável pela interação com o usuário.
* **Persistência:** responsável pela comunicação com o mecanismo de
  armazenamento.

A persistência será incorporada de forma incremental, mantendo a
separação entre o domínio e os mecanismos de armazenamento.

O mecanismo de persistência utilizado atualmente é o PostgreSQL,
executado em ambiente Docker durante o desenvolvimento.

---

# Modelo do Domínio

## Classes do Domínio

* `Tabuleiro`
* `Casa`

## Classes de Serviço

* `JogoSudoku`

## Classes da Interface

* `Menu`
* `ConsoleInput`
* `ConsolePrinter`

## Classes de Persistência

* `ConnectionFactory`
* `TabuleiroRepository`
* `PartidaRepository`

---

## Relacionamentos

* `Main` inicia `JogoSudoku`;
* `JogoSudoku` coordena a partida;
* `JogoSudoku` utiliza `ConsoleInput`, `ConsolePrinter` e `Menu`;
* `JogoSudoku` controla um `Tabuleiro`;
* `Tabuleiro` é composto por 81 objetos `Casa`;
* `ConnectionFactory` fornece conexões JDBC;
* `TabuleiroRepository` é responsável pela persistência da configuração
  permanente do tabuleiro;
* `PartidaRepository` é responsável pela persistência e recuperação do
  progresso de uma partida.

A camada de persistência não deve transferir para o banco de dados as
responsabilidades das regras de domínio.

---

# Modelagem da Persistência

## Objetivo

A persistência representa os dados necessários para armazenar e
reconstruir uma partida de Sudoku.

O modelo separa explicitamente:

* a configuração permanente do desafio;
* a execução de uma partida;
* o estado das casas durante uma partida;
* os candidatos registrados pelo jogador.

Essa separação permite que a configuração de um tabuleiro seja
independente do progresso produzido em uma partida.

---

# Modelo Conceitual

A persistência é organizada em cinco conceitos principais:

```text
TABULEIRO
    │
    ├───────────────┐
    │               │
    ▼               ▼
  CASA            PARTIDA
    │               │
    │               │
    └───────┬───────┘
            ▼
       ESTADO_CASA
            │
            ▼
        CANDIDATO
```

A entidade `CASA` pertence ao `TABULEIRO`, pois representa uma posição da
configuração do desafio.

A entidade `PARTIDA` pertence a um `TABULEIRO` e representa uma execução
desse desafio.

O estado de uma casa durante uma partida é representado separadamente
por `ESTADO_CASA`.

---

## TABULEIRO

Representa o desafio original do Sudoku.

É responsável por identificar a configuração à qual pertencem as casas
do tabuleiro.

O identificador do tabuleiro não representa nível de dificuldade.

O conceito de dificuldade poderá ser incorporado futuramente caso seja
necessário ao domínio do produto.

---

## CASA

Representa uma posição específica dentro de um tabuleiro.

Uma casa possui informações pertencentes à configuração original do
desafio:

* linha;
* coluna;
* número inicial;
* indicação se a casa é fixa.

A casa não armazena o número atualmente jogado pelo jogador.

---

## PARTIDA

Representa uma execução de um determinado tabuleiro.

A partida possui uma referência ao tabuleiro utilizado e representa o
progresso que pode ser persistido.

A partida não representa a configuração do tabuleiro.

> `TABULEIRO` representa o desafio.
>
> `PARTIDA` representa a execução desse desafio.

---

## ESTADO_CASA

Representa o estado de uma determinada casa durante uma partida.

É o elemento que relaciona a configuração permanente da `CASA` com o
progresso da `PARTIDA`.

O estado da casa pode conter:

* número atualmente inserido pelo jogador;
* candidatos registrados pelo jogador.

O atributo `tabuleiro_id` é utilizado para permitir que o banco de dados
garanta que a partida e a casa associadas pertençam ao mesmo tabuleiro.

A integridade dessa associação é definida pela **ADR-010 — Garantia de
integridade entre partida, tabuleiro e casa**.

---

## CANDIDATO

Representa uma possibilidade de preenchimento registrada pelo jogador em
uma casa durante uma partida.

Os candidatos fazem parte do progresso da partida e não pertencem à
configuração original do tabuleiro.

---

# Responsabilidades dos Conceitos

| Conceito      | Responsabilidade                                    |
| ------------- | --------------------------------------------------- |
| `TABULEIRO`   | Representar o desafio e sua configuração            |
| `CASA`        | Representar uma posição e seu estado inicial        |
| `PARTIDA`     | Representar uma execução de um tabuleiro            |
| `ESTADO_CASA` | Representar o estado de uma casa em uma partida     |
| `CANDIDATO`   | Representar possibilidades registradas pelo jogador |

---

# Modelo Lógico

O modelo lógico é composto pelas seguintes entidades:

```text
TABULEIRO
CASA
PARTIDA
ESTADO_CASA
CANDIDATO
```

---

## TABULEIRO

```text
TABULEIRO
├── id (PK)
```

### Regras

* `id` identifica unicamente o tabuleiro.

---

## CASA

```text
CASA
├── id (PK)
├── tabuleiro_id (FK)
├── linha
├── coluna
├── numero_inicial
└── fixa
```

### Regras

* `tabuleiro_id` referencia `TABULEIRO`;
* `linha` identifica a linha da posição;
* `coluna` identifica a coluna da posição;
* `numero_inicial` representa o número pertencente à configuração
  original, podendo ser vazio;
* `fixa` identifica se a casa pertence à configuração fixa do desafio;
* a combinação `(tabuleiro_id, linha, coluna)` deve ser única.

---

## PARTIDA

```text
PARTIDA
├── id (PK)
└── tabuleiro_id (FK)
```

### Regras

* `tabuleiro_id` referencia `TABULEIRO`;
* uma partida está associada a um único tabuleiro;
* um tabuleiro pode possuir várias partidas.

---

## ESTADO_CASA

```text
ESTADO_CASA
├── id (PK)
├── tabuleiro_id
├── partida_id (FK)
├── casa_id (FK)
└── numero_jogado
```

### Regras

* `partida_id` participa de uma referência composta com `tabuleiro_id`
  para `PARTIDA`;
* `casa_id` participa de uma referência composta com `tabuleiro_id`
  para `CASA`;
* `numero_jogado` representa o número inserido pelo jogador;
* `numero_jogado` pode ser vazio quando a casa não possui um número
  definitivo;
* a associação entre partida e casa identifica unicamente seu estado
  naquela partida;
* `tabuleiro_id` garante que a partida e a casa estejam vinculadas ao
  mesmo tabuleiro.

---

## CANDIDATO

```text
CANDIDATO
├── id (PK)
├── estado_casa_id (FK)
└── numero
```

### Regras

* `estado_casa_id` referencia `ESTADO_CASA`;
* `numero` representa um candidato;
* a combinação `(estado_casa_id, numero)` deve ser única.

Isso impede que o mesmo candidato seja registrado mais de uma vez para
o mesmo estado de casa.

---

# Modelo Relacional

O modelo relacional consolida as entidades, relações e chaves utilizadas
na implementação da persistência no PostgreSQL.

```text
┌──────────────────┐
│    TABULEIRO     │
│──────────────────│
│ id PK            │
└───────┬──────────┘
        │
        ├──────────────────────┐
        │                      │
        ▼                      ▼
┌──────────────────┐    ┌──────────────────┐
│      CASA        │    │     PARTIDA      │
│──────────────────│    │──────────────────│
│ id PK            │    │ id PK            │
│ tabuleiro_id FK  │    │ tabuleiro_id FK  │
│ linha            │    └────────┬─────────┘
│ coluna           │             │
│ numero_inicial   │             │
│ fixa             │             │
└────────┬─────────┘             │
         │                       │
         └──────────┬────────────┘
                    ▼
           ┌─────────────────────┐
           │    ESTADO_CASA      │
           │─────────────────────│
           │ id PK               │
           │ tabuleiro_id        │
           │ partida_id FK*      │
           │ casa_id FK*         │
           │ numero_jogado       │
           └──────────┬──────────┘
                      │
                      ▼
              ┌───────────────┐
              │   CANDIDATO   │
              │───────────────│
              │ id PK         │
              │ estado_casa_id│
              │ numero        │
              └───────────────┘
```

`partida_id` e `casa_id` participam de referências compostas com
`tabuleiro_id`, garantindo a integridade da associação.

---

## Relações

```text
TABULEIRO 1 ─── N CASA

TABULEIRO 1 ─── N PARTIDA

PARTIDA 1 ─── N ESTADO_CASA

CASA 1 ─── N ESTADO_CASA

ESTADO_CASA 1 ─── N CANDIDATO
```

Uma `CASA` pode possuir diferentes estados em diferentes partidas,
enquanto uma determinada combinação de `PARTIDA` e `CASA` possui um único
`ESTADO_CASA`.

---

# Regras de Integridade e Unicidade

## Posição de uma casa

```text
(tabuleiro_id, linha, coluna)
```

Uma posição só pode existir uma vez dentro de um tabuleiro.

---

## Estado de uma casa em uma partida

A associação entre uma partida e uma casa deve identificar unicamente
seu estado dentro daquela partida.

A implementação utiliza `tabuleiro_id` em conjunto com `partida_id` e
`casa_id` para preservar a integridade entre `TABULEIRO`, `PARTIDA` e
`CASA`.

---

## Candidato de uma casa

```text
(estado_casa_id, numero)
```

O mesmo candidato não pode ser registrado duas vezes no mesmo estado de
casa.

---

# Separação entre Configuração e Progresso

O modelo mantém uma separação explícita entre os dados permanentes do
desafio e os dados produzidos durante uma partida.

```text
CONFIGURAÇÃO DO TABULEIRO

TABULEIRO
    │
    └── CASA
        ├── linha
        ├── coluna
        ├── numero_inicial
        └── fixa
```

```text
PROGRESSO DA PARTIDA

PARTIDA
    │
    └── ESTADO_CASA
        ├── numero_jogado
        │
        └── CANDIDATO
```

As casas pertencem ao `TABULEIRO` e representam sua configuração.

O estado produzido pelo jogador não é armazenado diretamente em
`CASA`.

Ele é representado por `ESTADO_CASA`, associado a uma `PARTIDA` e a uma
`CASA`.

Essa separação permite que diferentes partidas utilizem a mesma
configuração de tabuleiro sem duplicar seus dados permanentes.

A modelagem não exige que toda partida possua registros de
`ESTADO_CASA` para as 81 casas. A estratégia de criação desses estados é
uma decisão de implementação da persistência.

---

# Representação das Posições

O domínio Java utiliza índices de posição entre `0` e `8`.

A persistência relacional utiliza valores entre `1` e `9` para
representar linhas e colunas.

Essa diferença é uma responsabilidade da camada de persistência.

```text
Domínio Java       Persistência
    0       →          1
    1       →          2
    2       →          3
    ...     →         ...
    8       →          9
```

O `TabuleiroRepository` realiza a conversão durante a persistência e
durante a reconstrução do modelo de domínio.

Essa conversão não altera a representação utilizada pelas regras do
domínio.

---

# Camada de Persistência

A comunicação entre a aplicação Java e o PostgreSQL utiliza JDBC.

A estrutura atual da camada é:

```text
persistence
├── ConnectionFactory
├── TabuleiroRepository
└── PartidaRepository
```

## ConnectionFactory

Responsável pelo fornecimento de conexões JDBC para o banco de dados.

---

## TabuleiroRepository

Responsável pela persistência da configuração permanente do Sudoku:

```text
TABULEIRO
    │
    └── CASA
```

Sua responsabilidade é tratar a persistência dos dados que pertencem à
configuração do desafio.

---

## PartidaRepository

Responsável pela persistência e recuperação do progresso de uma partida:

```text
PARTIDA
    │
    └── ESTADO_CASA
            │
            └── CANDIDATO
```

Sua responsabilidade é tratar o estado produzido durante a execução da
partida.

A camada de persistência não deve assumir responsabilidades pelas
regras de negócio do domínio.

---

# Implementação Física

O modelo relacional é implementado no PostgreSQL por meio do arquivo:

```text
database/schema.sql
```

O modelo físico utiliza as seguintes tabelas:

```text
tabuleiro
casa
partida
estado_casa
candidato
```

A implementação física define:

* tipos de dados;
* `NOT NULL`;
* `PRIMARY KEY`;
* `FOREIGN KEY`;
* referências compostas;
* `UNIQUE`;
* `CHECK`.

As constraints físicas devem preservar as regras de integridade
definidas neste documento e nas ADRs relacionadas.

---

# Evolução da Modelagem

A modelagem segue uma evolução incremental:

```text
Modelo Conceitual
        ↓
Modelo Lógico
        ↓
Modelo Relacional
        ↓
Implementação PostgreSQL
        ↓
Persistência na aplicação Java
```

O modelo conceitual define os conceitos e suas responsabilidades.

O modelo lógico define entidades, atributos, relacionamentos, chaves e
regras de unicidade.

O modelo relacional consolida as relações e referências necessárias para
a implementação.

A implementação PostgreSQL materializa esse modelo por meio do
`database/schema.sql`.

---

## Evolução Futura

O modelo foi estruturado de forma a permitir futuras extensões, caso
sejam necessárias ao produto.

Entre possibilidades futuras estão:

* múltiplos tabuleiros;
* diferentes níveis de dificuldade;
* histórico de partidas;
* estatísticas;
* outras informações relacionadas às partidas.

Essas funcionalidades não fazem parte do modelo funcional atual e
deverão ser introduzidas por suas respectivas User Stories.
